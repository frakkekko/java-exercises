package org.app.exercises;

import org.app.exercises.interfaceExercise.Exercises;
import org.app.utils.Utils;

import java.util.Arrays;

public class StringExercises extends Exercises {
    private static volatile StringExercises stringExercisesInstance;

    private StringExercises(){};

    public void soloVocali() {
        System.out.println(getFormattedExcerciseTitle("soloVocali"));

        String str = "string test";
        System.out.println("Original string: " + str + " --- vowels: " + Utils.getOnlyVowels(str));

        System.out.println(separator);
    }

    public void stampaMaiuscole() {
        System.out.println(getFormattedExcerciseTitle("stampaMaiuscole"));
        String[] originalStrArr = {"pippo", "Pluto", "Paperino", "fOo"};

        System.out.println("Original string array: " + Arrays.toString(originalStrArr) + " --- New array filtered: " + Arrays.toString(Utils.getStringStartWithCapital(originalStrArr)));
        System.out.println(separator);

    }

    public void contaLettera() {
        System.out.println(getFormattedExcerciseTitle("contaLettera"));
        String str = "String test";
        char charToFind = 'S';

        Utils.coutLetterOccurrency(charToFind, str);

        System.out.println("[Case insensitive] Occurrency number of letter \'" + charToFind + "\' in string \"" + str + "\" --> " + Utils.coutLetterOccurrency(charToFind, str));
        System.out.println(separator);

    }

    public void contrario() {
        System.out.println(getFormattedExcerciseTitle("contrario"));
        String str = "Test";

        System.out.println("Original string: " + str + " --- reversed string: " + Utils.getReversedString(str));
        System.out.println(Utils.getReversedString(str));
        System.out.println(separator);
    }

    public void concatena() {
        System.out.println(getFormattedExcerciseTitle("concatena"));
        String str1 = "pippo";
        String str2 = "pluto";
        String str3 = "paperino";

        System.out.println("Strings concatenated: " + Utils.joinStrings("*", str1, str2, str3));

        System.out.println(separator);
    }

    public static StringExercises getInstance() {
        synchronized (StringExercises.class) {
            if(StringExercises.stringExercisesInstance == null) {
                StringExercises.stringExercisesInstance = new StringExercises();
            }
        }
        return StringExercises.stringExercisesInstance;
    }
}
