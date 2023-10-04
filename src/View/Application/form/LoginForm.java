/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form;

import Services.Validaciones;
import View.aplicacion.Application;
import View.glasspanepopup.GlassPanePopup;
import View.samplemessage.Message;
import com.formdev.flatlaf.FlatClientProperties;
import expoescritorio.Controller.PersonasController;
import expoescritorio.Models.Personas;
import expoescritorio.Models.PersonasLo;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
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
        
        //Panel
        label1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font;");
        
        circulo.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten(@background,7%);");
        
        txtContraseña.putClientProperty(FlatClientProperties.STYLE, ""
                +"showCapsLock: true;"
                +"showRevealButton: true");
        //Hints 
        txtCorreo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Correo");
        txtContraseña.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Contraseña");
        
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

        btnLogin = new View.BotonLogin.boton3();
        btnNosotros = new View.BotonLogin.boton3();
        circulo = new javax.swing.JPanel();
        txtContraseña = new View.SWING.Contraseña();
        txtCorreo = new View.SWING.textField();
        btnIngresar = new View.SWING.boton();
        btnRecuperaciones = new View.SWING.boton();
        jLabel3 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();

        btnLogin.setForeground(new java.awt.Color(102, 102, 102));
        btnLogin.setText("Inicio de Sesión");
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnNosotros.setForeground(new java.awt.Color(102, 102, 102));
        btnNosotros.setText("Sobre Nosotros");
        btnNosotros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNosotros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNosotrosMouseClicked(evt);
            }
        });
        btnNosotros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNosotrosActionPerformed(evt);
            }
        });

        circulo.setPreferredSize(new java.awt.Dimension(55, 55));

        txtContraseña.setHint("CONTRASEÑA");
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });

        btnIngresar.setBackground(new java.awt.Color(78, 62, 108));
        btnIngresar.setForeground(new java.awt.Color(204, 204, 204));
        btnIngresar.setText("Iniciar Sesión");
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

        btnRecuperaciones.setForeground(new java.awt.Color(204, 204, 204));
        btnRecuperaciones.setText("¿Olvidó su contraseña?");
        btnRecuperaciones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRecuperaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRecuperacionesMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/png/SAE.png"))); // NOI18N

        label1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        label1.setText("Bienvenido a SAE");

        javax.swing.GroupLayout circuloLayout = new javax.swing.GroupLayout(circulo);
        circulo.setLayout(circuloLayout);
        circuloLayout.setHorizontalGroup(
            circuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(circuloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(circuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRecuperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
            .addGroup(circuloLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(circuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 55, Short.MAX_VALUE))
            .addGroup(circuloLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(label1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        circuloLayout.setVerticalGroup(
            circuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(circuloLayout.createSequentialGroup()
                .addGroup(circuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(circuloLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(label1))
                    .addGroup(circuloLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRecuperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(412, 412, 412)
                .addComponent(circulo, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(396, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNosotros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(circulo, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    Validaciones valida = new Validaciones();
        String Correo = this.txtCorreo.getText();
        String Contraseña = this.txtContraseña.getText();

        if(Correo.isBlank() == true || Contraseña.isBlank() == true){
            /*Validación de campos vacíos*/
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Los campos no pueden estar vacios");
            playError();
        }
        else if (!valida.checkEmail(this.txtCorreo.getText()) ) {
                //Muestra la notificacion y el sonido de error
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Tiene que ser un correo");
                playError();
            }
        else{
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
        Application.nosotross
        ();
    }//GEN-LAST:event_btnNosotrosMouseClicked

    private void btnNosotrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNosotrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNosotrosActionPerformed

    
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
    private javax.swing.JPanel circulo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel label1;
    private View.SWING.Contraseña txtContraseña;
    private View.SWING.textField txtCorreo;
    // End of variables declaration//GEN-END:variables

}
