package com.solvd.hospitaltc.util;

import com.solvd.hospitaltc.worker.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class ReflectionMaker {

    private static final Logger log = LogManager.getLogger(ReflectionMaker.class);

    public static <T> void analyzeReflect(T object) {

        Class<?> clas = object.getClass();
        log.info("Analysing:{}", clas.getName());

        Field[] fields = clas.getDeclaredFields();
        for (Field field : fields) {

            String fieldName = field.getName();
            log.info(fieldName);
            String type = field.getType().getSimpleName();
            log.info(type);
            String modifiers = Modifier.toString(field.getModifiers());
            log.info("{}\n", modifiers);
        }
        Constructor<?>[] constructors = clas.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            String constructorName = constructor.getName();
            log.info(constructorName);
            Parameter[] parameters = constructor.getParameters();
            log.info(Arrays.toString(parameters));
            String modifiers = Modifier.toString(constructor.getModifiers());
            log.info("{}\n", modifiers);
        }
        Method[] methods = clas.getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            log.info(methodName);
            String returnType = method.getReturnType().getSimpleName();
            log.info(returnType);
            Parameter[] parameters = method.getParameters();
            log.info(Arrays.toString(parameters));
            String modifiers = Modifier.toString(method.getModifiers());
            log.info("{}\n", modifiers);
        }
    }

    public static Doctor createDoctorWithReflection(Doctor doctor) throws Exception {
        Class<Doctor> doctorClass = Doctor.class;
        Field firstNameField = doctorClass.getSuperclass().getDeclaredField("firstName");
        firstNameField.setAccessible(true);
        String firstName = (String) firstNameField.get(doctor);

        Field lastNameField = doctorClass.getSuperclass().getDeclaredField("lastName");
        lastNameField.setAccessible(true);
        String lastName = (String) lastNameField.get(doctor);

        Field ageField = doctorClass.getSuperclass().getDeclaredField("age");
        ageField.setAccessible(true);
        int age = (int) ageField.get(doctor);

        Field emailField = doctorClass.getSuperclass().getDeclaredField("email");
        emailField.setAccessible(true);
        String email = (String) emailField.get(doctor);

        Field fieldField = doctorClass.getDeclaredField("field");
        fieldField.setAccessible(true);
        String field = (String) fieldField.get(doctor);

        Field expField = doctorClass.getDeclaredField("expirienceYears");
        expField.setAccessible(true);
        int experienceYears = (int) expField.get(doctor);

        Constructor<Doctor> constructor = doctorClass.getDeclaredConstructor(
                String.class, String.class, int.class, String.class, String.class, int.class
        );


        return constructor.newInstance(firstName + "reflected", lastName, age, email, field, experienceYears);
    }

}
