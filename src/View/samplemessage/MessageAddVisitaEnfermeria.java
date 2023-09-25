/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.samplemessage;

import View.Application.form.other.CodigosDisciplinarios;
import View.glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.FlatClientProperties;
import expoescritorio.Controller.ControllerFull;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.Timer;
import org.json.JSONException;
import org.json.JSONObject;
import raven.toast.Notifications;
import Services.Validaciones;
import View.Application.form.other.VisitasEnfermeria;
import expoescritorio.Controller.PeriodosController;
import expoescritorio.Controller.PersonasController;
import static expoescritorio.Controller.PersonasController.getPersonasAsync;
import expoescritorio.Models.Periodos;
//import  expoescritorio.Controller.PersonasController.getPersonasAsync;
import expoescritorio.Models.Personas;
import expoescritorio.Models.PersonasLo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author educs
 */
public class MessageAddVisitaEnfermeria extends javax.swing.JPanel {
       List<PersonasLo> listaIdPersonas = new ArrayList<>();
       List<PersonasLo> mySearch = new ArrayList<PersonasLo>();
       List<Periodos> periodos = new ArrayList<Periodos>();
       private TableRowSorter<DefaultTableModel> rowSorter;
       
       private Boolean noti;
       VisitasEnfermeria frm = null;
       
    public MessageAddVisitaEnfermeria(VisitasEnfermeria frmVisitasEnfermeria) {

        initComponents();
        
        cbPeriodo.setVisible(false);
        this.frm = frmVisitasEnfermeria;
        
        setOpaque(false);
        cbPersona.setVisible(false);
        txtTitle.setBackground(new Color(0, 0, 0, 0));
        txtTitle.setOpaque(false);
        txtTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h4.font");
        // Obtener los datos de la API y cargarlos en el ComboBox
        /*CompletableFuture<List<Periodos>> futurePeriodos= PeriodosController.getPeriodosApiAsync();
        
        futurePeriodos.thenAccept(futureList-> {
            // Crear un arreglo de nombres y apellidos para usar en el combobox
            int[] periodo = new int[futureList.size()];
            for (int i = 0; i < futureList.size(); i++) {
                Periodos periodos = futureList.get(i);
                periodo[i]=periodos.getIdPeriodo();
            }

            // Agregar los nombres y apellidos al combobox
            cbPeriodo.setModel(new DefaultComboBoxModel<>(periodo));
        });
        */

        CompletableFuture<List<PersonasLo>> futurePersonas = getPersonasAsync(2);
        
       
        
        mySearch = futurePersonas.join();

        String selectedText = (String) cbPersona.getSelectedItem();
        txtPersona.setText(selectedText);
        
        // Agrega el ActionListener al JComboBox
        cbPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene el elemento seleccionado y actualiza el JTextField
                String selectedText = (String) cbPersona.getSelectedItem();
               int index = selectedText.indexOf(" ");
        if (index != -1) {
        String nombre = selectedText.substring(0, index);
        txtPersona.setText(nombre);
}
            }
        });
        populateComboBox();
        txtVisita.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                for (char c : str.toCharArray()) {
                    if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c) && c != '.') {
                      // Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El campo solo permite números y letras");
                       noti=true;
                      return; // Ignora el carácter si no es letra, número, espacio o punto
                    }
                    else{
                        noti=false;
                    }
                }
                super.insertString(offset, str, attr);
            }
        });
        
        DefaultTableModel tableModel = (DefaultTableModel) tablaAlumnos.getModel();

        // Establece los "ColumnIdentifiers" en el modelo de la tabla
        tableModel.setColumnIdentifiers(new Object[]{"Codigo", "Nombre"});
        cargarDatos();
        tablaAlumnos.setDefaultEditor(Object.class, null);
        tablaAlumnos.getTableHeader().setReorderingAllowed(false);
        rowSorter = new TableRowSorter<>((DefaultTableModel) tablaAlumnos.getModel());
        tablaAlumnos.setRowSorter(rowSorter);

    }
