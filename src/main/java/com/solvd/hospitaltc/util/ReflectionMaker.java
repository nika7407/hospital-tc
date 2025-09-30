package com.solvd.hospitaltc.util;

import com.solvd.hospitaltc.worker.Doctor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectionMaker {

    public static <T> void analyzeReflect(T object) {

        Class<?> clas = object.getClass();
        System.out.println("\nAnalysing:" + clas.getName());

        Field[] fields = clas.getDeclaredFields();
        for (Field field : fields) {

            String fieldName = field.getName();
            System.out.println(fieldName);
            String type = field.getType().getSimpleName();
            System.out.println(type);
            String modifiers = Modifier.toString(field.getModifiers());
            System.out.println(modifiers + "\n");

        }
        Constructor<?>[] constructors = clas.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            String constructorName = constructor.getName();
            System.out.println(constructorName);
            Parameter[] parameters = constructor.getParameters();
            System.out.println(parameters);
            String modifiers = Modifier.toString(constructor.getModifiers());
            System.out.println(modifiers + "\n");
        }
        Method[] methods = clas.getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            System.out.println(methodName);
            String returnType = method.getReturnType().getSimpleName();
            System.out.println(returnType);
            Parameter[] parameters = method.getParameters();
            System.out.println(parameters);
            String modifiers = Modifier.toString(method.getModifiers());
            System.out.println(modifiers + "\n");
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
