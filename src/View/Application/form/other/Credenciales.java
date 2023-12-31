/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form.other;

import View.glasspanepopup.GlassPanePopup;
import View.samplemessage.Message;
import View.samplemessage.MessageAddCodigosDisciplinarios;
import View.samplemessage.MessageAddPersonas;
import View.samplemessage.MessageEditCodigosDisciplinarios;

import View.samplemessage.MessageEditPersonas;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import expoescritorio.Controller.CodigosConductualesController;
import expoescritorio.Controller.ControllerFull;
import expoescritorio.Controller.PersonasController;
import expoescritorio.Controller.TiposPersonasController;
import expoescritorio.Models.CodigosConductuales;
import expoescritorio.Models.Personas;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import org.json.JSONException;
import org.json.JSONObject;
import raven.toast.Notifications;

/**
 *
 * @author gyaci
 */
public class Credenciales extends javax.swing.JPanel {
private boolean procesoEnCurso = false;
    PersonasController controller = new PersonasController();
    List<Personas> myPersonas = new ArrayList<Personas>();
     private TableRowSorter<DefaultTableModel> rowSorter;

    /**
     * Creates new form CodigosDisciplinarios
     */
    public Credenciales() {
        initComponents();

        
        String bg = getBackground().toString();
        
       
        if(bg.contains("r=24")){
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
        
        
        
         
        btnReload.setEnabled(false);
        
        Timer timer = new Timer(6000, (ActionEvent e) -> { 
                    
                     btnReload.setEnabled(true);
        });
                timer.setRepeats(false);
                timer.start();
        
        
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        // Obtén el modelo de la tabla existente
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();

        // Establece los "ColumnIdentifiers" en el modelo de la tabla
        tableModel.setColumnIdentifiers(new Object[]{"Codigo", "Nombre", "Tipo Persona", "Correo"});

        cargarDatos();

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
                    }
                else{
                      
                    }
                }
                super.insertString(offset, str, attr);
            }
        });
    }

    public void cargarDatos() {
                        int columnIndexToHide = 0; // Índice de la columna del ID que deseas ocultar
table1.getColumnModel().getColumn(columnIndexToHide).setMinWidth(0);
table1.getColumnModel().getColumn(columnIndexToHide).setMaxWidth(0);
table1.getColumnModel().getColumn(columnIndexToHide).setWidth(0);
        CompletableFuture<List<Personas>> future = PersonasController.getPersonasAsyncs();
        future.thenAccept(personas -> {
            DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();

            myPersonas.clear();

            for (Personas persona : personas) {
                tableModel.addRow(new Object[]{
                    persona.getCodigo(),
                    persona.getNombrePersona() + " " + persona.getApellidoPersona(),
                    TiposPersonasController.getTipoPersonaAsync(persona.getIdTipoPersona()).join(),
                    persona.getCorreo()
                });
                myPersonas.add(persona);
            }
        });
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
        btnEdit = new View.BotonesText.Buttons();
        btnDelete = new View.BotonesText.Buttons();
        Buscador = new View.BotonesText.CustomTextField();
        jLabel1 = new javax.swing.JLabel();
        cbSearch = new View.BotonesText.CustomComboBox();
        btnReload = new View.BotonesText.Buttons();
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
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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

        Buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BuscadorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscadorKeyTyped(evt);
            }
        });

        jLabel1.setText("Buscar por:");

        cbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Persona", "Tipo" }));
        cbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSearchActionPerformed(evt);
            }
        });

        btnReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/reload.png"))); // NOI18N
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReloadMouseClicked(evt);
            }
        });
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lb.setText("Gestión de Usuarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lb)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lb)
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
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
                if (!procesoEnCurso) {
                procesoEnCurso = true; 

                    CompletableFuture<Boolean> deleteFuture = PersonasController.deleteCodigoPersona(id.toString());

                    // Manejar la respuesta de la API
                    deleteFuture.thenAccept(deleted -> {
                        if (deleted) {
                            // Registro eliminado con éxito
                            Message obj = new Message();
                            obj.txtTitle.setText("Aviso");
                            obj.txtContent.setText("Persona eliminada exitosamente");
                            obj.eventOK(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    deleteAllTableRows(table1);
                                    cargarDatos();
                                    GlassPanePopup.closePopupLast();
                                }
                            });
                            GlassPanePopup.showPopup(obj);
                            procesoEnCurso = false; 
                        } else {
                            // Ocurrió un error al eliminar el registro
                            Message obj = new Message();
                            obj.txtTitle.setText("Aviso");
                            obj.txtContent.setText("Error al eliminar la persona, intente nuevamente.");
                            obj.eventOK(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {

                                    GlassPanePopup.closePopupLast();
                                }
                            });
                            GlassPanePopup.showPopup(obj);
                              procesoEnCurso = false; 
                        }
                    });

                    GlassPanePopup.closePopupLast();
                    
                                                    }else{System.out.println("Le dio DOs veces xd");}
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

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        if (evt.getClickCount() == 1)
        {
              // TODO add your handling code here:

        int indx = table1.getSelectedRow();
        if (indx == -1) {
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
        } else {
            try {
                MessageEditPersonas obj = new MessageEditPersonas(myPersonas.get(indx), this);

                obj.txtTitle.setText("Actualizar Estudiante");

                GlassPanePopup.showPopup(obj);
playAbrir();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        }
        else 
        { 
            Notifications.getInstance().clearAll();
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Dar solo una vez al botón");
                playError();
        }
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked

    }//GEN-LAST:event_btnAddMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:

        MessageAddPersonas obj = new MessageAddPersonas(this);
        obj.txtTitle.setText("Añadir Credencial");
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Click OK");
                deleteAllTableRows(table1);
                cargarDatos();
                GlassPanePopup.closePopupLast();
            }
        });
        GlassPanePopup.showPopup(obj);

playAbrir();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
      
    }//GEN-LAST:event_btnEditActionPerformed

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
            // Crea un filtro para mostrar solo las filas cuyo nombre de estudiante contiene el texto de búsqueda.
            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i).*" + textoBusqueda + ".*", indice); // 1 representa la columna del estudiante
            rowSorter.setRowFilter(rowFilter);


        }
    }//GEN-LAST:event_BuscadorKeyTyped

    private void cbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSearchActionPerformed

    private void playError() {
        String filepath = "src/View/sounds/error.wav";

        PlayMusic(filepath);

    }
    
    private void btnReloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReloadMouseClicked
        // TODO add your handling code here:
     
        if(btnReload.isEnabled() ==false){
            
           Notifications.getInstance().clearAll();
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Espere un momento");
                playError();
        }
        else{
            deleteAllTableRows(table1);
        cargarDatos();
        
        btnReload.setEnabled(false);
        
        Timer timer = new Timer(6000, (ActionEvent e) -> { 
                    
                     btnReload.setEnabled(true);
        });
                timer.setRepeats(false);
                timer.start();
        
        }
        
    }//GEN-LAST:event_btnReloadMouseClicked

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnReloadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.CustomTextField Buscador;
    private View.BotonesText.Buttons btnAdd;
    private View.BotonesText.Buttons btnDelete;
    private View.BotonesText.Buttons btnEdit;
    private View.BotonesText.Buttons btnReload;
    private View.BotonesText.CustomComboBox cbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb;
    public View.ExampleTable.Table table1;
    // End of variables declaration//GEN-END:variables
}
