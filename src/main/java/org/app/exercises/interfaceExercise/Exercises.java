package org.app.exercises.interfaceExercise;

public abstract class Exercises {
    protected String separator = "---------------------";

    protected String getFormattedExcerciseTitle(String title){
        return String.format("--- %s ---", title);
    }

}
