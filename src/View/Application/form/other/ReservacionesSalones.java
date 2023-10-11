/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Application.form.other;

import Reportes.ConexionSQL;
import View.glasspanepopup.GlassPanePopup;
import View.samplemessage.Message;
import View.samplemessage.MessageAddCodigosDisciplinarios;
import View.samplemessage.MessageAddRangoHoras;
import View.samplemessage.MessageAddSalones;
import View.samplemessage.MessageAddTipoCodigos;
import View.samplemessage.MessageEditCodigosDisciplinarios;
import View.samplemessage.MessageEditRangoHoras;
import View.samplemessage.MessageEditSalones;
import View.samplemessage.MessageEditTipoCodigos;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import expoescritorio.Controller.ControllerFull;
import static expoescritorio.Controller.Funciones.GetInasisitencias;
import static expoescritorio.Controller.Funciones.GetReservacionesSalones;
import static expoescritorio.Controller.RangosHorasController.getRangoHorasApiAsync;
import expoescritorio.Controller.SalonesController;
import static expoescritorio.Controller.SalonesController.getSalonesApiAsync;
import expoescritorio.Controller.TiposCodigosConductualesController;
import expoescritorio.Models.Inasisitenciastring;
import expoescritorio.Models.RangosHoras;
import expoescritorio.Models.ReservacionesSalonestring;
import expoescritorio.Models.Salones;
import expoescritorio.Models.TiposCodigosConductuales;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.Timer;
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
import org.json.JSONException;
import org.json.JSONObject;
import raven.toast.Notifications;

/**
 *
 * @author educs
 */
public class ReservacionesSalones extends javax.swing.JPanel {
         private boolean procesoEnCurso = false;
 private TableRowSorter<DefaultTableModel> rowSorter;
    /**
     * Creates new form TiposCodigos
     */
    public ReservacionesSalones() {
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
        
        Timer timer = new Timer(1500, (ActionEvent e) -> { 
                    
                     btnReload.setEnabled(true);
        });
                timer.setRepeats(false);
                timer.start();
        
        
        
        
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        // Obtén el modelo de la tabla existente
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        // Establece los "ColumnIdentifiers" en el modelo de la tabla
        tableModel.setColumnIdentifiers(new Object[]{"ID", "Motivo","Docente","Fecha", "Hora","Salón", "Estado"});
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
                    }
                else{
                      
                    }
                }
                super.insertString(offset, str, attr);
            }
        });
    }
    
       private void mostrarReporte() {
        try {
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Inasistencias.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, ConexionSQL.getConexion());

            JasperViewer view = new JasperViewer(jprint, false);
            view.setTitle("Nombre Reporte");
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            ex.getMessage();
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new View.ExampleTable.Table();
        btnDelete = new View.BotonesText.Buttons();
        btnEdit1 = new View.BotonesText.Buttons();
        Buscador = new View.BotonesText.CustomTextField();
        jLabel1 = new javax.swing.JLabel();
        btnReload = new View.BotonesText.Buttons();
        cbSearch = new View.BotonesText.CustomComboBox();

        lb.setText("Gestión de las Reservaciones de salones");
        lb.setToolTipText("");

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

        btnEdit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/edit.png"))); // NOI18N
        btnEdit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEdit1MouseClicked(evt);
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

        btnReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/reload.png"))); // NOI18N
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReloadMouseClicked(evt);
            }
        });

        cbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Motivo", "Docente", "Salón", "Estado" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lb.getAccessibleContext().setAccessibleName("Gestión Reservaciones de salones");
    }// </editor-fold>//GEN-END:initComponents

    public void deleteAllTableRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

public void cargarDatosAsync() {
    GetReservacionesSalones()
        .thenAccept(encargadosList -> {
            DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
            for (ReservacionesSalonestring tipoCodigo : encargadosList) {
                 String estadoTexto = tipoCodigo.getEstado() == 1 ? "Pendiente" : "Aceptada";
                
                tableModel.addRow(new Object[]{
                    tipoCodigo.getIdReservacionSalon(),
                    tipoCodigo.getMotivoReserva(),
                    tipoCodigo.getReservante(),
                    tipoCodigo.getFecha(),
                    tipoCodigo.getInicio(),
                    tipoCodigo.getSalon(),
                    estadoTexto, 
                    
                   
                });
            }
        })
        .exceptionally(throwable -> {
            throwable.printStackTrace();
            return null;
        });
}

