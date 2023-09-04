package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase CodigosConductualesPersonas
@Data
public class CodigosConductualesPersonas {
    // Declarar campos de instancia para almacenar información relacionada con los códigos conductuales de las personas.
    int idCodigoConductualPersona;  // Identificador único del registro de código conductual de una persona.
    int idEstudiante;               // Identificador del estudiante relacionado con el registro.
    int idCodigoConductual;         // Identificador del código conductual relacionado con el registro.
    int idDocente;                  // Identificador del docente relacionado con el registro.
    int idPeriodo;                  // Identificador del período relacionado con el registro.
    String fecha;                   // Fecha asociada al registro.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public CodigosConductualesPersonas(int idCodigoConductualPersona, int idEstudiante, int idCodigoConductual, int idDocente, int idPeriodo, String fecha) {
        this.idCodigoConductualPersona = idCodigoConductualPersona;
        this.idEstudiante = idEstudiante;
        this.idCodigoConductual = idCodigoConductual;
        this.idDocente = idDocente;
        this.idPeriodo = idPeriodo;
        this.fecha = fecha;
    }
}

