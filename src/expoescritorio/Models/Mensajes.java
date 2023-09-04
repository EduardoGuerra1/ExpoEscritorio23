package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Mensajes
@Data
public class Mensajes {
    // Declarar un campo de instancia para almacenar un mensaje de texto.
    String messages;  // Mensaje de texto.

    // Constructor de la clase que toma un parámetro para inicializar el campo.
    public Mensajes(String messages) {
        this.messages = messages;
    }
}

