/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form;

import View.aplicacion.Application;
import View.glasspanepopup.GlassPanePopup;
import View.samplemessage.Message;
import expoescritorio.Controller.PersonasController;
import expoescritorio.Models.Personas;
import expoescritorio.Models.PersonasLo;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import raven.toast.Notifications;

/**
 *
 * @author gyaci
 */
public class LoginForm extends javax.swing.JPanel {

    /*Declaración de variables de componentes y paneles*/
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private LoginForm loginPanel;
    private Recus recuperaciones;
    
    public LoginForm() {
        initComponents();
        
        /*// Crear el CardLayout y el panel que contendrá los paneles a alternar
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Agregar el cardPanel al formulario
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);

        // Crea una instancia del formulario de inicio de sesión
        loginPanel = this;

        // Crea una instancia del formulario de restablecimiento de contraseña
        passwordPanel = new PasswordForm();

        // Asigna un nombre para identificar los paneles en el CardLayout
        cardPanel.add(loginPanel, "loginPanel");
        // cardPanel.add(passwordPanel, "passwordPanel");

        // Muestra el panel de inicio de sesión al principio
        cardLayout.show(cardPanel, "loginPanel");*/
    }
    
    public void clearTextFields() {
        txtCorreo.setText("");
        txtContraseña.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbCorreo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new View.SWING.textField();
        jLabel7 = new javax.swing.JLabel();
        btnIngresar = new View.SWING.boton();
        btnRecuperaciones = new View.SWING.boton();
        txtContraseña = new View.SWING.Contraseña();
        btnLogin = new View.BotonLogin.boton3();
        btnNosotros = new View.BotonLogin.boton3();

        lbCorreo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbCorreo.setText("Correo");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/png/SAE (1).png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Bienvenido a SAE");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Contraseña");

        btnIngresar.setBackground(new java.awt.Color(78, 62, 108));
        btnIngresar.setText("Iniciar Sesion");
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarMouseClicked(evt);
            }
        });
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnRecuperaciones.setText("¿Olvidó su contraseña?");
        btnRecuperaciones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRecuperaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRecuperacionesMouseClicked(evt);
            }
        });

        txtContraseña.setHint("CONTRASEÑA");
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });

        btnLogin.setText("Inicio Sesión");

        btnNosotros.setText("Sobre Nosotros");
        btnNosotros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNosotrosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(454, 454, 454)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbCorreo)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addContainerGap(457, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRecuperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(491, 491, 491))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNosotros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(52, 52, 52)
                        .addComponent(lbCorreo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnRecuperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNosotros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecuperacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecuperacionesMouseClicked
        // TODO add your handling code here:
        Application.recuperaciones();/*Método que se ejecuta al hacer clic en el botón "¿Olvidó su contraseña?"*/
    }//GEN-LAST:event_btnRecuperacionesMouseClicked

    private void btnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseClicked
        // TODO add your handling code here:
        /*Método que se ejecuta al hacer clic en el botón "Iniciar Sesión"*/
        String Correo = this.txtCorreo.getText();
        String Contraseña = this.txtContraseña.getText();

        if(Correo.isBlank() == true || Contraseña.isBlank() == true){
            /*Validación de campos vacíos*/
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Los campos no pueden estar vacios");
            playError();
        }else{
            /*Llamada a un controlador para procesar la autenticación*/
            PersonasLo personas = PersonasController.callApiAndProcessResponse(Correo, Contraseña);
            int id = personas.getIdTipoPersona();
            if (personas != null) {
                /*Verificación de acceso correcto*/
                System.out.println(id);
                if (id == 4) {
                    clearTextFields();
                    Application.login();
                }else{
                    /*Mostrar mensaje de acceso denegado si no es administrador*/
                    Message obj = new Message();
                    obj.txtTitle.setText("Aviso");
                    obj.txtContent.setText("Acceso denegado, no es administrador.");
                    obj.eventOK(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Click OK");
                            GlassPanePopup.closePopupLast();
                        }
                    });
                    GlassPanePopup.showPopup(obj);
                }
            }else{
                /*Mostrar mensaje de datos incorrectos*/
                Message obj = new Message();
                obj.txtTitle.setText("Aviso");
                obj.txtContent.setText("Datos incorrectos");
                obj.eventOK(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        System.out.println("Click OK");
                        GlassPanePopup.closePopupLast();
                    }
                });
                GlassPanePopup.showPopup(obj);
            }
        }

    }//GEN-LAST:event_btnIngresarMouseClicked

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnNosotrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNosotrosMouseClicked
        // TODO add your handling code here:
        Application.SobreNosotros();
    }//GEN-LAST:event_btnNosotrosMouseClicked

    
     private void playValidacion() {
        String filepath = "src/View/sounds/validacion.wav";

        PlayMusic(filepath);

    }

    private void playError() {
        String filepath = "src/View/sounds/error.wav";

        PlayMusic(filepath);

    }
    //metodo para reproducir sonidos
    private static void PlayMusic(String location) {
        try {
            File musicPath = new File(location);
            
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();//Codigo para que el audio se reproduzca
            }else{
                System.out.println("No se encuentra el archivo de sonido");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.SWING.boton btnIngresar;
    private View.BotonLogin.boton3 btnLogin;
    private View.BotonLogin.boton3 btnNosotros;
    private View.SWING.boton btnRecuperaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbCorreo;
    private View.SWING.Contraseña txtContraseña;
    private View.SWING.textField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
