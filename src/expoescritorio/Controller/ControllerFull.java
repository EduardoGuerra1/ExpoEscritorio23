package expoescritorio.Controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
public class ControllerFull {
    public static CompletableFuture<Boolean> postApiAsync(String endpointUrl, String jsonStrings ) {
        return CompletableFuture.supplyAsync(() -> {
            String apiUrl = endpointUrl;
            HttpURLConnection connection = null;
            try {
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                // Crear el objeto JSON con los datos a enviar
                String jsonInputString = jsonStrings;
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);

                // Enviar los datos en la solicitud POST
                try (OutputStream outputStream = connection.getOutputStream()) {
                    outputStream.write(input);
                }

                // Comprobar el código de estado de la respuesta HTTP
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Leer la respuesta de la API
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                        StringBuilder responseBuilder = new StringBuilder();
                        String response;
                        while ((response = reader.readLine()) != null) {
                            responseBuilder.append(response);
                        }

                        // Procesar la respuesta si es necesario
                        return true; // La solicitud POST fue exitosa
                    }
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
            return false; // La solicitud POST falló
        });
    }
    public static CompletableFuture<Boolean> putApiAsync(String endpointUrl, String jsonStrings ) {
        return CompletableFuture.supplyAsync(() -> {
            HttpURLConnection connection = null;

            try {
                URL url = new URL(endpointUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("PUT");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                String jsonInputString = jsonStrings;
                try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                    outputStream.writeBytes(jsonInputString);
                    outputStream.flush();
                }

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                        StringBuilder responseBuilder = new StringBuilder();
                        String response;
                        while ((response = reader.readLine()) != null) {
                            responseBuilder.append(response);
                        }
                        // Procesar la respuesta si es necesario
                    }
                    return true;
                } else {
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            } catch (IOException e) {
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }

            return false;
        });
    }

    public static CompletableFuture<Boolean> DeleteApiAsync(String endpointUrl, int id) {
        return CompletableFuture.supplyAsync(() -> {
            String apiUrl = endpointUrl + "/" + id;

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
}
