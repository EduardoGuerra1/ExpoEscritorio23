package View.Application.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.util.UIScale;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import View.aplicacion.Application;
import View.Application.form.other.Asistencias;
import View.Application.form.other.Avisos;
import View.Application.form.other.PantallaInicio;
import View.Application.form.other.CodigosDisciplinarios;
import View.Application.form.other.CodigosEstudiantes;
import View.Application.form.other.Comunicados;
import View.Application.form.other.Credenciales;
import View.Application.form.other.Estudiantes;
import View.Application.form.other.HorariosClases;
import View.Application.form.other.Inasistencias;
import View.Application.form.other.LlegadasTarde;
import View.Application.form.other.Observaciones;
import View.Application.form.other.RangoDeHoras;
import View.Application.form.other.ReservacionesSalones;
import View.Application.form.other.SalonesPantalla;
import View.Application.form.other.SolicitudesPermisos;
import View.Application.form.other.TiposCodigos;
import View.Application.form.other.VisitasEnfermeria;
import View.menu.Menu;
import View.menu.MenuAction;
import View.samplemessage.MessageEditCodigosDisciplinarios;
import java.awt.Window;
import javax.swing.SwingUtilities;

/**
 *
 * @author gyaci
 */
public class MainForm extends JLayeredPane {

    public MainForm() {
        init();
    }

