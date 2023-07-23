package Services;

import java.time.OffsetDateTime;

public class Validaciones {

    public static boolean checkEmail(String email) {
        String expression = "^[_a-z0-9-]+(.[_a-z0-9-]+)@[a-z0-9-]+(.[a-z0-9]+)(.[a-z]{2,4})$";
        if (email.matches(expression)) {
            if (email.replaceAll(expression, "").length() == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean checkRangeDate(OffsetDateTime begin, OffsetDateTime end) {
        return begin.compareTo(OffsetDateTime.now()) >= 0 && end.compareTo(begin) >= 0;
    }

    public static boolean checkDateUp(OffsetDateTime date) {
        return date.compareTo(OffsetDateTime.now()) >= 0;
    }

    public static boolean checkDateDown(OffsetDateTime date) {
        return date.compareTo(OffsetDateTime.now()) <= 0;
    }

    public static boolean onlyLetters(String text) {
        for (char character : text.toCharArray()) {
            if (character >= '0' && character <= '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean checkName(String text) {
        text = text.toLowerCase();
        System.out.println(text);
        for (char character : text.toCharArray()) {
            if ((character >= 'a' && character <= 'z') || character == ' ') {
                continue;
            }
            if (((character >= 'á' && character <= 'ú') || character == 'é')) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean onlyInts(String number) {
        for (char character : number.toCharArray()) {
            if (!(character >= '0' && character <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static boolean onlyFloats(String number) {
        int count = 0;
        for (char character : number.toCharArray()) {
            if (character == '.') {
                count++;
            }
            if ((character >= '0' && character <= '9') || (character == '.' && count < 2)) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean check20(String palabra) {
        return palabra.length() == 20;
    }

    public static boolean check30(String palabra) {
        return palabra.length() == 30;
    }

    public static boolean check50(String palabra) {
        return palabra.length() == 50;
    }

    public static boolean check75(String palabra) {
        return palabra.length() == 75;
    }

    public static boolean check5(String palabra) {
        return palabra.length() == 5;
    }

    public static boolean check6(String palabra) {
        return palabra.length() == 6;
    }

    public static boolean check8(String palabra) {
        return palabra.length() == 8;
    }

    public static boolean check4(String palabra) {
        return palabra.length() == 4;
    }

    public static boolean check7(String palabra) {
        return palabra.length() == 7;
    }

    public static boolean checkPassword(String pass) {
        return pass.length() >= 8;
    }

    public static boolean checkPassword(String pass, String confirm) {
        return pass.length() >= 8 && pass.equals(confirm);
    }
}
