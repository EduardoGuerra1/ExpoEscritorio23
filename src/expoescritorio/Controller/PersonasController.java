/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expoescritorio.Controller;


import com.google.gson.Gson;
import expoescritorio.Models.Personas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 50379
 */
public class PersonasController {
   public static Personas callApiAndProcessResponse(String correo, String claveCredenciales) {
        String encryptedPassword = encryptPassword(claveCredenciales);
        String baseUrl = "https://expo2023-6f28ab340676.herokuapp.com/Credenciales/user";

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("correo", correo);
        queryParams.put("claveCredenciales", encryptedPassword);

        String url = addQueryParameters(baseUrl, queryParams);

        try {
            URL urlObject = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }

                reader.close();

                String responseData = response.toString();
                if (responseData != null) {
                    Gson gson = new Gson();
                    return gson.fromJson(responseData, Personas.class);
                }
            } else {
                System.out.println("No se encontro: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Si hay algún problema, retorna null
    }
public static String encryptPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static String addQueryParameters(String baseUrl, Map<String, String> params) {
        StringBuilder builder = new StringBuilder(baseUrl);

        if (!params.isEmpty()) {
            builder.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            builder.deleteCharAt(builder.length() - 1); // Elimina el último "&"
        }

        return builder.toString();
    }
}

