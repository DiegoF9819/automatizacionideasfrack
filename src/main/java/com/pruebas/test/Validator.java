package com.pruebas.test;

public class Validator {
    public static boolean isNotNullOrEmpty(String str) {
        return str != null && !str.isEmpty();
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email != null && email.matches(emailRegex);
    }
}
