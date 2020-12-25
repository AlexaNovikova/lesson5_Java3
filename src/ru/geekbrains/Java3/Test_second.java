package ru.geekbrains.Java3;

public class Test_second extends TestMajor {

        @BeforeSuite
        public static void beforeTestSecond (){
            System.out.println("Выполняется только перед тестами один раз в начале.");
        }

//        @BeforeSuite
//         public static void mistake2 (){
//        System.out.println("Выполняется только перед тестами один раз в начале.");
//        }

        @Test
        public static void test21 (){
            System.out.println("Выполнен тест 2.1");
        }


        @Test
        public static void test22(){
            System.out.println("Выполнен тест 2.2");
        }

        @Test
        public static void test23(){
            System.out.println("Выполнен тест 2.3");
        }

        @AfterSuite
        public static void afterTestSecond (){
            System.out.println("Выполняется только после всех тестов один раз в конце.");
        }
    }


