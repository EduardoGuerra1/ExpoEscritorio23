package View.BotonesText;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class RippleEffect {

    private final Component component;
    private Color rippleColor = new Color(255, 255, 255);
    private List<Effect> effects;

    public RippleEffect(Component component) {
        this.component = component;
        init();
    }

    private void init() {
        effects = new ArrayList<>();
        /*Agrega un MouseListener para detectar clics en el componente*/
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    /*Agrega un nuevo efecto de ondulación al hacer clic*/
                    addEffect(e.getPoint());
                }
            }
        });
    }

    public void addEffect(Point location) {
        /*Agrega un nuevo efecto a la lista para ser representado*/
        effects.add(new Effect(component, location));
    }

    public void reder(Graphics g, Shape contain) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        /*Renderiza todos los efectos activos en el componente*/
        for (int i = 0; i < effects.size(); i++) {
            Effect effect = effects.get(i);
            if (effect != null) {
                effect.render(g2, contain);
            }
        }
    }

    private class Effect {

        private final Component component;
        private final Point location;
        private Animator animator;
        private float animate;

        public Effect(Component component, Point location) {
            this.component = component;
            this.location = location;
            init();
        }

        private void init() {
            /*Inicializa un animador para crear una animación de desvanecimiento*/
            animator = new Animator(500, new TimingTargetAdapter() {
                @Override
                public void timingEvent(float fraction) {
                    animate = fraction;
                    /*Vuelve a pintar el componente cuando cambia la animación*/
                    component.repaint();
                }

                @Override
                public void end() {
                    /*Cuando la animación termina, elimina este efecto de la lista*/
                    effects.remove(Effect.this);
                }
            });
            animator.setResolution(5);
            animator.setDeceleration(.5f);
            animator.start();
        }

        public void render(Graphics2D g2, Shape contain) {
            /*Calcula el área de intersección entre el efecto y el componente*/
            Area area = new Area(contain);
            area.intersect(new Area(getShape(getSize(contain.getBounds2D()))));
            g2.setColor(rippleColor);
            float alpha = 0.3f;
            if (animate >= 0.7f) {
                double t = animate - 0.7f;
                alpha = (float) (alpha - (alpha * (t / 0.3f)));
            }
            /*Aplica un efecto de transparencia y pinta el área de intersección*/
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            g2.fill(area);
        }

        private Shape getShape(double size) {
            /*Calcula la forma de la onda en función del tamaño y la posición*/
            double s = size * animate;
            double x = location.getX();
            double y = location.getY();
            Shape shape = new Ellipse2D.Double(x - s, y - s, s * 2, s * 2);
            return shape;
        }

        private double getSize(Rectangle2D rec) {
            /*Calcula el tamaño de la onda en función del componente y la posición*/
            double size;
            if (rec.getWidth() > rec.getHeight()) {
                if (location.getX() < rec.getWidth() / 2) {
                    size = rec.getWidth() - location.getX();
                } else {
                    size = location.getX();
                }
            } else {
                if (location.getY() < rec.getHeight() / 2) {
                    size = rec.getHeight() - location.getY();
                } else {
                    size = location.getY();
                }
            }
            return size + (size * 0.1f);
        }
    }

    public void setRippleColor(Color rippleColor) {
        this.rippleColor = rippleColor;
    }

    public Color getRippleColor() {
        return rippleColor;
    }
}