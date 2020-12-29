package ru.geekbrains.Java3;

public class Main {

    public static void main(String[] args) {
	 int x= 8;
	 test(x);
	 Integer i = new Integer(7);
     Integer j = new Integer(7);
        System.out.println(i==j);
        System.out.println(i.equals(j));
    // Integer pull (-127 127)
        Integer a =125;
        Integer b = 125;
        System.out.println(a==b);

        for (String arg : args) {
            System.out.println(arg);
        }




        Object o = "fff";
        System.out.println(((String)o).length());
    }
    private static void test (Integer a){
        System.out.println(a);
    }
}
