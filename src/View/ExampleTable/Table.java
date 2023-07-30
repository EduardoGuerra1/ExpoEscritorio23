package View.ExampleTable;
import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.theme.SkyBluer;
import mdlaf.MaterialLookAndFeel;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.themes.MaterialLiteTheme;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Table extends JTable {

    private static final int ROW_HEIGHT = 60;
    private static final int FONT_SIZE = 18;
    private static final Color HEADER_BACKGROUND_COLOR = MaterialColors.TEAL_500;
    private static final Color SELECTED_ROW_BACKGROUND_COLOR = MaterialColors.TEAL_700;
    private static final Color UNSELECTED_ROW_BACKGROUND_COLOR = MaterialColors.GRAY_800;

    public Table() {
        try {
            // Set the MaterialLookAndFeel
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setShowHorizontalLines(false);
        setRowHeight(ROW_HEIGHT);
        setFont(new Font("Segoe UI", Font.PLAIN, FONT_SIZE));

        // Set the custom header renderer
        HeaderTableCellRenderer headerRenderer = new HeaderTableCellRenderer();
        getTableHeader().setDefaultRenderer(headerRenderer);

        // Set the custom cell renderer
        FuturisticTableCellRenderer cellRenderer = new FuturisticTableCellRenderer();
        setDefaultRenderer(Object.class, cellRenderer);

        // Set the color of the selection
        setSelectionBackground(SELECTED_ROW_BACKGROUND_COLOR);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Set the MaterialLiteTheme for MaterialUI
        MaterialLookAndFeel.changeTheme(new MaterialLiteTheme());
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

    public void fixTable(JScrollPane scroll) {
        setFillsViewportHeight(true);
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scroll.setViewportView(this);
        scroll.getViewport().setBackground(MaterialColors.WHITE);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel cornerPanel = new JPanel();
        cornerPanel.setBackground(MaterialColors.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, cornerPanel);

        scroll.setBorder(BorderFactory.createEmptyBorder());

        ((DefaultTableCellRenderer) getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }

    public class HeaderTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel headerLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            headerLabel.setFont(new Font("Segoe UI", Font.BOLD, FONT_SIZE + 2));
            headerLabel.setForeground(Color.WHITE);
            headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
            headerLabel.setBackground(HEADER_BACKGROUND_COLOR);
            headerLabel.setOpaque(true);
            headerLabel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
            return headerLabel;
        }
    }

    public class FuturisticTableCellRenderer extends DefaultTableCellRenderer {

        private final int BORDER_RADIUS = 30;
        private final int SHADOW_SIZE = 15;
        private final int TRANSPARENCY = 200;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            label.setFont(new Font("Segoe UI", Font.PLAIN, FONT_SIZE));
            label.setOpaque(false);
            label.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));

            // Set the background and border based on the selection state
            if (isSelected) {
                label.setForeground(MaterialColors.WHITE);
                label.setBackground(SELECTED_ROW_BACKGROUND_COLOR);
                label.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(SHADOW_SIZE, SHADOW_SIZE, 0, 0),
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(SELECTED_ROW_BACKGROUND_COLOR, BORDER_RADIUS),
                                BorderFactory.createLineBorder(new Color(0, 0, 0, TRANSPARENCY), 1)
                        )
                ));
            } else {
                label.setForeground(MaterialColors.GRAY_200);
                label.setBackground(UNSELECTED_ROW_BACKGROUND_COLOR);
                label.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(SHADOW_SIZE, SHADOW_SIZE, 0, 0),
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(UNSELECTED_ROW_BACKGROUND_COLOR, BORDER_RADIUS),
                                BorderFactory.createLineBorder(new Color(0, 0, 0, TRANSPARENCY), 1)
                        )
                ));
            }

            // Add the Material UI hover effect to the cells
            MaterialUIMovement.add(label, MaterialColors.GRAY_400);

            return label;
        }
    }
}

