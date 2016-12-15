package org.fasttrackit.util;

/**
 * Created by Marius on 08-Dec-16.
 */
public class Primul {
    public static void main(String[] args) {
        System.out.println("main body");

        int sum = Calc.add(2, 5);
        System.out.println("Sum is:" + sum);

    }
}

class  Calc {
   public static int add(int a, int b) {
       return a + b;
}
}
