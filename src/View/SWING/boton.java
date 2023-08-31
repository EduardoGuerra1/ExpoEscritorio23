package View.SWING;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author gyaci
 */
public class boton extends JButton{
    
    private Color buttonColor = new Color(69,88,105);
    
    public boton() {
        setBorder(new EmptyBorder(8, 15, 8, 15));
        setContentAreaFilled(false);
        setForeground(Color.GRAY);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isPressed()) {
            g2.setColor(buttonColor.darker());
        } else if (getModel().isRollover()) {
            g2.setColor(buttonColor.brighter());
        } else {
            g2.setColor(buttonColor);
        }
        
        int width = getWidth() - 1;
        int height = getHeight() - 1;
        int cornerRadius = height; 
        g2.fill(new RoundRectangle2D.Double(0, 0, width, height, cornerRadius, cornerRadius));

        g2.dispose();
        super.paintComponent(grphcs);
    }
    
}