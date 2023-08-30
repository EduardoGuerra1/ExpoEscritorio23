/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.samplemessage;

import View.Application.form.other.CodigosDisciplinarios;
import View.glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.FlatClientProperties;
import com.kitfox.svg.A;
import expoescritorio.Controller.CodigosConductualesController;
import expoescritorio.Controller.ControllerFull;
import expoescritorio.Controller.NivelesCodigosConductualesController;
import expoescritorio.Controller.TiposCodigosConductualesController;
import expoescritorio.Models.CodigosConductuales;
import expoescritorio.Models.NivelesCodigosConductuales;
import expoescritorio.Models.TiposCodigosConductuales;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.Timer;
import org.json.JSONException;
import org.json.JSONObject;
import raven.toast.Notifications;
import Services.Validaciones;
import View.Application.form.other.VisitasEnfermeria;
import expoescritorio.Controller.PeriodosController;
import expoescritorio.Controller.PersonasController;
import static expoescritorio.Controller.PersonasController.getPersonasAsync;
import expoescritorio.Models.Periodos;
//import  expoescritorio.Controller.PersonasController.getPersonasAsync;
import expoescritorio.Models.Personas;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author educs
 */
public class MessageAddVisitaEnfermeria extends javax.swing.JPanel {
       List<Personas> listaIdPersonas = new ArrayList<>();
    public MessageAddVisitaEnfermeria() {

        initComponents();
        setOpaque(false);
        txtPersona.setVisible(false);
        txtTitle.setBackground(new Color(0, 0, 0, 0));
        txtTitle.setOpaque(false);
        txtTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h4.font");
        // Obtener los datos de la API y cargarlos en el ComboBox
        /*CompletableFuture<List<Periodos>> futurePeriodos= PeriodosController.getPeriodosApiAsync();
        
        futurePeriodos.thenAccept(futureList-> {
            // Crear un arreglo de nombres y apellidos para usar en el combobox
            int[] periodo = new int[futureList.size()];
            for (int i = 0; i < futureList.size(); i++) {
                Periodos periodos = futureList.get(i);
                periodo[i]=periodos.getIdPeriodo();
            }

            // Agregar los nombres y apellidos al combobox
            cbPeriodo.setModel(new DefaultComboBoxModel<>(periodo));
        });
        */

        CompletableFuture<List<Personas>> futurePersonas = getPersonasAsync(2);

        // Agregar un ActionListener para cargar los datos del combobox una vez que estén disponibles
        futurePersonas.thenAccept(personasList -> {
            // Crear un arreglo de nombres y apellidos para usar en el combobox
            String[] nombresApellidos = new String[personasList.size()];
            String[] ID = new String[personasList.size()];
            for (int i = 0; i < personasList.size(); i++) {
                Personas persona = personasList.get(i);
                listaIdPersonas = personasList;
                
                nombresApellidos[i] = persona.getCodigo()+ " " +persona.getNombrePersona() + " " + persona.getApellidoPersona();
                ID[i] = persona.getIdPersona() + " ";
            }

            // Agregar los nombres y apellidos al combobox
            cbPersona.setModel(new DefaultComboBoxModel<>(nombresApellidos));
            //cbPersona.setModel(new DefaultComboBoxModel<>(ID));
            
        });

        String selectedText = (String) cbPersona.getSelectedItem();
        txtPersona.setText(selectedText);
        
        // Agrega el ActionListener al JComboBox
        cbPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene el elemento seleccionado y actualiza el JTextField
                String selectedText = (String) cbPersona.getSelectedItem();
               int index = selectedText.indexOf(" ");
        if (index != -1) {
        String nombre = selectedText.substring(0, index);
        txtPersona.setText(nombre);
}
            }
        });
        populateComboBox();
        txtVisita.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                for (char c : str.toCharArray()) {
                    if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c) && c != '.') {
                       Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El campo solo permite números y letras");
                        return; // Ignora el carácter si no es letra, número, espacio o punto
                    }
                }
                super.insertString(offset, str, attr);
            }
        });

    }
