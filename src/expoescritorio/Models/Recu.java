package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Recu
@Data
public class Recu {
    // Declarar campos de instancia para almacenar información relacionada con los recus.
    int idPersona;         // Identificador único de la persona.
    int idTipoPersona;     // Identificador del tipo de persona.
    String correo;         // Dirección de correo electrónico de la persona.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public Recu(int idPersona, int idTipoPersona, String correo) {
        this.idPersona = idPersona;
        this.idTipoPersona = idTipoPersona;
        this.correo = correo;
    }
}