    private void init() {
        /*Configura el borde y el diseño del formulario*/
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new MainFormLayout());
        /*Inicializa el menú y el panel principal*/
        menu = new Menu();
        panelBody = new JPanel(new BorderLayout());/*Inicializa y configura el ícono del botón del menú*/
        initMenuArrowIcon();/*Configura el botón del menú y su acción*/
        menuButton.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Menu.button.background;"
                + "arc:999;"
                + "focusWidth:0;"
                + "borderWidth:0");
        menuButton.addActionListener((ActionEvent e) -> {
            setMenuFull(!menu.isMenuFull());
        });
        /*Inicializa y configura eventos del menú*/
        initMenuEvent();
        /*Establece la capa del botón del menú y agrega los componentes al formulario*/
        setLayer(menuButton, JLayeredPane.POPUP_LAYER);
        add(menuButton);
        add(menu);
        add(panelBody);
    }

    @Override
    public void applyComponentOrientation(ComponentOrientation o) {
        super.applyComponentOrientation(o);
        /*Actualiza el ícono del botón del menú en función de la orientación*/
        initMenuArrowIcon();
    }

    /*Inicializa y configura el ícono del botón del menú*/
    private void initMenuArrowIcon() {
        if (menuButton == null) {
            menuButton = new JButton();
        }
        /*Determina el ícono del botón del menú según la orientación del componente*/
        String icon = (getComponentOrientation().isLeftToRight()) ? "menu_left.svg" : "menu_right.svg";
        menuButton.setIcon(new FlatSVGIcon("View/icon/svg/" + icon, 0.8f));
    }

    /*Configura los eventos del menú y cómo deben manejarse las acciones al seleccionar elementos*/
    private void initMenuEvent() {
        menu.addMenuEvent((int index, int subIndex, MenuAction action) -> {
            // Application.mainForm.showForm(new DefaultForm("Form : " + index + " " + subIndex));
            if (index == 0) {
                Application.showForm(new View.Application.form.other.PantallaPrincipal());
            } else if (index == 1) {
                if (subIndex == 1) {
                    Application.showForm(new TiposCodigos());
                } else if (subIndex == 2) {
                    Application.showForm(new CodigosDisciplinarios());
                } else if (subIndex == 3) {
                    Application.showForm(new CodigosEstudiantes());
                } else if (subIndex == 4) {
                    Application.showForm(new Observaciones());
                } else if (subIndex == 5) {
                    Application.showForm(new LlegadasTarde());
                } else if (subIndex == 6) {
                    Application.showForm(new Inasistencias());
                } else {
                    action.cancel();
                }

            } else if (index == 2) {
                Application.showForm(new Comunicados());
            } else if (index == 3) {
                Application.showForm(new VisitasEnfermeria());
            } else if (index == 4) {
              if (subIndex == 1) {
                    Application.showForm(new RangoDeHoras());
                } else if (subIndex == 2) {
                  Application.showForm(new SalonesPantalla());
                } else if (subIndex == 3) {
                  Application.showForm(new ReservacionesSalones());
                } else {
                    action.cancel();
                }
            } else if (index == 5) {
                Application.showForm(new Credenciales());
            } else if (index == 6) {
                Application.logout();
            } else {
                action.cancel();
            }
        });
    }

    // Este método establece el estado del menú y actualiza la apariencia
    private void setMenuFull(boolean full) {
         // Determina el ícono del menú en función de la orientación del componente
        String icon;
        if (getComponentOrientation().isLeftToRight()) {
            icon = (full) ? "menu_left.svg" : "menu_right.svg";
        } else {
            icon = (full) ? "menu_right.svg" : "menu_left.svg";
        }
        // Establece el ícono del botón del menú.
        menuButton.setIcon(new FlatSVGIcon("View/icon/svg/" + icon, 0.8f));
        menu.setMenuFull(full);// Establece el estado del menú
        revalidate();// Actualiza el diseño del contenedor
    }

    public void hideMenu() {// Este método oculta el menú.
        menu.hideMenuItem();
    }

   // Este método muestra un formulario en el panel principal.
    public void showForm(Component component) {
        panelBody.removeAll();// Elimina todos los componentes del panel principal.
        panelBody.add(component);//Agrega el nuevo componente al panel principa
        panelBody.repaint();// Repinta y vuelve a validar el panel principal para mostrar el nuevo component
        panelBody.revalidate();
    }

    // Este método establece la selección en el menú
    public void setSelectedMenu(int index, int subIndex) {
        menu.setSelectedMenu(index, subIndex);
    }

    // Declaración de variables miembro
    private Menu menu;
    private JPanel panelBody;
    private JButton menuButton;

    private static class PantallaPrincipal extends Component {

        public PantallaPrincipal() {
        }
    }

    private static class SolicitudesPermiso extends Component {

        public SolicitudesPermiso() {
        }
    }

    // Clase que implementa un administrador de diseño personalizado para el formulario principal
    private class MainFormLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            // Devuelve las dimensiones preferidas para el contenedor principal
            synchronized (parent.getTreeLock()) {
                return new Dimension(5, 5);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            // Devuelve las dimensiones mínimas para el contenedor principal
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            // Realiza el diseño de los componentes en el contenedor principal
            synchronized (parent.getTreeLock()) {
                boolean ltr = parent.getComponentOrientation().isLeftToRight();
                Insets insets = UIScale.scale(parent.getInsets());
                int x = insets.left;
                int y = insets.top;
                int width = parent.getWidth() - (insets.left + insets.right);
                int height = parent.getHeight() - (insets.top + insets.bottom);
                int menuWidth = UIScale.scale(menu.isMenuFull() ? menu.getMenuMaxWidth() : menu.getMenuMinWidth());
                int menuX = ltr ? x : x + width - menuWidth;
                // Establece el tamaño y la posición del menú
                menu.setBounds(menuX, y, menuWidth, height);
                int menuButtonWidth = menuButton.getPreferredSize().width;
                int menuButtonHeight = menuButton.getPreferredSize().height;
                int menubX;
                if (ltr) {
                    menubX = (int) (x + menuWidth - (menuButtonWidth * (menu.isMenuFull() ? 0.5f : 0.3f)));
                } else {
                    menubX = (int) (menuX - (menuButtonWidth * (menu.isMenuFull() ? 0.5f : 0.7f)));
                }
                // Establece el tamaño y la posición del botón del menú
                menuButton.setBounds(menubX, UIScale.scale(30), menuButtonWidth, menuButtonHeight);
                int gap = UIScale.scale(5);
                int bodyWidth = width - menuWidth - gap;
                int bodyHeight = height;
                int bodyx = ltr ? (x + menuWidth + gap) : x;
                int bodyy = y;
                panelBody.setBounds(bodyx, bodyy, bodyWidth, bodyHeight);
            }
        }
    }
}
