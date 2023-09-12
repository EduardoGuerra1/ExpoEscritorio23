/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.samplemessage;

import Services.Encriptacion;
import Services.Validaciones;
import View.Application.form.other.Credenciales;
import View.Application.form.other.Estudiantes;
import View.glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.FlatClientProperties;
import expoescritorio.Controller.ControllerFull;
import expoescritorio.Controller.TiposPersonasController;
import expoescritorio.Models.Personas;
import expoescritorio.Models.TiposPersonas;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.JSONException;
import raven.toast.Notifications;
import org.json.JSONObject;
/**
 *
 * @author thatsgonzalez
 */
public class MessageEditPersonas extends javax.swing.JPanel {
    List<TiposPersonas> secciones = new ArrayList<TiposPersonas>();
    String rute = "";
    Personas modelEstudiante = null;
    File mImageFile = null;
    Credenciales frm = null;
    /**
     * Creates new form MessageEditEstudiante
     */
    
    public boolean panelClosing() {
        // Realiza las acciones necesarias antes de cerrar el panel
        System.out.println("El panel se va a cerrar.");
        Estudiantes cd = new Estudiantes();

        cd.cargarDatos();
        cd.deleteAllTableRows(cd.table1);
        return false;
    }
    
    public void eventOK(ActionListener event) {
        btnAceptar1.addActionListener(event);
    }
    
