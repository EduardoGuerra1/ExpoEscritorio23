/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form;

import View.aplicacion.Application;
import static expoescritorio.Controller.ControllerFull.postApiAsync;
import static expoescritorio.Controller.ControllerFull.putApiAsync;
import expoescritorio.Controller.PersonasController;
import expoescritorio.Controller.Recuperaciones;
import static expoescritorio.Controller.TiposPersonasController.getTiposPersonasApiAsync;
import expoescritorio.Models.Personas;
import expoescritorio.Models.TiposPersonas;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.swing.ImageIcon;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class RecuQR extends javax.swing.JPanel {

   Recuperaciones controller = new Recuperaciones ();
   int idPersona; 
    public RecuQR() {
        
         
        initComponents();
        txtTexto.setVisible(true);
        jScrollPane1.setVisible(true);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    public static String encryptPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
     int idEncargado = 27;
     String PASSEN = encryptPassword(txtCambioContraseña.getText());
        String nombrePersona = this.txtCambioContraseña.getText();
        

          String jsonInputString = "{\"idPersona\": " + idEncargado + ", \"claveCredenciales\": \"" + PASSEN + "\"}";


        String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/Credenciales/Contra";

        CompletableFuture<Boolean> result = putApiAsync(endpointUrl, jsonInputString);
        
        result.thenAccept(response -> {
            if (response) {
                
                 System.out.println("La solicitud HTTP Post exitosa.");
            } else {
                 
             System.out.println("La solicitud HTTP put no fue exitosa.");
            }
        }).join();

             CompletableFuture<List<TiposPersonas>> encargadosFuture = getTiposPersonasApiAsync();

    // Esperar a que la operación asincrónica se complete y obtener el resultado de la lista de encargados
  
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        txtTelefono1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        label1 = new java.awt.Label();
        btnRestablecer = new javax.swing.JButton();
        label4 = new java.awt.Label();
        btnEnviar = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        btnRegreso = new View.SWING.boton();
        txtTelefono = new View.SWING.textField();
        txtCorreo = new View.SWING.textField();
        txtCambioContraseña = new View.SWING.Contraseña();

        txtTexto.setEditable(false);
        txtTexto.setBackground(new java.awt.Color(0, 51, 102));
        txtTexto.setColumns(20);
        txtTexto.setForeground(new java.awt.Color(0, 51, 102));
        txtTexto.setRows(5);
        jScrollPane1.setViewportView(txtTexto);

        setBackground(new java.awt.Color(49, 61, 73));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        label1.setForeground(java.awt.Color.lightGray);
        label1.setText("Ingrese la nueva contraseña:");

        btnRestablecer.setBackground(new java.awt.Color(49, 61, 73));
        btnRestablecer.setForeground(new java.awt.Color(204, 204, 204));
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

        label4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        label4.setForeground(java.awt.Color.lightGray);
        label4.setText("Ingrese el codigo que se genero");

        btnEnviar.setBackground(new java.awt.Color(49, 61, 73));
        btnEnviar.setForeground(new java.awt.Color(204, 204, 204));
        btnEnviar.setText("Generar");
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnviarMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icon/png/QR Code-amico (3).png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(87, 104, 120));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        label2.setForeground(java.awt.Color.lightGray);
        label2.setText("Genere el codigo, para posteriormente escanearlo e iniciar con el proceso de recuperación ");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        btnRegreso.setText("Regresar a Opciones");
        btnRegreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresoMouseClicked(evt);
            }
        });
        jPanel1.add(btnRegreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        txtTelefono.setForeground(new java.awt.Color(204, 204, 204));

        txtCorreo.setForeground(new java.awt.Color(204, 204, 204));

        txtCambioContraseña.setHint("Nueva Contraseña");
        txtCambioContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCambioContraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1197, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtCambioContraseña, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(btnRestablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCambioContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        label1.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRestablecerActionPerformed

    private void btnRestablecerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestablecerMouseClicked
        PersonasController recu = new PersonasController();

        Personas person = recu.CellApiCorreo(txtCorreo.getText());
        int idPersona = person.getIdPersona();

        int id =  person.getIdTipoPersona();

        String COD = txtTexto.getText();

        if ( txtTelefono.getText().equals(COD))
        {
            String PASSEN = encryptPassword(txtCambioContraseña.getText());

            String jsonInputString = "{\"idPersona\": " + idPersona + ", \"claveCredenciales\": \"" + PASSEN + "\"}";

            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/Credenciales/Contra";

            CompletableFuture<Boolean> result = putApiAsync(endpointUrl, jsonInputString);

            result.thenAccept(response -> {
                if (response) {

                    System.out.println("La solicitud HTTP Post exitosa.");
                } else {

                    System.out.println("La solicitud HTTP put no fue exitosa.");
                }
            }).join();

            CompletableFuture<List<TiposPersonas>> encargadosFuture = getTiposPersonasApiAsync();
            System.out.println("furulo");
        }
        else
        {
            System.out.println("no furulo");
        }
    }//GEN-LAST:event_btnRestablecerMouseClicked

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseClicked

        txtTexto.setText( controller.generateRandomCode());
        ByteArrayOutputStream out = QRCode.from(this.txtTexto.getText()).to(ImageType.PNG).stream();
        ImageIcon imageIcon = new ImageIcon(out.toByteArray());
        this.lblImagen.setIcon(imageIcon);

    }//GEN-LAST:event_btnEnviarMouseClicked

    private void btnRegresoQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresoQRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresoQRActionPerformed

    private void btnRegresoQRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresoQRMouseClicked
        // TODO add your handling code here:
        Application.recuperaciones();
    }//GEN-LAST:event_btnRegresoQRMouseClicked

    private void btnRegresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresoMouseClicked
        // TODO add your handling code here:
        Application.recuperaciones();
    }//GEN-LAST:event_btnRegresoMouseClicked

    private void txtCambioContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCambioContraseñaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private View.SWING.boton btnRegreso;
    private javax.swing.JButton btnRestablecer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label4;
    private javax.swing.JLabel lblImagen;
    private View.SWING.Contraseña txtCambioContraseña;
    private View.SWING.textField txtCorreo;
    private View.SWING.textField txtTelefono;
    private javax.swing.JTextField txtTelefono1;
    private javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables
}
