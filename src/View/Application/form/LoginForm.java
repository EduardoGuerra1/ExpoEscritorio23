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
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import raven.toast.Notifications;

/**
 *
 * @author gyaci
 */
public class LoginForm extends javax.swing.JPanel {

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
        txtContraseña = new View.SWING.textField();
        btnIngresar = new View.SWING.boton();
        btnRecuperaciones = new View.SWING.boton();

        lbCorreo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbCorreo.setForeground(new java.awt.Color(204, 204, 204));
        lbCorreo.setText("Correo");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/png/SAE (1).png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Bienvenido a SAE");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Contraseña");

        btnIngresar.setText("Iniciar Sesion");
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarMouseClicked(evt);
            }
        });

        btnRecuperaciones.setText("¿Olvido su contraseña?");
        btnRecuperaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRecuperacionesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(448, 448, 448)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCorreo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1))
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(429, 429, 429))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRecuperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(454, 454, 454))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(486, 486, 486))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1)))
                .addGap(42, 42, 42)
                .addComponent(lbCorreo)
                .addGap(9, 9, 9)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnRecuperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseClicked
        // TODO add your handling code here:
        String Correo = this.txtCorreo.getText();
        String Contraseña = this.txtContraseña.getText();
        
        if(Correo.isBlank() == true || Contraseña.isBlank() == true){
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Los campos no pueden estar vacios");
        }else{
            Personas personas = PersonasController.callApiAndProcessResponse(Correo, Contraseña);
            int id = personas.getIdTipoPersona();
        if (personas != null) {
            System.out.println(id);
            if (id == 4) {
                 clearTextFields();
                Application.login();
            }else{
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

    private void btnRecuperacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecuperacionesMouseClicked
        // TODO add your handling code here:
        Application.recuperaciones();

    }//GEN-LAST:event_btnRecuperacionesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.SWING.boton btnIngresar;
    private View.SWING.boton btnRecuperaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbCorreo;
    private View.SWING.textField txtContraseña;
    private View.SWING.textField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
