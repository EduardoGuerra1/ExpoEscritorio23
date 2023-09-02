package expoescritorio.Controller;

import expoescritorio.Models.Inasistencias;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InasistenciasController {
    public static CompletableFuture<List<Inasistencias>> getInasistenciasApiAsync() {
        return CompletableFuture.supplyAsync(() -> {
            // URL de la API
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/Inasistencias/list";
            List<Inasistencias> modelList = new ArrayList<>();
            HttpURLConnection connection = null;
            try {
                // Se crea una URL a partir de la apiUrl.
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                // Se establece el método de solicitud como GET.
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Si la solicitud es exitosa (código de respuesta HTTP 200), se procesa la respuesta JSON.
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    JSONArray jsonArray = new JSONArray(reader.readLine());

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        int idInasistencia = jsonObject.getInt("idInasistencia");
                        int idTipoInasistencia = jsonObject.getInt ("idTipoInasistencia");
                        int idEstudiante = jsonObject.getInt ("idEstudiante");
                        int idDocente = jsonObject.getInt ("idDocente");
                        int idPeriodo = jsonObject.getInt ("idPeriodo");
                        String Estado = jsonObject.getString("Estado");
                        String Fecha = jsonObject.getString("Fecha");
                        modelList.add(new Inasistencias(idInasistencia, idTipoInasistencia,idEstudiante,idDocente, idPeriodo, Estado, Fecha));
                    }
                } else {
                    // Si la solicitud no es exitosa, se muestra un mensaje de error junto con el código de estado HTTP.
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            } catch (IOException | JSONException e) {
                // Se maneja cualquier excepción que pueda ocurrir durante la solicitud HTTP.
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
    
