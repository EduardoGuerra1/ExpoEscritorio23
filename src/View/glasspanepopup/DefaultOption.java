package View.glasspanepopup;

import java.awt.Color;
import java.awt.Component;
import net.miginfocom.layout.LayoutCallback;

public class DefaultOption implements Option {

    private float animate;

    // Método para obtener el LayoutCallback personalizado.
    @Override
    public LayoutCallback getLayoutCallBack(Component parent) {
        return new DefaultLayoutCallBack(parent);
    }

    // Método para obtener la configuración de diseño de la ventana emergente.
    @Override
    public String getLayout(Component parent, float animate) {
        float an = 20f / parent.getHeight();
        float space = 0.5f + an - (animate * an);
        return "pos 0.5al " + space + "al";
    }

    // Método para determinar si se cierra la ventana emergente al hacer clic fuera de ella.
    @Override
    public boolean closeWhenClickOutside() {
        return true;
    }

    // Método para bloquear el fondo cuando se muestra la ventana emergente.
    @Override
    public boolean blockBackground() {
        return true;
    }

    // Método para obtener el color de fondo de la ventana emergente.
    @Override
    public Color background() {
        return new Color(100, 100, 100);
    }

    // Método para obtener la opacidad de la ventana emergente.
    @Override
    public float opacity() {
        return 0.5f;
    }

    // Método para obtener la duración de la animación de la ventana emergente.
    @Override
    public int duration() {
        return 300;
    }

    // Método para obtener el valor de animación actual.
    @Override
    public float getAnimate() {
        return animate;
    }

    // Método para establecer el valor de animación.
    @Override
    public void setAnimate(float animate) {
        this.animate = animate;
    }
}
