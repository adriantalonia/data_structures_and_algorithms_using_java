package com.atr.sort_algorithms.shell_sort;


/**
 * - In place algorithm
 * - Difficult to nail down the time complexity because it will depend on the gap, worts case : O(n2), but it can perform much better than that like O(n)
 * - Doesn't require as much shifting as insertion sort, so it usually performs better
 * - Unstable algorithm
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < intArray.length; i += 1) {
                int temp = intArray[i];

                /*int j;
                for (j = i; j >= gap && intArray[j - gap] > temp; j -= gap) {
                    intArray[j] = intArray[j - gap];
                }
                intArray[j] = temp;*/
                int j = i;
                while (j >= gap && intArray[j - gap] > temp) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }
                intArray[j] = temp;

            }
        }

        for (int i = 0; i < intArray.length; ++i)
            System.out.print(intArray[i] + " ");
    }
}
