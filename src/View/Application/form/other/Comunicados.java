/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form.other;

import View.glasspanepopup.GlassPanePopup;
import View.samplemessage.Message;
import View.samplemessage.MessageAddComunicados;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import expoescritorio.Controller.ControllerFull;
import static expoescritorio.Controller.Funciones.GetComunicados;
import static expoescritorio.Controller.Funciones.GetObservaciones;
import expoescritorio.Controller.GradosController;
import static expoescritorio.Controller.SalonesController.getSalonesApiAsync;
import expoescritorio.Models.ComunicadosModel;
import expoescritorio.Models.GradosView;
import expoescritorio.Models.ObservacionesString;
import expoescritorio.Models.Salones;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author educs
 */
public class Comunicados extends javax.swing.JPanel {

    /**
     * Creates new form Observaciones
     */
    
    List<ComunicadosModel> comunicados = new ArrayList<ComunicadosModel>();
    
    public Comunicados() {
        
        initComponents();
        String bg = getBackground().toString();
        table1.setDefaultEditor(Object.class, null);
       
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
            // Agregar las columnas al modelo de tabla
         tableModel.addColumn("ID Comunicado");
                  tableModel.addColumn("Fecha");
         tableModel.addColumn("Titulo");
        
        cargarDatos();
        table1.getTableHeader().setReorderingAllowed(false); 
        
    }

    public void cargarDatos(){
    GetComunicados()
        .thenAccept(encargadosList -> {
            DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
            for (ComunicadosModel tipoCodigo : encargadosList) {
                String Fecha = tipoCodigo.getDetalle().substring(0, 11);
                tableModel.addRow(new Object[]{
                    tipoCodigo.getIdComunicado(),
                    Fecha,
                    tipoCodigo.getFecha()
                });
            }
        })
        .exceptionally(throwable -> {
            throwable.printStackTrace();
            return null;
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new View.ExampleTable.Table();
        btnAdd = new View.BotonesText.Buttons();
        btnEdit = new View.BotonesText.Buttons();
        btnDelete = new View.BotonesText.Buttons();
        btnReload = new View.BotonesText.Buttons();

        lb.setText("Comunicados");

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

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/edit.png"))); // NOI18N
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/delete.png"))); // NOI18N
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/reload.png"))); // NOI18N
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReloadMouseClicked(evt);
            }
        });

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lb)
                .addContainerGap(612, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        MessageAddComunicados obj = new MessageAddComunicados(this);
        obj.txtTitle.setText("Añadir comunicado");
        GlassPanePopup.showPopup(obj);
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:

        int selectedRow = table1.getSelectedRow();

        if (selectedRow != -1) {
            // Obtener los datos de las columnas de la fila seleccionada
            MessageEditComunicados obj = new MessageEditComunicados();
            obj.txtTitle.setText("Editar comunicado");
            Object Titulo = table1.getValueAt(selectedRow, 2);
            Object id = table1.getValueAt(selectedRow, 0);
            obj.txtTitulo.setText(Titulo.toString());
            obj.id = Integer.parseInt(id.toString()); 
            obj.eventOK(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.out.println("Click OK");
                    GlassPanePopup.closePopupLast();
                    Timer timer = new Timer(500, (ActionEvent e) -> {
                     cargarDatos();
                        deleteAllTableRows(table1);
                       
                        
                    });
                    timer.setRepeats(false);
                timer.start();
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
                    Timer timer = new Timer(500, (ActionEvent e) -> {
                    
                        
                    });
                    timer.setRepeats(false);
                timer.start();
                }
            });
            GlassPanePopup.showPopup(obj);

        }
    }//GEN-LAST:event_btnEditMouseClicked

    public void deleteAllTableRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }
    
    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:

        int selectedRow = table1.getSelectedRow();

        // Verificar si se ha seleccionado una fila
        if (selectedRow != -1) {
            
            Object id = table1.getValueAt(selectedRow, 0);

            Message obj = new Message();
            obj.txtTitle.setText("Aviso");
            obj.txtContent.setText("¿Desea eliminar este registro?");
            obj.eventOK(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {

                    String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/Comunicados/delete";
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

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnReloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReloadMouseClicked
        // TODO add your handling code here:
        
         deleteAllTableRows(table1);
        cargarDatos();
    }//GEN-LAST:event_btnReloadMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.Buttons btnAdd;
    private View.BotonesText.Buttons btnDelete;
    private View.BotonesText.Buttons btnEdit;
    private View.BotonesText.Buttons btnReload;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb;
    public View.ExampleTable.Table table1;
    // End of variables declaration//GEN-END:variables
}