private int compararNombreApellido(String nombre, String apellido, List<Personas> personasList) {
    int nombreEncontrado = 0;
    
    for (Personas persona : personasList) {
        if (persona.getNombrePersona().equals(nombre) && persona.getApellidoPersona().equals(apellido)) {
         nombreEncontrado = persona.getIdPersona();
        }
    }
    
    if (nombreEncontrado != 0) {
        // Realizar la acción deseada con el nombre encontrado
        System.out.println("Nombre encontrado: " + nombreEncontrado);
    } else {
        // Realizar la acción deseada si no se encuentra ninguna coincidencia
        System.out.println("Nombre no encontrado");
    }
    return  nombreEncontrado ;
}
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    private void populateComboBox() {
        // Obtener los periodos desde la API usando el controlador
        List<Periodos> periodosList;
        try {
            periodosList = PeriodosController.getPeriodosApiAsync().get();
            for (Periodos periodo : periodosList) {
                cbPeriodo.addItem(String.valueOf(periodo.getIdPeriodo()));
                periodos.add(periodo);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitle = new javax.swing.JLabel();
        btnCancelar = new View.BotonesText.Buttons();
        btnAceptar = new View.BotonesText.Buttons();
        jLabel1 = new javax.swing.JLabel();
        cbPeriodo = new javax.swing.JComboBox<>();
        cbPersona = new javax.swing.JComboBox<>();
        txtPersona = new View.BotonesText.CustomTextField();
        txtVisita = new View.BotonesText.CustomTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new View.ExampleTable.Table();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTitle.setText("Agregar una visita de enfermeria al estudiante");
        add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 430, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 510, 120, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 120, -1));

        jLabel1.setText("Detalle de visita");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, -1));
        add(cbPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 160, -1));

        cbPersona.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbPersonaPopupMenuWillBecomeVisible(evt);
            }
        });
        add(cbPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 160, -1));

        txtPersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPersonaKeyTyped(evt);
            }
        });
        add(txtPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 540, 50));

        txtVisita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVisitaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVisitaKeyReleased(evt);
            }
        });
        add(txtVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 400, 50));

        jLabel4.setText("Persona");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaAlumnos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 690, 180));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnCancelarMouseClicked

    
    private void playValidacion() {
        String filepath = "src/View/sounds/validacion.wav";

        PlayMusic(filepath);

    }

    private void playError() {
        String filepath = "src/View/sounds/error.wav";

        PlayMusic(filepath);

    }
    //Metodo para reproducir sonidos
    private static void PlayMusic(String location) {
        try {
            File musicPath = new File(location);
            
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();//Codigo para reproducir el clip de audio
            }else{
                System.out.println("No se encuentra el archivo de sonido");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   
    }

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked

       Validaciones valida = new Validaciones();
        if (txtVisita.getText().isEmpty() ) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "El campo no puede estar vacío");
            playError();
        }
          else if (!valida.check30(txtVisita.getText()) ) {
                //Muestra la notificacion y el sonido de error
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "El Campo es muy grande");
                playError();
            }
          else if (tablaAlumnos.getSelectedRow() == -1){
              Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Seleccione un estudiante");
                playError();
          }
          
        else {
                GlassPanePopup.closePopupLast();
            enviarDatosHaciaApi();
             
        }


    }//GEN-LAST:event_btnAceptarMouseClicked

    public void cargarDatos() {
            DefaultTableModel tableModel = (DefaultTableModel) tablaAlumnos.getModel();
            for (PersonasLo item : mySearch) {
                tableModel.addRow(new Object[]{
                    item.getCodigo(),
                    item.getNombrePersona()+" "+item.getApellidoPersona()
                });
            }
    }
    
    private void txtVisitaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVisitaKeyReleased
        // TODO add your handling code here:
        
         if(noti==true){
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El campo solo permite números y letras");
            playValidacion();
        }
    }//GEN-LAST:event_txtVisitaKeyReleased

    private void txtVisitaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVisitaKeyTyped
        // TODO add your handling code here:
       

    }//GEN-LAST:event_txtVisitaKeyTyped

    private void cbPersonaPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbPersonaPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPersonaPopupMenuWillBecomeVisible

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtPersonaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonaKeyTyped
        // TODO add your handling code here:
        
        rowSorter = new TableRowSorter<>((DefaultTableModel) tablaAlumnos.getModel());
        tablaAlumnos.setRowSorter(rowSorter);
        if (txtPersona.getText().isEmpty()) {
            // Si el JTextField está vacío, muestra todas las filas.
            rowSorter.setRowFilter(null);
        } else {
            int index;
            
            String filtro = txtPersona.getText().toLowerCase();
            String ini = ""; 
            ini+=filtro.charAt(0);
                    
                    
            if(Validaciones.onlyLetters(ini)){
                index = 1;
            }
            else index = 0;
            
            // Crea un filtro para mostrar solo las filas cuyo nombre de estudiante contiene el texto de búsqueda.
            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i).*" + filtro + ".*", index); // 1 representa la columna del estudiante
            rowSorter.setRowFilter(rowFilter);

        }
        
    }//GEN-LAST:event_txtPersonaKeyTyped

    public void eventOK(ActionListener event) {
        btnAceptar.addActionListener(event);
        
    }

    private void enviarDatosHaciaApi() {
        int num = 4;
        int num1 = 1;

        
        // Obtener los valores seleccionados del ComboBox y el texto del TextField
        int idTipoCodigoConductual = obtenerIdSeleccionadoComboBox(cbPeriodo);
        // TODO add your handling code here:

        // Obtener la fecha actual del sistema
        Date fechaActual = new Date();

        // Crear un objeto SimpleDateFormat con el formato deseado
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Formatear la fecha en el formato deseado
        String fechaFormateada = sdf.format(fechaActual);

        System.out.println(idTipoCodigoConductual);
 
        try {
            // Crear un objeto JSON con los datos recopilados
            JSONObject jsonData = new JSONObject();
            jsonData.put("idPeriodo", periodos.get(cbPeriodo.getSelectedIndex()).getIdPeriodo());
            jsonData.put("idPersona",  tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 0));
            jsonData.put("fecha", fechaFormateada);
            jsonData.put("detalleVisitia", txtVisita.getText());

            // Llamar al método postApiAsync para enviar los datos
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/VisitasEnfermeria/save"; // Reemplaza esto con la URL de tu API
            String jsonString = jsonData.toString();

            CompletableFuture<Boolean> postFuture = ControllerFull.postApiAsync(endpointUrl, jsonString);

            // Manejar la respuesta de la API
            postFuture.thenAccept(success -> {
                if (success) {
                    // La solicitud POST fue exitosa
                    System.out.println("Datos enviados correctamente a la API");
                    frm.deleteAllTableRows(frm.table1);
                    frm.cargarDatos();

                    // boolean pC = panelClosing() == true;
                    GlassPanePopup.closePopupLast();
Message obj = new Message();
                    obj.txtTitle.setText("Aviso");
                    obj.txtContent.setText("Datos enviados correctamente");
                    obj.eventOK(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            System.out.println("Click OK");
                            GlassPanePopup.closePopupLast();
                        }
                    });
                    GlassPanePopup.showPopup(obj);
                } else {
                    // La solicitud POST falló
                    System.out.println("Error al enviar los datos a la API");
                }
            });
        } catch (JSONException e) {
            // Manejar la excepción JSONException aquí
            System.out.println("Error al crear el objeto JSON: " + e.getMessage());
        }
    }

    private int obtenerIdSeleccionadoComboBox(JComboBox<String> comboBox) {
        
        int selectedIndex = (int) comboBox.getSelectedIndex();
    
    

    
    return selectedIndex;
    }

    public boolean panelClosing() {
        // Realiza las acciones necesarias antes de cerrar el panel
        System.out.println("El panel se va a cerrar.");
        CodigosDisciplinarios cd = new CodigosDisciplinarios();

        cd.cargarDatos();
        cd.deleteAllTableRows(cd.table1);
        return false;
    }
// Método para obtener el ID seleccionado de un JComboBox

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.Buttons btnAceptar;
    private View.BotonesText.Buttons btnCancelar;
    public javax.swing.JComboBox<String> cbPeriodo;
    public javax.swing.JComboBox<String> cbPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public View.ExampleTable.Table tablaAlumnos;
    public View.BotonesText.CustomTextField txtPersona;
    public javax.swing.JLabel txtTitle;
    private View.BotonesText.CustomTextField txtVisita;
    // End of variables declaration//GEN-END:variables
}
