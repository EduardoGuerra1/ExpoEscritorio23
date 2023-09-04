package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase CodigosConductualesString
@Data
public class CodigosConductualesString {
    // Declarar campos de instancia para almacenar información relacionada con los códigos conductuales en formato String.
    int idCodigoConductualPersona;  // Identificador único del registro de código conductual de una persona.
    String Estudiante;             // Nombre del estudiante relacionado con el registro en formato String.
    String CodigoConductual;       // Código conductual en formato String.
    String tipoCodigoConductual;   // Tipo de código conductual en formato String.
    String Docente;                // Nombre del docente relacionado con el registro en formato String.
    int idPeriodo;                 // Identificador del período relacionado con el registro.
    String fecha;                  // Fecha asociada al registro en formato String.
    int idEstudiante;              // Identificador del estudiante relacionado con el registro.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public CodigosConductualesString(int idCodigoConductualPersona, String Estudiante, String CodigoConductual, String tipoCodigoConductual, String Docente, int idPeriodo, String fecha, int idEstudiante) {
        this.idCodigoConductualPersona = idCodigoConductualPersona;
        this.Estudiante = Estudiante;
        this.CodigoConductual = CodigoConductual;
        this.tipoCodigoConductual = tipoCodigoConductual;
        this.Docente = Docente;
        this.idPeriodo = idPeriodo;
        this.fecha = fecha;
        this.idEstudiante = idEstudiante;
    }
}

