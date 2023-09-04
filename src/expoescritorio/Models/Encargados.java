package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Encargados
@Data
public class Encargados {
    // Declarar campos de instancia para almacenar información relacionada con los encargados.
    int idEncargado;                  // Identificador único del encargado.
    String nombrePersona;             // Nombre del encargado.
    String apellidoPersona;           // Apellido del encargado.
    int idPersona;                   // Identificador de la persona relacionada con el encargado.
    String correoEncargado;           // Correo electrónico del encargado.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public Encargados(int idEncargado, String nombrePersona, String apellidoPersona, int idPersona, String correoEncargado) {
        this.idEncargado = idEncargado;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.idPersona = idPersona;
        this.correoEncargado = correoEncargado;
    }
}
