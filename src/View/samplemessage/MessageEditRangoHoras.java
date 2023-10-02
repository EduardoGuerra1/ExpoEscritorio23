/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.samplemessage;

import Services.Validaciones;
import View.Application.form.other.RangoDeHoras;
import View.glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.FlatClientProperties;
import expoescritorio.Controller.ControllerFull;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Timer;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import org.json.JSONException;
import org.json.JSONObject;
import raven.toast.Notifications;

/**
 *
 * @author educs
 */
public class MessageEditRangoHoras extends javax.swing.JPanel {

    public int id;
    private Boolean noti;

    public MessageEditRangoHoras() {

        initComponents();
        setOpaque(false);

        txtTitle.setBackground(new Color(0, 0, 0, 0));
        txtTitle.setOpaque(false);
        txtTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h4.font");
        txtTipoCodigo.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                for (char c : str.toCharArray()) {
                    if (!Character.isLetter(c) && !Character.isWhitespace(c) && c != '.') {
                        //Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El campo solo permite números y letras");
                        noti = true;
                        return; // Ignora el carácter si no es letra, número, espacio o punto
                    } else {
                        noti = false;
                    }
                }
                super.insertString(offset, str, attr);
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
        jLabel2 = new javax.swing.JLabel();
        txtTipoCodigo = new View.BotonesText.CustomTextField();
        jLabel3 = new javax.swing.JLabel();
        Inicio = new View.ExampleTable.Tiempo();
        Final = new View.ExampleTable.Tiempo();
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
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 120, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 120, -1));

        jLabel2.setText("Titulo De Hora:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, 20));
        jLabel2.getAccessibleContext().setAccessibleName("Codigo de Salon:");

        txtTipoCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTipoCodigoKeyReleased(evt);
            }
        });
        add(txtTipoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 310, 50));

        jLabel3.setText("Final de hora");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));
        add(Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 90, -1));

        Final.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalActionPerformed(evt);
            }
        });
        add(Final, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 90, -1));

        jLabel4.setText("Inicio de hora");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        GlassPanePopup.closePopupLast();
        playCerrar();
    }//GEN-LAST:event_btnCancelarMouseClicked

    
     private void playCerrar() {
        String filepath = "src/View/sounds/cerrar.wav";

        PlayMusic(filepath);

    }
     
    private void playValidacion() {
        String filepath = "src/View/sounds/validacion.wav";

        PlayMusic(filepath);

    }

    private void playError() {
        String filepath = "src/View/sounds/error.wav";

        PlayMusic(filepath);

    }
    
    private static void PlayMusic(String location) {
        try {
            File musicPath = new File(location);
            
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }else{
                System.out.println("No se encuentra el archivo de sonido");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   
    }

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        String selectedTime1 = Final.getSelectedTime();
        String selectedTime2 = Inicio.getSelectedTime();

        String[] timeParts1 = selectedTime1.split(":");
        int hour1 = Integer.parseInt(timeParts1[0]);
        int minute1 = Integer.parseInt(timeParts1[1]);

        String[] timeParts2 = selectedTime2.split(":");
        int hour2 = Integer.parseInt(timeParts2[0]);
        int minute2 = Integer.parseInt(timeParts2[1]);

        if (hour1 > hour2 || (hour1 == hour2 && minute1 > minute2)) {
            if (txtTipoCodigo.getText().isBlank()) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "El campo no puede estar vacío");
                playError();
            } else {
                Validaciones valida = new Validaciones();
                if (!valida.check16(txtTipoCodigo.getText())) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "El Campo es muy grande");
                    playError();
                } else {
                    actualizarDatosHaciaApi();
                    Timer timer = new Timer(500, (ActionEvent e) -> {
                        RangoDeHoras tc = new RangoDeHoras();
                        tc.cargarDatosAsync();
                        tc.deleteAllTableRows(tc.table1);
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Revisar La hora final ");
        }

    }//GEN-LAST:event_btnAceptarMouseClicked

    private void FinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FinalActionPerformed

    private void txtTipoCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoCodigoKeyReleased
        // TODO add your handling code here:

        if (noti == true) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El campo solo permite letras");
            playValidacion();
        }
    }//GEN-LAST:event_txtTipoCodigoKeyReleased

    public void eventOK(ActionListener event) {
        btnAceptar.addActionListener(event);
    }

    public void actualizarDatosHaciaApi() {
        String codigoSalon = txtTipoCodigo.getText();
        String selectedInicio = Inicio.getSelectedTime();
        String selectedFinal = Final.getSelectedTime();
        try {
            // Crear un objeto JSON con los datos recopilados
            JSONObject jsonData = new JSONObject();
            jsonData.put("idRangoHora", id);
            jsonData.put("titulo", codigoSalon);
            jsonData.put("inicio", selectedInicio);
            jsonData.put("finals", selectedFinal);

            // Llamar al método putApiAsync para enviar los datos de actualización
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/RangoHoras/update"; // Reemplaza esto con la URL de tu API
            String jsonString = jsonData.toString();

            CompletableFuture<Boolean> putFuture = ControllerFull.putApiAsync(endpointUrl, jsonString);

            // Manejar la respuesta de la API
            putFuture.thenAccept(success -> {
                if (success) {
                    // La solicitud PUT fue exitosa
                    System.out.println("Datos actualizados correctamente en la API");

                    
                    Message obj = new Message();
                    obj.txtTitle.setText("Aviso");
                    obj.txtContent.setText("Datos actualizados correctamente");
                    obj.eventOK(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            System.out.println("Click OK");
                            GlassPanePopup.closePopupLast();
                        }
                    });
                    GlassPanePopup.showPopup(obj);
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

// Método para obtener el ID seleccionado de un JComboBox

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public View.ExampleTable.Tiempo Final;
    public View.ExampleTable.Tiempo Inicio;
    private View.BotonesText.Buttons btnAceptar;
    private View.BotonesText.Buttons btnCancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public View.BotonesText.CustomTextField txtTipoCodigo;
    public javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
