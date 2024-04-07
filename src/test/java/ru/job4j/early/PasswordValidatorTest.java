package ru.job4j.early;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PasswordValidatorTest {

    @Test
    public void whenPasswordIsValid() {
        String password = "Ln2$mrTY12";
        String expected = "Ln2$mrTY12";
        String result = PasswordValidator.validate(password);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPasswordisNull() {
        try {
            PasswordValidator.validate(null);
        } catch (IllegalArgumentException exc) {
            String expected = "Password can't be null";
            assertThat(exc.getMessage(), is(expected));
        }
    }

    @Test
    public void whenPasswordLengthLess8() {
        String password = "Ln2$mrT";
        try {
            PasswordValidator.validate(password);
        } catch (IllegalArgumentException exc) {
            String expected = "Password should be length [8, 32]";
            assertThat(exc.getMessage(), is(expected));
        }
    }

    @Test
    public void whenPasswordLengthMore32() {
        String password = "Ln2$mrTegegehrrhebukyilynbgrtuyimngtytuk";
        try {
            PasswordValidator.validate(password);
        } catch (IllegalArgumentException exc) {
            String expected = "Password should be length [8, 32]";
            assertThat(exc.getMessage(), is(expected));
        }
    }

    @Test
    public void whenPasswordNotContainUpperCaseLetter() {
        String password = "ln2$mrty12";
        try {
            PasswordValidator.validate(password);
        } catch (IllegalArgumentException exc) {
            String expected = "Password should contain at least one uppercase letter";
            assertThat(exc.getMessage(), is(expected));
        }
    }

    @Test
    public void whenPasswordNotContainLowerCaseLetter() {
        String password = "LN2$MRTY12";
        try {
            PasswordValidator.validate(password);
        } catch (IllegalArgumentException exc) {
            String expected = "Password should contain at least one lowercase letter";
            assertThat(exc.getMessage(), is(expected));
        }
    }

    @Test
    public void whenPasswordNotContainFigure() {
        String password = "Ln$MRTYqwe";
        try {
            PasswordValidator.validate(password);
        } catch (IllegalArgumentException exc) {
            String expected = "Password should contain at least one figure";
            assertThat(exc.getMessage(), is(expected));
        }
    }

    @Test
    public void whenPasswordNotContainSpecialSymbol() {
        String password = "LN2mRtY12";
        try {
            PasswordValidator.validate(password);
        } catch (IllegalArgumentException exc) {
            String expected = "Password should contain at least one special symbol";
            assertThat(exc.getMessage(), is(expected));
        }
    }

    @Test
    public void whenPasswordContainSubstringQWERTY() {
        String password = "LN2mRtY1QWertY2";
        try {
            PasswordValidator.validate(password);
        } catch (IllegalArgumentException exc) {
            String expected = "Password shouldn't contain substrings:"
                    + " qwerty, 12345, password, admin, user";
            assertThat(exc.getMessage(), is(expected));
        }
    }

    @Test
    public void whenPasswordContainSubstring12345() {
        String password = "LN2mRtY112345Y2";
        try {
            PasswordValidator.validate(password);
        } catch (IllegalArgumentException exc) {
            String expected = "Password shouldn't contain substrings:"
                    + " qwerty, 12345, password, admin, user";
            assertThat(exc.getMessage(), is(expected));
        }
    }

    @Test
    public void whenPasswordContainSubstringPassword() {
        String password = "LN2mRtY1PaSsWoRd2";
        try {
            PasswordValidator.validate(password);
        } catch (IllegalArgumentException exc) {
            String expected = "Password shouldn't contain substrings:"
                    + " qwerty, 12345, password, admin, user";
            assertThat(exc.getMessage(), is(expected));
        }
    }

    @Test
    public void whenPasswordContainSubstringPAdmin() {
        String password = "LN2mRtY1AdMiN2";
        try {
            PasswordValidator.validate(password);
        } catch (IllegalArgumentException exc) {
            String expected = "Password shouldn't contain substrings:"
                    + " qwerty, 12345, password, admin, user";
            assertThat(exc.getMessage(), is(expected));
        }
    }

    @Test
    public void whenPasswordContainSubstringUser() {
        String password = "LN2mRtY1UsEr2";
        try {
            PasswordValidator.validate(password);
        } catch (IllegalArgumentException exc) {
            String expected = "Password shouldn't contain substrings:"
                    + " qwerty, 12345, password, admin, user";
            assertThat(exc.getMessage(), is(expected));
        }
    }
}