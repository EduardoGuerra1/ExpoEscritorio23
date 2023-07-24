/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expoescritorio.Controller;


import com.google.gson.Gson;
import expoescritorio.Models.CodigosConductuales;
import expoescritorio.Models.Personas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author 50379
 */
public class PersonasController {
    
    public static CompletableFuture<Boolean> deleteCodigoPersona(String codigo){
        return CompletableFuture.supplyAsync(() -> {
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/Credenciales/deleteCodigo/"+codigo;

            HttpURLConnection connection = null;

            try {
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("DELETE");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    return true;
                } else {
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            } catch (IOException e) {
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            } finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }

            return false;
        });
    }
    
    public static CompletableFuture<String> getEspecialidadPersona(int idPersona){
       return CompletableFuture.supplyAsync(()->{
          String apiUrl =  "https://expo2023-6f28ab340676.herokuapp.com/Credenciales/getEspecialidad/"+idPersona;
          String grado = "";
          HttpURLConnection connection = null;
          try {
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    
                    if(response.length()>0){
                        grado = response.toString();
                    }
                }else {
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            }catch (Exception e) {
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            }finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }
            return grado;
       });
   }
    
   public static CompletableFuture<String> getGradoPersona(int idPersona){
       return CompletableFuture.supplyAsync(()->{
          String apiUrl =  "https://expo2023-6f28ab340676.herokuapp.com/Credenciales/getGrado/"+idPersona;
          String grado = "";
          HttpURLConnection connection = null;
          try {
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    
                    if(response.length()>0){
                        grado = response.toString();
                    }
                }else {
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            }catch (Exception e) {
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            }finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }
            return grado;
       });
   }
    
   public static CompletableFuture<List<Personas>> getPersonasAsync(int tipo){
       return CompletableFuture.supplyAsync(() -> {
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/Credenciales/get/"+tipo;
            List<Personas> modelList = new ArrayList<>();
            HttpURLConnection connection = null;
            try {
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    JSONArray jsonArray = new JSONArray(reader.readLine());
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        int idPersona = jsonObject.getInt("idPersona");
                        String codigo = jsonObject.getString("codigo");
                        String nombre = jsonObject.getString("nombrePersona");
                        String apellido = jsonObject.getString("apellidoPersona");
                        String nacimiento = jsonObject.getString("nacimientoPersona");
                        int idTipoPersona = jsonObject.getInt("idTipoPersona");
                        String correo = jsonObject.getString("correo");
                        String claveCredenciales = jsonObject.getString("claveCrendenciales");
                        String foto = jsonObject.getString("foto");
                        
                        modelList.add(new Personas(idPersona, codigo, nombre, apellido, nacimiento, idTipoPersona, correo, claveCredenciales, foto));
                    }
                }else {
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            }catch (IOException | JSONException e) {
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            }finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }
            return modelList;
        });
   }
    
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
   
   public static Personas CellApiCorreo(String correo) {
        String baseUrl = "https://expo2023-6f28ab340676.herokuapp.com/Credenciales/validar";

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("correo", correo);
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

