
package expoescritorio.Controller;


import static expoescritorio.Controller.TiposCodigosConductualesController.getTiposCodigosConductualesFromApi;
import expoescritorio.Models.NivelesCodigosConductuales;
import expoescritorio.Models.TiposCodigosConductuales;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class NivelesCodigosConductualesController {
    
    public static Integer getPosicionNivelCodigoConductual(int id){
        // Obtener la lista
        List<NivelesCodigosConductuales> tiposCodigosConductuales = getNivelesCodigosConductualesAsync().join();
        int cnt = 0;
        //Encuentra la pocision del elemento con el ID especificado.
        for(NivelesCodigosConductuales item: tiposCodigosConductuales){
            if(item.getIdNivelCodigoConductual() == id) break;
            cnt++;// Incrementar la posición si no se encuentra el elemento
        }
        // Devolver la posición del elemento con el ID especificado en la lista
        return cnt;
    }
    
    public static CompletableFuture<List<NivelesCodigosConductuales>> getNivelesCodigosConductualesAsyn() {
        return CompletableFuture.supplyAsync(() -> {
            // URL de la API
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/NivelesCodigosConductuales/list";
            List<NivelesCodigosConductuales> modelList = new ArrayList<>();
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
                        int idNivelCodigoConductual = jsonObject.getInt("idNivelCodigoConductual");
                        String nivelCodigoConductual = jsonObject.getString("nivelCodigoConductual");
                        modelList.add(new NivelesCodigosConductuales(idNivelCodigoConductual, nivelCodigoConductual));
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
    
    public static CompletableFuture<Integer> getNivelesCodigosConductualesNameAsync(String name) {
        return CompletableFuture.supplyAsync(() -> {
            // URL de la API
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/NivelesCodigosConductuales/getName/"+name;
            Integer modelList = 0;
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
                    // Si la solicitud no es exitosa, se muestra un mensaje de error junto con el código de estado HTTP.
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            } catch (Exception e) {
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
    
    public static CompletableFuture<List<NivelesCodigosConductuales>> getNivelesCodigosConductualesAsync() {
        return CompletableFuture.supplyAsync(() -> {
            // URL de la API
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/NivelesCodigosConductuales/list";
            List<NivelesCodigosConductuales> modelList = new ArrayList<>();
            HttpURLConnection connection = null;
            try {
                 // Se crea una URL a partir de la apiUrl.
                URL url = new URL(apiUrl);
                connection = (HttpURLConnection) url.openConnection();
                 // Se establece el método de solicitud como GET.
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Verificar si la solicitud fue exitosa
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    JSONArray jsonArray = new JSONArray(reader.readLine());

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        int idNivelCodigoConductual = jsonObject.getInt("idNivelCodigoConductual");
                        String nivelCodigoConductual = jsonObject.getString("nivelCodigoConductual");
                        modelList.add(new NivelesCodigosConductuales(idNivelCodigoConductual, nivelCodigoConductual));
                    }
                }else {
                    // Si la solicitud no es exitosa, se muestra un mensaje de error junto con el código de estado HTTP.
                    System.out.println("La solicitud HTTP no fue exitosa. Código de estado: " + responseCode);
                }
            }catch (IOException | JSONException e) {
                // Se maneja cualquier excepción que pueda ocurrir durante la solicitud HTTP.
                System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            }finally {
                if (connection != null) {
                    connection.disconnect(); // Cerrar la conexión
                }
            }
            return modelList;
        });
    }
}
