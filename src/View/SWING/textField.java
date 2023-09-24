package View.SWING;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class textField extends JTextField {
    
    private String hint = "";

    public String getHint() {
        return hint;
    }
    
    public void setHint(String hint) {
        this.hint = hint;
    }
    
    public textField() {
        /* Constructor */     
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(new Color(0, 0, 0, 0));
        setHorizontalAlignment(JTextField.LEFT); // Alineación horizontal izquierda
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        /* Método para pintar el componente de texto */
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        int width = getWidth() - 1;
        int height = getHeight() - 1;
        g2.draw(new RoundRectangle2D.Double(0, 0, width, height, height, height));
        if (hint.equals("") && getText().length() == 0) {
            createHintText(g2);
        }
        g2.dispose();
        super.paintComponent(grphcs);
    }
    
    private void createHintText(Graphics2D g) {
        /* Método para crear y mostrar el texto de sugerencia si no hay entrada de texto */
        FontMetrics fm = g.getFontMetrics();
        int c0 = getBackground().getRGB();
        int c1 = getForeground().getRGB();
        int m = 0xfefefefe;
        int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
        g.setColor(new Color(c2, true));
        g.drawString(hint, ((getWidth() - fm.stringWidth(hint))) / 2, getHeight() / 2 + fm.getAscent() / 2 - 2);
    }
}
