package View.glasspanepopup;

import java.awt.Color;
import java.awt.Component;
import net.miginfocom.layout.LayoutCallback;

public interface Option {

    // Método para obtener el LayoutCallback personalizado.
    public LayoutCallback getLayoutCallBack(Component parent);

    // Método para obtener la configuración de diseño de la ventana emergente.
    public String getLayout(Component parent, float animate);

    // Método para determinar si se cierra la ventana emergente al hacer clic fuera de ella.
    public boolean closeWhenClickOutside();

    // Método para determinar si se bloquea el fondo cuando se muestra la ventana emergente.
    public boolean blockBackground();

    // Método para obtener el color de fondo de la ventana emergente.
    public Color background();

    // Método para obtener la opacidad de la ventana emergente.
    public float opacity();

    // Método para obtener la duración de la animación de la ventana emergente.
    public int duration();

    // Método para obtener el valor de animación actual.
    public float getAnimate();

    // Método para establecer el valor de animación.
    void setAnimate(float animate);
}

