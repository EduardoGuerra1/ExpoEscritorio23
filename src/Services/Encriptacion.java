/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptacion {
    public static String encryptPassword(String password) {
        try {
             // Se obtiene una instancia de MessageDigest para el algoritmo SHA-256.
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Se calcula el hash de la contraseña como un arreglo de bytes.
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            
            StringBuilder hexString = new StringBuilder();
            // Se itera a través de cada byte en el hash.
            for (byte b : hash) {
                // Convierte el byte a su representación hexadecimal y lo agrega al StringBuilder.
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            // Devuelve el hash de la contraseña como una cadena en formato hexadecimal.
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Manejo de excepciones en caso de que no se pueda encontrar el algoritmo SHA-256.
            e.printStackTrace();
            return null;
        }
    }
}
