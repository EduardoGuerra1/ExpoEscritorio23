package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase LlegadasTarde
@Data
public class LlegadasTarde {
    // Declarar campos de instancia para almacenar información relacionada con las llegadas tarde.
    int idLlegadaTarde;          // Identificador único de la llegada tarde.
    int idTipoLlegadaTarde;      // Identificador del tipo de llegada tarde (motivo).
    int idEstudiante;            // Identificador del estudiante relacionado con la llegada tarde.
    int idPeriodo;               // Identificador del período relacionado con la llegada tarde.
    int idDocente;               // Identificador del docente relacionado con la llegada tarde.
    String estado;               // Estado de la llegada tarde (por ejemplo, aprobada, pendiente).
    String fecha;                // Fecha de la llegada tarde en formato de texto.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public LlegadasTarde(int idLlegadaTarde, int idTipoLlegadaTarde, int idEstudiante, int idPeriodo, int idDocente, String estado, String fecha) {
        this.idLlegadaTarde = idLlegadaTarde;
        this.idTipoLlegadaTarde = idTipoLlegadaTarde;
        this.idEstudiante = idEstudiante;
        this.idPeriodo = idPeriodo;
        this.idDocente = idDocente;
        this.estado = estado;
        this.fecha = fecha;
    }
}
 