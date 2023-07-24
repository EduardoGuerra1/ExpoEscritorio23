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
import expoescritorio.Controller.PeriodosController;
import expoescritorio.Controller.PersonasController;
import static expoescritorio.Controller.PersonasController.getPersonasAsync;
import expoescritorio.Models.Periodos;
import expoescritorio.Models.Personas;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author educs
 */
public class MessageEditVisitaEnfermeria extends javax.swing.JPanel {

    public MessageEditVisitaEnfermeria() {

        initComponents();
        setOpaque(false);

        txtTitle.setBackground(new Color(0, 0, 0, 0));
        txtTitle.setOpaque(false);
        txtTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h4.font");
        // Obtener los datos de la API y cargarlos en el ComboBox
        List<TiposCodigosConductuales> tiposCodigosConductualesList = TiposCodigosConductualesController.getTiposCodigosConductualesFromApi();
        for (TiposCodigosConductuales tipoCodigoConductual : tiposCodigosConductualesList) {
            cbPeriodo.addItem(tipoCodigoConductual.getTipoCodigoConductual());
        }

        CompletableFuture<List<Personas>> futurePersonas = getPersonasAsync(2);

        // Agregar un ActionListener para cargar los datos del combobox una vez que estén disponibles
        futurePersonas.thenAccept(personasList -> {
            // Crear un arreglo de nombres y apellidos para usar en el combobox
            String[] nombresApellidos = new String[personasList.size()];
            for (int i = 0; i < personasList.size(); i++) {
                Personas persona = personasList.get(i);
                nombresApellidos[i] = persona.getNombrePersona() + " " + persona.getApellidoPersona();
            }

            // Agregar los nombres y apellidos al combobox
            cbPersona.setModel(new DefaultComboBoxModel<>(nombresApellidos));
        });
        

        String selectedText = (String) cbPersona.getSelectedItem();
        txtPersona.setText(selectedText);
        // Agrega el ActionListener al JComboBox
        cbPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene el elemento seleccionado y actualiza el JTextField
                String selectedText = (String) cbPersona.getSelectedItem();
                txtPersona.setText(selectedText);
            }
        });
        txtPersona.setDocument(new PlainDocument() { // desde aca 
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
        txtVisita.setDocument(new PlainDocument() { // desde aca 
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
        populateComboBox();
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
        txtFecha = new View.BotonesText.CustomTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPersona = new View.BotonesText.CustomTextField();
        jLabel2 = new javax.swing.JLabel();
        btnFecha = new javax.swing.JButton();
        txtVisita = new View.BotonesText.CustomTextField();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTitle.setText("Your Message Title Dialog Custom");
        add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

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
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));
        add(cbPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 160, -1));
        add(cbPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 160, -1));

        txtFecha.setEnabled(false);
        add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 230, 50));

        jLabel3.setText("Persona");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        txtPersona.setEnabled(false);
        add(txtPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 230, 50));

        jLabel2.setText("Período");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        btnFecha.setText("Hoy");
        btnFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFechaMouseClicked(evt);
            }
        });
        add(btnFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 70, -1));
        add(txtVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 400, 50));

        jLabel4.setText("Fecha");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:

        if (txtFecha.getText().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El campo no puede estar vacío");
        } else {
            enviarDatosHaciaApi();
            Timer timer = new Timer(500, (ActionEvent e) -> {
                CodigosDisciplinarios cd = new CodigosDisciplinarios();

                cd.cargarDatos();
                cd.deleteAllTableRows(cd.table1);
            });
            timer.setRepeats(false);
            timer.start();
        }


    }//GEN-LAST:event_btnAceptarMouseClicked

    private void btnFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFechaMouseClicked
        // TODO add your handling code here:

        // Obtener la fecha actual del sistema
        Date fechaActual = new Date();

        // Crear un objeto SimpleDateFormat con el formato deseado
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Formatear la fecha en el formato deseado
        String fechaFormateada = sdf.format(fechaActual);

        txtFecha.setText(fechaFormateada);
    }//GEN-LAST:event_btnFechaMouseClicked

    public void eventOK(ActionListener event) {
        btnAceptar.addActionListener(event);
    }

    private void enviarDatosHaciaApi() {

        int num = 4;
        int num1 = 1;

        MessageEditVisitaEnfermeria msg = new MessageEditVisitaEnfermeria();
        // Obtener los valores seleccionados del ComboBox y el texto del TextField
        int idTipoCodigoConductual = obtenerIdSeleccionadoComboBox(msg.cbPeriodo) + num;
        int idNivelCodigoConductual = obtenerIdSeleccionadoComboBox(msg.cbPersona) + num1;
        String codigoConductual = txtFecha.getText();

        System.out.println(idTipoCodigoConductual);
        System.out.println(idNivelCodigoConductual);
        System.out.println(codigoConductual);
        try {
            // Crear un objeto JSON con los datos recopilados
            JSONObject jsonData = new JSONObject();
            jsonData.put("idTipoCodigoConductual", idTipoCodigoConductual);
            jsonData.put("idNivelCodigoConductual", idNivelCodigoConductual);
            jsonData.put("codigoConductual", codigoConductual);

            // Llamar al método postApiAsync para enviar los datos
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/CodigosConductuales/save"; // Reemplaza esto con la URL de tu API
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
        // Aquí deberías obtener el ID correspondiente al valor seleccionado en el ComboBox
        // Puedes tener una lista de objetos con ID y valor asociado y buscar el ID basado en el valor seleccionado.
        // Por simplicidad, aquí asumiremos que el valor seleccionado es el ID directamente.

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
    private javax.swing.JButton btnFecha;
    public javax.swing.JComboBox<String> cbPeriodo;
    public javax.swing.JComboBox<String> cbPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public View.BotonesText.CustomTextField txtFecha;
    public View.BotonesText.CustomTextField txtPersona;
    public javax.swing.JLabel txtTitle;
    public View.BotonesText.CustomTextField txtVisita;
    // End of variables declaration//GEN-END:variables
}
