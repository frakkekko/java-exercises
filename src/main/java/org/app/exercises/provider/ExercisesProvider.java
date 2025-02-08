package org.app.exercises.provider;

import org.app.exercises.interfaceExercise.Exercises;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ExercisesProvider {
    public static void executeAll(Exercises exercisesObj){
        Class clazz = exercisesObj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            int modifier = method.getModifiers();
            if(method.getParameterCount() != 0 || Modifier.isPrivate(modifier) || Modifier.isStatic(modifier) || Modifier.isAbstract(modifier)) {
                continue;
            }
            try {
                method.invoke(exercisesObj);
            } catch (Exception error) {
                System.out.println(error);
            }
        }
    }
}
