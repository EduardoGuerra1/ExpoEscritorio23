/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.samplemessage;

import View.Application.form.other.CodigosDisciplinarios;
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
import Services.Validaciones;
import View.Application.form.other.SalonesPantalla;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author educs
 */
public class MessageAddCodigosDisciplinarios extends javax.swing.JPanel {
        private boolean procesoEnCurso = false;
    int nivel1 = 1;
    int tipo = 4;

    public MessageAddCodigosDisciplinarios() {

        initComponents();
        setOpaque(false);

        txtTitle.setBackground(new Color(0, 0, 0, 0));
        txtTitle.setOpaque(false);
        txtTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h4.font");
       
        CompletableFuture<List<NivelesCodigosConductuales>> futureNivelesCodigos = NivelesCodigosConductualesController.getNivelesCodigosConductualesAsyn();
        futureNivelesCodigos.thenAccept(nivelesCodigosList -> {
            // Crear un arreglo de niveles de códigos conductuales para usar en el combobox
            String[] nivelesCodigos = new String[nivelesCodigosList.size()];
            int[] ids = new int[nivelesCodigosList.size()];

            for (int i = 0; i < nivelesCodigosList.size(); i++) {
                NivelesCodigosConductuales nivelCodigo = nivelesCodigosList.get(i);
                nivelesCodigos[i] = nivelCodigo.getNivelCodigoConductual();
                ids[i] = nivelCodigo.getIdNivelCodigoConductual();
            }

            // Agregar los niveles de códigos conductuales al combobox
            cbNivelCodigoConductual.setModel(new DefaultComboBoxModel<>(nivelesCodigos));

            // Agregar un ActionListener al JComboBox para obtener el ID seleccionado
            cbNivelCodigoConductual.addActionListener(e -> {
                int selectedIndex = cbNivelCodigoConductual.getSelectedIndex();
                int selectedId = ids[selectedIndex];
                nivel1 = selectedId;

                // Hacer algo con el ID seleccionado...
            });
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
        cbNivelCodigoConductual = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Codigos = new View.BotonesText.CustomTextField();

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
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 120, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 120, -1));
        add(cbNivelCodigoConductual, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 160, -1));

        jLabel3.setText("Descripción:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel4.setText("Nivel de Código:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));
        add(Codigos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 210, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        GlassPanePopup.closePopupLast();
        playCerrar();
    }//GEN-LAST:event_btnCancelarMouseClicked
    private void playValidacion() {
        String filepath = "src/View/sounds/validacion.wav";

        PlayMusic(filepath);

    }

    private void playCerrar() {
        String filepath = "src/View/sounds/cerrar.wav";

        PlayMusic(filepath);

    }
    private void playError() {
        String filepath = "src/View/sounds/error.wav";

        PlayMusic(filepath);

    }

    private static void PlayMusic(String location) {
        try {
            File musicPath = new File(location);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.out.println("No se encuentra el archivo de sonido");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:

        Validaciones valida = new Validaciones();
        if (Codigos.getText().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "El campo no puede estar vacío");
            playError();
        } else {
            if (!valida.check25(Codigos.getText())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "El Campo es muy grande");
                playError();
            } else {
                btnAceptar.setEnabled(false);
                enviarDatosHaciaApi();
               
Timer timer = new Timer(500, (ActionEvent e) -> {
    if (!procesoEnCurso) {
        CodigosDisciplinarios cd = new CodigosDisciplinarios();
        cd.cargarDatos();
        //  cd.deleteAllTableRows(cd.table1);
         btnAceptar.setEnabled(true);
    }
    else {
        System.out.println("Esta verdadero ");
    }
});

                timer.setRepeats(false);
                timer.start();
            }
        }


    }//GEN-LAST:event_btnAceptarMouseClicked

    public void eventOK(ActionListener event) {
        btnAceptar.addActionListener(event);
    }

    private void enviarDatosHaciaApi() {
            if (procesoEnCurso) {
                System.out.println("Le di dos veces xd ");
        return;
    }
             procesoEnCurso = true;

        MessageAddCodigosDisciplinarios msg = new MessageAddCodigosDisciplinarios();
        // Obtener los valores seleccionados del ComboBox y el texto del TextField
        String codigoConductual = Codigos.getText();
        System.out.println(codigoConductual);
        try {
            JSONObject jsonData = new JSONObject();
            jsonData.put("TipoCodigoConductual", codigoConductual);
            jsonData.put("IdNivelCodigoConductual", nivel1);

            // Llamar al método postApiAsync para enviar los datos
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/CodigosP/save"; // Reemplaza esto con la URL de tu API
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
                    
                    
                    Message obj = new Message();
                    obj.txtTitle.setText("Aviso");
                    obj.txtContent.setText("Datos enviados correctamente");
                    obj.eventOK(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            System.out.println("Click OK");
                            GlassPanePopup.closePopupLast();
                        }
                    });
                    GlassPanePopup.showPopup(obj);
                       procesoEnCurso = false;
                } else {
                    // La solicitud POST falló
                    System.out.println("Error al enviar los datos a la API");
                       procesoEnCurso = false;
                }
            });
        } catch (JSONException e) {
            // Manejar la excepción JSONException aquí
            System.out.println("Error al crear el objeto JSON: " + e.getMessage());
               procesoEnCurso = false;
        }
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
    private View.BotonesText.CustomTextField Codigos;
    private View.BotonesText.Buttons btnAceptar;
    private View.BotonesText.Buttons btnCancelar;
    public javax.swing.JComboBox<String> cbNivelCodigoConductual;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
