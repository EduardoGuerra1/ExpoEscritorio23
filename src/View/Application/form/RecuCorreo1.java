/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form;

import static View.Application.form.RecuQR.encryptPassword;
import View.aplicacion.Application;
import com.formdev.flatlaf.FlatClientProperties;
import expoescritorio.Controller.ControllerFull;
import static expoescritorio.Controller.ControllerFull.putApiAsync;
import expoescritorio.Controller.PersonasController;
import expoescritorio.Controller.Recuperaciones;
import static expoescritorio.Controller.TiposPersonasController.getTiposPersonasApiAsync;
import expoescritorio.Models.Personas;
import expoescritorio.Models.Recu;
import expoescritorio.Models.TiposPersonas;
import java.io.File;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import org.json.JSONException;
import org.json.JSONObject;
import raven.toast.Notifications;

/**
 *
 * @author gyaci
 */
public class RecuCorreo1 extends javax.swing.JPanel {

    Recuperaciones controller = new Recuperaciones();
    String Code = controller.generateRandomCode();
    int idPersona;
    private Boolean noti;
    String Mensaje;

    public RecuCorreo1() {
        initComponents();
        
        //Hints TextField
        txtCorreo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Correo");
        txtCodigo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Código Recibido");
        txtContraseña.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nueva Contraseña");
        
        txtCodigo.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                for (char c : str.toCharArray()) {
                    if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c) && c != '.') {
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
        lb1.setVisible(false);
        lb2.setVisible(false);
        txtCodigo.setVisible(false);
        txtContraseña.setVisible(false);
        btnRestablecer.setVisible(false);
        
        
        txtCorreo.setText("");
        txtCodigo.setText("");
        txtContraseña.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        btnRestablecer = new javax.swing.JButton();
        txtCorreo = new View.SWING.textField();
        txtCodigo = new View.SWING.textField();
        lb0 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        txtContraseña = new View.SWING.Contraseña();
        lb2 = new javax.swing.JLabel();
        btnRegresar = new View.SWING.boton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/png/correooo.png"))); // NOI18N

        btnEnviar.setBackground(new java.awt.Color(49, 61, 73));
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("Enviar");
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnviarMouseClicked(evt);
            }
        });
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnRestablecer.setBackground(new java.awt.Color(49, 61, 73));
        btnRestablecer.setForeground(new java.awt.Color(255, 255, 255));
        btnRestablecer.setText("Restablecer");
        btnRestablecer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRestablecerMouseClicked(evt);
            }
        });
        btnRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestablecerActionPerformed(evt);
            }
        });

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });

        lb0.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lb0.setText("Ingrese el correo con el que está registrado:");

        lb1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lb1.setText("Ingrese el código que se le envió al correo:  ");

        lb2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lb2.setText("Ingrese su nueva contraseña:");

        btnRegresar.setForeground(new java.awt.Color(204, 204, 204));
        btnRegresar.setText("Regresar a Opciones");
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("Recuperacion por Correo Electrónico ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb0)
                            .addComponent(lb1)
                            .addComponent(lb2))
                        .addContainerGap(391, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRestablecer, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(213, 213, 213))))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(106, 106, 106)
                .addComponent(lb0)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addComponent(lb1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(206, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseClicked
        PersonasController recu = new PersonasController();

        Recu person = recu.CellApiCorreo(txtCorreo.getText());
        idPersona = person.getIdPersona();

        int id = person.getIdTipoPersona();
        if (id == 4) {
            enviarDatosHaciaApi();

            System.out.println(Code);

        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Debe ingresar un correo de administrador");
            playError();
        }

    }//GEN-LAST:event_btnEnviarMouseClicked
    private void enviarDatosHaciaApi() {
        String Correo = txtCorreo.getText();
        try {
            // Crear un objeto JSON con los datos recopilados
            JSONObject jsonData = new JSONObject();
            jsonData.put("correo", Correo);
            jsonData.put("code", Code);

            // Llamar al método postApiAsync para enviar los datos
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/MandarCorreo/enviarCodigo"; // Reemplaza esto con la URL de tu API
            String jsonString = jsonData.toString();

            CompletableFuture<Boolean> postFuture = ControllerFull.postApiAsync(endpointUrl, jsonString);

            // Manejar la respuesta de la API
            postFuture.thenAccept(success -> {
                if (success) {
                    Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Se envió correctamente el código");
                    lb1.setVisible(true);
                    lb2.setVisible(true);
                    txtCodigo.setVisible(true);
                    txtContraseña.setVisible(true);
                    btnRestablecer.setVisible(true);

                    lb0.setVisible(false);
                    txtCorreo.setVisible(false);
                    btnEnviar.setVisible(false);
                } else {
                    Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Hubo un error al enviar el código, intente nuevamente");
                }
            });
        } catch (JSONException e) {
            // Manejar la excepción JSONException aquí
            System.out.println("Error al crear el objeto JSON: " + e.getMessage());
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Ocurrió un error, intente nuevamente");
            playError();
        }
    }
    private void btnRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerActionPerformed

    }//GEN-LAST:event_btnRestablecerActionPerformed

    private void btnRestablecerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestablecerMouseClicked
        if (txtCodigo.getText().equals(Code)) {
            String PASSEN = encryptPassword(txtContraseña.getText());

            String jsonInputString = "{\"idPersona\": " + idPersona + ", \"claveCredenciales\": \"" + PASSEN + "\"}";

            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/Credenciales/Contra";

            CompletableFuture<Boolean> result = putApiAsync(endpointUrl, jsonInputString);

            result.thenAccept(response -> {
                if (response) {
                    System.out.println("La solicitud HTTP put  fue exitosa.");
                    Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Se cambió correctamente la contraseña");
                    Application.logout();
                    lb1.setVisible(false);
                    lb2.setVisible(false);
                    txtCodigo.setVisible(false);
                    txtContraseña.setVisible(false);
                    btnRestablecer.setVisible(false);

                    lb0.setVisible(true);
                    txtCorreo.setVisible(true);
                    btnEnviar.setVisible(true);
                } else {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Ocurrió un error, intente nuevamente");
                    playError();
                    System.out.println("La solicitud HTTP put no fue exitosa.");
                }
            }).join();

            CompletableFuture<List<TiposPersonas>> encargadosFuture = getTiposPersonasApiAsync();
        } else {
            System.out.println(" no se que paso ");
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Ocurrió un error, intente nuevamente");
            playError();
        }
    }//GEN-LAST:event_btnRestablecerMouseClicked

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        // TODO add your handling code here:
        Application.recuperaciones();
        lb1.setVisible(false);
        lb2.setVisible(false);
        txtCodigo.setVisible(false);
        txtContraseña.setVisible(false);
        btnRestablecer.setVisible(false);

        lb0.setVisible(true);
        txtCorreo.setVisible(true);
        btnEnviar.setVisible(true);
        
        txtCorreo.setText("");
        txtCodigo.setText("");
        txtContraseña.setText("");

    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        // TODO add your handling code here:

        if (noti == true) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El campo solo permite números y letras");
            playValidacion();
        }
    }//GEN-LAST:event_txtCodigoKeyReleased

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private View.SWING.boton btnRegresar;
    private javax.swing.JButton btnRestablecer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lb0;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private View.SWING.textField txtCodigo;
    private View.SWING.Contraseña txtContraseña;
    private View.SWING.textField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
