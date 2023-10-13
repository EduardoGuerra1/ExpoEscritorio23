package Services;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
public static boolean checkDateNotOlderThan9Years(String dateString) {
    // Define el formato de la cadena de fecha.
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    try {
        // Convierte la cadena de fecha en un objeto LocalDate.
        LocalDate date = LocalDate.parse(dateString, formatter);

        // Calcula la fecha actual menos 9 años.
        LocalDate nineYearsAgo = LocalDate.now().minusYears(9);

        // Compara la fecha dada con la fecha que está 9 años atrás.
        return !date.isBefore(nineYearsAgo);
    } catch (Exception e) {
        // En caso de error en el formato de la cadena de fecha, puedes manejarlo como desees.
        return false;
    }
}
public static boolean checkDateDown(OffsetDateTime date) {
    OffsetDateTime currentDate = OffsetDateTime.now();
    OffsetDateTime nineYearsAgo = currentDate.minusYears(9);
    
    return date.isBefore(nineYearsAgo) || date.isEqual(nineYearsAgo);
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
    text = text.toLowerCase(); // Convierte todo el texto a minúsculas para simplificar las comprobaciones.
    for (char character : text.toCharArray()) {
       if (text.length() > 50) {
        return false; // La cadena supera los 50 caracteres permitidos
        }
        // Verifica si el carácter es una letra minúscula de la 'a' a la 'z' o un espacio.
        if ((character >= 'a' && character <= 'z') || character == ' ') {
            continue;
        }
        // Verifica si el carácter es una letra acentuada (como á, é, ú).
        if (((character >= 'á' && character <= 'ú') || character == 'é')) {
            continue;
        }
        // Verifica si el carácter es un número del '0' al '9'.
        if (character >= '0' && character <= '9') {
            return false;
        }
        return false; // Si el carácter no es una letra, un espacio, una letra acentuada o un número, retorna false.
    }
    return true;
}


    public static boolean onlyInts(String number) {
         if (number.isEmpty() || number.length() > 50) {
        return false;
    }
        for (char character : number.toCharArray()) {
            if (!(character >= '0' && character <= '9')) {// Verifica si el carácter no es un dígito numérico (no está en el rango '0' a '9').
                return false;// Si encuentra un carácter que no es un dígito, devuelve false.
            }
        }
        return true;// Si todos los caracteres son dígitos numéricos, devuelve true.
    }
    public static boolean isPhoneNumber(String phoneNumber) {
    // Verifica que la cadena no esté vacía y que no supere los 20 caracteres
    if (phoneNumber.isEmpty() || phoneNumber.length() > 20) {
        return false;
    }

    // Verifica que la cadena comience con "+503"
    if (!phoneNumber.startsWith("+503")) {
        return false;
    }

    // Itera a través de los caracteres restantes para asegurarse de que sean dígitos numéricos
    for (int i = 4; i < phoneNumber.length(); i++) {
        char character = phoneNumber.charAt(i);
        if (!(character >= '0' && character <= '9')) {
            return false;
        }
    }

    // Si pasa todas las comprobaciones, devuelve true
    return true;
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
    }    // Compara la longitud de la cadena de texto 
    public static boolean check20(String palabra) {
        return palabra.length() <= 20;
    }
      
    // Compara la longitud de la cadena de texto 
    public static boolean check30(String palabra) {
        return palabra.length() <= 30;
    }
    public static boolean check25(String palabra) {
        return palabra.length() <= 25;
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
        public static boolean check12(String palabra) {
        return palabra.length() <= 12;
    }
    // Compara la longitud de la cadena de texto 
        public static boolean check16(String palabra) {
        return palabra.length() <= 16 ;
    }
                public static boolean check14(String palabra) {
        return palabra.length() <= 14 ;
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
