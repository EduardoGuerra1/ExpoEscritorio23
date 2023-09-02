package expoescritorio.Controller;

import expoescritorio.Models.Secciones;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
public class SeccionesController {
    public static CompletableFuture<List<Secciones>> getSeccionesApiAsync() {
        return CompletableFuture.supplyAsync(() -> {
            // URL de la API
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/Secciones/list";
            List<Secciones> modelList = new ArrayList<>();
            HttpURLConnection connection = null;
            try {
                // Crear una URL a partir de la apiUrl
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                // Configurar el método de solicitud HTTP como GET
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();
                // Verificar si la solicitud HTTP fue exitosa (código 200)
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    JSONArray jsonArray = new JSONArray(reader.readLine());

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        int idSeccion = jsonObject.getInt("idSeccion");
                        String seccion = jsonObject.getString("seccion");
                        modelList.add(new Secciones(idSeccion, seccion));
                    }
                } else {
                    // Imprimir un mensaje si la solicitud HTTP no fue exitosa
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            } catch (IOException | JSONException e) {
                // Manejar excepciones en caso de errores de conexión o procesamiento JSON
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            } finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }

            return modelList;
        });
    }
}
