package View.glasspanepopup;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

public class GlassPanePopup {

    // Método para obtener la capa de glass pane.
    protected JLayeredPane getLayerPane() {
        return layerPane;
    }

    private static GlassPanePopup instance;
    private JLayeredPane layerPane;

    // Constructor privado para la instancia única.
    private GlassPanePopup() {
        init();
    }

    // Inicializa la capa de glass pane.
    private void init() {
        layerPane = new JLayeredPane();
        layerPane.setLayout(new CardLayout());
    }

    // Agrega y muestra una ventana emergente.
    public void addAndShowPopup(Component component, Option option, String name) {
        Popup popup = new Popup(this, component, option);
        if (name != null) {
            popup.setName(name);
        }
        layerPane.add(popup, 0);
        popup.setVisible(true);
        popup.setShowPopup(true);
        if (!layerPane.isVisible()) {
            layerPane.setVisible(true);
        }
        layerPane.grabFocus();
    }

    // Actualiza el diseño de las ventanas emergentes.
    private void updateLayout() {
        for (Component com : layerPane.getComponents()) {
            com.revalidate();
        }
    }

    // Instala GlassPanePopup en un JFrame.
    public static void install(JFrame fram) {
        instance = new GlassPanePopup();
        fram.setGlassPane(instance.layerPane);
        fram.addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        instance.updateLayout();
                    }
                });
            }
        });
    }

    // Muestra una ventana emergente con opciones personalizadas.
    public static void showPopup(Component component, Option option, String name) {
        if (component.getMouseListeners().length == 0) {
            component.addMouseListener(new MouseAdapter() {});
        }
        instance.addAndShowPopup(component, option, name);
    }

    // Muestra una ventana emergente con opciones personalizadas sin nombre.
    public static void showPopup(Component component, Option option) {
        showPopup(component, option, null);
    }

    // Muestra una ventana emergente con opciones predeterminadas y nombre.
    public static void showPopup(Component component, String name) {
        showPopup(component, new DefaultOption(), name);
    }

    // Muestra una ventana emergente con opciones predeterminadas sin nombre.
    public static void showPopup(Component component) {
        showPopup(component, new DefaultOption(), null);
    }

    // Cierra una ventana emergente por índice.
    public static void closePopup(int index) {
        index = instance.getLayerPane().getComponentCount() - 1 - index;
        if (index >= 0 && index < instance.getLayerPane().getComponentCount()) {
            if (instance.getLayerPane().getComponent(index) instanceof Popup) {
                Popup popup = (Popup) instance.getLayerPane().getComponent(index);
                popup.setShowPopup(false);
            }
        }
    }

    // Cierra la última ventana emergente abierta.
    public static void closePopupLast() {
        closePopup(getPopupCount() - 1);
    }

    // Cierra una ventana emergente por nombre.
    public static void closePopup(String name) {
        for (Component com : instance.layerPane.getComponents()) {
            if (com.getName() != null && com.getName().equals(name)) {
                if (com instanceof Popup) {
                    Popup popup = (Popup) com;
                    popup.setShowPopup(false);
                }
            }
        }
    }

    // Cierra todas las ventanas emergentes abiertas.
    public static void closePopupAll() {
        for (Component com : instance.layerPane.getComponents()) {
            if (com instanceof Popup) {
                Popup popup = (Popup) com;
                popup.setShowPopup(false);
            }
        }
    }

    // Obtiene la cantidad de ventanas emergentes abiertas.
    public static int getPopupCount() {
        return instance.layerPane.getComponentCount();
    }

    // Elimina una ventana emergente específica.
    protected synchronized void removePopup(Component popup) {
        layerPane.remove(popup);
        if (layerPane.getComponentCount() == 0) {
            layerPane.setVisible(false);
        }
    }
}
