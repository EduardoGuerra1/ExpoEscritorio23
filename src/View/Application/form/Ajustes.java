/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form;

import View.aplicacion.Application;
import View.menu.mode.ToolBarAccentColor;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.util.LoggingFacade;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.Collections;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author gyaci
 */
public class Ajustes extends javax.swing.JPanel {

    /**
     * Creates new form Avisos
     */
    public Ajustes() {
        initComponents();

        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        lbColor1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h2.font");
        lbColor2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h2.font");
        lbColor3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font");
        lbColor4.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font");

        String bg = getBackground().toString();

        if (bg.contains("r=24")) {
            System.out.println("Modo oscuro");
            btnDark.putClientProperty(FlatClientProperties.STYLE, ""
                    + "background:rgb(65, 75, 85);"
                    + "foreground:$Menu.foreground;");

            btnLight.putClientProperty(FlatClientProperties.STYLE, ""
                    + "background:$Menu.lightdark.button.background;"
                    + "foreground:$Menu.foreground;"
                    + "background:null");
        } else {
            System.out.println("Modo claro");
            EventQueue.invokeLater(() -> {
                // FlatAnimatedLafChange.showSnapshot();
                FlatIntelliJLaf.setup();
                FlatLaf.updateUI();
                //FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });

            btnLight.putClientProperty(FlatClientProperties.STYLE, ""
                    + "background:$Menu.lightdark.button.background;"
                    + "foreground:$Menu.foreground;");

            btnDark.putClientProperty(FlatClientProperties.STYLE, ""
                    + "background:$Menu.lightdark.button.background;"
                    + "foreground:$Menu.foreground;"
                    + "background:null");
        }

        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbColor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buttons1 = new View.BotonesText.Buttons();
        buttons2 = new View.BotonesText.Buttons();
        buttons3 = new View.BotonesText.Buttons();
        buttons4 = new View.BotonesText.Buttons();
        buttons5 = new View.BotonesText.Buttons();
        buttons6 = new View.BotonesText.Buttons();
        buttons7 = new View.BotonesText.Buttons();
        jPanel2 = new javax.swing.JPanel();
        btnDark = new View.BotonesText.Buttons();
        btnLight = new View.BotonesText.Buttons();
        lbColor1 = new javax.swing.JLabel();
        lbColor3 = new javax.swing.JLabel();
        lbColor2 = new javax.swing.JLabel();
        lbColor4 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();

        lbColor.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        lbColor.setForeground(new java.awt.Color(230, 230, 230));
        lbColor.setText("Theme Color");

        jLabel4.setForeground(new java.awt.Color(128, 128, 128));
        jLabel4.setText("Select color to set theme system");

        buttons1.setBackground(new java.awt.Color(176, 224, 230));
        buttons1.setMaximumSize(new java.awt.Dimension(25, 25));
        buttons1.setMinimumSize(new java.awt.Dimension(25, 25));
        buttons1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttons1MouseClicked(evt);
            }
        });

