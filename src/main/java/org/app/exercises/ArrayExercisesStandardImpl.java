package org.app.exercises;

import org.app.exercises.interfaceExercise.ArrayExercisesI;
import org.app.exercises.interfaceExercise.Exercises;
import org.app.sampledata.Car;
import org.app.sampledata.FerrariRoma;
import org.app.sampledata.TeslaModelS;
import org.app.utils.Utils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayExercisesStandardImpl extends Exercises implements ArrayExercisesI {
    private static volatile ArrayExercisesStandardImpl arrayExercisesInstance;

    private ArrayExercisesStandardImpl(){};

    @Override
    public void minMaxInArray() {
        System.out.println(getFormattedExcerciseTitle("minMaxInArray"));

        Integer[] numbersArr = {32,14,26,43,87,43,92,60,31};
        List<Integer> numbersList = Arrays.asList(numbersArr);

        Map<String, Integer> maxMinMap = Utils.getMaxAndMinFromList(numbersList);

        System.out.println("Numbers list: " + numbersList);
        System.out.println("Max number: " + maxMinMap.get("Max") + " --- Min number: " + maxMinMap.get("Min"));
        System.out.println(separator);
    }

    @Override
    public void findMaxAndMinIndex() {
        System.out.println(getFormattedExcerciseTitle("findMaxAndMinIndex"));

        Integer[] numbersArr = {32,14,26,43,87,43,92,60,31};
        List<Integer> numbersList = Arrays.asList(numbersArr);

        Map<String, Integer> maxMinMap = Utils.getMaxAndMinFromList(numbersList);

        Integer indexOfMaxNumber = numbersList.indexOf(maxMinMap.get("Max"));
        Integer indexOfMinNumber = numbersList.indexOf(maxMinMap.get("Min"));

        System.out.println("Numbers list: " + numbersList);
        System.out.println("Index of Max: " + indexOfMaxNumber + " --- Index of Min: " + indexOfMinNumber);
        System.out.println(separator);
    }

    @Override
    public void isElementPresent() {
        System.out.println(getFormattedExcerciseTitle("isElementPresent"));

        int[] primitiveNumbersArr = {32,14,26,43,87,43,92,60,31};
        int primitiveNumberToCheck = 8;
        System.out.println("Is " + primitiveNumberToCheck + " contained in primitive array: " + Utils.contains(primitiveNumberToCheck, primitiveNumbersArr));

        Integer objectNumberToCheck = 81;
        Integer[] objectNumbersArr = {32,14,26,43,87,43,92,60,31};
        System.out.println("Is " + objectNumberToCheck + " contained in object array: " + Utils.contains(objectNumberToCheck, objectNumbersArr));

        // ---------------------------
        Car ferrari1 = new FerrariRoma("12321232323234567");
        Car ferrari2 = new FerrariRoma("12321232277645656");
        Car tesla1 = new TeslaModelS("12665454544543534");
        Car tesla2 = new TeslaModelS("12665454654345238");

        Car objectToCheck1 = new FerrariRoma("1245678990");
        Car objectToCheck2 = new FerrariRoma("12321232323234567");
        Car objectToCheck3 = ferrari2;
        Car[] objectCarsArray = {ferrari1, ferrari2, tesla1, tesla2};

        System.out.println("Is " + objectToCheck1.getSerialNumber() + " contained in object array: " + Utils.contains(objectToCheck1, objectCarsArray));
        System.out.println("Is " + objectToCheck2.getSerialNumber() + " contained in object array: " + Utils.contains(objectToCheck2, objectCarsArray));
        System.out.println("Is " + objectToCheck3.getSerialNumber() + " contained in object array: " + Utils.contains(objectToCheck3, objectCarsArray));

        // Anche se objectToCheck2 ha le stesse proprietà di ferrari1, avremo sempre false perché sono referenziate in aree diverse di memoria
        System.out.println(separator);
    }

    @Override
    public void verifyIsCrescente() {
        System.out.println(getFormattedExcerciseTitle("verifyIsCrescente"));

        int[] primitiveNumbersArr = {1,2,3,5,8,10};

        System.out.println("primitiveArray: " + Arrays.toString(primitiveNumbersArr) + " is crescent: " + Utils.isCrescente(primitiveNumbersArr));
        System.out.println(separator);
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

        int[] numbersArr = {32,14,12,1,30,26,27,43, 90};
        OptionalDouble average = Arrays.stream(numbersArr).filter(number -> number % 3 == 0).average();

        System.out.println(average.isPresent() ?
                "Average of the multiple numbers of 3: " + average.getAsDouble() :
                "There are no multiple numbers of three");
        System.out.println(separator);
    }

    @Override
    public void stampaZigZag() {
        System.out.println(getFormattedExcerciseTitle("stampaZigZag"));
        int[] primitiveNums = {1,2,3,4,5,6,7,8,9,10};
        Integer[] objectNums = {1,2,3,4,5,6};
        List<Integer> objectNumsList = Arrays.asList(objectNums);

        System.out.println(
                "Primitive original numbers: " + Arrays.toString(primitiveNums) + " --- " +
                        "ZigZag order: " + Utils.getZigZagOrder(primitiveNums)
        );

        System.out.println(
                "Object original numbers: " + Arrays.toString(Arrays.stream(objectNums).toArray()) + " --- " +
                        "ZigZag order: " + Utils.getZigZagOrder(objectNums)
        );

        System.out.println(
                "Object original numbers list: " + Arrays.toString(objectNumsList.toArray()) + " --- " +
                        "ZigZag order: " + Utils.getZigZagOrder(objectNumsList)
        );

        System.out.println(separator);
    }

    @Override
    public void media() {
        System.out.println(getFormattedExcerciseTitle("media"));
        int[] numbersArr = {1,2,3,4};

        OptionalDouble average = Arrays.stream(numbersArr).average();

        System.out.println(average.isPresent() ?
                "Average: " + average.getAsDouble() :
                "Cannot convert average of empty list");

        System.out.println(separator);
    }

    @Override
    public void pushStringInArray() {
        System.out.println(getFormattedExcerciseTitle("pushStringInArray"));
        String[] originaStringArray = {"1a", "2b", "3c"};
        String stringToAppend = "4d";

        System.out.println("Original String array: " + Arrays.toString(originaStringArray) +
                " --- new array: " + Arrays.toString(Utils.addString(stringToAppend, originaStringArray)));

        System.out.println(separator);
    }

    public static ArrayExercisesStandardImpl getInstance() {
        synchronized (ArrayExercisesStandardImpl.class) {
            if(ArrayExercisesStandardImpl.arrayExercisesInstance == null) {
                ArrayExercisesStandardImpl.arrayExercisesInstance = new ArrayExercisesStandardImpl();
            }
        }
        return ArrayExercisesStandardImpl.arrayExercisesInstance;
    }

}
