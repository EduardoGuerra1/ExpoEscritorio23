package View.menu.mode;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// Definición de la clase LightDarkMode que extiende JPanel
public class LightDarkMode extends JPanel {
    private boolean menuFull = true; // Indicador del modo de menú (completo o colapsado)
    private JButton buttonLight; // Botón para cambiar al modo claro
    private JButton buttonDark; // Botón para cambiar al modo oscuro
    private JButton buttonLighDark; // Botón para alternar entre modos claro y oscuro

    // Constructor de la clase LightDarkMode
    public LightDarkMode() {
        init(); // Inicialización de la interfaz de usuario
    }

    // Método para establecer el modo de menú (completo o colapsado)
    public void setMenuFull(boolean menuFull) {
        this.menuFull = menuFull;
        // Configuración de la visibilidad de los botones en función del modo
        if (menuFull) {
            buttonLight.setVisible(true);
            buttonDark.setVisible(true);
            buttonLighDark.setVisible(false);
        } else {
            buttonLight.setVisible(false);
            buttonDark.setVisible(false);
            buttonLighDark.setVisible(true);
        }
    }

    // Método de inicialización de la interfaz de usuario
    private void init() {
        // Configuración del borde y del diseño del panel
        setBorder(new EmptyBorder(2, 2, 2, 2));
        setLayout(new LightDarkModeLayout());
        putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:999;"
                + "background:$Menu.lightdark.background");

        // Creación de los botones y asignación de iconos
        buttonLight = new JButton("Claro", new FlatSVGIcon("View/menu/mode/light.svg"));
        buttonDark = new JButton("Oscuro", new FlatSVGIcon("View/menu/mode/dark.svg"));
        buttonLighDark = new JButton();
        buttonLighDark.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:999;"
                + "background:$Menu.lightdark.button.background;"
                + "foreground:$Menu.foreground;"
                + "focusWidth:0;"
                + "borderWidth:0");
        
        // Configuración del botón para alternar entre modos claro y oscuro
        buttonLighDark.addActionListener((ActionEvent e) -> {
            changeMode(!FlatLaf.isLafDark());
        });
        
        // Comprobación del estilo actual (claro u oscuro)
        checkStyle();
        
        // Configuración de los botones para cambiar al modo claro y oscuro
        buttonDark.addActionListener((ActionEvent e) -> {
            changeMode(true);
        });
        buttonLight.addActionListener((ActionEvent e) -> {
            changeMode(false);
        });

        // Agregar los botones al panel
        add(buttonLight);
        add(buttonDark);
        add(buttonLighDark);
    }
    
    // Método para cambiar entre modos claro y oscuro
    private void changeMode(boolean dark) {
        if (FlatLaf.isLafDark() != dark) {
            if (dark) {
                EventQueue.invokeLater(() -> {
                    // Cambiar al modo oscuro con una animación
                    FlatAnimatedLafChange.showSnapshot();
                    FlatDarculaLaf.setup();
                    FlatLaf.updateUI();
                    checkStyle();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                });
            } else {
                EventQueue.invokeLater(() -> {
                    // Cambiar al modo claro con una animación
                    FlatAnimatedLafChange.showSnapshot();
                    FlatIntelliJLaf.setup();
                    FlatLaf.updateUI();
                    checkStyle();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                });
            }
        }
    }

    // Método para comprobar y configurar el estilo de los botones en función del modo
    private void checkStyle() {
        boolean isDark = FlatLaf.isLafDark();
        addStyle(buttonLight, !isDark);
        addStyle(buttonDark, isDark);
        if (isDark) {
            buttonLighDark.setIcon(new FlatSVGIcon("View/menu/mode/dark.svg"));
        } else {
            buttonLighDark.setIcon(new FlatSVGIcon("View/menu/mode/light.svg"));
        }
    }

    // Método para agregar un estilo a un botón (botón claro u oscuro)
    private void addStyle(JButton button, boolean style) {
        if (style) {
            button.putClientProperty(FlatClientProperties.STYLE, ""
                    + "arc:999;"
                    + "background:$Menu.lightdark.button.background;"
                    + "foreground:$Menu.foreground;"
                    + "focusWidth:0;"
                    + "borderWidth:0");
        } else {
            button.putClientProperty(FlatClientProperties.STYLE, ""
                    + "arc:999;"
                    + "background:$Menu.lightdark.button.background;"
                    + "foreground:$Menu.foreground;"
                    + "focusWidth:0;"
                    + "borderWidth:0;"
                    + "background:null");
        }
    }

    // Clase interna LightDarkModeLayout que implementa el diseño personalizado para el panel
    private class LightDarkModeLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
            // No se implementa, pero se requiere por la interfaz LayoutManager
        }

        @Override
        public void removeLayoutComponent(Component comp) {
            // No se implementa, pero se requiere por la interfaz LayoutManager
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            // Método para calcular el tamaño preferido del panel
            synchronized (parent.getTreeLock()) {
                return new Dimension(5, buttonDark.getPreferredSize().height + (menuFull ? 0 : 5));
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            // Método para calcular el tamaño mínimo del panel
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                Insets insets = parent.getInsets();
                int x = insets.left;
                int y = insets.top;
                int gap = 5;
                int width = parent.getWidth() - (insets.left + insets.right);
                int height = parent.getHeight() - (insets.top + insets.bottom);
                int buttonWidth = (width - gap) / 2;
                if (menuFull) {
                    buttonLight.setBounds(x, y, buttonWidth, height);
                    buttonDark.setBounds(x + buttonWidth + gap, y, buttonWidth, height);
                } else {
                    buttonLighDark.setBounds(x, y, width, height);
                }
            }
        }
    }
}
    

