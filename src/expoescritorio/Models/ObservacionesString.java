package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase ObservacionesString
@Data
public class ObservacionesString {
    // Declarar campos de instancia para almacenar información relacionada con las observaciones en formato de texto.
    int idObservacion;           // Identificador único de la observación.
    String Estudiante;          // Nombre o descripción del estudiante relacionado con la observación.
    String Docente;             // Nombre o descripción del docente relacionado con la observación.
    int idPeriodo;              // Identificador del período relacionado con la observación.
    String fecha;               // Fecha de la observación en formato de texto.
    String detalle;             // Detalle o contenido de la observación.
    int idEstudiante;           // Identificador del estudiante relacionado con la observación.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public ObservacionesString(int idObservacion, String Estudiante, String Docente, int idPeriodo, String fecha, String detalle, int idEstudiante) {
        this.idObservacion = idObservacion;
        this.Estudiante = Estudiante;
        this.Docente = Docente;
        this.idPeriodo = idPeriodo;
        this.fecha = fecha;
        this.detalle = detalle;
        this.idEstudiante = idEstudiante;
    }
}

