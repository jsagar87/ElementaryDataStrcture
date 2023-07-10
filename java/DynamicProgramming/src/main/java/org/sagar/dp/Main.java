package org.sagar.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class Main{

    static void printArry(int[] myArray) {
        for (int arrayItem : myArray) {
            System.out.print(arrayItem);
            System.out.print(' ');
        }
        System.out.println();
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        printArry(A);
        return A[A.length-1];
    }

    public static void main(String[] args) {
        int[] myArray = new int[] {1,3,6,4,1,2} ;

        printArry(myArray);
        System.out.println(solution(myArray));

    }
}