/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form.other;

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
import javax.swing.JComboBox;
import javax.swing.Timer;
import org.json.JSONObject;
import raven.toast.Notifications;
import Services.Validaciones;
import expoescritorio.Controller.Funciones;
import expoescritorio.Models.GradosView;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author educs
 */
public class MessageEditComunicados extends javax.swing.JPanel {
    private boolean procesoEnCurso = false;
    List<GradosView> grados = new ArrayList<GradosView>();
    public int id ; 
    String rute = "";

    private  Boolean noti;
    
    public MessageEditComunicados() {

        initComponents();
        setOpaque(false);

        txtTitle.setBackground(new Color(0, 0, 0, 0));
        txtTitle.setOpaque(false);
        txtTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h4.font");
        // Obtener los datos de la API y cargarlos en el ComboBox
        
        grados = Funciones.GetGrados().join();

        
        int ind = 0;
        int cnt = 0;
        

        txtTitulo.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                for (char c : str.toCharArray()) {
                    if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c) && c != '.') {
                     
                        noti = true;
                        return; // Ignora el carácter si no es letra, número, espacio o punto
                    }
                else{
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
        jLabel4 = new javax.swing.JLabel();
        btnImagen1 = new View.BotonesText.Buttons();
        jLabel13 = new javax.swing.JLabel();
        lbArchivo = new javax.swing.JLabel();
        txtTitulo = new View.BotonesText.CustomTextField();

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
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 120, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, 120, -1));

        jLabel4.setText("Título:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        btnImagen1.setText("Escoger archivo");
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
        add(btnImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 120, -1));

        jLabel13.setText("Archivo:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        lbArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lbArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 220, 190));
        add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 280, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        GlassPanePopup.closePopupLast();
        playCerrar();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:

        Validaciones valida = new Validaciones();
        if (txtTitulo.getText().isBlank()){
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "El comunicado debe tener un título"); 
            playError();
        }
        else if(!Validaciones.check30(txtTitulo.getText())){
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El Titulo es muy grande");
            playValidacion();
        }else {
            btnAceptar.setEnabled(false);
            enviarDatosHaciaApi();
            Timer timer = new Timer(500, (ActionEvent e) -> {
           if (!procesoEnCurso) {
                Comunicados cd = new Comunicados();
                cd.cargarDatos();
                cd.deleteAllTableRows(cd.table1);
                    boolean pC = panelClosing() == true;
                    btnAceptar.setEnabled(true);
           }      
            });
            timer.setRepeats(false);
            timer.start();
            
        }
        

    }//GEN-LAST:event_btnAceptarMouseClicked

    private void btnImagen1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImagen1MouseClicked
        rute = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PFD","pdf");
        chooser.setFileFilter(filter);
        
        int res = chooser.showOpenDialog(this);
        
        if(res == JFileChooser.APPROVE_OPTION){
            rute = chooser.getSelectedFile().getPath();
            
            lbArchivo.setText(rute);
            
        }
    }//GEN-LAST:event_btnImagen1MouseClicked

    private void btnImagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagen1ActionPerformed
        // TODO add your handling code here:
        /*rute = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG","jpg","png");
        chooser.setFileFilter(filter);

        int res = chooser.showOpenDialog(this);

        if(res == JFileChooser.APPROVE_OPTION){
            rute = chooser.getSelectedFile().getPath();

            Image mImagen = new ImageIcon(rute).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lbImagen.getWidth(), lbImagen.getHeight(), Image.SCALE_SMOOTH));
            lbImagen.setIcon(mIcono);

        }*/
    }//GEN-LAST:event_btnImagen1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

     
    
    private void playValidacion() {
        String filepath = "src/View/sounds/validacion.wav";

        PlayMusic(filepath);

    }

    private void playError() {
        String filepath = "src/View/sounds/error.wav";

        PlayMusic(filepath);

    }
    
    private void playCerrar() {
        String filepath = "src/View/sounds/cerrar.wav";

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

    
    public void eventOK(ActionListener event) {
        btnAceptar.addActionListener(event);
    }

    private void enviarDatosHaciaApi() {
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
            else{
                System.out.println("SI no hay nada ");
            }
            
            Date currentDate = new Date();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = dateFormat.format(currentDate);
            
            System.out.println(formattedDateTime);
            
            jsonData.put("idComunicado",id);
            jsonData.put("idGrado", 1);
            jsonData.put("detalle", txtTitulo.getText());
            jsonData.put("fecha", formattedDateTime);
            if(rute == "") jsonData.put("archivo", JSONObject.NULL);
            else jsonData.put("archivo", base64Image);
            
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/Comunicados/update"; // Reemplaza esto con la URL de tu API
            String jsonString = jsonData.toString();
            
            CompletableFuture<Boolean> postFuture = ControllerFull.putApiAsync(endpointUrl, jsonString);

            // Manejar la respuesta de la API
            postFuture.thenAccept(success -> {
                if (success) {
                    // La solicitud POST fue exitosa
                    System.out.println("Datos enviados correctamente a la API");

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
        CodigosDisciplinarios cd = new CodigosDisciplinarios();

        cd.cargarDatos();
        cd.deleteAllTableRows(cd.table1);
        return false;
    }
// Método para obtener el ID seleccionado de un JComboBox

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.Buttons btnAceptar;
    private View.BotonesText.Buttons btnCancelar;
    private View.BotonesText.Buttons btnImagen1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbArchivo;
    public javax.swing.JLabel txtTitle;
    public View.BotonesText.CustomTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
