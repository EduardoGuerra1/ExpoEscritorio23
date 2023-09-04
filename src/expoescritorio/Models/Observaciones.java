package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Observaciones
@Data
public class Observaciones {
    // Declarar campos de instancia para almacenar información relacionada con las observaciones.
    int idObservacion;           // Identificador único de la observación.
    int idEstudiante;            // Identificador del estudiante relacionado con la observación.
    int idDocente;               // Identificador del docente relacionado con la observación.
    int idPeriodo;               // Identificador del período relacionado con la observación.
    String fecha;                // Fecha de la observación en formato de texto.
    String detalle;              // Detalle o contenido de la observación.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public Observaciones(int idObservacion, int idEstudiante, int idDocente, int idPeriodo, String fecha, String detalle) {
        this.idObservacion = idObservacion;
        this.idEstudiante = idEstudiante;
        this.idDocente = idDocente;
        this.idPeriodo = idPeriodo;
        this.fecha = fecha;
        this.detalle = detalle;
    }
}

