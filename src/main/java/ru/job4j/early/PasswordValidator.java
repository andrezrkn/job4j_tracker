package ru.job4j.early;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        boolean hasUpCase = false;
        boolean hasLowCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        if (password == null) {
            throw new IllegalArgumentException(
                    "Password can't be null"
            );
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException(
                    "Password should be length [8, 32]"
            );
        }

        for (String el : FORBIDDEN) {
            Pattern pattern = Pattern.compile(el, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(password);
            if (matcher.find()) {
                throw new IllegalArgumentException(
                        "Password shouldn't contain substrings:"
                                + " qwerty, 12345, password, admin, user"
                );
            }
        }

        for (char symbol : password.toCharArray()) {
            if (hasLowCase && hasDigit && hasUpCase && hasSpecial) {
                break;
            }
            if (!hasUpCase && Character.isUpperCase(symbol)) {
                hasUpCase = true;
            }
            if (!hasLowCase && Character.isLowerCase(symbol)) {
                hasLowCase = true;
            }
            if (!hasDigit && Character.isDigit(symbol)) {
                hasDigit = true;
            }
            if (!hasSpecial && !Character.isLetterOrDigit(symbol)) {
                hasSpecial = true;
            }
        }

        if (!hasUpCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter"
            );
        }
        if (!hasLowCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter"
            );
        }
        if (!hasDigit) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure"
            );
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol"
            );
        }
        return password;
    }
}
