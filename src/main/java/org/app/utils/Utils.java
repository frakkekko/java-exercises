package org.app.utils;

import org.app.exceptions.MaxMinCalcException;
import org.app.exceptions.OddSizeListException;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {
    public static <T extends  Number & Comparable> Map<String, T> getMaxAndMinFromList(List<T> numbers) throws MaxMinCalcException {
        Map<String, T> mappedValues = new HashMap<>();

        Optional<T> max = numbers.stream().max(T::compareTo);
        Optional<T> min = numbers.stream().min(T::compareTo);

        if(max.isEmpty() || min.isEmpty()) {
            throw new MaxMinCalcException();
        }

        mappedValues.put("Max", max.get());
        mappedValues.put("Min", min.get());

        return mappedValues;
    }

    public static boolean contains(int e, int[] array) {
        for (int element : array) {
            if(e == element){
                return true;
            }
        }

        return false;
    }

    public static boolean contains(Object e, Object[] array) {
        for(Object arrayItem : array) {
            if(e.equals(arrayItem)){
                return true;
            }
        }

        return false;
    }

    public static boolean isCrescente(int[] array) {
        for(int i = 1; i < array.length; i++) {
            if(array[i] < array[i-1]){
                return false;
            }
        }

        return true;
    }

    public static <T> List<T> getZigZagOrder(List<T> list) throws OddSizeListException {
        if(list.size() % 2 != 0) {
            throw new OddSizeListException();
        }

        List<T> zigZagOrderList = new ArrayList<>();

        for(int i = 0; i < list.size() / 2; i++){
            zigZagOrderList.add(list.get(i));
            zigZagOrderList.add(list.get((list.size() - 1) - i));
        }

        return zigZagOrderList;
    }

    public static <T> List<T> getZigZagOrder(T[] arr) {
        List<T> convertedList = Arrays.asList(arr);
        return Utils.getZigZagOrder(convertedList);
    }

    public static <T> List<Integer> getZigZagOrder(int[] arr) {
        List<Integer> convertedList = Arrays.asList(
                Arrays.stream(arr).boxed().toArray(Integer[]::new)
        );
        return Utils.getZigZagOrder(convertedList);
    }

    public static String[] addString(String s, String[] a) {
        String[] mergedArr = new String[a.length + 1];
        System.arraycopy(a, 0, mergedArr , 0, a.length);
        mergedArr[mergedArr.length - 1] = s;

        return mergedArr;
    }

    // ------------------------------------

    public static String getOnlyVowels(String str) {
        final String vowels = "aeiouAEIOU";
        return Arrays.stream(str.split("")).filter(strChar -> vowels.contains(strChar)).collect(Collectors.joining());
    }

    public static String[] getStringStartWithCapital(String[] strArr) {
        return Arrays.stream(strArr).filter(str -> {
            Pattern p = Pattern.compile("^[A-Z]");
            Matcher m = p.matcher(str);
            return m.find();
        }).toArray(String[]::new);
    }

    public static int coutLetterOccurrency(char c, String str) {
        int numOccurrency = 0;
        char normalizedChar = Character.toLowerCase(c);
        char[] characters = str.toLowerCase().toCharArray();

        for(char character : characters) {
            if(character == normalizedChar) {
                numOccurrency += 1;
            }
        }

        return numOccurrency;
    }

    public static String getReversedString(String str){
        List<String> strList = Arrays.asList(str.split(""));
        Collections.reverse(strList);

        return strList.stream().collect(Collectors.joining());
    }

    public static String joinStrings(String delimiter, String... strs) {
        List<String> strList = Arrays.asList(strs);
        return strList.stream().collect(Collectors.joining(delimiter));
    }

    // ------------------------------------

    public static void printTabellina(int number) {
        for(int i = 0; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }

    public static void printFigure(String symbol) {
        for (int i = 0; i <= 5; i++) {
            for(int j = 6 - i; j > 0; j--){
                System.out.print(symbol);
            }

            System.out.print("\n");
        }
    }

    public static void printReversedFigure(String symbol) {
        for (int i = 0; i <= 5; i++) {
            for(int j = 0; j <= i; j++){
                System.out.print(symbol);
            }

            System.out.print("\n");
        }
    }

    public static void printNumberFigure() {
        for(int i = 0; i < 6; i++) {
            for(int j = 1; j <= i + 1; j++) {
                System.out.print(j);
            }

            System.out.print("  ");

            for(int k = 6 - i; k > 0; k--) {
                System.out.print(k);
            }

            System.out.print("\n");
        }
    }

    public static List<BigInteger> calculateFibonacciSequence(int endEdge) {
        List<BigInteger> fibonacciSequence = new ArrayList<>();
        for (int i = 0; i < endEdge; i++) {
            if (i == 0 || i == 1) {
                fibonacciSequence.add(BigInteger.ONE);
                continue;
            }
            fibonacciSequence.add(fibonacciSequence.get(i-2).add(fibonacciSequence.get(i-1)));
        }

        return fibonacciSequence;
    }
}
