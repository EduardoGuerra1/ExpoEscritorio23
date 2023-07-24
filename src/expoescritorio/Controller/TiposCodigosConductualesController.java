package expoescritorio.Controller;

import static expoescritorio.Controller.NivelesCodigosConductualesController.getNivelesCodigosConductualesAsync;
import expoescritorio.Models.NivelesCodigosConductuales;
import expoescritorio.Models.TiposCodigosConductuales;
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

public class TiposCodigosConductualesController {
    
    public static Integer getPosicionNivelCodigoConductual(int id){
        List<TiposCodigosConductuales> tiposCodigosConductuales = getTiposCodigosConductualesFromApi();
        int cnt = 0;
        for(TiposCodigosConductuales item: tiposCodigosConductuales){
            if(item.getIdTipoCodigoConductual()==id) break;
            cnt++;
        }
        return cnt;
    }
    
    public static CompletableFuture<Integer> getTiposCodigosConductualesNameAsync(String name) {
        return CompletableFuture.supplyAsync(() -> {
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/TiposCodigosConductuales/getName/"+name;
            Integer modelList = 0;
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
                        modelList = Integer.parseInt(response.toString());
                    }
                } else {
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            } catch (Exception e) {
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            } finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }
            return modelList;
        });
    }
    
    
    public static List<TiposCodigosConductuales> getTiposCodigosConductualesFromApi() {
        String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/TiposCodigosConductuales/list";
        List<TiposCodigosConductuales> modelList = new ArrayList<>();
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
                    int idTipoCodigoConductual = jsonObject.getInt("idTipoCodigoConductual");
                    String tipoCodigoConductual = jsonObject.getString("tipoCodigoConductual");
                    modelList.add(new TiposCodigosConductuales(idTipoCodigoConductual, tipoCodigoConductual));
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
    }
}
