package View.Application.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import View.aplicacion.Application;
import View.glasspanepopup.GlassPanePopup;
import View.samplemessage.Message;
import expoescritorio.Controller.PersonasController;
import expoescritorio.Controller.Recuperaciones;
import expoescritorio.Models.CodigoRecuperacion;
import expoescritorio.Models.Personas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author gyaci
 */
public class LoginForm extends javax.swing.JPanel {

    public LoginForm() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new LoginFormLayout());
        login.setLayout(new LoginLayout());
        lbTitulo.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        login.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Login.background;"
                + "arc:20;"
                + "border:30,40,50,30");

        txtContraseña.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true;"
                + "showCapsLock:true");
        cmdEntrar.putClientProperty(FlatClientProperties.BUTTON_TYPE, "roundRect");
        cmdEntrar1.putClientProperty(FlatClientProperties.BUTTON_TYPE, "roundRect");

        /*cmdEntrar.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:none;"
                + "focusWidth:0");*/
        txtUsuario.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Correo");
        txtContraseña.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Contraseña");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        cmdEntrar = new javax.swing.JButton();
        cmdEntrar1 = new javax.swing.JButton();
        lbTitulo = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lbContraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();

        cmdEntrar.setText("Entrar");
        cmdEntrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmdEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEntrarActionPerformed(evt);
            }
        });

        cmdEntrar1.setText("Se me olvidó la contraseña pipip");
        cmdEntrar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmdEntrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEntrar1ActionPerformed(evt);
            }
        });

        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Bienvenido a SAE");

        lbUsuario.setText("Correo");

        lbContraseña.setText("Contraseña");

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(lbUsuario)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(lbContraseña)
                            .addComponent(txtContraseña))
                        .addContainerGap(43, Short.MAX_VALUE))))
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(loginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdEntrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(lbTitulo)
                .addGap(18, 18, 18)
                .addComponent(lbUsuario)
                .addGap(29, 29, 29)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbContraseña)
                .addGap(5, 5, 5)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdEntrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 216, Short.MAX_VALUE)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 216, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("login");
    }// </editor-fold>//GEN-END:initComponents

    private void cmdEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEntrarActionPerformed
        String Correo = this.txtUsuario.getText(); 
       String Password = this.txtContraseña.getText(); 
        Personas personas = PersonasController.callApiAndProcessResponse(Correo, Password);
        /* Recuperaciones Recuperaciones2 = new Recuperaciones();
       String Code =  Recuperaciones2.mandarCorreo(Correo);

        System.out.println(Code);*/
        if (personas != null) {
             Application.login();
        } else {
            Message obj = new Message();
            obj.txtTitle.setText("Aviso");
            obj.txtContent.setText("Datos incorrectos" );
            obj.eventOK(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {

                    System.out.println("Click OK");
                    GlassPanePopup.closePopupLast();
                }
            });
            GlassPanePopup.showPopup(obj);
        }
        
       
    }//GEN-LAST:event_cmdEntrarActionPerformed

    private void cmdEntrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEntrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdEntrar1ActionPerformed

    private class LoginFormLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                int width = parent.getWidth();
                int height = parent.getHeight();
                int loginWidth = UIScale.scale(320);
                int loginHeight = login.getPreferredSize().height;
                int x = (width - loginWidth) / 2;
                int y = (height - loginHeight) / 2;
                login.setBounds(x, y, loginWidth, loginHeight);
            }
        }

    }

    private class LoginLayout implements LayoutManager {

        private final int titleGap = 10;
        private final int textGap = 10;
        private final int labelGap = 5;
        private final int buttonGap = 50;

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                Insets insets = parent.getInsets();
                int height = insets.top + insets.bottom;

                height += lbTitulo.getPreferredSize().height;
                height += UIScale.scale(titleGap);
                height += lbUsuario.getPreferredSize().height;
                height += UIScale.scale(labelGap);
                height += txtUsuario.getPreferredSize().height;
                height += UIScale.scale(textGap);
                height += lbContraseña.getPreferredSize().height;
                height += UIScale.scale(labelGap);
                height += txtContraseña.getPreferredSize().height;
                height += UIScale.scale(buttonGap);
                height += cmdEntrar.getPreferredSize().height;
                height += UIScale.scale(buttonGap);
                height += cmdEntrar1.getPreferredSize().height;
                return new Dimension(0, height);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                Insets insets = parent.getInsets();
                int x = insets.left;
                int y = insets.top;
                int width = parent.getWidth() - (insets.left + insets.right);

                lbTitulo.setBounds(x, y, width, lbTitulo.getPreferredSize().height);
                y += lbTitulo.getPreferredSize().height + UIScale.scale(titleGap);

                lbUsuario.setBounds(x, y, width, lbUsuario.getPreferredSize().height);
                y += lbUsuario.getPreferredSize().height + UIScale.scale(labelGap);
                txtUsuario.setBounds(x, y, width, txtUsuario.getPreferredSize().height);
                y += txtUsuario.getPreferredSize().height + UIScale.scale(textGap);

                lbContraseña.setBounds(x, y, width, lbContraseña.getPreferredSize().height);
                y += lbContraseña.getPreferredSize().height + UIScale.scale(labelGap);
                txtContraseña.setBounds(x, y, width, txtContraseña.getPreferredSize().height);
                y += txtContraseña.getPreferredSize().height + UIScale.scale(buttonGap);

                cmdEntrar.setBounds(x, y, width, cmdEntrar.getPreferredSize().height);
                cmdEntrar1.setBounds(x, y, width, cmdEntrar1.getPreferredSize().height);
               
            }

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdEntrar;
    private javax.swing.JButton cmdEntrar1;
    private javax.swing.JLabel lbContraseña;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPanel login;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