        buttons2.setBackground(new java.awt.Color(255, 218, 185));
        buttons2.setMaximumSize(new java.awt.Dimension(25, 25));
        buttons2.setMinimumSize(new java.awt.Dimension(25, 25));
        buttons2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttons2MouseClicked(evt);
            }
        });

        buttons3.setBackground(new java.awt.Color(192, 217, 217));
        buttons3.setMaximumSize(new java.awt.Dimension(25, 25));
        buttons3.setMinimumSize(new java.awt.Dimension(25, 25));
        buttons3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttons3MouseClicked(evt);
            }
        });

        buttons4.setBackground(new java.awt.Color(255, 160, 122));
        buttons4.setMaximumSize(new java.awt.Dimension(25, 25));
        buttons4.setMinimumSize(new java.awt.Dimension(25, 25));
        buttons4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttons4MouseClicked(evt);
            }
        });

        buttons5.setBackground(new java.awt.Color(50, 205, 50));
        buttons5.setMaximumSize(new java.awt.Dimension(25, 25));
        buttons5.setMinimumSize(new java.awt.Dimension(25, 25));
        buttons5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttons5MouseClicked(evt);
            }
        });
        buttons5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttons5ActionPerformed(evt);
            }
        });

        buttons6.setBackground(new java.awt.Color(255, 105, 180));
        buttons6.setMaximumSize(new java.awt.Dimension(25, 25));
        buttons6.setMinimumSize(new java.awt.Dimension(25, 25));
        buttons6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttons6MouseClicked(evt);
            }
        });

        buttons7.setBackground(new java.awt.Color(255, 165, 0));
        buttons7.setMaximumSize(new java.awt.Dimension(25, 25));
        buttons7.setMinimumSize(new java.awt.Dimension(25, 25));
        buttons7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttons7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttons1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttons2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttons3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttons4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttons5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttons6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttons7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttons7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/menu/mode/dark.png"))); // NOI18N
        btnDark.setToolTipText("Modo Oscuro");
        btnDark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDarkMouseClicked(evt);
            }
        });

        btnLight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/menu/mode/light.png"))); // NOI18N
        btnLight.setToolTipText("Modo Claro");
        btnLight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLightMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDark, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lbColor1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbColor1.setText("Modo Oscuro/Claro");

        lbColor3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbColor3.setText("Seleccione el modo en que desea utilizar el sistema.");

        lbColor2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbColor2.setText("Selector de Tema");

        lbColor4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbColor4.setText("Seleccione el color de selector que desea utilizar.");

        lb.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lb.setText("Ajustes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbColor1)
                            .addComponent(lbColor3)
                            .addComponent(lbColor2)
                            .addComponent(lbColor4))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb)
                        .addGap(71, 71, 71)
                        .addComponent(lbColor1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbColor3)
                        .addGap(38, 38, 38)
                        .addComponent(lbColor2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbColor4)))
                .addContainerGap(368, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private final String[] accentColorKeys = {
        "App.accent.default", "App.accent.blue", "App.accent.purple", "App.accent.red",
        "App.accent.orange", "App.accent.yellow", "App.accent.green",};

    // Método para convertir un color en su representación hexadecimal
    private String toHexCode(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    private void colorAccentChanged(String colorKey) {

        Color color = UIManager.getColor(colorKey);

        Class<? extends LookAndFeel> lafClass = UIManager.getLookAndFeel().getClass();
        try {
            FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentColor", toHexCode(color)));
            FlatLaf.setup(lafClass.newInstance());
            FlatLaf.updateUI();
        } catch (InstantiationException | IllegalAccessException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }

    private void buttons1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttons1MouseClicked
        String key = accentColorKeys[0];
        colorAccentChanged(key);

        buttons1.setText("✓");
        buttons2.setText("");
        buttons3.setText("");
        buttons4.setText("");
        buttons5.setText("");
        buttons6.setText("");
        buttons7.setText("");

    }//GEN-LAST:event_buttons1MouseClicked

    private void buttons2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttons2MouseClicked
        // TODO add your handling code here:
        String key = accentColorKeys[1];
        colorAccentChanged(key);

        buttons1.setText("");
        buttons2.setText("✓");
        buttons3.setText("");
        buttons4.setText("");
        buttons5.setText("");
        buttons6.setText("");
        buttons7.setText("");
    }//GEN-LAST:event_buttons2MouseClicked

    private void buttons3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttons3MouseClicked
        // TODO add your handling code here:

        String key = accentColorKeys[2];
        colorAccentChanged(key);

        buttons1.setText("");
        buttons2.setText("");
        buttons3.setText("✓");
        buttons4.setText("");
        buttons5.setText("");
        buttons6.setText("");
        buttons7.setText("");
    }//GEN-LAST:event_buttons3MouseClicked

    private void buttons4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttons4MouseClicked
        // TODO add your handling code here:
        String key = accentColorKeys[3];
        colorAccentChanged(key);

        buttons1.setText("");
        buttons2.setText("");
        buttons3.setText("");
        buttons4.setText("✓");
        buttons5.setText("");
        buttons6.setText("");
        buttons7.setText("");
    }//GEN-LAST:event_buttons4MouseClicked

    private void buttons5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttons5MouseClicked
        // TODO add your handling code here:
        String key = accentColorKeys[4];
        colorAccentChanged(key);

        buttons1.setText("");
        buttons2.setText("");
        buttons3.setText("");
        buttons4.setText("");
        buttons5.setText("✓");
        buttons6.setText("");
        buttons7.setText("");
    }//GEN-LAST:event_buttons5MouseClicked

    private void buttons6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttons6MouseClicked
        // TODO add your handling code here:
        String key = accentColorKeys[5];
        colorAccentChanged(key);

        buttons1.setText("");
        buttons2.setText("");
        buttons3.setText("");
        buttons4.setText("");
        buttons5.setText("");
        buttons6.setText("✓");
        buttons7.setText("");
    }//GEN-LAST:event_buttons6MouseClicked

    private void buttons7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttons7MouseClicked
        // TODO add your handling code here:
        String key = accentColorKeys[6];
        colorAccentChanged(key);

        buttons1.setText("");
        buttons2.setText("");
        buttons3.setText("");
        buttons4.setText("");
        buttons5.setText("");
        buttons6.setText("");
        buttons7.setText("✓");
    }//GEN-LAST:event_buttons7MouseClicked

    private void btnDarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDarkMouseClicked
        changeMode(true);

        btnDark.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:rgb(65, 75, 85);"
                + "foreground:$Menu.foreground;");

        btnLight.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Menu.lightdark.button.background;"
                + "foreground:$Menu.foreground;"
                + "background:null");
    }//GEN-LAST:event_btnDarkMouseClicked

    private void btnLightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLightMouseClicked
        // TODO add your handling code here:
        changeMode(false);

        btnLight.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Menu.lightdark.button.background;"
                + "foreground:$Menu.foreground;");

        btnDark.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Menu.lightdark.button.background;"
                + "foreground:$Menu.foreground;"
                + "background:null");
    }//GEN-LAST:event_btnLightMouseClicked

    private void buttons5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttons5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttons5ActionPerformed

    private void changeMode(boolean dark) {
        if (FlatLaf.isLafDark() != dark) {
            if (dark) {
                EventQueue.invokeLater(() -> {
                    // Cambiar al modo oscuro con una animación
                    FlatAnimatedLafChange.showSnapshot();
                    FlatDarculaLaf.setup();
                    FlatLaf.updateUI();

                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                });
            } else {
                EventQueue.invokeLater(() -> {
                    // Cambiar al modo claro con una animación
                    FlatAnimatedLafChange.showSnapshot();
                    FlatIntelliJLaf.setup();
                    FlatLaf.updateUI();

                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                });
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.Buttons btnDark;
    private View.BotonesText.Buttons btnLight;
    private View.BotonesText.Buttons buttons1;
    private View.BotonesText.Buttons buttons2;
    private View.BotonesText.Buttons buttons3;
    private View.BotonesText.Buttons buttons4;
    private View.BotonesText.Buttons buttons5;
    private View.BotonesText.Buttons buttons6;
    private View.BotonesText.Buttons buttons7;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbColor;
    private javax.swing.JLabel lbColor1;
    private javax.swing.JLabel lbColor2;
    private javax.swing.JLabel lbColor3;
    private javax.swing.JLabel lbColor4;
    // End of variables declaration//GEN-END:variables
}
