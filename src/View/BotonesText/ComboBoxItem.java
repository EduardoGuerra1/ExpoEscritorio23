/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.BotonesText;
import java.util.ArrayList;
import java.util.List;

public class ComboBoxItem {
    private String text;

    public ComboBoxItem(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public static List<ComboBoxItem> getDefaultItems() {
        List<ComboBoxItem> items = new ArrayList<>();
        items.add(new ComboBoxItem("Codigo"));
        items.add(new ComboBoxItem("Nombre"));
        items.add(new ComboBoxItem("Tipo Persona"));
        items.add(new ComboBoxItem("Correo"));
        return items;
    }
}
