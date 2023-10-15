/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.samplemessage;

import Reportes.ConexionSQL;
import Services.Validaciones;
import View.glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import raven.toast.Notifications;

/**
 *
 * @author thatsgonzalez
 */
public class MessageReportVisitas extends javax.swing.JPanel {

    /**
     * Creates new form MessageAddObservaciones
     */
    public MessageReportVisitas() {
        initComponents();
        txtTitle.setBackground(new Color(0, 0, 0, 0));
        txtTitle.setOpaque(false);
        txtTitle.setText("Imprimir Reporte");
        txtTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h4.font");
    }

   public void mostrarReporte() {
           String Fecha; 
       java.util.Date date = new java.util.Date(); 
        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd"); 
        Fecha = ff.format(dpNacimiento.getDate());
        System.out.println(Fecha);
        try {
            Map<String,Object>parametros = new HashMap<>();
            parametros.put("VSenfer", Fecha);
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/VisitasEnfermeria.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, parametros, ConexionSQL.getConexion());

            JasperViewer view = new JasperViewer(jprint, false);
            view.setTitle("Nombre Reporte");
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            ex.getMessage();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpNacimiento = new com.toedter.calendar.JDateChooser();
        txtTitle = new javax.swing.JLabel();
        btnCancelar = new View.BotonesText.Buttons();
        btnAceptar3 = new View.BotonesText.Buttons();

        dpNacimiento.setToolTipText("");
        dpNacimiento.setDateFormatString("yyyy-MM-dd");
        dpNacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dpNacimientoPropertyChange(evt);
            }
        });

        txtTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTitle.setText("Your Message Title Dialog Custom");

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        btnAceptar3.setText("Imprimir Reporte");
        btnAceptar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptar3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dpNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitle))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(txtTitle)
                .addGap(18, 18, 18)
                .addComponent(dpNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dpNacimientoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dpNacimientoPropertyChange

    }//GEN-LAST:event_dpNacimientoPropertyChange

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnCancelarMouseClicked
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
    private void btnAceptar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptar3MouseClicked
        if (dpNacimiento.getDate() == null) {
           Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Por favor, asegúrate de completar tu fecha en un formato válido");
          playError();
        }
         else if(!Validaciones.checkDateCurrentYear(dpNacimiento.getDate().toInstant().atOffset(ZoneOffset.UTC))){
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "La fecha no es válida");
            playError();
        }
          else if(!Validaciones.checkDateNotGreaterThanToday(dpNacimiento.getDate().toInstant().atOffset(ZoneOffset.UTC))){
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "La fecha no es válida");
            playError();
        }
         else{
        mostrarReporte();
         }
    }//GEN-LAST:event_btnAceptar3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.Buttons btnAceptar3;
    private View.BotonesText.Buttons btnCancelar;
    private com.toedter.calendar.JDateChooser dpNacimiento;
    public javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
