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
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setShowHorizontalLines(false);
        setRowHeight(ROW_HEIGHT);
        setFont(new Font("Segoe UI", Font.PLAIN, FONT_SIZE));

        // Establecer el renderizador para el encabezado de la tabla
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel headerLabel = new JLabel(value.toString());
                headerLabel.setFont(new Font("Segoe UI", Font.BOLD, FONT_SIZE + 2));
                headerLabel.setForeground(Color.WHITE);
                headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
                headerLabel.setOpaque(true);
                headerLabel.setBackground(HEADER_BACKGROUND_COLOR);
                headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                return headerLabel;
            }
        };
        getTableHeader().setDefaultRenderer(headerRenderer);

        // Establecer el renderizador para las celdas de la tabla
        ModernTableCellRenderer cellRenderer = new ModernTableCellRenderer();
        setDefaultRenderer(Object.class, cellRenderer);

        // Establecer el color de selección de la tabla
        setSelectionBackground(SELECTED_ROW_BACKGROUND_COLOR);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

    public void fixTable(JScrollPane scroll) {
        setFillsViewportHeight(true);
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scroll.setViewportView(this);
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel cornerPanel = new JPanel();
        cornerPanel.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, cornerPanel);

        scroll.setBorder(BorderFactory.createEmptyBorder());

        ((DefaultTableCellRenderer) getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);
    }

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

            // Set the background, shadows, and highlights based on the selection state
            if (isSelected) {
                label.setBackground(SELECTED_COLOR);
                label.setForeground(Color.WHITE);
                label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                label.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(SELECTED_COLOR, 3),
                        BorderFactory.createEmptyBorder(5, 10, 5, 10)
                ));
            } else {
                label.setBackground(row % 2 == 0 ? UNSELECTED_COLOR : Color.WHITE);
                label.setForeground(Color.BLACK);
                label.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                label.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.WHITE, BORDER_RADIUS),
                        BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)
                ));
            }

            // Add rounded borders
            label.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

            return label;
        }
    }
}
