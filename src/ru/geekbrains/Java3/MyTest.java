package ru.geekbrains.Java3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class MyTest {

    public void start (Class testRun) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
         if (!(testRun.getSuperclass().equals(TestMajor.class))){
             throw new RuntimeException("Неверный параметр!");
         }
        int kol = 0;
        int kol2 = 0;

           Constructor constructor= testRun.getConstructor(null);

           Object object = constructor.newInstance(null);

             Method[] methods = testRun.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(BeforeSuite.class)) {
                kol++;

            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                kol2++;
            }

            if ((kol > 1) || (kol2 > 1))
                throw new RuntimeException("Ошибка аннотации");
        }

        if (kol==1){
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class))
                method.invoke(object);
        }}
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class))
                method.invoke(object);
        }
        if (kol2==1) {
            for (Method method : methods) {
                if (method.isAnnotationPresent(AfterSuite.class))
                    method.invoke(object);
            }
        }
    }
}

