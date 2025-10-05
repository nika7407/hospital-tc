package com.solvd.hospitaltc.administration;

import com.solvd.hospitaltc.util.CustomContaminationAnnotation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContaminationCheck {

    private static final Logger logger = LogManager.getLogger(ContaminationCheck.class);

    public static <T> void Check(T objectToCheck) {
        Class<?> clazz = objectToCheck.getClass();
        if (clazz.isAnnotationPresent(CustomContaminationAnnotation.class)) {
            String status = clazz.getAnnotation(CustomContaminationAnnotation.class).status();
            logger.info("{} HAS {}", clazz.getName(), status);
        } else {
            logger.info("{} does no has contamination!", clazz.getName());
        }
    }
}
