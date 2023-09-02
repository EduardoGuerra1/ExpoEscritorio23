package expoescritorio.Controller;

import expoescritorio.Models.CodigosConductualesString;
import expoescritorio.Models.CodigosString;
import expoescritorio.Models.ComunicadosModel;
import expoescritorio.Models.GradosView;
import expoescritorio.Models.Inasisitenciastring;
import expoescritorio.Models.LlegadasTardeString;
import expoescritorio.Models.ObservacionesString;
import expoescritorio.Models.ReservacionesSalonestring;
import expoescritorio.Models.VisitasEnfermeriaString;
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


public class Funciones {
    
    public static CompletableFuture<List<ComunicadosModel>> GetComunicados() {
            return CompletableFuture.supplyAsync(() -> {
                // URL de la API
                String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/Comunicados/list";
                List<ComunicadosModel> modelList = new ArrayList<>();
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
                            int idObservacion = jsonObject.getInt("idComunicado");
                            int idPeriodo= jsonObject.getInt("idGrado");
                            String fecha= jsonObject.getString("fecha");
                            String detalle = jsonObject.getString("detalle");
                            String idEstudiante= jsonObject.getString("archivo");
                            modelList.add(new ComunicadosModel(idObservacion, idPeriodo,fecha,detalle, idEstudiante));
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
    
     public static CompletableFuture<List<CodigosString>> getCodigosConductualesStringApiAsync() {
         
        return CompletableFuture.supplyAsync(() -> {
            // URL de la API
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/CodigosConductuales/String";
            List<CodigosString> modelList = new ArrayList<>();
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
                        int idCodigoConductual = jsonObject.getInt("idCodigoConductual");
                        String nivelCodigoConductual = jsonObject.getString("nivelCodigoConductual");
                        String codigoConductual = jsonObject.getString("codigoConductual");
                        modelList.add(new CodigosString(idCodigoConductual, nivelCodigoConductual, codigoConductual));
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
        public static CompletableFuture<List<CodigosConductualesString>> GetCodigosString() {
        return CompletableFuture.supplyAsync(() -> {
            // URL de la API
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/Funciones/CodigosConductuales";
            List<CodigosConductualesString> modelList = new ArrayList<>();
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
                        int idCodigoConductual = jsonObject.getInt("idCodigoConductualPersona");
                        String estudiante = jsonObject.getString("estudiante");
                        String CodigoConductual = jsonObject.getString("codigoConductual");
                        String tipoCodigoConductual= jsonObject.getString("tipoCodigoConductual");
                        String Docente= jsonObject.getString("docente");
                        int idPeriodo = jsonObject.getInt("idPeriodo");
                        String fecha= jsonObject.getString("fecha");
                        int idEstudiante = jsonObject.getInt("idEstudiante");
                        modelList.add(new CodigosConductualesString(idCodigoConductual, estudiante, CodigoConductual,tipoCodigoConductual,Docente,idPeriodo, fecha,idEstudiante));
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
        public static CompletableFuture<List<ReservacionesSalonestring>> GetReservacionesSalones() {
        return CompletableFuture.supplyAsync(() -> {
            // URL de la API
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/Funciones/ReservacionesSalones";
            List<ReservacionesSalonestring> modelList = new ArrayList<>();
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
                        int idReservacionSalon = jsonObject.getInt("idReservacionSalon");
                        String Salon = jsonObject.getString("salon");
                        String Inicio = jsonObject.getString("inicio");
                        String Final= jsonObject.getString("final");
                        String Reservante= jsonObject.getString("reservante");
                        String motivoReserva = jsonObject.getString("motivoReserva");
                        int idReservante= jsonObject.getInt("idReservante");
                        int Estado= jsonObject.getInt("estado");
                        modelList.add(new ReservacionesSalonestring(idReservacionSalon, Salon, Inicio,Final,Reservante,motivoReserva, idReservante, Estado));
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
        public static CompletableFuture<List<ObservacionesString>> GetObservaciones() {
        return CompletableFuture.supplyAsync(() -> {
             // URL de la API
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/Funciones/Observaciones";
            List<ObservacionesString> modelList = new ArrayList<>();
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
                        int idObservacion = jsonObject.getInt("idObservacion");
                        String Estudiante = jsonObject.getString("estudiante");
                        String Docente = jsonObject.getString("docente");
                        int idPeriodo= jsonObject.getInt("idPeriodo");
                        String fecha= jsonObject.getString("fecha");
                        String detalle = jsonObject.getString("detalle");
                        int idEstudiante= jsonObject.getInt("idEstudiante");
                        modelList.add(new ObservacionesString(idObservacion, Estudiante, Docente,idPeriodo,fecha,detalle, idEstudiante));
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
        public static CompletableFuture<List<GradosView>> GetGrados() {
        return CompletableFuture.supplyAsync(() -> {
            // URL de la API
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/Grados/list";
            List<GradosView> modelList = new ArrayList<>();
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
                        int idGrado = jsonObject.getInt("idGrado");
                        String idNivelAcademico = jsonObject.getString("idNivelAcademico");
                        String idSeccion = jsonObject.getString("idSeccion");
                        String idSeccionBachillerato= jsonObject.getString("idSeccionBachillerato");
                        String idDocenteEncargado= jsonObject.getString("idDocenteEncargado");
                        String idEspecialidad = jsonObject.getString("idEspecialidad");
                        String idGrupoTecnico= jsonObject.getString("idGrupoTecnico");
                        modelList.add(new GradosView(idGrado, idNivelAcademico, idSeccion,idSeccionBachillerato,idDocenteEncargado,idEspecialidad, idGrupoTecnico));
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
        public static CompletableFuture<List<LlegadasTardeString>> GetLLegadasTardes() {
        return CompletableFuture.supplyAsync(() -> {
            // URL de la API
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/Funciones/LlegadasTardes";
            List<LlegadasTardeString> modelList = new ArrayList<>();
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
                        int idLlegadaTarde = jsonObject.getInt("idLlegadaTarde");
                        String TipoLlegadaTarde = jsonObject.getString("tipoLlegadaTarde");
                        String Estudiante = jsonObject.getString("estudiante");
                        int idPeriodo = jsonObject.getInt("idPeriodo");
                        String Docente = jsonObject.getString("docente");
                        int estado = jsonObject.getInt("estado");
                        String fecha = jsonObject.getString("fecha");
                        int idEstudiante = jsonObject.getInt("idEstudiante");
                        
                        modelList.add(new LlegadasTardeString(idLlegadaTarde, TipoLlegadaTarde, Estudiante, idPeriodo, Docente, estado,fecha,idEstudiante));
                    
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
          public static CompletableFuture<List<Inasisitenciastring>> GetInasisitencias() {
        return CompletableFuture.supplyAsync(() -> {
            // URL de la API
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/Funciones/Inasisitencias";
            List<Inasisitenciastring> modelList = new ArrayList<>();
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
                        String tipoLlegadaTarde = jsonObject.getString("tipoLlegadaTarde");
                        String Estudiante = jsonObject.getString("estudiante");
                        int idPeriodo = jsonObject.getInt("idPeriodo");
                        String Docente = jsonObject.getString("docente");
                        int estado = jsonObject.getInt("estado");
                        String fecha = jsonObject.getString("fecha");
                        int idEstudiante = jsonObject.getInt("idEstudiante");
                        
                        modelList.add(new Inasisitenciastring(idInasistencia, tipoLlegadaTarde, Estudiante, Docente, idPeriodo, estado,fecha,idEstudiante));
                    
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
        
        
        public static CompletableFuture<List<VisitasEnfermeriaString>> GetVisitasEnfermeria() {
        return CompletableFuture.supplyAsync(() -> {
            // URL de la API
            String apiUrl = "https://expo2023-6f28ab340676.herokuapp.com/VisitasEnfermeria/String";
            List<VisitasEnfermeriaString> modelList = new ArrayList<>();
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
                        int idVisitaEnfermeria = jsonObject.getInt("idVisitaEnfermeria");
                        String Persona = jsonObject.getString("persona");
                        String detalleVisitia = jsonObject.getString("detalleVisitia");
                        int idPeriodo = jsonObject.getInt("idPeriodo");
                        String fecha = jsonObject.getString("fecha");
                        int idPersona = jsonObject.getInt("idPersona");
                        modelList.add(new VisitasEnfermeriaString(idVisitaEnfermeria, Persona, idPeriodo, fecha, detalleVisitia, idPersona));
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
