package View.BotonesText;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;


public class Buttons extends JButton {

    public int getRound() {
        return round;
    }
    /*getter que devuelve el valor de la variable round*/
    public void setRound(int round) {
        this.round = round;
        createImageShadow();
        repaint();
    }

    /*setter que establece el valor de la variable round*/
    public Color getShadowColor() {
        return shadowColor;
    }

    /*getter que devuelve el valor de la variable shadowColor*/
    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
        createImageShadow();
        repaint();
    }

    /*setter que establece el color de la sombra del botón*/
    public void setRippleColor(Color color) {
        rippleEffect.setRippleColor(color);
    }

    /*establece el color del efecto de ondulación del botón*/
    public Color getRippleColor() {
        return rippleEffect.getRippleColor();
    }

    /*getter que devuelve el color del efecto de ondulación del botón.*/
    private int round = 10;
    private Color shadowColor = new Color(170, 170, 170);
    /*Se inicializan las variables round y shadowColor con valores predeterminados*/
    private BufferedImage imageShadow;
    private final Insets shadowSize = new Insets(2, 5, 8, 5);
    private final RippleEffect rippleEffect = new RippleEffect(this);

    /*Configuración inicial del botón*/
    public Buttons() {
        setBorder(new EmptyBorder(10, 12, 15, 12));
        setContentAreaFilled(false);
        setBackground(new Color(255, 255, 255));
        setForeground(new Color(80, 80, 80));
        rippleEffect.setRippleColor(new Color(220, 220, 220));
    }

    /*Método para dibujar la apariencia del botón*/
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double width = getWidth() - (shadowSize.left + shadowSize.right);
        double height = getHeight() - (shadowSize.top + shadowSize.bottom);
        double x = shadowSize.left;
        double y = shadowSize.top;
        g2.drawImage(imageShadow, 0, 0, null);
        g2.setColor(getBackground());
        Area area = new Area(new RoundRectangle2D.Double(x, y, width, height, round, round));
        g2.fill(area);
        rippleEffect.reder(grphcs, area);
        g2.dispose();
        super.paintComponent(grphcs);
    }

    /*El método se sobrescribe para personalizar la apariencia del botón*/
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        createImageShadow();
    }

    /*El método se sobrescribe para manejar cambios en las dimensiones del botón.*/
    private void createImageShadow() {
        int height = getHeight();
        int width = getWidth();
        if (width > 0 && height > 0) {
            imageShadow = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = imageShadow.createGraphics();
            BufferedImage img = createShadow();
            if (img != null) {
                g2.drawImage(createShadow(), 0, 0, null);
            }
            g2.dispose();
        }
    }
    
    /*El método se utiliza para crear la imagen de la sombra del botón.*/
    private BufferedImage createShadow() {
        int width = getWidth() - (shadowSize.left + shadowSize.right);
        int height = getHeight() - (shadowSize.top + shadowSize.bottom);
        if (width > 0 && height > 0) {
            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fill(new RoundRectangle2D.Double(0, 0, width, height, round, round));
            g2.dispose();
            return new ShadowRenderer(5, 0.3f, shadowColor).createShadow(img);
        } else {
            return null;
        }
    }
}
