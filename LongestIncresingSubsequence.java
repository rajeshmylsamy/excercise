package com.learn.java.core.excercises;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Rajesh Mylsamy
 */

public class LongestIncresingSubsequence {
    public static void main(String[] args) {
        Stream.of(
                new TestCases(new int[] {3, 10, 2, 1, 20}, 3),
                new TestCases(new int[] {3, 2}, 1),
                new TestCases(new int[] {50, 3, 10, 7, 40, 80}, 4),
                new TestCases(new int[] {3, 8, 90, 7, 40, 80}, 4)
        ).forEach(testCase -> {
           int result = getLongestIncresingSubsequence(testCase.input);
            System.out.println("Input:" + Arrays.toString(testCase.input) + " ExpectedOutput:" + testCase.output + " ActualOutput:" + result + " Result:" + (result == testCase.output ? "Success" : "Failure"));
        });

    }

    private static  int getLongestIncresingSubsequence(int[] inputValues) {
        int lis = 0;
        for (int i = 0; i < inputValues.length; i++) {
            int[] newArray = Arrays.copyOfRange(inputValues, i, inputValues.length);
            int currentLis = computeLongestIncreasingSubsequence(newArray);
            if (currentLis > lis) {
                lis = currentLis;
            }
        }
        return lis;
    }

    private static int computeLongestIncreasingSubsequence(int[] inputValues) {
        if (inputValues.length == 0)
            return 0;
        if (inputValues.length == 1)
            return 1;

        int maxLis = 0;
        for (int i = 0; i < inputValues.length; i++) {
            int lisTillI = computeLongestIncreasingSubsequence(Arrays.copyOfRange(inputValues, 0, i));
            if ( i == 0) {
                continue;
            }
            if (inputValues[inputValues.length - 1] > inputValues[i - 1] && lisTillI + 1 > maxLis) {
                maxLis = lisTillI + 1;
            }
        }
        return maxLis;
    }
}

class TestCases {
    int[] input;
    int output;

    TestCases(int[] input, int output) {
        this.input = input;
        this.output = output;
    }
}
