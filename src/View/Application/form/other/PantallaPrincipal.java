/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form.other;

import View.BotonesText.Buttons;
import View.ExampleTable.BordeRedondeado;
import com.formdev.flatlaf.FlatClientProperties;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;
import View.evento.CambioColor;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;

/**
 *
 * @author educs
 */
public class PantallaPrincipal extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {

        Thread t = new Thread(this);
        t.start();
        initComponents();

        String bg = getBackground().toString();
        System.out.println("El color de fondo de Pantalla Inicio es: " + bg);

        time.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        date.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        lbBienvenido.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font;");
        lbTitulo.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font;");
        lbTitulo2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font;");
        lbContenido.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbContenido1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbContenido2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbContenido3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbContenido4.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");

        lbContenido.setText("El Sistema de Administración ");
        //+ "(SAE), es una herramienta que facilita la gestión disciplinaria y administrativa de los estudiantes del Instituto Técnico Ricaldone.");
        lbContenido1.setText("Estudiantil (SAE), es una herramienta");
        lbContenido2.setText("que facilita la gestión disciplinaria");
        lbContenido3.setText("y administrativa para los estudiantes");
        lbContenido4.setText("del Instituto Técnico Ricaldone.");
        // panel1.setBackground(Color.getHSBColor(209, 34, 29));

        //cambiarColorRGB(44, 55, 66);
        //Asignacion de diseño a la parte inferior de la pantalla (Valores)
        //Integridad
        lbIntegridad.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font;");
        lbIntegridad1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbIntegridad2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbIntegridad3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");

        pIntegridad.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten($Menu.background,7%);");

        //Solidaridad
        lbSolidaridad.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font;");
        lbSolidaridad1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbSolidaridad2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbSolidaridad3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbSolidaridad4.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");

        pSolidaridad.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten($Menu.background,7%);");

        //FE
        lbFe.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font;");
        lbFe1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbFe2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbFe3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbFe4.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");

        pFe.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten($Menu.background,7%);");

        panel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten(@background,3%);");
        /* panel2.putClientProperty(FlatClientProperties.STYLE, ""
               + "arc:50;"
               + "background:lighten($Menu.background,7%);");
       
        panel3.putClientProperty(FlatClientProperties.STYLE, ""
               + "arc:50;"
               + "background:lighten(@background,8%);");*/
        panel4.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten(@background,3%);");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        lbContenido = new javax.swing.JLabel();
        lbContenido1 = new javax.swing.JLabel();
        lbContenido2 = new javax.swing.JLabel();
        lbContenido3 = new javax.swing.JLabel();
        lbContenido4 = new javax.swing.JLabel();
        lbTitulo2 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        lbBienvenido = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pIntegridad = new javax.swing.JPanel();
        lbIntegridad = new javax.swing.JLabel();
        lbIntegridad1 = new javax.swing.JLabel();
        lbIntegridad2 = new javax.swing.JLabel();
        lbIntegridad3 = new javax.swing.JLabel();
        pFe = new javax.swing.JPanel();
        lbFe4 = new javax.swing.JLabel();
        lbFe3 = new javax.swing.JLabel();
        lbFe2 = new javax.swing.JLabel();
        lbFe1 = new javax.swing.JLabel();
        lbFe = new javax.swing.JLabel();
        pSolidaridad = new javax.swing.JPanel();
        lbSolidaridad2 = new javax.swing.JLabel();
        lbSolidaridad3 = new javax.swing.JLabel();
        lbSolidaridad1 = new javax.swing.JLabel();
        lbSolidaridad = new javax.swing.JLabel();
        lbSolidaridad4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        time = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        lbTitulo.setText("¿Qué es SAE?");

