package ru.geekbrains.Java3;

public class Test_first extends TestMajor {

    @BeforeSuite
    public static void beforeTestFirst (){
        System.out.println("Выполняется только перед тестами один раз в начале.");
    }
//
//    @AfterSuite
//    public static void mistake (){
//        System.out.println("Выполняется только перед тестами один раз в начале.");
//    }

    @Test
    public static void test11 (){
        System.out.println("Выполнен тест 1.1");
    }

    @Test
    public static void test12(){
        System.out.println("Выполнен тест 1.2");
    }

    @Test
    public static void test13(){
        System.out.println("Выполнен тест 1.3");
    }

    @AfterSuite
    public static void afterTestFirst (){
        System.out.println("Выполняется только после всех тестов один раз в конце.");
    }
}