private int compararNombreApellido(String nombre, String apellido, List<Personas> personasList) {
    int nombreEncontrado = 0;
    
    for (Personas persona : personasList) {
        if (persona.getNombrePersona().equals(nombre) && persona.getApellidoPersona().equals(apellido)) {
         nombreEncontrado = persona.getIdPersona();
        }
    }
    
    if (nombreEncontrado != 0) {
        // Realizar la acción deseada con el nombre encontrado
        System.out.println("Nombre encontrado: " + nombreEncontrado);
    } else {
        // Realizar la acción deseada si no se encuentra ninguna coincidencia
        System.out.println("Nombre no encontrado");
    }
    return  nombreEncontrado ;
}
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    private void populateComboBox() {
        // Obtener los periodos desde la API usando el controlador
        List<Periodos> periodosList;
        try {
            periodosList = PeriodosController.getPeriodosApiAsync().get();
            for (Periodos periodo : periodosList) {
                cbPeriodo.addItem(String.valueOf(periodo.getIdPeriodo()));
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitle = new javax.swing.JLabel();
        btnCancelar = new View.BotonesText.Buttons();
        btnAceptar = new View.BotonesText.Buttons();
        jLabel1 = new javax.swing.JLabel();
        cbPeriodo = new javax.swing.JComboBox<>();
        cbPersona = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtPersona = new View.BotonesText.CustomTextField();
        jLabel2 = new javax.swing.JLabel();
        txtVisita = new View.BotonesText.CustomTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTitle.setText("Agregar una visita de enfermeria al estudiante");
        add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 430, -1));
        txtTitle.getAccessibleContext().setAccessibleName("Agregar una visita de enfermeria al estudiante");

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 120, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 120, -1));

        jLabel1.setText("Detalle de visita");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));
        add(cbPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 160, -1));
        add(cbPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 160, -1));

        jLabel3.setText("Persona");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        txtPersona.setEnabled(false);
        add(txtPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 230, 50));

        jLabel2.setText("Período");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));
        add(txtVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 400, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked

        if (txtPersona.getText().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El estudiante se debe seleccionar");
        } else {
            enviarDatosHaciaApi();
            Timer timer = new Timer(500, (ActionEvent e) -> {
                VisitasEnfermeria cd = new VisitasEnfermeria();

                cd.cargarDatos();
                cd.deleteAllTableRows(cd.table1);
            });
            timer.setRepeats(false);
            timer.start();
        }


    }//GEN-LAST:event_btnAceptarMouseClicked

    public void eventOK(ActionListener event) {
        btnAceptar.addActionListener(event);
    }

    private void enviarDatosHaciaApi() {
        int num = 4;
        int num1 = 1;

        MessageAddVisitaEnfermeria msg = new MessageAddVisitaEnfermeria();
        // Obtener los valores seleccionados del ComboBox y el texto del TextField
        int idTipoCodigoConductual = obtenerIdSeleccionadoComboBox(msg.cbPeriodo);
        // TODO add your handling code here:

        // Obtener la fecha actual del sistema
        Date fechaActual = new Date();

        // Crear un objeto SimpleDateFormat con el formato deseado
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Formatear la fecha en el formato deseado
        String fechaFormateada = sdf.format(fechaActual);

        System.out.println(idTipoCodigoConductual);
 
        try {
            // Crear un objeto JSON con los datos recopilados
            JSONObject jsonData = new JSONObject();
            jsonData.put("idPeriodo", 1);
            jsonData.put("idPersona",  txtPersona.getText());
            jsonData.put("fecha", fechaFormateada);
            jsonData.put("detalleVisitia", txtVisita.getText());

            // Llamar al método postApiAsync para enviar los datos
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/VisitasEnfermeria/save"; // Reemplaza esto con la URL de tu API
            String jsonString = jsonData.toString();

            CompletableFuture<Boolean> postFuture = ControllerFull.postApiAsync(endpointUrl, jsonString);

            // Manejar la respuesta de la API
            postFuture.thenAccept(success -> {
                if (success) {
                    // La solicitud POST fue exitosa
                    System.out.println("Datos enviados correctamente a la API");

                    CodigosDisciplinarios cd = new CodigosDisciplinarios();

                    cd.cargarDatos();

                    cd.deleteAllTableRows(cd.table1);
                    boolean pC = panelClosing() == true;
                    GlassPanePopup.closePopupLast();

                } else {
                    // La solicitud POST falló
                    System.out.println("Error al enviar los datos a la API");
                }
            });
        } catch (JSONException e) {
            // Manejar la excepción JSONException aquí
            System.out.println("Error al crear el objeto JSON: " + e.getMessage());
        }
    }

    private int obtenerIdSeleccionadoComboBox(JComboBox<String> comboBox) {
        
        int selectedIndex = (int) comboBox.getSelectedIndex();
    
    

    
    return selectedIndex;
    }

    public boolean panelClosing() {
        // Realiza las acciones necesarias antes de cerrar el panel
        System.out.println("El panel se va a cerrar.");
        CodigosDisciplinarios cd = new CodigosDisciplinarios();

        cd.cargarDatos();
        cd.deleteAllTableRows(cd.table1);
        return false;
    }
// Método para obtener el ID seleccionado de un JComboBox

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.Buttons btnAceptar;
    private View.BotonesText.Buttons btnCancelar;
    public javax.swing.JComboBox<String> cbPeriodo;
    public javax.swing.JComboBox<String> cbPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public View.BotonesText.CustomTextField txtPersona;
    public javax.swing.JLabel txtTitle;
    private View.BotonesText.CustomTextField txtVisita;
    // End of variables declaration//GEN-END:variables
}
