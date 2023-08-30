/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.samplemessage;

import Services.Validaciones;
import View.Application.form.other.CodigosDisciplinarios;
import View.Application.form.other.SalonesPantalla;
import View.Application.form.other.TiposCodigos;
import View.glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.FlatClientProperties;
import com.kitfox.svg.A;
import expoescritorio.Controller.CodigosConductualesController;
import expoescritorio.Controller.ControllerFull;
import expoescritorio.Controller.NivelesCodigosConductualesController;
import expoescritorio.Controller.TiposCodigosConductualesController;
import expoescritorio.Models.CodigosConductuales;
import expoescritorio.Models.NivelesCodigosConductuales;
import expoescritorio.Models.TiposCodigosConductuales;
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
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import org.json.JSONException;
import org.json.JSONObject;
import raven.toast.Notifications;

/**
 *
 * @author educs
 */
public class MessageEditSalones extends javax.swing.JPanel {

    public int id;

    public MessageEditSalones() {

        initComponents();
        setOpaque(false);

        txtTitle.setBackground(new Color(0, 0, 0, 0));
        txtTitle.setOpaque(false);
        txtTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h4.font");
        txtTipoCodigo.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                for (char c : str.toCharArray()) {
                    if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c) && c != '.') {
                        Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El campo solo permite números y letras");

                        return; // Ignora el carácter si no es letra, número, espacio o punto
                    }
                }
                super.insertString(offset, str, attr);
            }
        });
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitle = new javax.swing.JLabel();
        btnCancelar = new View.BotonesText.Buttons();
        btnAceptar = new View.BotonesText.Buttons();
        jLabel2 = new javax.swing.JLabel();
        txtTipoCodigo = new View.BotonesText.CustomTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTitle.setText("Your Message Title Dialog Custom");
        add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 120, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 120, -1));

        jLabel2.setText("Codigo De Salon:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));
        jLabel2.getAccessibleContext().setAccessibleName("Codigo de Salon:");

        add(txtTipoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 400, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:

       Validaciones valida = new Validaciones();
        if (txtTipoCodigo.getText().isEmpty() ) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El campo no puede estar vacío");
        }else {
            if (!valida.check6(txtTipoCodigo.getText()) ) {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "El Campo es muy grande");
            }
            else{
            actualizarDatosHaciaApi();
            Timer timer = new Timer(500, (ActionEvent e) -> {
                SalonesPantalla tc = new SalonesPantalla();
                tc.cargarDatosAsync();
                tc.deleteAllTableRows(tc.table1);
            });
            timer.setRepeats(false);
            timer.start();
            }
        }


    }//GEN-LAST:event_btnAceptarMouseClicked

    public void eventOK(ActionListener event) {
        btnAceptar.addActionListener(event);
    }

    public void actualizarDatosHaciaApi() {
        String codigoSalon = txtTipoCodigo.getText();

        try {
            // Crear un objeto JSON con los datos recopilados
            JSONObject jsonData = new JSONObject();
            jsonData.put("idSalon", id);
            jsonData.put("codigoSalon", codigoSalon);

            // Llamar al método putApiAsync para enviar los datos de actualización
            String endpointUrl = "https://expo2023-6f28ab340676.herokuapp.com/Salones/update"; // Reemplaza esto con la URL de tu API
            String jsonString = jsonData.toString();

            CompletableFuture<Boolean> putFuture = ControllerFull.putApiAsync(endpointUrl, jsonString);

            // Manejar la respuesta de la API
            putFuture.thenAccept(success -> {
                if (success) {
                    // La solicitud PUT fue exitosa
                    System.out.println("Datos actualizados correctamente en la API");

                    // Realizar las acciones necesarias después de la actualización, si es necesario
                } else {
                    // La solicitud PUT falló
                    System.out.println("Error al actualizar los datos en la API");
                }
            });
        } catch (JSONException e) {
            // Manejar la excepción JSONException aquí
            System.out.println("Error al crear el objeto JSON: " + e.getMessage());
        }
    }

// Método para obtener el ID seleccionado de un JComboBox

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.BotonesText.Buttons btnAceptar;
    private View.BotonesText.Buttons btnCancelar;
    private javax.swing.JLabel jLabel2;
    public View.BotonesText.CustomTextField txtTipoCodigo;
    public javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
