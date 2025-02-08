package org.app;

import org.app.exercises.*;
import org.app.exercises.interfaceExercise.Exercises;
import org.app.exercises.provider.ExercisesProvider;

public class Main {
    public static void main(String[] args) {
        Exercises arrayExercises = ArrayExercisesStandardImpl.getInstance();
        Exercises stringExercises = StringExercises.getInstance();
        Exercises cycleExercises = CycleExercises.getInstance();

        ExercisesProvider.executeAll(arrayExercises);
        ExercisesProvider.executeAll(stringExercises);
        ExercisesProvider.executeAll(cycleExercises);
    }
}