package ru.geekbrains.Java3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int CARS_COUNT = 4;


    public static void main(String[] args) {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];


        ExecutorService executorService = Executors.newFixedThreadPool(CARS_COUNT);
        List<Callable<String>> raceParticipants = new ArrayList<>();
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
            raceParticipants.add(cars[i]);
            executorService.submit(cars[i]);
        }

        try {
            Car.beginRace.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        }

        try {
            Car.endRace.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            executorService.shutdown();
        }

    }

}







