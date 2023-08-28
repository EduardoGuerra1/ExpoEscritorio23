/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.ExampleTable;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;

public class BordeRedondeado extends AbstractBorder {
    private int radio; // Radio de las esquinas redondeadas

    public BordeRedondeado(int radio) {
        this.radio = radio;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(c.getBackground());

        // Dibuja un rectángulo redondeado como borde
        g2d.drawRoundRect(x, y, width - 1, height - 1, radio, radio);
        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radio, radio, radio, radio);
    }
}
