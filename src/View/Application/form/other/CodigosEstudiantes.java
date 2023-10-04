/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form.other;

import Reportes.ConexionSQL;
import View.BotonesText.CustomComboBox;
import View.glasspanepopup.GlassPanePopup;
import View.samplemessage.Message;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import expoescritorio.Controller.ControllerFull;
import static expoescritorio.Controller.Funciones.GetCodigosString;
import expoescritorio.Models.CodigosConductualesString;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
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
public class CodigosEstudiantes extends javax.swing.JPanel {

    private TableRowSorter<DefaultTableModel> rowSorter;

    /**
     * Creates new form Observaciones
     */
    public CodigosEstudiantes() {
        initComponents();

        String bg = getBackground().toString();

        if (bg.contains("r=24")) {
            System.out.println("Modo oscuro");
        } else {
            System.out.println("Modo claro");
            EventQueue.invokeLater(() -> {
                // FlatAnimatedLafChange.showSnapshot();
                FlatIntelliJLaf.setup();
                FlatLaf.updateUI();
                //FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        }

        String[] items = {"Estudiantes", "Docente", "Código"};

        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        // Obtén el modelo de la tabla existente
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        // Establece los "ColumnIdentifiers" en el modelo de la tabla
        tableModel.setColumnIdentifiers(new Object[]{"ID", "Estudiante", "Docente", "CodigoConductual", "Fecha"});
        cargarDatosAsync();
        table1.setDefaultEditor(Object.class, null);
        table1.getTableHeader().setReorderingAllowed(false);
        rowSorter = new TableRowSorter<>((DefaultTableModel) table1.getModel());
        table1.setRowSorter(rowSorter);
        Buscador.setDocument(new PlainDocument() { // desde aca 
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                for (char c : str.toCharArray()) {
                    if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c) && c != '.') {
                        // Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El campo solo permite números y letras");

                        return; // Ignora el carácter si no es letra, número, espacio o punto
                    } else {

                    }
                }
                super.insertString(offset, str, attr);
            }
        });// ha

    }

    public void deleteAllTableRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public void cargarDatosAsync() {
        GetCodigosString()
                .thenAccept(encargadosList -> {
                    DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
                    for (CodigosConductualesString tipoCodigo : encargadosList) {
                        String Fecha = tipoCodigo.getFecha().substring(0, 11);

                        tableModel.addRow(new Object[]{
                            tipoCodigo.getIdCodigoConductualPersona(),
                            tipoCodigo.getEstudiante(),
                            tipoCodigo.getDocente(),
                            tipoCodigo.getCodigoConductual(),
                            Fecha,});
                    }
                })
                .exceptionally(throwable -> {
                    throwable.printStackTrace();
                    return null;
                });
    }

    private void filterTable() {
        String searchText = Buscador.getText().toLowerCase();

        for (int row = 0; row < table1.getRowCount(); row++) {
            String nombre = table1.getValueAt(row, 1).toString().toLowerCase();
            boolean match = nombre.contains(searchText);
            table1.setValueAt(match, row, 0); // Muestra/oculta la fila
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new View.ExampleTable.Table();
        btnDelete = new View.BotonesText.Buttons();
        buttons1 = new View.BotonesText.Buttons();
        Buscador = new View.BotonesText.CustomTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRecargar = new View.BotonesText.Buttons();
        cbSearch = new View.BotonesText.CustomComboBox();

        lb.setText("Gestión de códigos asignados");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/delete.png"))); // NOI18N
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        buttons1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/disquete.png"))); // NOI18N
        buttons1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttons1MouseClicked(evt);
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

        btnRecargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/reload.png"))); // NOI18N
        btnRecargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRecargarMouseClicked(evt);
            }
        });

        cbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estudiantes", "Docente", "Código" }));

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
                        .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttons1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttons1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRecargar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        int selectedRow = table1.getSelectedRow();

        // Verificar si se ha seleccionado una fila
        if (selectedRow != -1) {
            // Obtener los datos de las columnas de la fila seleccionada
            Object id = table1.getValueAt(selectedRow, 0);
            System.out.println(id);
            Message obj = new Message();
            obj.txtTitle.setText("Aviso");
            obj.txtContent.setText("¿Desea eliminar este registro?");
            obj.eventOK(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {

                    String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/CodigosConductualesPersonas/delete";
                    // Código para eliminar el registro de la API
                    CompletableFuture<Boolean> deleteFuture = ControllerFull.DeleteApiAsync(endpointUrl, (int) id);

                    // Manejar la respuesta de la API
                    deleteFuture.thenAccept(deleted -> {
                        if (deleted) {
                            // Registro eliminado con éxito
                            Message obj = new Message();
                            obj.txtTitle.setText("Aviso");
                            obj.txtContent.setText("Codigos Conductual eliminado");
                            obj.eventOK(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {

                                    cargarDatosAsync();
                                    deleteAllTableRows(table1);
                                    GlassPanePopup.closePopupLast();
                                }
                            });
                            GlassPanePopup.showPopup(obj);
                        } else {
                            // Ocurrió un error al eliminar el registro
                            Message obj = new Message();
                            obj.txtTitle.setText("Aviso");
                            obj.txtContent.setText("Error al eliminar la Codigo, intente nuevamente.");
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
            playAbrir();

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
    private void mostrarReporte() {
        try {
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/CodigosConductialesEXPO.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, ConexionSQL.getConexion());

            JasperViewer view = new JasperViewer(jprint, false);
            view.setTitle("Nombre Reporte");
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            ex.getMessage();
        }
    }
    
    
    private void playAbrir() {
        String filepath = "src/View/sounds/abrir.wav";

        PlayMusic(filepath);

    }
    
    private static void PlayMusic(String location) {
        try {
            File musicPath = new File(location);
            
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }else{
                System.out.println("No se encuentra el archivo de sonido");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   
    }
    
    
    private void buttons1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttons1MouseClicked
        mostrarReporte();
    }//GEN-LAST:event_buttons1MouseClicked

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

        } // TODO add your handling code here:
    }//GEN-LAST:event_BuscadorKeyTyped

    private void btnRecargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecargarMouseClicked
        // TODO add your handling code here:
        deleteAllTableRows(table1);
        cargarDatosAsync();
    }//GEN-LAST:event_btnRecargarMouseClicked

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        if (evt.getClickCount() == 2) {
            DetCod obj = new DetCod(this);
            int index = table1.getSelectedRow();
            TableModel model = table1.getModel();
            String id = model.getValueAt(index, 0).toString();
            String estudiante = model.getValueAt(index, 1).toString();
            String Docente = model.getValueAt(index, 2).toString();
            String Cod = model.getValueAt(index, 3).toString();
            String Fecha = model.getValueAt(index, 4).toString();

            obj.lbIdent.setText(id);
            obj.lbEstudiante.setText(estudiante);
            obj.lbDocente.setText(Docente);
            obj.lbCod.setText(Cod);
            obj.lbFecha.setText(Fecha);
            GlassPanePopup.showPopup(obj);
        }
    }//GEN-LAST:event_table1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.CustomTextField Buscador;
    private View.BotonesText.Buttons btnDelete;
    private View.BotonesText.Buttons btnRecargar;
    private View.BotonesText.Buttons buttons1;
    private View.BotonesText.CustomComboBox cbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb;
    public View.ExampleTable.Table table1;
    // End of variables declaration//GEN-END:variables
}
