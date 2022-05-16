package com.atr.sort_algorithms.recursion;

public class Recursion {

    public static void main(String[] args) {
        int a = 5;
        System.out.println("IterativeFactorial: " + iterativeFactorial(a));
        System.out.println("RecursiveFactorial: " + recursiveFactorial(a));

    }


    public static int iterativeFactorial(int num) {
        if (num == 0)
            return 1;

        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    // 1! = 0! * 1 = 1
    // 2! = 2 * 1 = 2 *1!
    // 3! = 3 * 2 * 1 = 3 * 2 * 1!
    // 4! = 4 * 3 * 2 * 1 = 4 * 3!

    // n! = n * (n-1)!

    public static int recursiveFactorial(int num) {
        if (num == 0)
            return 1;
        return num * recursiveFactorial(num - 1);
    }

}
