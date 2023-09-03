/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.samplemessage;

import Services.Validaciones;
import View.Application.form.other.CodigosDisciplinarios;
import View.Application.form.other.TiposCodigos;
import View.glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.FlatClientProperties;
import expoescritorio.Controller.ControllerFull;
import expoescritorio.Controller.NivelesCodigosConductualesController;
import expoescritorio.Controller.TiposCodigosConductualesController;
import expoescritorio.Models.NivelesCodigosConductuales;
import expoescritorio.Models.TiposCodigosConductuales;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.Timer;
import org.json.JSONException;
import org.json.JSONObject;
import raven.toast.Notifications;

/**
 *
 * @author educs
 */
public class MessageEditCodigosDisciplinarios extends javax.swing.JPanel {

    public int id;

    public MessageEditCodigosDisciplinarios() {
        initComponents();
        setOpaque(false);

        txtTitle.setBackground(new Color(0, 0, 0, 0));
        txtTitle.setOpaque(false);
        txtTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h4.font");
        /*// Obtener los datos de la API y cargarlos en el ComboBox
        List<TiposCodigosConductuales> tiposCodigosConductualesList = TiposCodigosConductualesController.getTiposCodigosConductualesFromApi();
        for (TiposCodigosConductuales tipoCodigoConductual : tiposCodigosConductualesList) {
            cbTiposCodigosConductuales.addItem(tipoCodigoConductual.getTipoCodigoConductual());
        }

        try {
            // Obtener la lista de niveles de códigos conductuales de manera asíncrona
            CompletableFuture<List<NivelesCodigosConductuales>> nivelesFuture = NivelesCodigosConductualesController.getNivelesCodigosConductualesAsync();
            List<NivelesCodigosConductuales> nivelesCodigosConductualesList = nivelesFuture.get();

            // Limpiar el ComboBox antes de agregar los nuevos elementos
            cbNivelCodigoConductual.removeAllItems();

            // Agregar los niveles de códigos conductuales al ComboBox
            for (NivelesCodigosConductuales nivelesCodigosConductuales : nivelesCodigosConductualesList) {
                cbNivelCodigoConductual.addItem(nivelesCodigosConductuales.getNivelCodigoConductual());
            }
        } catch (InterruptedException | ExecutionException e) {
            // Manejar las excepciones aquí
            System.out.println("Error al obtener la lista de niveles de códigos conductuales: " + e.getMessage());
        }
        
         */

        CompletableFuture<List<NivelesCodigosConductuales>> futureNivelesCodigos = NivelesCodigosConductualesController.getNivelesCodigosConductualesAsyn();

// Agregar un ActionListener para cargar los datos del combobox una vez que estén disponibles
        futureNivelesCodigos.thenAccept(nivelesCodigosList -> {
            // Crear un arreglo de niveles de códigos conductuales para usar en el combobox
            String[] nivelesCodigos = new String[nivelesCodigosList.size()];

            for (int i = 0; i < nivelesCodigosList.size(); i++) {
                NivelesCodigosConductuales nivelCodigo = nivelesCodigosList.get(i);
                nivelesCodigos[i] = nivelCodigo.getNivelCodigoConductual();
            }

            // Agregar los niveles de códigos conductuales al combobox
            cbNivelCodigoConductual.setModel(new DefaultComboBoxModel<>(nivelesCodigos));
        });

        
        
        
        CompletableFuture<List<TiposCodigosConductuales>> futureTiposCodigos = TiposCodigosConductualesController.getTiposCodigosConductualesAsync();

// Agregar un ActionListener para cargar los datos del combobox una vez que estén disponibles
        futureTiposCodigos.thenAccept(tiposCodigosList -> {
            // Crear un arreglo de tipos de códigos conductuales para usar en el combobox
            String[] tiposCodigos = new String[tiposCodigosList.size()];

            for (int i = 0; i < tiposCodigosList.size(); i++) {
                TiposCodigosConductuales tipoCodigo = tiposCodigosList.get(i);
                tiposCodigos[i] = tipoCodigo.getTipoCodigoConductual();
            }

            // Agregar los tipos de códigos conductuales al combobox
            cbTiposCodigosConductuales.setModel(new DefaultComboBoxModel<>(tiposCodigos));
        });

        String selectedText = (String) cbTiposCodigosConductuales.getSelectedItem();
        txtCodigoConductual.setText(selectedText);
        // Agrega el ActionListener al JComboBox
        cbTiposCodigosConductuales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene el elemento seleccionado y actualiza el JTextField
                String selectedText = (String) cbTiposCodigosConductuales.getSelectedItem();
                txtCodigoConductual.setText(selectedText);
            }
        });
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitle = new javax.swing.JLabel();
        btnCancelar = new View.BotonesText.Buttons();
        btnAceptar = new View.BotonesText.Buttons();
        jLabel1 = new javax.swing.JLabel();
        cbTiposCodigosConductuales = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbNivelCodigoConductual = new javax.swing.JComboBox<>();
        txtCodigoConductual = new View.BotonesText.CustomTextField();
        jLabel3 = new javax.swing.JLabel();

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
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 120, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, 120, -1));

        jLabel1.setText("Tipo de Código:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));
        add(cbTiposCodigosConductuales, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 160, -1));

        jLabel2.setText("Código Disciplinario:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));
        add(cbNivelCodigoConductual, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 160, -1));

        txtCodigoConductual.setEnabled(false);
        add(txtCodigoConductual, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 230, 50));

        jLabel3.setText("Nivel de Código:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:

        Validaciones valida = new Validaciones();
        if (txtCodigoConductual.getText().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El campo no puede estar vacío");
        } else {
            if (!valida.check50(txtCodigoConductual.getText())) {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El Campo es muy grande");
            } else {
                actualizarDatosHaciaApi();
                Timer timer = new Timer(500, (ActionEvent e) -> {
                    TiposCodigos tc = new TiposCodigos();
                    tc.cargarDatos();
                    tc.deleteAllTableRows(tc.table1);
                });
                timer.setRepeats(false);
                timer.start();
            }
        }

    }//GEN-LAST:event_btnAceptarMouseClicked

    public void eventOK(ActionListener event) {
        btnAceptar.addActionListener(event);
    }

    public void actualizarDatosHaciaApi() {
        int num = 4;
        int num1 = 1;

        MessageEditCodigosDisciplinarios msg = new MessageEditCodigosDisciplinarios();
        // Obtener los valores seleccionados del ComboBox y el texto del TextField
        int idTipoCodigoConductual = obtenerIdSeleccionadoComboBox(msg.cbTiposCodigosConductuales, false);
        int idNivelCodigoConductual = obtenerIdSeleccionadoComboBox(msg.cbNivelCodigoConductual, true);
        String codigoConductual = txtCodigoConductual.getText();

        System.out.println(idTipoCodigoConductual);
        System.out.println(idNivelCodigoConductual);
        System.out.println(codigoConductual);

        try {
            // Crear un objeto JSON con los datos recopilados
            JSONObject jsonData = new JSONObject();
            jsonData.put("idCodigoConductual", id);
            jsonData.put("idTipoCodigoConductual", idTipoCodigoConductual);
            jsonData.put("idNivelCodigoConductual", idNivelCodigoConductual);
            jsonData.put("codigoConductual", codigoConductual);

            // Llamar al método putApiAsync para enviar los datos de actualización
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/CodigosConductuales/update";
            String jsonString = jsonData.toString();

            CompletableFuture<Boolean> putFuture = ControllerFull.putApiAsync(endpointUrl, jsonString);

            // Manejar la respuesta de la API
            putFuture.thenAccept(success -> {
                if (success) {
                    // La solicitud PUT fue exitosa
                    System.out.println("Datos actualizados correctamente en la API");

                    // Realizar las acciones necesarias después de la actualización, si es necesario
                } else {
                    // La solicitud PUT falló
                    System.out.println("Error al actualizar los datos en la API");
                }
            });
        } catch (JSONException e) {
            // Manejar la excepción JSONException aquí
            System.out.println("Error al crear el objeto JSON: " + e.getMessage());
        }
    }

    private int obtenerIdSeleccionadoComboBox(JComboBox<String> comboBox, Boolean band) {
        int selectedIndex = (int) comboBox.getSelectedIndex();
        String txt = comboBox.getItemAt(selectedIndex);
        if (band) {
            return NivelesCodigosConductualesController.getNivelesCodigosConductualesNameAsync(txt).join();
        } else {
            return TiposCodigosConductualesController.getTiposCodigosConductualesNameAsync(txt).join();
        }
        // Aquí deberías obtener el ID correspondiente al valor seleccionado en el ComboBox
        // Puedes tener una lista de objetos con ID y valor asociado y buscar el ID basado en el valor seleccionado.
        // Por simplicidad, aquí asumiremos que el valor seleccionado es el ID directamente.
    }

    public boolean panelClosing() {
        // Realiza las acciones necesarias antes de cerrar el panel
        System.out.println("El panel se va a cerrar.");
        CodigosDisciplinarios cd = new CodigosDisciplinarios();
        cd.deleteAllTableRows(cd.table1);
        cd.cargarDatos();
        return false;
    }
// Método para obtener el ID seleccionado de un JComboBox

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.Buttons btnAceptar;
    private View.BotonesText.Buttons btnCancelar;
    public javax.swing.JComboBox<String> cbNivelCodigoConductual;
    public javax.swing.JComboBox<String> cbTiposCodigosConductuales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public View.BotonesText.CustomTextField txtCodigoConductual;
    public javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