    private void enviarDatosHaciaApi() throws FileNotFoundException, IOException {
        
        
        
        try{
            JSONObject jsonData = new JSONObject();
            
            Path fotoPath;
            byte[] imageBytes;
            String base64Image="";
            
            if(rute==""){
                base64Image = Base64.getEncoder().encodeToString(modelEstudiante.getFoto());
            }
            else{
                fotoPath = Paths.get(rute);
                // Read the image file and encode it to Base64
                imageBytes = Files.readAllBytes(fotoPath);
                base64Image = Base64.getEncoder().encodeToString(imageBytes);
            }
            
            /*FileInputStream fileInputStream = new FileInputStream(imageFile);

            // Read the image file and encode it to Base64
            byte[] imageBytes = new byte[(int) imageFile.length()];
            fileInputStream.read(imageBytes);*/
     
            
            
            
            jsonData.put("idPersona", modelEstudiante.getIdPersona());
            jsonData.put("codigo", txtCodigo1.getText());
            jsonData.put("nombrePersona", txtNombres2.getText());
            jsonData.put("apellidoPersona", txtApellidos1.getText());
            
            Date selectedDate = dpNacimiento1.getDate();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(selectedDate);
             
            
            jsonData.put("nacimientoPersona", formattedDate);
            jsonData.put("idTipoPersona", "Estudiante");
            jsonData.put("correo",txtCodigo1.getText()+"@ricaldone.edu.sv");
            jsonData.put("telefonoPersona", TxTelefono.getText());
            if(!txtClave.getText().isEmpty()) jsonData.put("claveCredenciales", Encriptacion.encryptPassword(txtClave1.getText()));
            else jsonData.put("claveCredenciales", modelEstudiante.getClaveCredenciales());
            jsonData.put("foto", base64Image);
            
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/Credenciales/update"; // Reemplaza esto con la URL de tu API
            String jsonString = jsonData.toString();
            
            CompletableFuture<Boolean> postFuture = ControllerFull.putApiAsync(endpointUrl, jsonString);

            // Manejar la respuesta de la API
            postFuture.thenAccept(success -> {
                if (success) {
                    // La solicitud POST fue exitosa
                    System.out.println("Datos enviados correctamente a la API");

                    Estudiantes cd = new Estudiantes();

                    frm.deleteAllTableRows(frm.table1);
                    frm.cargarDatos();

                    
                    boolean pC = panelClosing() == true;
                    GlassPanePopup.closePopupLast();

                } else {
                    // La solicitud POST falló
                    System.out.println("Error al enviar los datos a la API");
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "No se pueden editar los datos de los administradores, intente nuevamente");
            playError();
                    
                }
            });
            
        }
        catch (JSONException e) {
            // Manejar la excepción JSONException aquí
            System.out.println("Error al crear el objeto JSON: " + e.getMessage());
        }
        catch(Exception e){
           e.printStackTrace();
        }
        
    }
    
    public MessageEditPersonas(Personas estudiante, Credenciales frmCredenciales) throws SQLException, IOException {
        initComponents();
        setOpaque(false);
         cbTipoUsuario.setVisible(false);
        txtTitle.setBackground(new Color(0, 0, 0, 0));
        txtTitle.setOpaque(false);
        txtTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h4.font");
        
        this.frm = frmCredenciales;
        
        CompletableFuture<List<TiposPersonas>> seccionesFuture = 
                TiposPersonasController.getTiposPersonasApiAsync();
        
        secciones = seccionesFuture.join();
        
        
        
        Date nacimiento = null;
        try{
            nacimiento = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(estudiante.getNacimientoPersona());
        }
        catch(Exception e){
            
        }
        
        
        
        try{
            ByteArrayInputStream in = new ByteArrayInputStream(estudiante.getFoto());
            BufferedImage image = ImageIO.read(in);
            in.close();
            mImageFile = new File("outputImage.jpg");
            ImageIO.write(image, "jpg", mImageFile);
            System.out.println("hola k ase");
            ImageIcon mIcono = new ImageIcon(image);
            
            lbImagen1.setIcon(mIcono);
            lbImagen1.revalidate();
            lbImagen1.repaint();
            lbImagen1.setVisible(true);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("esta no la cuento");
        
        String tipoPersona = TiposPersonasController.getTipoPersonaAsync(estudiante.getIdTipoPersona()).join();
        
        this.modelEstudiante = estudiante;
        
        txtNombres2.setText(estudiante.getNombrePersona());
        txtApellidos1.setText(estudiante.getApellidoPersona());
        txtCodigo1.setText(estudiante.getCodigo());
        dpNacimiento1.setDate(nacimiento);
        TxTelefono.setText(estudiante.getTelefonoPersona());
        
        

            // Limpiar el ComboBox antes de agregar los nuevos elementos
            cbTipoUsuario.removeAllItems();

            int cnt = 0;
            int indx1 = 0;
            
            
            // Agregar los niveles de códigos conductuales al ComboBox
            
            
            for(TiposPersonas grados : secciones){
                if(grados.getTipoPersona() == tipoPersona){
                    indx1 = cnt;
                }
                cnt++;
                cbTipoUsuario.addItem(grados.getTipoPersona());
            }
            
            cbTipoUsuario.setSelectedIndex(indx1);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        btnImagen = new View.BotonesText.Buttons();
        btnAceptar = new View.BotonesText.Buttons();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombres1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtNombres3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        txtNombres4 = new javax.swing.JTextField();
        btnCancelar = new View.BotonesText.Buttons();
        lbImagen = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbTecnicos = new javax.swing.JComboBox<>();
        cbAcademicos = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbSeccionTecnica = new javax.swing.JComboBox<>();
        cbSeccionAcademica = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dpNacimiento = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        txtTitle1 = new javax.swing.JLabel();
        btnImagen1 = new View.BotonesText.Buttons();
        btnAceptar1 = new View.BotonesText.Buttons();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNombres2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCodigo1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNombres5 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtApellidos1 = new javax.swing.JTextField();
        txtNombres6 = new javax.swing.JTextField();
        txtClave1 = new javax.swing.JTextField();
        txtNombres7 = new javax.swing.JTextField();
        btnCancelar1 = new View.BotonesText.Buttons();
        lbImagen1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        dpNacimiento1 = new com.toedter.calendar.JDateChooser();
        cbTipoUsuario = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        TxTelefono = new javax.swing.JTextField();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTitle.setText("Your Message Title Dialog Custom");
        jPanel1.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

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
        jPanel1.add(btnImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 120, -1));

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
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 120, -1));

        jLabel1.setText("Nombres:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel2.setText("Foto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 260, 20));

        jLabel4.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 150, 20));

        jLabel5.setText("Nombres:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        txtNombres1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombres1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 260, 20));

        jLabel6.setText("Apellidos:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 260, 20));

        txtNombres3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombres3ActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombres3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 260, 20));

        jLabel7.setText("Sección Técnica:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, -1, -1));

        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        jPanel1.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 260, 20));

        txtNombres4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombres4ActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombres4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 260, 20));

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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 120, -1));
        jPanel1.add(lbImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 220, 190));

        jLabel8.setText("Contraseña:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        jLabel9.setText("Especialidad:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, -1));

        cbTecnicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbTecnicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 210, -1));

        cbAcademicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbAcademicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 210, -1));

        jLabel10.setText("Nivel Academico:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        cbSeccionTecnica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbSeccionTecnica, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 210, -1));

        cbSeccionAcademica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbSeccionAcademica, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 210, -1));

        jLabel11.setText("Sección Academica:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, -1, -1));

        jLabel12.setText("Codigo:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        dpNacimiento.setDateFormatString("YYYY-MM-DD");
        jPanel1.add(dpNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 180, -1));

        setPreferredSize(new java.awt.Dimension(810, 491));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTitle1.setText("Actualizar Credenciales");
        jPanel2.add(txtTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        btnImagen1.setText("Escoger foto");
        btnImagen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImagen1MouseClicked(evt);
            }
        });
        btnImagen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagen1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 120, -1));

        btnAceptar1.setText("Aceptar");
        btnAceptar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptar1MouseClicked(evt);
            }
        });
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 120, -1));

        jLabel3.setText("Nombres:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel13.setText("Foto:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        txtNombres2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombres2ActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombres2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 260, 20));

        jLabel14.setText("Fecha de nacimiento:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        txtCodigo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigo1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtCodigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 150, 20));

        jLabel15.setText("Nombres:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        txtNombres5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombres5ActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombres5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 260, 20));

        jLabel16.setText("Apellidos:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        txtApellidos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidos1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtApellidos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 260, 20));

        txtNombres6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombres6ActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombres6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 260, 20));

        txtClave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClave1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtClave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 260, 20));

        txtNombres7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombres7ActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombres7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 260, 20));

        btnCancelar1.setText("Cancelar");
        btnCancelar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelar1MouseClicked(evt);
            }
        });
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 120, -1));
        jPanel2.add(lbImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 220, 190));

        jLabel18.setText("Contraseña:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        jLabel22.setText("Codigo:");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        dpNacimiento1.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(dpNacimiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 180, -1));

        cbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 190, -1));

        jLabel17.setText("Telefono:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        TxTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxTelefonoActionPerformed(evt);
            }
        });
        jPanel2.add(TxTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 260, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 851, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImagenMouseClicked

    }//GEN-LAST:event_btnImagenMouseClicked

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
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lbImagen1.getWidth(), lbImagen1.getHeight(), Image.SCALE_SMOOTH));
            lbImagen1.setIcon(mIcono);
            
        }

    }//GEN-LAST:event_btnImagenActionPerformed

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
        // TODO add your handling code here:

        if (txtNombres.getText().isBlank() || txtApellidos.getText().isBlank() || txtCodigo.getText().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Los campos no puede estar vacíos");
            playError();
        }  else {
            try {
                enviarDatosHaciaApi();
            } catch (IOException ex) {
                Logger.getLogger(MessageAddEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Ocurrió un error, intente nuevamente");
            playError();
            }
            Timer timer = new Timer(500, (ActionEvent e) -> {
                Estudiantes cd = new Estudiantes();

                frm.deleteAllTableRows(frm.table1);
                frm.cargarDatos();
            });
            timer.setRepeats(false);
            timer.start();
        }

    }//GEN-LAST:event_btnAceptarMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombres1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombres1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombres1ActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtNombres3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombres3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombres3ActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    private void txtNombres4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombres4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombres4ActionPerformed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // TODO add your handling code here:
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnImagen1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImagen1MouseClicked

    }//GEN-LAST:event_btnImagen1MouseClicked

    private void btnImagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagen1ActionPerformed
        // TODO add your handling code here:
        rute = "";
        JFileChooser chooser = new JFileChooser();
       FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG","jpg","png", "jpeg");
        chooser.setFileFilter(filter);

        int res = chooser.showOpenDialog(this);

        if(res == JFileChooser.APPROVE_OPTION){
            rute = chooser.getSelectedFile().getPath();

            Image mImagen = new ImageIcon(rute).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lbImagen1.getWidth(), lbImagen1.getHeight(), Image.SCALE_SMOOTH));
            lbImagen1.setIcon(mIcono);

        }

    }//GEN-LAST:event_btnImagen1ActionPerformed

    private void btnAceptar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptar1MouseClicked
        // TODO add your handling code here:

        

    }//GEN-LAST:event_btnAceptar1MouseClicked

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed
        // TODO add your handling code here:
        if (txtNombres2.getText().isEmpty() || txtApellidos1.getText().isEmpty() || txtCodigo1.getText().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Los campos no puede estar vacío");
        }  
        else if(!Validaciones.checkName(txtNombres2.getText()) || !Validaciones.checkName(txtApellidos1.getText())){
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El nombre o apellido es invalido");
        }
        else if(!Validaciones.checkDateDown(dpNacimiento1.getDate().toInstant().atOffset(ZoneOffset.UTC))){
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "La fecha de nacimiento no es válida");
        }
        else if(!Validaciones.onlyInts(txtCodigo1.getText())){
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El codigo solo debe tener números");
        }
        else if(!txtClave1.getText().isEmpty() && txtClave1.getText().length()<6){
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "La contraseña debe ser de al menos 6 caracteres");
        }
        else {
            try {
                enviarDatosHaciaApi();
            } catch (IOException ex) {
                Logger.getLogger(MessageAddEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
            Timer timer = new Timer(500, (ActionEvent e) -> {
                Estudiantes cd = new Estudiantes();

                cd.cargarDatos();
                cd.deleteAllTableRows(cd.table1);
            });
            timer.setRepeats(false);
            timer.start();
        }
    }//GEN-LAST:event_btnAceptar1ActionPerformed

    private void txtNombres2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombres2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombres2ActionPerformed

    private void txtCodigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigo1ActionPerformed

    private void txtNombres5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombres5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombres5ActionPerformed

    private void txtApellidos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidos1ActionPerformed

    private void txtNombres6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombres6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombres6ActionPerformed

    private void txtClave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClave1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClave1ActionPerformed

    private void txtNombres7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombres7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombres7ActionPerformed

    private void btnCancelar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelar1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnCancelar1MouseClicked

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        // TODO add your handling code here:
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void TxTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxTelefonoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxTelefono;
    private View.BotonesText.Buttons btnAceptar;
    private View.BotonesText.Buttons btnAceptar1;
    private View.BotonesText.Buttons btnCancelar;
    private View.BotonesText.Buttons btnCancelar1;
    private View.BotonesText.Buttons btnImagen;
    private View.BotonesText.Buttons btnImagen1;
    private javax.swing.JComboBox<String> cbAcademicos;
    private javax.swing.JComboBox<String> cbSeccionAcademica;
    private javax.swing.JComboBox<String> cbSeccionTecnica;
    private javax.swing.JComboBox<String> cbTecnicos;
    private javax.swing.JComboBox<String> cbTipoUsuario;
    private com.toedter.calendar.JDateChooser dpNacimiento;
    private com.toedter.calendar.JDateChooser dpNacimiento1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JLabel lbImagen1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidos1;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtClave1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigo1;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNombres1;
    private javax.swing.JTextField txtNombres2;
    private javax.swing.JTextField txtNombres3;
    private javax.swing.JTextField txtNombres4;
    private javax.swing.JTextField txtNombres5;
    private javax.swing.JTextField txtNombres6;
    private javax.swing.JTextField txtNombres7;
    public javax.swing.JLabel txtTitle;
    public javax.swing.JLabel txtTitle1;
    // End of variables declaration//GEN-END:variables
}
