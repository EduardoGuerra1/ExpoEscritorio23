package View.ExampleTable;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Table extends JTable {

    private static final Color HEADER_BACKGROUND_COLOR = new Color(52, 152, 219);
    private static final Color SELECTED_ROW_BACKGROUND_COLOR = new Color(52, 152, 219);
    private static final int ROW_HEIGHT = 50;
    private static final int FONT_SIZE = 16;
    private static final int BORDER_RADIUS = 20;

    public Table() {
        // Configura el aspecto de FlatDarkLaf.
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Configura propiedades de la tabla.
        setShowHorizontalLines(false);
        setRowHeight(ROW_HEIGHT);
        setFont(new Font("Segoe UI", Font.PLAIN, FONT_SIZE));

        // Configura el renderizador para las celdas del encabezado.
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel headerLabel = new JLabel(value.toString());
                headerLabel.setFont(new Font("Segoe UI", Font.BOLD, FONT_SIZE + 2));
                headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
                headerLabel.setOpaque(true);
                headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                return headerLabel;
            }
        };
        getTableHeader().setDefaultRenderer(headerRenderer);

        // Configura el renderizador para las celdas de datos.
        ModernTableCellRenderer cellRenderer = new ModernTableCellRenderer();
        setDefaultRenderer(Object.class, cellRenderer);

        // Configura la apariencia de selección de filas.
        setSelectionBackground(SELECTED_ROW_BACKGROUND_COLOR);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Método para agregar una fila a la tabla.
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

    // Método para ajustar la apariencia y comportamiento de la tabla en un JScrollPane.
    public void fixTable(JScrollPane scroll) {
        setFillsViewportHeight(true);
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scroll.setViewportView(this);
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Configura el panel de la esquina superior derecha.
        JPanel cornerPanel = new JPanel();
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, cornerPanel);

        // Elimina los bordes del JScrollPane.
        scroll.setBorder(BorderFactory.createEmptyBorder());

        // Alinea el encabezado al centro.
        ((DefaultTableCellRenderer) getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);
    }

    // Clase interna para personalizar el renderizador de celdas de datos.
    public class ModernTableCellRenderer extends DefaultTableCellRenderer {

        private final Color UNSELECTED_COLOR = new Color(245, 245, 245);
        private final Color SELECTED_COLOR = new Color(75, 172, 198);
        private final int HIGHLIGHT_HEIGHT = 2;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = new JLabel(value.toString(), SwingConstants.CENTER);
            label.setFont(new Font("Segoe UI", Font.PLAIN, FONT_SIZE));
            label.setOpaque(true);
            label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

            // Configura la apariencia de la celda seleccionada.
            if (isSelected) {
                label.setBackground(SELECTED_COLOR);
                label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                label.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(SELECTED_COLOR, 3),
                        BorderFactory.createEmptyBorder(5, 10, 5, 10)
                ));
            } else {
                // Configura la apariencia de las celdas no seleccionadas.

                
            }

            label.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

            return label;
        }
    }
}