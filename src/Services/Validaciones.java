package Services;

import java.time.OffsetDateTime;

public class Validaciones {

    public static boolean checkEmail(String email) {
         // Expresión regular para validar una dirección de correo electrónico
        String expression = "^[_a-z0-9-]+(.[_a-z0-9-]+)@[a-z0-9-]+(.[a-z0-9]+)(.[a-z]{2,4})$";
        // Comprueba si la cadena de correo electrónico coincide con la expresión regular.
        if (email.matches(expression)) {
              // Si coincide, significa que la cadena es una dirección de correo electrónico válida.
        // Luego, se elimina cualquier parte que coincida con la expresión regular (debería ser toda la cadena).
            if (email.replaceAll(expression, "").length() == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;// La cadena no coincide con el formato de una dirección de correo electrónico.
        }
    }
    
    // Compara la fecha de inicio con la fecha y hora actuales.
    public static boolean checkRangeDate(OffsetDateTime begin, OffsetDateTime end) {
        return begin.compareTo(OffsetDateTime.now()) >= 0 && end.compareTo(begin) >= 0;
    }
     // Compara la fecha proporcionada (date) con la fecha y hora actuales.
    public static boolean checkDateUp(OffsetDateTime date) {
        return date.compareTo(OffsetDateTime.now()) >= 0;
    }
    
    // Compara la fecha proporcionada (date) con la fecha y hora actuales.
    public static boolean checkDateDown(OffsetDateTime date) {
        return date.compareTo(OffsetDateTime.now()) <= 0;
    }

    public static boolean onlyLetters(String text) {
        for (char character : text.toCharArray()) {
            // Verifica si el carácter es un número (dígito).
            if (character >= '0' && character <= '9') {
                // Si se encuentra un número, devuelve false, indicando que la cadena no contiene solo letras.
                return false;
            }
        }
          // Si no se encontraron números en la cadena, devuelve true, indicando que la cadena contiene solo letras
        return true;
    }

    public static boolean checkName(String text) {
        text = text.toLowerCase();// Convierte todo el texto a minúsculas para simplificar las comprobaciones.
        System.out.println(text);
        for (char character : text.toCharArray()) {
            // Verifica si el carácter es una letra minúscula de la 'a' a la 'z' o un espacio.
            if ((character >= 'a' && character <= 'z') || character == ' ') {
                continue;
            }
            // Verifica si el carácter es una letra acentuada (como á, é, ú).
            if (((character >= 'á' && character <= 'ú') || character == 'é')) {
                continue;
            }
            return false;// Si el carácter no es una letra ni un espacio ni una letra acentuada permitida, retorna false
        }
        return true;
    }

    public static boolean onlyInts(String number) {
        for (char character : number.toCharArray()) {
            if (!(character >= '0' && character <= '9')) {// Verifica si el carácter no es un dígito numérico (no está en el rango '0' a '9').
                return false;// Si encuentra un carácter que no es un dígito, devuelve false.
            }
        }
        return true;// Si todos los caracteres son dígitos numéricos, devuelve true.
    }

    public static boolean onlyFloats(String number) {
        int count = 0;
        for (char character : number.toCharArray()) {
            if (character == '.') { // Verifica si el carácter es un punto decimal.
                count++;
            }
            // Verifica si el carácter es un dígito numérico o un punto decimal (con un máximo de 1 punto decimal).
            if ((character >= '0' && character <= '9') || (character == '.' && count < 2)) {
                continue;
            }
            return false;// Si encuentra un carácter que no es válido, devuelve false.
        }
        return true;// Si todos los caracteres son dígitos numéricos o, como máximo, un punto decimal, devuelve true.
    }
    // Compara la longitud de la cadena de texto 
    public static boolean check20(String palabra) {
        return palabra.length() <= 20;
    }
    // Compara la longitud de la cadena de texto 
    public static boolean check30(String palabra) {
        return palabra.length() <= 30;
    }
    // Compara la longitud de la cadena de texto 
    public static boolean check100(String palabra) {
        return palabra.length() <= 100;
    }
    // Compara la longitud de la cadena de texto 
    public static boolean check50(String palabra) {
        return palabra.length() <= 50;
    }
    // Compara la longitud de la cadena de texto        
    public static boolean check75(String palabra) {
        return palabra.length() <= 75;
    }
    // Compara la longitud de la cadena de texto 
    public static boolean check5(String palabra) {
        return palabra.length() <= 5;
    }
    // Compara la longitud de la cadena de texto 
    public static boolean check6(String palabra) {
        return palabra.length() <= 32;
    }
    // Compara la longitud de la cadena de texto 
    public static boolean check8(String palabra) {
        return palabra.length() <= 8;
    }
    // Compara la longitud de la cadena de texto 
    public static boolean check4(String palabra) {
        return palabra.length() <= 4;
    }

    // Compara la longitud de la cadena de texto 
    public static boolean check7(String palabra) {
        return palabra.length() <= 7;
    }
    // Compara la longitud de la cadena de texto 
        public static boolean check16(String palabra) {
        return palabra.length() <= 16 ;
    }
    // Compara la longitud de la cadena de texto 
    public static boolean checkPassword(String pass) {
        return pass.length() >= 8;
    }
    // Compara la longitud de la cadena de texto 
    public static boolean checkPassword(String pass, String confirm) {
        return pass.length() >= 8 && pass.equals(confirm);
    }
}
