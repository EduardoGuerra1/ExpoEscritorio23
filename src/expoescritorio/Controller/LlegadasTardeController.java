package expoescritorio.Controller;

import expoescritorio.Models.LlegadasTardeString;
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

public class LlegadasTardeController {
    public static CompletableFuture<List<LlegadasTardeString>> getLlegadasTardeApiAsync() {
        return CompletableFuture.supplyAsync(() -> {
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/LlegadasTarde/list";
            List<LlegadasTardeString> modelList = new ArrayList<>();
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
                        int idLlegadaTarde = jsonObject.getInt("idLlegadaTarde");
                        String TipoLlegadaTarde = jsonObject.getString("TipoLlegadaTarde"); 
                        String Estudiante = jsonObject.getString("Estudiante"); 
                        int idPeriodo = jsonObject.getInt("idPeriodo;"); 
                        String Docente = jsonObject.getString("Docente"); 
                        int estado = jsonObject.getInt("estado"); 
                        String fecha = jsonObject.getString("fecha"); 
                        int idEstudiante = jsonObject.getInt("idEstudiante");
                        modelList.add(new LlegadasTardeString(idLlegadaTarde,TipoLlegadaTarde, Estudiante, idPeriodo, Docente, estado, fecha, idEstudiante));
                    }
                } else {
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            } catch (IOException | JSONException e) {
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
    
    

