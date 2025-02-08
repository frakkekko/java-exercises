package org.app.exercises;

import org.app.exercises.interfaceExercise.Exercises;
import org.app.utils.Utils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class CycleExercises extends Exercises {
    private static CycleExercises cycleExercisesInstance;

    private CycleExercises(){};

    public void firstTenNumbers() {
        System.out.println(getFormattedExcerciseTitle("firstTenNumbers"));
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};

        System.out.println("Print first ten number of " + Arrays.toString(nums));

        for (int i = 0; i < 10; i++) {
            System.out.println(nums[i]);
        }

        System.out.println(separator);
    }

    public void firstTenEvenNumbers() {
        System.out.println(getFormattedExcerciseTitle("firstTenEvenNumbers"));

        for (int i = 20; i > 0; i--) {
            if(i % 2 != 0) continue;

            System.out.println(i);
        }


        System.out.println(separator);
    }

    public void tabellina() {
        System.out.println(getFormattedExcerciseTitle("tabellina"));

        int numberTabellina = 8;

        Utils.printTabellina(numberTabellina);

        System.out.println(separator);
    }

    public void printFigure() {
        System.out.println(getFormattedExcerciseTitle("printFigure"));
        Utils.printFigure("*");
        System.out.println(separator);
    }

    public void printReversedFigure() {
        System.out.println(getFormattedExcerciseTitle("printReversedFigure"));
        Utils.printReversedFigure("#");
        System.out.println(separator);
    }

    public void printNumberFigure() {
        System.out.println(getFormattedExcerciseTitle("printNumberFigure"));
        Utils.printNumberFigure();
        System.out.println(separator);
    }

    public void printFibonacci() {
        System.out.println(getFormattedExcerciseTitle("printFibonacci"));
        List<BigInteger> fibonacciSequence = Utils.calculateFibonacciSequence(100);

        fibonacciSequence.forEach(number -> System.out.println(number));

        System.out.println(separator);
    }

    public void printFibonacciWaterfall() {
        System.out.println(getFormattedExcerciseTitle("printFibonacciWaterfall"));
        int numberOfIteration = 12;

        List<BigInteger> fibonacciSequence = Utils.calculateFibonacciSequence(numberOfIteration);

        for(int i = 1; i <= numberOfIteration; i++) {
            System.out.println(fibonacciSequence.subList(0, i).toString());
        }

        System.out.println(separator);
    }

    public static CycleExercises getInstance() {
        if(CycleExercises.cycleExercisesInstance == null) {
            CycleExercises.cycleExercisesInstance = new CycleExercises();
        }
        return CycleExercises.cycleExercisesInstance;
    }
}
