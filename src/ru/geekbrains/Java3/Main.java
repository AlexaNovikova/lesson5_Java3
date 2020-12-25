package ru.geekbrains.Java3;
// Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами методов с аннотациями @Test.
// Для этого у него должен быть статический метод start(), которому в качестве параметра передается или объект типа Class,
// или имя класса. Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется,
// далее запущены методы с аннотациями @Test, а по завершению всех тестов – метод с аннотацией @AfterSuite.
// К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10), в соответствии с которыми будет
// выбираться порядок их выполнения, если приоритет одинаковый, то порядок не имеет значения.
// Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре, иначе необходимо
// бросить RuntimeException при запуске «тестирования».


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        Class myTest = MyTest.class;
        MyTest myTest1 = new MyTest();
        Class test1 = Test_first.class;
        Class test2 = Test_second.class;
        Class test3 = Test_third.class;
        Class[] test = {test1, test2, test3};

        System.out.println(myTest.getMethods());

        Method mStart = null;
        try {
            mStart = myTest.getMethod("start", Class.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        for (Class aClass : test)
            try {
                mStart.invoke(myTest1, aClass);
            } catch (RuntimeException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
    }
}


