/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.samplemessage;

import Services.Encriptacion;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.Timer;
import org.json.JSONObject;
import raven.toast.Notifications;
import Services.Validaciones;
import View.Application.form.other.Credenciales;
import View.Application.form.other.Estudiantes;
import static expoescritorio.Controller.TiposPersonasController.getTiposPersonasApiAsync;
import expoescritorio.Models.TiposPersonas;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.util.Date;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author educs
 */
public class MessageAddPersonas extends javax.swing.JPanel {
     private boolean procesoEnCurso = false;
    List<TiposPersonas> secciones = new ArrayList<TiposPersonas>();
    String rute = "";
    Credenciales frm = null;
    
    private Boolean noti;
    
    public MessageAddPersonas(Credenciales frmCredenciales) {
        initComponents();
        setOpaque(false);

        txtTitle.setBackground(new Color(0, 0, 0, 0));
        txtTitle.setOpaque(false);
        txtTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h4.font");
        // Obtener los datos de la API y cargarlos en el ComboBox
        
        this.frm = frmCredenciales;
        
               CompletableFuture<List<TiposPersonas>> futurePersonas = getTiposPersonasApiAsync();

        // Agregar un ActionListener para cargar los datos del combobox una vez que estén disponibles
        futurePersonas.thenAccept(personasList -> {
            // Crear un arreglo de nombres y apellidos para usar en el combobox
            String[] nombresApellidos = new String[personasList.size()];
            for (int i = 0; i < personasList.size(); i++) {
                TiposPersonas persona = personasList.get(i);
                
                nombresApellidos[i] = persona.getTipoPersona();

            }

            // Agregar los nombres y apellidos al combobox
            cbTipoUsuario.setModel(new DefaultComboBoxModel<>(nombresApellidos));
            //cbPersona.setModel(new DefaultComboBoxModel<>(ID));
            
        });
                cbTipoUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene el elemento seleccionado y actualiza el JTextField
                String selectedText = (String) cbTipoUsuario.getSelectedItem();
 
        Tipos.setText(selectedText);
}
            
        });

            Tipos.setVisible(false);
            
             TxTelefono.setDocument(new PlainDocument() { // desde aca 
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                for (char c : str.toCharArray()) {
                    if (!Character.isDigit(c) && !Character.isWhitespace(c) && c != '+') {
                        // Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El campo solo permite números y letras");

                        noti = true;
                        return; // Ignora el carácter si no es letra, número, espacio o punto
                    }
                else{
                      noti = false;
                    }
                }
                super.insertString(offset, str, attr);
            }
        });// ha
               txtNombres1.setDocument(new PlainDocument() { // desde aca 
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                for (char c : str.toCharArray()) {
                    if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                        // Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El campo solo permite números y letras");

                        noti=true;  
                        return; // Ignora el carácter si no es letra, número, espacio o punto
                    }
                else{
                        noti=false;
                    }
                }
                super.insertString(offset, str, attr);
            }
        });
              txtApellidos.setDocument(new PlainDocument() { // desde aca 
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                for (char c : str.toCharArray()) {
                    if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                        // Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El campo solo permite números y letras");
                        noti=true;
                        
                        return; // Ignora el carácter si no es letra, número, espacio o punto
                    }
                else{
                      noti=false;
                    }
                }
                super.insertString(offset, str, attr);
            }
        });   
              txtCodigo.setDocument(new PlainDocument() { // desde aca 
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                for (char c : str.toCharArray()) {
                    if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                        // Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El campo solo permite números y letras");

                        noti=true;
                        return; // Ignora el carácter si no es letra, número, espacio o punto
                    }
                else{
                      noti=false;
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
        btnImagen = new View.BotonesText.Buttons();
        btnAceptar = new View.BotonesText.Buttons();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombres1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtClave = new javax.swing.JTextField();
        btnCancelar = new View.BotonesText.Buttons();
        lbImagen = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dpNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        cbTipoUsuario = new javax.swing.JComboBox<>();
        Tipos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxTelefono = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTitle.setText("Gestión de Usuarios");
        add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        btnImagen.setText("Escoger foto");
        btnImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImagenMouseClicked(evt);
            }
        });
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });
        add(btnImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 120, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 120, -1));

        jLabel1.setText("Nombres:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel2.setText("Foto:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        jLabel4.setText("Fecha de nacimiento:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 160, 30));

        jLabel5.setText("Nombres:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        txtNombres1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombres1ActionPerformed(evt);
            }
        });
        txtNombres1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombres1KeyReleased(evt);
            }
        });
        add(txtNombres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 260, 30));

        jLabel6.setText("Apellidos:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidosKeyReleased(evt);
            }
        });
        add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 260, 30));

        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 260, 30));

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 120, -1));
        add(lbImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 220, 190));

        jLabel8.setText("Contraseña:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        jLabel12.setText("Codigo:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        dpNacimiento.setToolTipText("");
        dpNacimiento.setDateFormatString("yyyy-MM-dd");
        add(dpNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 180, -1));

        jLabel3.setText("Tipo de Usuario:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));
        add(cbTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 160, -1));

        Tipos.setEditable(false);
        Tipos.setText("Docente");
        Tipos.setToolTipText("");
        Tipos.setEnabled(false);
        Tipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TiposActionPerformed(evt);
            }
        });
        add(Tipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 150, 20));

        jLabel7.setText("Telefono:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        TxTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxTelefonoActionPerformed(evt);
            }
        });
        TxTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxTelefonoKeyReleased(evt);
            }
        });
        add(TxTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 260, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:
             Date selectedDate = dpNacimiento.getDate();
           Date currentDate = new Date(); // Fecha actual
          Boolean band1 = true, band2 = true;
        
        
         if (txtNombres1.getText().isBlank() || txtApellidos.getText().isBlank() || txtCodigo.getText().isBlank() || TxTelefono.getText().isBlank() || txtClave.getText().isBlank()) {
           Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Los campos no pueden estar vacíos");
          playError();
         }
         else if (dpNacimiento.getDate() == null) {
           Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Por favor, asegúrate de completar tu fecha de nacimiento en un formato válido");
          playError();
        }

        else if(!Validaciones.checkName(txtNombres1.getText()) && !Validaciones.checkName(txtApellidos.getText())){
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "El nombre o apellido no es inválido");
            playError();
        }
        else if(!Validaciones.checkDateDown(dpNacimiento.getDate().toInstant().atOffset(ZoneOffset.UTC))){
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "La fecha de nacimiento no es válida");
            playError();
        }
      
        else if(!Validaciones.onlyInts(txtCodigo.getText())){
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El codigo solo debe tener números");
            playValidacion();
        }
        else if(!txtClave.getText().isEmpty() && txtClave.getText().length()<6){
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "La contraseña debe ser de al menos 6 carácteres");
            playValidacion();
        }
        else if(!Validaciones.onlyInts(TxTelefono.getText())){
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El Numero solo debe tener números");
            playValidacion();
        }
         else if(!Validaciones.check8(txtCodigo.getText())){
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El Campo codigo es muy grande");
            playValidacion();
        }
                  else if(!Validaciones.check8(TxTelefono.getText())){
           Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El Campo Telefono es muy grande");
            playValidacion();
        }
                   else if(!Validaciones.check100(txtClave.getText())){
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El Campo Contraseña es muy grande");
            playValidacion();
        }
        
        else {
            try {
                enviarDatosHaciaApi();
            } catch (IOException ex) {
                Logger.getLogger(MessageAddPersonas.class.getName()).log(Level.SEVERE, null, ex);
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Ocurrió un error, intente nuevamente");
            playError();
            }
           /* Timer timer = new Timer(500, (ActionEvent e) -> {
                Estudiantes cd = new Estudiantes();

                cd.cargarDatos();
                cd.deleteAllTableRows(cd.table1);
            });
            timer.setRepeats(false);
            timer.start();*/
        }


    }//GEN-LAST:event_btnAceptarMouseClicked

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
    
    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombres1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombres1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombres1ActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    private void btnImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImagenMouseClicked
        
    }//GEN-LAST:event_btnImagenMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // TODO add your handling code here:
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        playCerrar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        // TODO add your handling code here:
        rute = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG","jpg","png", "jpeg");
        chooser.setFileFilter(filter);
        
        int res = chooser.showOpenDialog(this);
        
        if(res == JFileChooser.APPROVE_OPTION){
            rute = chooser.getSelectedFile().getPath();
            
            Image mImagen = new ImageIcon(rute).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lbImagen.getWidth(), lbImagen.getHeight(), Image.SCALE_SMOOTH));
            lbImagen.setIcon(mIcono);
            
        }
        
    }//GEN-LAST:event_btnImagenActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void TiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TiposActionPerformed

    private void TxTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxTelefonoActionPerformed

    private void txtNombres1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombres1KeyReleased
        // TODO add your handling code here:
        if(noti==true){
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El campo solo permite letras.");
            playValidacion();
        }
        
        
    }//GEN-LAST:event_txtNombres1KeyReleased

    private void TxTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxTelefonoKeyReleased
        // TODO add your handling code here:
        if(noti==true){
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El campo solo permite números.");
            playValidacion();
        }
    }//GEN-LAST:event_TxTelefonoKeyReleased

    private void txtApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyReleased
        // TODO add your handling code here:
        
        if(noti==true){
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El campo solo permite letras.");
            playValidacion();
        }
    }//GEN-LAST:event_txtApellidosKeyReleased

    public void eventOK(ActionListener event) {
    }

    private void enviarDatosHaciaApi() throws FileNotFoundException, IOException {
        
                    if (procesoEnCurso) {
                System.out.println("Le di dos veces xd ");
        return;
    }

    procesoEnCurso = true;
        
        try{
            JSONObject jsonData = new JSONObject();
            
            Path fotoPath;
            byte[] imageBytes;
            String base64Image="";
            
            if(!rute.isEmpty()){
                fotoPath = Paths.get(rute);
                // Read the image file and encode it to Base64
                imageBytes = Files.readAllBytes(fotoPath);
                base64Image = Base64.getEncoder().encodeToString(imageBytes);
            }
            
            Date selectedDate = dpNacimiento.getDate(); // Obtiene la fecha seleccionada como un objeto Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(selectedDate);
            
            jsonData.put("codigo", txtCodigo.getText());
            jsonData.put("nombrePersona", txtNombres1.getText());
            jsonData.put("apellidoPersona", txtApellidos.getText());
            jsonData.put("nacimientoPersona", formattedDate);
            jsonData.put("idTipoPersona", Tipos.getText());
            jsonData.put("correo",txtCodigo.getText()+"@ricaldone.edu.sv");
            jsonData.put("claveCredenciales", Encriptacion.encryptPassword(txtClave.getText()));
             jsonData.put("telefonoPersona", "+503"+TxTelefono.getText());
            if(rute == "") jsonData.put("foto", JSONObject.NULL);
            else jsonData.put("foto", base64Image);
            
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/Credenciales/save"; // Reemplaza esto con la URL de tu API
            String jsonString = jsonData.toString();
            
            CompletableFuture<Boolean> postFuture = ControllerFull.postApiAsync(endpointUrl, jsonString);

            // Manejar la respuesta de la API
            postFuture.thenAccept(success -> {
                if (success) {
                    // La solicitud POST fue exitosa
                    System.out.println("Datos enviados correctamente a la API");

                    frm.deleteAllTableRows(frm.table1);
                    frm.cargarDatos();

                    
                   // boolean pC = panelClosing() == true;
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
            
        }
        catch (Exception e) {
            // Manejar la excepción JSONException aquí
            e.printStackTrace();
            System.out.println("Error al crear el objeto JSON: " + e.getMessage());
            procesoEnCurso = false;
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
        Estudiantes cd = new Estudiantes();
        frm.deleteAllTableRows(frm.table1);
        frm.cargarDatos();
        
        return false;
    }
// Método para obtener el ID seleccionado de un JComboBox

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Tipos;
    private javax.swing.JTextField TxTelefono;
    private View.BotonesText.Buttons btnAceptar;
    private View.BotonesText.Buttons btnCancelar;
    private View.BotonesText.Buttons btnImagen;
    public javax.swing.JComboBox<String> cbTipoUsuario;
    private com.toedter.calendar.JDateChooser dpNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombres1;
    public javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