        panel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel4MouseExited(evt);
            }
        });

        lbContenido.setText("lbContenido");

        lbContenido1.setForeground(new java.awt.Color(153, 153, 153));
        lbContenido1.setText("lbContenido1");

        lbContenido2.setForeground(new java.awt.Color(153, 153, 153));
        lbContenido2.setText("lbContenido2");

        lbContenido3.setForeground(new java.awt.Color(153, 153, 153));
        lbContenido3.setText("lbContenido3");

        lbContenido4.setForeground(new java.awt.Color(153, 153, 153));
        lbContenido4.setText("lbContenido4");

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbContenido1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(lbContenido2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbContenido3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbContenido4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbContenido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbContenido1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbContenido2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbContenido3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbContenido4)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbTitulo2.setText("Valores del Instituto Técnico Ricaldone:");

        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel1MouseExited(evt);
            }
        });

        lbBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBienvenido.setText("Bienvenido a SAE");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(lbBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pIntegridad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pIntegridadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pIntegridadMouseExited(evt);
            }
        });

        lbIntegridad.setText("Integridad");

        lbIntegridad1.setForeground(new java.awt.Color(153, 153, 153));
        lbIntegridad1.setText("\"Actuar con transparencia y");

        lbIntegridad2.setForeground(new java.awt.Color(153, 153, 153));
        lbIntegridad2.setText("honestidad en todas las ");

        lbIntegridad3.setForeground(new java.awt.Color(153, 153, 153));
        lbIntegridad3.setText("dimensiones de nuestra vida\"");

        javax.swing.GroupLayout pIntegridadLayout = new javax.swing.GroupLayout(pIntegridad);
        pIntegridad.setLayout(pIntegridadLayout);
        pIntegridadLayout.setHorizontalGroup(
            pIntegridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pIntegridadLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pIntegridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIntegridad3)
                    .addComponent(lbIntegridad2)
                    .addComponent(lbIntegridad1)
                    .addComponent(lbIntegridad))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        pIntegridadLayout.setVerticalGroup(
            pIntegridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pIntegridadLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbIntegridad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbIntegridad1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbIntegridad2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbIntegridad3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pFe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pFeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pFeMouseExited(evt);
            }
        });

        lbFe4.setForeground(new java.awt.Color(153, 153, 153));
        lbFe4.setText("que motiva nuestro existir\"");

        lbFe3.setForeground(new java.awt.Color(153, 153, 153));
        lbFe3.setText("experimentarla como vida y amor,");

        lbFe2.setForeground(new java.awt.Color(153, 153, 153));
        lbFe2.setText("de Dios en nuestro quehacer y");

        lbFe1.setForeground(new java.awt.Color(153, 153, 153));
        lbFe1.setText("\"Reconocer la presencia operante");

        lbFe.setText("Fe");

        javax.swing.GroupLayout pFeLayout = new javax.swing.GroupLayout(pFe);
        pFe.setLayout(pFeLayout);
        pFeLayout.setHorizontalGroup(
            pFeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFeLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pFeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFe3)
                    .addComponent(lbFe2)
                    .addComponent(lbFe1)
                    .addComponent(lbFe4)
                    .addComponent(lbFe))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pFeLayout.setVerticalGroup(
            pFeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFeLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbFe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbFe1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFe2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFe3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFe4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pSolidaridad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pSolidaridadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pSolidaridadMouseExited(evt);
            }
        });

        lbSolidaridad2.setForeground(new java.awt.Color(153, 153, 153));
        lbSolidaridad2.setText("de estar a la búsqueda de");

        lbSolidaridad3.setForeground(new java.awt.Color(153, 153, 153));
        lbSolidaridad3.setText("soluciones ante las necesidades");

        lbSolidaridad1.setForeground(new java.awt.Color(153, 153, 153));
        lbSolidaridad1.setText("\"Manifestar la disposición");

        lbSolidaridad.setText("Solidaridad");

        lbSolidaridad4.setForeground(new java.awt.Color(153, 153, 153));
        lbSolidaridad4.setText("y problemas de los demás\"");

        javax.swing.GroupLayout pSolidaridadLayout = new javax.swing.GroupLayout(pSolidaridad);
        pSolidaridad.setLayout(pSolidaridadLayout);
        pSolidaridadLayout.setHorizontalGroup(
            pSolidaridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSolidaridadLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pSolidaridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSolidaridad3)
                    .addComponent(lbSolidaridad2)
                    .addComponent(lbSolidaridad1)
                    .addComponent(lbSolidaridad4)
                    .addComponent(lbSolidaridad))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pSolidaridadLayout.setVerticalGroup(
            pSolidaridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSolidaridadLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbSolidaridad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSolidaridad1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSolidaridad2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSolidaridad3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSolidaridad4)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jLabel3.setText("HOLA");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(426, 426, 426)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pIntegridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pSolidaridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pFe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pFe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pSolidaridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pIntegridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        date.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        time.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/clock.png"))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/calendar1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2))
                            .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbTitulo2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(42, 42, 42))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)))
                .addComponent(lbTitulo2)
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        new BordeRedondeado(10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseEntered
        // TODO add your handling code here:
        panel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:darken(@background,10%);");
    }//GEN-LAST:event_panel1MouseEntered

    private void panel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseExited
        // TODO add your handling code here:
        panel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten(@background,3%);");
    }//GEN-LAST:event_panel1MouseExited

    private void panel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel4MouseEntered
        // TODO add your handling code here:

        int height = panel4.getHeight();
        int width = panel4.getWidth();
        panel4.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:darken(@background,10%);");

        lbContenido.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");
        lbContenido1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");
        lbContenido2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");
        lbContenido3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");
        lbContenido4.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");

    }//GEN-LAST:event_panel4MouseEntered

    private void panel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel4MouseExited
        // TODO add your handling code here:

        panel4.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten(@background,3%);");

        lbContenido.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbContenido1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbContenido2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbContenido3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbContenido4.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");

    }//GEN-LAST:event_panel4MouseExited

    private void pIntegridadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pIntegridadMouseEntered
        // TODO add your handling code here:

        lbIntegridad.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font;"
                + "foreground: darken(@foreground,7%);");
        lbIntegridad1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");
        lbIntegridad2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");
        lbIntegridad3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");

        pIntegridad.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:darken(@background,10%);");
    }//GEN-LAST:event_pIntegridadMouseEntered

    private void pIntegridadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pIntegridadMouseExited
        // TODO add your handling code here:

        lbIntegridad.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font;");
        lbIntegridad1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbIntegridad2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbIntegridad3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");

        pIntegridad.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten($Menu.background,7%);");
    }//GEN-LAST:event_pIntegridadMouseExited

    private void pSolidaridadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pSolidaridadMouseEntered
        // TODO add your handling code here:

        lbSolidaridad.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font;");
        lbSolidaridad1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");
        lbSolidaridad2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");
        lbSolidaridad3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");
        lbSolidaridad4.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");

        pSolidaridad.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:darken(@background,10%);");
    }//GEN-LAST:event_pSolidaridadMouseEntered

    private void pSolidaridadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pSolidaridadMouseExited
        // TODO add your handling code here:

        lbSolidaridad.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font;");
        lbSolidaridad1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbSolidaridad2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbSolidaridad3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbSolidaridad4.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");

        pSolidaridad.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten($Menu.background,7%);");
    }//GEN-LAST:event_pSolidaridadMouseExited

    private void pFeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pFeMouseEntered
        // TODO add your handling code here:
        lbFe.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font;");
        lbFe1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");
        lbFe2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");
        lbFe3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");
        lbFe4.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: darken(@foreground,7%);");

        pFe.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:darken(@background,10%);");
    }//GEN-LAST:event_pFeMouseEntered

    private void pFeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pFeMouseExited
        // TODO add your handling code here:
        lbFe.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font;");
        lbFe1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbFe2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbFe3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");
        lbFe4.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h3.font;"
                + "foreground: rgb(153,153,153);");

        pFe.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:50;"
                + "background:lighten($Menu.background,7%);");
    }//GEN-LAST:event_pFeMouseExited

    public CambioColor getEvent() {
        return event;
    }

    public void setEvent(CambioColor event) {
        this.event = event;
    }

    private CambioColor event;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbBienvenido;
    private javax.swing.JLabel lbContenido;
    private javax.swing.JLabel lbContenido1;
    private javax.swing.JLabel lbContenido2;
    private javax.swing.JLabel lbContenido3;
    private javax.swing.JLabel lbContenido4;
    private javax.swing.JLabel lbFe;
    private javax.swing.JLabel lbFe1;
    private javax.swing.JLabel lbFe2;
    private javax.swing.JLabel lbFe3;
    private javax.swing.JLabel lbFe4;
    private javax.swing.JLabel lbIntegridad;
    private javax.swing.JLabel lbIntegridad1;
    private javax.swing.JLabel lbIntegridad2;
    private javax.swing.JLabel lbIntegridad3;
    private javax.swing.JLabel lbSolidaridad;
    private javax.swing.JLabel lbSolidaridad1;
    private javax.swing.JLabel lbSolidaridad2;
    private javax.swing.JLabel lbSolidaridad3;
    private javax.swing.JLabel lbSolidaridad4;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTitulo2;
    private javax.swing.JPanel pFe;
    private javax.swing.JPanel pIntegridad;
    private javax.swing.JPanel pSolidaridad;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        DateTimeFormatter formateadorHora = DateTimeFormatter.ofPattern("hh:mm:ss a");
        DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            LocalDateTime ahora = LocalDateTime.now();
            String horaStr = ahora.format(formateadorHora);
            String fechaStr = ahora.format(formateadorFecha);

            SwingUtilities.invokeLater(() -> {
                time.setText(horaStr);
                date.setText(fechaStr);
            });

            try {
                // Esperamos 1 segundo antes de actualizar nuevamente
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void setSelected(Buttons cmd) {
        event.colorChange(cmd.getBackground());
        for (Component com : getComponents()) {
            Buttons cm = (Buttons) com;
    }
        }
        
    public void setSelectedColor(Color color) {
        for (Component com : getComponents()) {
            if (com.getBackground().getRGB() == color.getRGB()) {
                setSelected((Buttons) com);
                break;
           }
        }
    }
}
