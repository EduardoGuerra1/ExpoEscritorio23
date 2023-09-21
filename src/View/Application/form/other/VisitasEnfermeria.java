/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form.other;

import Reportes.ConexionSQL;
import View.glasspanepopup.GlassPanePopup;
import View.samplemessage.Message;
import View.samplemessage.MessageAddRangoHoras;
import View.samplemessage.MessageAddVisitaEnfermeria;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import expoescritorio.Controller.ControllerFull;
import expoescritorio.Controller.Funciones;
import expoescritorio.Models.VisitasEnfermeriaString;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author educs
 */
public class VisitasEnfermeria extends javax.swing.JPanel {
 private TableRowSorter<DefaultTableModel> rowSorter;
    /**
     * Creates new form VisitasEnfermeria
     */
    public VisitasEnfermeria() {
        initComponents();
String bg = getBackground().toString();
        
       
        if(bg.contains("r=49")){
            System.out.println("Modo oscuro");
        }else{
            System.out.println("Modo claro");
             EventQueue.invokeLater(() -> {
                   // FlatAnimatedLafChange.showSnapshot();
                    FlatIntelliJLaf.setup();
                    FlatLaf.updateUI();
                    //FlatAnimatedLafChange.hideSnapshotWithAnimation();
                });
        }
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");

        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();

        // Establece los "ColumnIdentifiers" en el modelo de la tabla
        tableModel.setColumnIdentifiers(new Object[]{"ID", "Fecha", "Detalle de Visita", "Persona"});
        cargarDatos();
        table1.setDefaultEditor(Object.class, null);
        table1.getTableHeader().setReorderingAllowed(false); 
                rowSorter = new TableRowSorter<>((DefaultTableModel) table1.getModel());
        table1.setRowSorter(rowSorter);
        
    }

    public void cargarDatos() {
        CompletableFuture<List<VisitasEnfermeriaString>> future = Funciones.GetVisitasEnfermeria();
        future.thenAccept(visitas -> {
            DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
            for (VisitasEnfermeriaString visita : visitas) {
                String inicioFormatted = visita.getFecha().substring(0, 10); 
                tableModel.addRow(new Object[]{
                    visita.getIdVisitaEnfermeria(),
                    inicioFormatted,
                    visita.getDetalleVisitia(),
                    visita.getPersona()
                });
            }
        });
    }

    private void mostrarReporte() {
        try {
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/VisitasEnfermeria.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, ConexionSQL.getConexion());

            JasperViewer view = new JasperViewer(jprint, false);
            view.setTitle("Nombre Reporte");
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            ex.getMessage();
        }
    }
    
    public void deleteAllTableRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new View.ExampleTable.Table();
        btnAdd = new View.BotonesText.Buttons();
        btnDelete = new View.BotonesText.Buttons();
        btnReport = new View.BotonesText.Buttons();
        Buscador = new View.BotonesText.CustomTextField();
        jLabel1 = new javax.swing.JLabel();
        cbSearch = new javax.swing.JComboBox<>();
        lb = new javax.swing.JLabel();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table1);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/add1.png"))); // NOI18N
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/delete.png"))); // NOI18N
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/disquete.png"))); // NOI18N
        btnReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportMouseClicked(evt);
            }
        });

        Buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BuscadorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscadorKeyTyped(evt);
            }
        });

        jLabel1.setText("Buscar por:");

        cbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fecha", "Detalle", "Persona" }));
        cbSearch.setSelectedIndex(2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lb.setText("Gestión de Visitas a Enfermería");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lb)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        MessageAddVisitaEnfermeria obj = new MessageAddVisitaEnfermeria();
        obj.txtTitle.setText("Agregar na visita de enfermeria al estudiante");
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Timer timer = new Timer(500, (ActionEvent e) -> {
                    cargarDatos();
                    deleteAllTableRows(table1);
                    
                });
                timer.setRepeats(false);
                timer.start();
            }
        });
        GlassPanePopup.showPopup(obj);
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:

        int selectedRow = table1.getSelectedRow();

        // Verificar si se ha seleccionado una fila
        if (selectedRow != -1) {
            // Obtener los datos de las columnas de la fila seleccionada
            Object id = table1.getValueAt(selectedRow, 0);

            Message obj = new Message();
            obj.txtTitle.setText("Aviso");
            obj.txtContent.setText("¿Desea eliminar este registro?");
            obj.eventOK(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {

                    String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/VisitasEnfermeria/delete";
                    // Código para eliminar el registro de la API
                    CompletableFuture<Boolean> deleteFuture = ControllerFull.DeleteApiAsync(endpointUrl, (int) id);

                    // Manejar la respuesta de la API
                    deleteFuture.thenAccept(deleted -> {
                        if (deleted) {
                            // Registro eliminado con éxito
                            Message obj = new Message();
                            obj.txtTitle.setText("Aviso");
                            obj.txtContent.setText("Registro eliminado exitosamente");
                            obj.eventOK(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    deleteAllTableRows(table1);
                                    cargarDatos();
                                    GlassPanePopup.closePopupLast();
                                }
                            });
                            GlassPanePopup.showPopup(obj);
                        } else {
                            // Ocurrió un error al eliminar el registro
                            Message obj = new Message();
                            obj.txtTitle.setText("Aviso");
                            obj.txtContent.setText("Error al eliminar el registro, intente nuevamente.");
                            obj.eventOK(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {

                                    GlassPanePopup.closePopupLast();
                                }
                            });
                            GlassPanePopup.showPopup(obj);
                        }
                    });

                    GlassPanePopup.closePopupLast();
                }
            });
            GlassPanePopup.showPopup(obj);

        } else {
            Message obj = new Message();
            obj.txtTitle.setText("Aviso");
            obj.txtContent.setText("Debe seleccionar una fila.");
            obj.eventOK(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.out.println("Click OK");
                    GlassPanePopup.closePopupLast();
                }
            });
            GlassPanePopup.showPopup(obj);

        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseClicked
        mostrarReporte();
    }//GEN-LAST:event_btnReportMouseClicked

    private void BuscadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorKeyPressed

    }//GEN-LAST:event_BuscadorKeyPressed

    private void BuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorKeyTyped
        rowSorter = new TableRowSorter<>((DefaultTableModel) table1.getModel());
        table1.setRowSorter(rowSorter);
        String textoBusqueda = Buscador.getText().trim().toLowerCase();
        if (textoBusqueda.isEmpty()) {
            // Si el JTextField está vacío, muestra todas las filas.
            rowSorter.setRowFilter(null);
        } else {
            int indice = cbSearch.getSelectedIndex();
            int index = indice + 1;
            // Crea un filtro para mostrar solo las filas cuyo nombre de estudiante contiene el texto de búsqueda.
            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i).*" + textoBusqueda + ".*", index); // 1 representa la columna del estudiante
            rowSorter.setRowFilter(rowFilter);


        }
    }//GEN-LAST:event_BuscadorKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.CustomTextField Buscador;
    private View.BotonesText.Buttons btnAdd;
    private View.BotonesText.Buttons btnDelete;
    private View.BotonesText.Buttons btnReport;
    private javax.swing.JComboBox<String> cbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb;
    public View.ExampleTable.Table table1;
    // End of variables declaration//GEN-END:variables
}
