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
public class DetObservaciones extends javax.swing.JPanel {




    Observaciones frm = null;

    public DetObservaciones(Observaciones Observaciones) {

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
           jLabel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font");
            jLabel5.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font");
            lbIdent.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font");
            
            
           lbEstudinte.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
            lbDocente.putClientProperty(FlatClientProperties.STYLE, ""
               + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
            Detalle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
            Detalle.disable();
            lbFecha.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");

            
            pEstudiantes.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten(@background,3%);");
            pDocente.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten(@background,3%);");
            pDetalle.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten(@background,3%);");
            pFecha.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten(@background,3%);");
            
        this.frm = Observaciones;


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
        lbEstudinte = new javax.swing.JLabel();
        btnCancelar = new View.BotonesText.Buttons();
        lbIdent = new javax.swing.JLabel();
        pEstudiantes = new javax.swing.JPanel();
        lb2 = new javax.swing.JLabel();
        pDocente = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pDetalle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pFecha = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbInfo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Detalle = new javax.swing.JTextArea();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb1.setText("ID:");
        lb1.setToolTipText("");

        lbFecha.setText("jLabel2");

        lbDocente.setText("jLabel2");

        lbEstudinte.setText("jLabel2");

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

        lb2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb2.setText("Estudiante:");

        javax.swing.GroupLayout pEstudiantesLayout = new javax.swing.GroupLayout(pEstudiantes);
        pEstudiantes.setLayout(pEstudiantesLayout);
        pEstudiantesLayout.setHorizontalGroup(
            pEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEstudiantesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pEstudiantesLayout.setVerticalGroup(
            pEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstudiantesLayout.createSequentialGroup()
                .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Docente:");

        javax.swing.GroupLayout pDocenteLayout = new javax.swing.GroupLayout(pDocente);
        pDocente.setLayout(pDocenteLayout);
        pDocenteLayout.setHorizontalGroup(
            pDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDocenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pDocenteLayout.setVerticalGroup(
            pDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDocenteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Detalle:");

        javax.swing.GroupLayout pDetalleLayout = new javax.swing.GroupLayout(pDetalle);
        pDetalle.setLayout(pDetalleLayout);
        pDetalleLayout.setHorizontalGroup(
            pDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDetalleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pDetalleLayout.setVerticalGroup(
            pDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDetalleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fecha:");

        javax.swing.GroupLayout pFechaLayout = new javax.swing.GroupLayout(pFecha);
        pFecha.setLayout(pFechaLayout);
        pFechaLayout.setHorizontalGroup(
            pFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFechaLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pFechaLayout.setVerticalGroup(
            pFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFechaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbInfo.setText("Información");

        Detalle.setColumns(20);
        Detalle.setRows(5);
        jScrollPane1.setViewportView(Detalle);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pEstudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pDocente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbInfo)
                            .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEstudinte, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIdent, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lbInfo)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIdent, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEstudinte, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 370));
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
    public javax.swing.JTextArea Detalle;
    private View.BotonesText.Buttons btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    public javax.swing.JLabel lbDocente;
    public javax.swing.JLabel lbEstudinte;
    public javax.swing.JLabel lbFecha;
    public javax.swing.JLabel lbIdent;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JPanel pDetalle;
    private javax.swing.JPanel pDocente;
    private javax.swing.JPanel pEstudiantes;
    private javax.swing.JPanel pFecha;
    // End of variables declaration//GEN-END:variables
}
