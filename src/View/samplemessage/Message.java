/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.samplemessage;

import View.glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author educs
 */
public class Message extends javax.swing.JPanel {

    /**
     * Creates new form Message
     */
    public Message() {
        initComponents();
        setOpaque(false);
        txtContent.setBackground(new Color(0, 0, 0, 0));
        txtContent.setOpaque(false);
        
        txtTitle.setBackground(new Color(0, 0, 0, 0));
        txtTitle.setOpaque(false);
        txtTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h4.font");
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
        txtContent = new javax.swing.JTextPane();
        btnCancelar = new View.BotonesText.Buttons();
        btnAceptar = new View.BotonesText.Buttons();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTitle.setText("Your Message Title Dialog Custom");
        add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 44, -1, -1));

        txtContent.setForeground(new java.awt.Color(133, 133, 133));
        txtContent.setText("This is part of a series of short tutorials about specific elements, components, or interactions. We’ll cover the UX, the UI, and the construction inside of Sketch. Plus, there’s a freebie for you at the end!");
        txtContent.setEnabled(false);
        txtContent.setFocusable(false);
        add(txtContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 470, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 120, -1));

        btnAceptar.setText("Aceptar");
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 120, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnCancelarMouseClicked

    public void eventOK(ActionListener event) {
        btnAceptar.addActionListener(event);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.Buttons btnAceptar;
    private View.BotonesText.Buttons btnCancelar;
    public javax.swing.JTextPane txtContent;
    public javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
