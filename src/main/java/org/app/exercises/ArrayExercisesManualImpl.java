package org.app.exercises;

import org.app.exercises.interfaceExercise.ArrayExercisesI;
import org.app.exercises.interfaceExercise.Exercises;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayExercisesManualImpl extends Exercises implements ArrayExercisesI {
    private static volatile ArrayExercisesManualImpl arrayExercisesInstance;

    private ArrayExercisesManualImpl(){};

    @Override
    public void minMaxInArray() {
        System.out.println(getFormattedExcerciseTitle("minMaxInArray"));
        int[] arr = {5,2,3,1,9,6,7,14,10};
        int max = arr[0];
        int min = arr[0];

        for (int num : arr) {
            if(num > max) {
                max = num;
            }

            if(num < min) {
                min = num;
            }
        }

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println(separator);
    }

    @Override
    public void findMaxAndMinIndex() {
        System.out.println(getFormattedExcerciseTitle("findMaxAndMinIndex"));

        int[] arr = {5,2,3,1,9,6,7,14,10};
        int indexOfMax = arr[0];
        int indexOfMin = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > indexOfMax) {
                indexOfMax = i;
            }

            if(arr[i] < indexOfMin) {
                indexOfMin = i;
            }
        }

        System.out.println("Index of Min: " + indexOfMin);
        System.out.println("Index of Max: " + indexOfMax);
        System.out.println(separator);

    }

    @Override
    public void isElementPresent() {
        int[] arr = {5,2,3,1,9,6,7,14,10};
        int elementToCheck = 5;

        boolean isElementPresent = false;

        for (int element : arr) {
            if (element == elementToCheck){
                isElementPresent = true;
                break;
            }
        }

        System.out.println("Is present element " + elementToCheck + " in array: " + isElementPresent);
    }

    @Override
    public void verifyIsCrescente() {
        int[] arr = {1,5,8,9,14};
        boolean isCrescente = false;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]) {
                break;
            }

            if(i == arr.length - 1){
                isCrescente = true;
            }
        }

        System.out.println("Is array crescente: " + isCrescente);
    }

    @Override
    public void mostPresentElement() {
        System.out.println(getFormattedExcerciseTitle("mostPresentElement"));

        Integer[] numbersArr = {32,14,12,26,43,87,32,32,87,32,43,14,92,60,31};

        Map<Integer, Long> occurencyMap = Arrays.stream(numbersArr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<Integer, Long> maxEntry = Collections.max(occurencyMap.entrySet(), Map.Entry.comparingByValue());

        System.out.println("Elemento più ricorrente: " + maxEntry.getKey() + " --- Numero occorrenze: " + maxEntry.getValue());
        System.out.println(separator);

    }

    @Override
    public void mediaMultipliTre() {
        System.out.println(getFormattedExcerciseTitle("mediaMultipliTre"));
        int[] numbersArr = {32,14,12,26};
        int sum = 0;
        int length = 0;

        for (int number : numbersArr) {
            if(number % 3 == 0) {
                sum += number;
                length++;
            }
        }

        System.out.println("Average: " + (sum/length));
        System.out.println(separator);
    }

    @Override
    public void stampaZigZag() {
        System.out.println(getFormattedExcerciseTitle("stampaZigZag"));
        int[] numsArr = {1,2,3,4,5,6,7,8,9,10};
        int[] zigZagArr = new int[numsArr.length];

        int left = 0;
        int right = numsArr.length - 1;
        int index = 0;

        while (index <= numsArr.length - 1) {
            zigZagArr[index++] = numsArr[left];
            zigZagArr[index++] = numsArr[right];

            left++;
            right--;
        }

        System.out.println("Original Array: " + Arrays.toString(numsArr));
        System.out.println("ZigZag Array: " + Arrays.toString(zigZagArr));
        System.out.println(separator);
    }

    @Override
    public void media() {
        System.out.println(getFormattedExcerciseTitle("media"));
        int[] numsArr = {2,24,5,3};
        int total = 0;
        for (int number : numsArr) {
            total += number;
        }

        double average = (double) total / numsArr.length;

        System.out.println("Average: " + average);
        System.out.println(separator);
    }

    @Override
    public void pushStringInArray() {

        System.out.println(getFormattedExcerciseTitle("pushStringInArray"));
        String[] strArr = {"1a","2b","3c"};
        String strToAdd = "4d";

        String[] newString = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, newString, 0, strArr.length);
        newString[newString.length-1] = strToAdd;

        System.out.println("Original string array: " + Arrays.toString(strArr) + " --- New String array: " + Arrays.toString(newString));
        System.out.println(separator);
    }

    public static ArrayExercisesManualImpl getInstance() {
        synchronized (ArrayExercisesManualImpl.class) {
            if(ArrayExercisesManualImpl.arrayExercisesInstance == null) {
                ArrayExercisesManualImpl.arrayExercisesInstance = new ArrayExercisesManualImpl();
            }
        }
        return ArrayExercisesManualImpl.arrayExercisesInstance;
    }
}