public int ActualizarDatos(int id ){
    procesoEnCurso = true;
 try {
            JSONObject jsonData = new JSONObject();
            jsonData.put("idReservacionSalon", id);
            jsonData.put("estado", 0);

            // Llamar al método putApiAsync para enviar los datos de actualización
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/ReservacionesSalones/update"; // Reemplaza esto con la URL de tu API
            String jsonString = jsonData.toString();
            CompletableFuture<Boolean> putFuture = ControllerFull.putApiAsync(endpointUrl, jsonString);
            putFuture.thenAccept(success -> {
                if (success) {
                    // La solicitud PUT fue exitosa
                    System.out.println("Datos actualizados correctamente en la API");
                    
                    procesoEnCurso = false;
                } else {
                    // La solicitud PUT falló
                    System.out.println("Error al actualizar los datos en la API");
                     procesoEnCurso = false;
                }
            });
            return 1; 
        } catch (JSONException e) {
           
            System.out.println("Error al crear el objeto JSON: " + e.getMessage());
             procesoEnCurso = false;
            return 0;
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
    

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
       // TODO add your handling code here:

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
                if (!procesoEnCurso) {
                procesoEnCurso = true; 

                    String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/ReservacionesSalones/delete";
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

                                    cargarDatosAsync();
                                    deleteAllTableRows(table1);
                                    GlassPanePopup.closePopupLast();
                                }
                            });
                            GlassPanePopup.showPopup(obj);
                                                        procesoEnCurso = false; 

                        } else {
                            // Ocurrió un error al eliminar el registro
                            Message obj = new Message();
                            obj.txtTitle.setText("Aviso");
                            obj.txtContent.setText("Error al eliminar el Registro, intente nuevamente.");
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

    private void btnEdit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEdit1MouseClicked
       int selectedRow = table1.getSelectedRow();
    if (selectedRow != -1) {
        Object id = table1.getValueAt(selectedRow, 0);
        Object Estado = table1.getValueAt(selectedRow, 6);
        String Estado1 = Estado.toString(); 
        if(Estado1 == "Pendiente"){
        System.out.println(id);
        Message obj = new Message();
        obj.txtTitle.setText("Aviso");
        obj.txtContent.setText("¿Desea Actualizar el estado del registro?");
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!procesoEnCurso){
                int updateResult = ActualizarDatos((int) id);
                GlassPanePopup.closePopupLast();
                if (updateResult == 1) { 
                    procesoEnCurso = true; 
                            Message obj = new Message();
                            obj.txtTitle.setText("Aviso");
                            obj.txtContent.setText("Reservaciom Actualizada exitosamente");
                            obj.eventOK(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                     if(!procesoEnCurso){
                                    cargarDatosAsync();
                                    deleteAllTableRows(table1);
                                    GlassPanePopup.closePopupLast();
                                     }
                                }
                            });
                            GlassPanePopup.showPopup(obj);
                            procesoEnCurso = false; 
                } else {
                    // Error al actualizar
                    Message errorMessage = new Message();
                    errorMessage.txtTitle.setText("Aviso");
                    errorMessage.txtContent.setText("Error al actualizar el registro, intente nuevamente.");
                    errorMessage.eventOK(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {

                            GlassPanePopup.closePopupLast();
                        }
                    });
                    GlassPanePopup.showPopup(errorMessage);
                    
                }
                }
                else {
                    System.out.println("Dio DOble click");}
            }
        });
        GlassPanePopup.showPopup(obj);
        playAbrir();
        }
        else{
        Message obj = new Message();
        obj.txtTitle.setText("Aviso");
        obj.txtContent.setText("La reservación ya se encuentra aceptada");
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Click OK");
                GlassPanePopup.closePopupLast();
            }
        });
        GlassPanePopup.showPopup(obj);
        }
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

    }//GEN-LAST:event_btnEdit1MouseClicked

    private void BuscadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorKeyPressed
    // TODO add your handling code here:
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
            int valor  ;
            if (indice == 2) {
            valor = 5;
            }
            else if (indice == 3) {
            valor = 6;
            } 
            else {
              valor = indice + 1;
            }
            
            // Crea un filtro para mostrar solo las filas cuyo nombre de estudiante contiene el texto de búsqueda.
            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i).*" + textoBusqueda + ".*", valor); // 1 representa la columna del estudiante
            rowSorter.setRowFilter(rowFilter);
           
        }    
    }//GEN-LAST:event_BuscadorKeyTyped

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
        cargarDatosAsync();
        
        btnReload.setEnabled(false);
        
        Timer timer = new Timer(1500, (ActionEvent e) -> { 
                    
                     btnReload.setEnabled(true);
        });
                timer.setRepeats(false);
                timer.start();
        
        }
        
    }//GEN-LAST:event_btnReloadMouseClicked

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
           if (evt.getClickCount() == 2)
        {
        DetReservaSalones obj =new DetReservaSalones(this);
        int index = table1.getSelectedRow();
        TableModel model = table1.getModel();
        String id = model.getValueAt(index, 0).toString();
        String motivo = model.getValueAt(index, 1).toString();
        String Docente = model.getValueAt(index, 2).toString();
        String Fecha = model.getValueAt(index, 3).toString();
        String Inicio = model.getValueAt(index, 4).toString();
        String salon = model.getValueAt(index, 5).toString();
        String Estado = model.getValueAt(index, 6).toString();
        
         obj.lbIdent.setText(id);
         obj.lbMotivo.setText(motivo);
         obj.lbDocente.setText(Docente);
         obj.lbFecha.setText(Fecha);
         obj.lbHora.setText(Inicio);
         obj.lbSalon.setText(salon);
         obj.lbEstado.setText(Estado);
         GlassPanePopup.showPopup(obj);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_table1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.CustomTextField Buscador;
    private View.BotonesText.Buttons btnDelete;
    private View.BotonesText.Buttons btnEdit1;
    private View.BotonesText.Buttons btnReload;
    private View.BotonesText.CustomComboBox cbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb;
    public View.ExampleTable.Table table1;
    // End of variables declaration//GEN-END:variables
}
