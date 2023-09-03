package View.menu.mode;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.icons.FlatAbstractIcon;
import com.formdev.flatlaf.util.ColorFunctions;
import com.formdev.flatlaf.util.LoggingFacade;
import com.formdev.flatlaf.util.UIScale;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.util.Collections;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import View.menu.Menu;

// Definición de la clase ToolBarAccentColor que extiende JPanel
public class ToolBarAccentColor extends JPanel {
    private final Menu menu; // Referencia al menú principal
    private final JPopupMenu popup = new JPopupMenu(); // Menú emergente para seleccionar colores de acento

    // Métodos getter y setter para el modo de menú (completo o colapsado)
    public boolean isMenuFull() {
        return menuFull;
    }

    public void setMenuFull(boolean menuFull) {
        this.menuFull = menuFull;
        removeAll();
        // Configuración de los componentes en función del modo
        if (menuFull) {
            add(toolbar);
            popup.remove(toolbar);
        } else {
            add(selectedButton);
            popup.add(toolbar);
        }
        repaint();
        revalidate();
    }

    private final String[] accentColorKeys = {
        "App.accent.default", "App.accent.blue", "App.accent.purple", "App.accent.red",
        "App.accent.orange", "App.accent.yellow", "App.accent.green",};
    private final String[] accentColorNames = {
        "Default", "Blue", "Purple", "Red", "Orange", "Yellow", "Green",};
    private boolean menuFull = true;

    // Constructor de la clase ToolBarAccentColor
    public ToolBarAccentColor(Menu menu) {
        this.menu = menu;
        init(); // Inicialización de la interfaz de usuario
    }

    // Método para mostrar el menú emergente
    public void show(Component com, int x, int y) {
        if (menu.getComponentOrientation().isLeftToRight()) {
            popup.show(com, x, y);
        } else {
            int px = toolbar.getPreferredSize().width + UIScale.scale(5);
            popup.show(com, -px, y);
        }
        SwingUtilities.updateComponentTreeUI(popup);
    }

    // Método de inicialización de la interfaz de usuario
    private void init() {
        setLayout(new BorderLayout());
        toolbar = new JToolBar();
        add(toolbar);
        putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Menu.background");
        toolbar.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Menu.background");

        popup.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Menu.background;"
                + "borderColor:$Menu.background;");
        ButtonGroup group = new ButtonGroup();
        selectedButton = new JToggleButton(new AccentColorIcon(accentColorKeys[0]));
        selectedButton.addActionListener((ActionEvent e) -> {
            int y = (selectedButton.getPreferredSize().height - (toolbar.getPreferredSize().height + UIScale.scale(10))) / 2;
            show(ToolBarAccentColor.this, (int) getWidth() + UIScale.scale(4), y);
        });
        for (int i = 0; i < accentColorNames.length; i++) {
            String key = accentColorKeys[i];
            JToggleButton tbutton = new JToggleButton(new AccentColorIcon(key));
            tbutton.addActionListener((ActionEvent e) -> {
                colorAccentChanged(key);
            });
            group.add(tbutton);
            toolbar.add(tbutton);
        }
    }

    // Método para manejar el cambio de color de acento
    private void colorAccentChanged(String colorKey) {
        if (popup.isVisible()) {
            popup.setVisible(false);
        }
        Color color = UIManager.getColor(colorKey);
        selectedButton.setIcon(new AccentColorIcon(colorKey));
        Class<? extends LookAndFeel> lafClass = UIManager.getLookAndFeel().getClass();
        try {
            FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentColor", toHexCode(color)));
            FlatLaf.setup(lafClass.newInstance());
            FlatLaf.updateUI();
        } catch (InstantiationException | IllegalAccessException ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
    }

    // Método para convertir un color en su representación hexadecimal
    private String toHexCode(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    private JToolBar toolbar;
    private JToggleButton selectedButton;

    // Clase interna AccentColorIcon que representa un icono de color de acento
    private class AccentColorIcon extends FlatAbstractIcon {
        private final String colorKey;

        public AccentColorIcon(String colorKey) {
            super(16, 16, null);
            this.colorKey = colorKey;
        }

        @Override
        protected void paintIcon(Component c, Graphics2D g) {
            Color accColor = UIManager.getColor(colorKey);
            if (accColor == null) {
                accColor = Color.lightGray;
            } else if (!c.isEnabled()) {
                accColor = FlatLaf.isLafDark()
                        ? ColorFunctions.shade(accColor, 0.5f)
                        : ColorFunctions.tint(accColor, 0.6f);
            }
            g.setColor(accColor);
            g.fillRoundRect(1, 1, width - 2, height - 2, 5, 5);
        }
    }
}

    

