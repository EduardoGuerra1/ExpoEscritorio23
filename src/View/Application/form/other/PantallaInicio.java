/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form.other;

import View.ExampleTable.BordeRedondeado;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PantallaInicio extends javax.swing.JPanel implements Runnable {
 int hora,minutos,segundos; 
    String timestr, yearstr; 
    int day,month,year;
    
    /**
     * Creates new form PantallaInicio
     */
    public PantallaInicio() {
        
        Thread t= new Thread(this);
        t.start();
        initComponents();
        
        String bg = getBackground().toString();
        System.out.println("El color de fondo de Pantalla Inicio es: "+bg);
        
        time.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        date.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        lbBienvenido.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h1.font;");
        lbTitulo.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h1.font;");
        lbTitulo2.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h1.font;");
        lbContenido.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        lbContenido1.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        lbContenido2.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        lbContenido3.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        lbContenido4.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        
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
        lbIntegridad.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h1.font;");
        lbIntegridad1.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        lbIntegridad2.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        lbIntegridad3.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        
        pIntegridad.putClientProperty(FlatClientProperties.STYLE, ""
               + "arc:50;"
               + "background:lighten($Menu.background,7%);");
        
        
        //Solidaridad
        lbSolidaridad.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h1.font;");
        lbSolidaridad1.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        lbSolidaridad2.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        lbSolidaridad3.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        lbSolidaridad4.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        
        pSolidaridad.putClientProperty(FlatClientProperties.STYLE, ""
               + "arc:50;"
               + "background:lighten($Menu.background,3%);");
        
        
        //FE
        lbFe.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h1.font;");
        lbFe1.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        lbFe2.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        lbFe3.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        lbFe4.putClientProperty(FlatClientProperties.STYLE,""
                + "font:$h3.font;");
        
        pFe.putClientProperty(FlatClientProperties.STYLE, ""
               + "arc:50;"
               + "background:lighten($Menu.background,7%);");
        
        
       panel1.putClientProperty(FlatClientProperties.STYLE, ""
               + "arc:50;"
               + "background:lighten(@background,5%);");
      /* panel2.putClientProperty(FlatClientProperties.STYLE, ""
               + "arc:50;"
               + "background:lighten($Menu.background,7%);");
       
        panel3.putClientProperty(FlatClientProperties.STYLE, ""
               + "arc:50;"
               + "background:lighten(@background,8%);");*/
        panel4.putClientProperty(FlatClientProperties.STYLE, ""
               + "arc:50;"
               + "background:lighten(@background,10%);");
        
        
        
    
       
    }

    
    private void cambiarColorRGB(int red, int green, int blue) {
        Color nuevoColor = new Color(red, green, blue);
        panel1.setBackground(nuevoColor);
        panel1.repaint(); // Refresca la interfaz de usuario para mostrar el cambio
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        lbBienvenido = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        time = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        lbContenido = new javax.swing.JLabel();
        lbContenido1 = new javax.swing.JLabel();
        lbContenido2 = new javax.swing.JLabel();
        lbContenido3 = new javax.swing.JLabel();
        lbContenido4 = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        lbTitulo2 = new javax.swing.JLabel();
        pIntegridad = new javax.swing.JPanel();
        lbIntegridad = new javax.swing.JLabel();
        lbIntegridad1 = new javax.swing.JLabel();
        lbIntegridad2 = new javax.swing.JLabel();
        lbIntegridad3 = new javax.swing.JLabel();
        pSolidaridad = new javax.swing.JPanel();
        lbSolidaridad2 = new javax.swing.JLabel();
        lbSolidaridad3 = new javax.swing.JLabel();
        lbSolidaridad1 = new javax.swing.JLabel();
        lbSolidaridad = new javax.swing.JLabel();
        lbSolidaridad4 = new javax.swing.JLabel();
        pFe = new javax.swing.JPanel();
        lbFe4 = new javax.swing.JLabel();
        lbFe3 = new javax.swing.JLabel();
        lbFe2 = new javax.swing.JLabel();
        lbFe1 = new javax.swing.JLabel();
        lbFe = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/calendar1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/clock.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

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

        jPanel1.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 210, 70));

        lbBienvenido.setText("Bienvenido a SAE");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(lbBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(lbBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel1.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 870, 120));
        new BordeRedondeado(10);

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

        jPanel1.add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 210, 70));

        lbContenido.setForeground(new java.awt.Color(153, 153, 153));
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
                .addGap(28, 28, 28)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbContenido1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(lbContenido2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbContenido3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbContenido4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
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

        jPanel1.add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 330, 160));

        lbTitulo.setText("¿Qué es SAE?");
        jPanel1.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 249, 46));

        lbTitulo2.setText("Valores del Instituto Técnico Ricaldone:");
        jPanel1.add(lbTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        lbIntegridad.setForeground(new java.awt.Color(255, 255, 255));
        lbIntegridad.setText("Integridad");

        lbIntegridad1.setForeground(new java.awt.Color(255, 255, 255));
        lbIntegridad1.setText("\"Actuar con transparencia y");

        lbIntegridad2.setForeground(new java.awt.Color(255, 255, 255));
        lbIntegridad2.setText("honestidad en todas las ");

        lbIntegridad3.setForeground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap(90, Short.MAX_VALUE))
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
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanel1.add(pIntegridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 260, 180));

        lbSolidaridad2.setForeground(new java.awt.Color(255, 255, 255));
        lbSolidaridad2.setText("de estar a la búsqueda de");

        lbSolidaridad3.setForeground(new java.awt.Color(255, 255, 255));
        lbSolidaridad3.setText("soluciones ante las necesidades");

        lbSolidaridad1.setForeground(new java.awt.Color(255, 255, 255));
        lbSolidaridad1.setText("\"Manifestar la disposición");

        lbSolidaridad.setForeground(new java.awt.Color(255, 255, 255));
        lbSolidaridad.setText("Solidaridad");

        lbSolidaridad4.setForeground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap(72, Short.MAX_VALUE))
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

        jPanel1.add(pSolidaridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 260, 180));

        lbFe4.setForeground(new java.awt.Color(255, 255, 255));
        lbFe4.setText("que motiva nuestro existir\"");

        lbFe3.setForeground(new java.awt.Color(255, 255, 255));
        lbFe3.setText("experimentarla como vida y amor,");

        lbFe2.setForeground(new java.awt.Color(255, 255, 255));
        lbFe2.setText("de Dios en nuestro quehacer y");

        lbFe1.setForeground(new java.awt.Color(255, 255, 255));
        lbFe1.setText("\"Reconocer la presencia operante");

        lbFe.setForeground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap(87, Short.MAX_VALUE))
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
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel1.add(pFe, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 290, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
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
        while(true){
        try{
            Calendar c=Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            if(hora>12)
                hora = hora-12;
            minutos=c.get(Calendar.MINUTE);
            segundos=c.get(Calendar.SECOND);
            year=c.get(Calendar.YEAR);
            month=c.get(Calendar.MONTH);
            day=c.get(Calendar.DAY_OF_MONTH);
            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss a");
            SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
            Date dat=c.getTime() ;
            timestr=sdf.format(dat);
            yearstr=df.format(dat);
            time.setText(timestr);
            date.setText(yearstr);
        }catch (Exception e ){
            e.printStackTrace();
        }
    }}
}
