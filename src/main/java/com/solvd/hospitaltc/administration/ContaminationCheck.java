package com.solvd.hospitaltc.administration;

import com.solvd.hospitaltc.util.CustomContaminationAnnotation;

public class ContaminationCheck {

    public static <T> void Check(T objectToCheck) {
        Class<?> clazz = objectToCheck.getClass();
        if (clazz.isAnnotationPresent(CustomContaminationAnnotation.class)) {
            String status = clazz.getAnnotation(CustomContaminationAnnotation.class).status();
            System.out.println("\n" + clazz.getName() + "HAS " + status);

        } else {
            System.out.println("\n" + clazz.getName() + " does not has contamination!");
        }
    }
}
