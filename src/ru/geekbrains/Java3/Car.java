package ru.geekbrains.Java3;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Callable{
    private static int CARS_COUNT;
    private static CyclicBarrier carsReadyAll;
   public static CountDownLatch endRace;
   public static CountDownLatch beginRace;
   private static Lock lock;
   private static volatile int winner=0;

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public static boolean allReady = false;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        carsReadyAll = new CyclicBarrier(CARS_COUNT);
        endRace = new CountDownLatch(CARS_COUNT);
        beginRace = new CountDownLatch(CARS_COUNT);
        lock=new ReentrantLock();

    }
    @Override
    public String call() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            beginRace.countDown();
            carsReadyAll.await();
            Thread.sleep(5);

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
       if (lock.tryLock()&&winner==0) {
           {
               lock.lock();
               System.out.println(this.getName() + " Пришел к финишу первым!");
               winner = 1;
               lock.unlock();
           }
       }
        endRace.countDown();
        return this.name;
    }
}