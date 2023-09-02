package expoescritorio.Controller;

import expoescritorio.Models.TiposLlegadasTarde;
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
public class TiposLlegadasTardeController {
    public static CompletableFuture<List<TiposLlegadasTarde>> getTiposLlegadasTardeApiAsync() {
        return CompletableFuture.supplyAsync(() -> {
            // URL de la API
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/TiposLlegadasTarde/list";
            List<TiposLlegadasTarde> modelList = new ArrayList<>();
            HttpURLConnection connection = null;
            try {
                // Se crea una URL a partir de la apiUrl.
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                // Se establece el método de solicitud como GET.
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();
                // Verificar si la solicitud fue exitosa
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    JSONArray jsonArray = new JSONArray(reader.readLine());

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        int idTipoLlegadaTarde = jsonObject.getInt("idTipoLlegadaTarde");
                        String TipoLlegadaTarde = jsonObject.getString("TipoLlegadaTarde");
                        modelList.add(new TiposLlegadasTarde(idTipoLlegadaTarde, TipoLlegadaTarde));
                    }
                } else {
                    // Imprimir un mensaje de error si la solicitud HTTP no fue exitosa
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            } catch (IOException | JSONException e) {
                // Capturar y manejar errores en caso de una excepción
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
