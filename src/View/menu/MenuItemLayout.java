package View.menu;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JLabel;

// Definición de la clase MenuItemLayout que implementa el LayoutManager
public class MenuItemLayout implements LayoutManager {

    // Referencia a la instancia de la clase Menu
    private final Menu menu;

    // Constructor que toma una instancia de Menu como parámetro
    public MenuItemLayout(Menu menu) {
        this.menu = menu;
    }

    // Método que agrega un componente al diseño (no se utiliza en esta implementación)
    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    // Método que quita un componente del diseño (no se utiliza en esta implementación)
    @Override
    public void removeLayoutComponent(Component comp) {
    }

    // Método para calcular el tamaño preferido del contenedor
    @Override
    public Dimension preferredLayoutSize(Container parent) {
        synchronized (parent.getTreeLock()) {
            Insets insets = parent.getInsets();
            int height = insets.top + insets.bottom;
            int size = parent.getComponentCount();
            for (int i = 0; i < size; i++) {
                Component com = parent.getComponent(i);
                if (com.isVisible()) {
                    if (com instanceof JLabel) {
                        // Si el componente es una etiqueta (título de menú)
                        if (menu.isMenuFull() || !menu.isHideMenuTitleOnMinimum()) {
                            // Si el menú está lleno o no se debe ocultar el título en el tamaño mínimo
                            height += com.getPreferredSize().height + (UIScale.scale(menu.getMenuTitleVgap()) * 2);
                        }
                    } else {
                        // Si el componente no es una etiqueta (elemento de menú)
                        height += com.getPreferredSize().height;
                    }
                }
            }
            return new Dimension(0, height);
        }
    }

    // Método para calcular el tamaño mínimo del contenedor (no se utiliza en esta implementación)
    @Override
    public Dimension minimumLayoutSize(Container parent) {
        synchronized (parent.getTreeLock()) {
            return new Dimension(0, 0);
        }
    }

    // Método para realizar el diseño de los componentes en el contenedor
    @Override
    public void layoutContainer(Container parent) {
        synchronized (parent.getTreeLock()) {
            Insets insets = parent.getInsets();
            int x = insets.left;
            int y = insets.top;
            int width = parent.getWidth() - (insets.left + insets.right);
            int size = parent.getComponentCount();
            for (int i = 0; i < size; i++) {
                Component com = parent.getComponent(i);
                if (com.isVisible()) {
                    int comHeight = com.getPreferredSize().height;
                    if (com instanceof JLabel) {
                        // Si el componente es una etiqueta (título de menú)
                        if (menu.isMenuFull() || !menu.isHideMenuTitleOnMinimum()) {
                            // Si el menú está lleno o no se debe ocultar el título en el tamaño mínimo
                            int menuTitleInset = UIScale.scale(menu.getMenuTitleLeftInset());
                            int menuTitleVgap = UIScale.scale(menu.getMenuTitleVgap());
                            int titleWidth = width - menuTitleInset;
                            y += menuTitleVgap;
                            com.setBounds(x + menuTitleInset, y, titleWidth, comHeight);
                            y += comHeight + menuTitleVgap;
                        } else {
                            // Si se debe ocultar el título en el tamaño mínimo, se establecen dimensiones nulas
                            com.setBounds(0, 0, 0, 0);
                        }
                    } else {
                        // Si el componente no es una etiqueta (elemento de menú)
                        com.setBounds(x, y, width, comHeight);
                        y += comHeight;
                    }
                }
            }
        }
    }
}

