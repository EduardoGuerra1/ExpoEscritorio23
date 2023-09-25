/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form.other;

import View.samplemessage.*;
import View.Application.form.other.CodigosDisciplinarios;
import View.glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.FlatClientProperties;
import com.kitfox.svg.A;
import expoescritorio.Controller.CodigosConductualesController;
import expoescritorio.Controller.ControllerFull;
import expoescritorio.Controller.NivelesCodigosConductualesController;
import expoescritorio.Controller.TiposCodigosConductualesController;
import expoescritorio.Models.CodigosConductuales;
import expoescritorio.Models.NivelesCodigosConductuales;
import expoescritorio.Models.TiposCodigosConductuales;
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
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.Timer;
import org.json.JSONException;
import org.json.JSONObject;
import raven.toast.Notifications;
import Services.Validaciones;
import View.Application.form.other.Comunicados;
import expoescritorio.Controller.EspecialidadesController;
import expoescritorio.Controller.Funciones;
import expoescritorio.Controller.GruposTecnicosController;
import expoescritorio.Controller.NivelesAcademicosController;
import expoescritorio.Controller.PersonasController;
import expoescritorio.Controller.SeccionesBachilleratoController;
import expoescritorio.Models.Especialidades;
import expoescritorio.Models.GradosView;
import expoescritorio.Models.GruposTecnicos;
import expoescritorio.Models.NivelesAcademicos;
import expoescritorio.Models.Personas;
import expoescritorio.Models.SeccionesBachillerato;
import java.awt.Image;
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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author educs
 */
public class DetEnferemeria extends javax.swing.JPanel {




    VisitasEnfermeria frm = null;

    public DetEnferemeria(VisitasEnfermeria VisitasEnfermeria) {

        initComponents();
        setOpaque(false);

                lb1.setVisible(false);
        lbIdent.setVisible(false);
        
        
        lbInfo.putClientProperty(FlatClientProperties.STYLE, ""
               + "font:$h1.font;");
        
        
       lb1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font");
         lb2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font");
          jLabel4.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font");
           jLabel5.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font");
           
           
           
           
           
            lbIdent.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
            lbMotivo.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
            lbDocente.putClientProperty(FlatClientProperties.STYLE, ""
               + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
            
            lbFecha.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
            lbMotivo.disable();

            
            pEstudiante.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten(@background,3%);");
            pMotivo.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten(@background,3%);");
            pFecha.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten(@background,3%);");
        this.frm = VisitasEnfermeria;


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

        jPanel2 = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lbDocente = new javax.swing.JLabel();
        btnCancelar = new View.BotonesText.Buttons();
        lbIdent = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbMotivo = new javax.swing.JTextArea();
        pMotivo = new javax.swing.JPanel();
        lb2 = new javax.swing.JLabel();
        pEstudiante = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pFecha = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbInfo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb1.setText("ID:");
        lb1.setToolTipText("");

        lbFecha.setText("jLabel2");

        lbDocente.setText("jLabel2");

        btnCancelar.setText("Cerrar");
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

        lbIdent.setText("jLabel2");

        lbMotivo.setColumns(20);
        lbMotivo.setRows(5);
        jScrollPane1.setViewportView(lbMotivo);

        lb2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb2.setText("Motivo:");

        javax.swing.GroupLayout pMotivoLayout = new javax.swing.GroupLayout(pMotivo);
        pMotivo.setLayout(pMotivoLayout);
        pMotivoLayout.setHorizontalGroup(
            pMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMotivoLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pMotivoLayout.setVerticalGroup(
            pMotivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMotivoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Estudiante:");

        javax.swing.GroupLayout pEstudianteLayout = new javax.swing.GroupLayout(pEstudiante);
        pEstudiante.setLayout(pEstudianteLayout);
        pEstudianteLayout.setHorizontalGroup(
            pEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstudianteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pEstudianteLayout.setVerticalGroup(
            pEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEstudianteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fecha:");

        javax.swing.GroupLayout pFechaLayout = new javax.swing.GroupLayout(pFecha);
        pFecha.setLayout(pFechaLayout);
        pFechaLayout.setHorizontalGroup(
            pFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFechaLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pFechaLayout.setVerticalGroup(
            pFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFechaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbInfo.setText("Información");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(pMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbDocente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(lbFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbInfo)
                            .addComponent(lbIdent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(186, 186, 186)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbInfo)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdent, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDocente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pEstudiante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 350));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnCancelarMouseClicked
 

   

    

   
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
    private View.BotonesText.Buttons btnCancelar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    public javax.swing.JLabel lbDocente;
    public javax.swing.JLabel lbFecha;
    public javax.swing.JLabel lbIdent;
    private javax.swing.JLabel lbInfo;
    public javax.swing.JTextArea lbMotivo;
    private javax.swing.JPanel pEstudiante;
    private javax.swing.JPanel pFecha;
    private javax.swing.JPanel pMotivo;
    // End of variables declaration//GEN-END:variables
}
