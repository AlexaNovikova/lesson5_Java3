package ru.geekbrains.Java3;

public class Test_third extends TestMajor{

    @BeforeSuite
    public static void beforeTestThird (){
        System.out.println("Выполняется только перед тестами один раз в начале.");
    }

    @Test
    public static void test31 (){
        System.out.println("Выполнен тест 3.1");
    }


    @Test
    public static void test32(){
        System.out.println("Выполнен тест 3.2");
    }

    @Test
    public static void test33(){
        System.out.println("Выполнен тест 3.3");
    }

    @AfterSuite
    public static void afterTestThird (){
        System.out.println("Выполняется только после всех тестов один раз в конце.");
    }
}


