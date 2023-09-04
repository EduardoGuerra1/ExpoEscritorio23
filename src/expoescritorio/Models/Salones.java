package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Salones
@Data
public class Salones {
    // Declarar campos de instancia para almacenar información relacionada con los salones.
    int idSalon;          // Identificador único del salón.
    String codigoSalon;   // Código asociado al salón.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public Salones(int idSalon, String codigoSalon) {
        this.idSalon = idSalon;
        this.codigoSalon = codigoSalon;
    }
}

