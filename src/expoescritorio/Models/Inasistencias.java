package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Inasistencias
@Data
public class Inasistencias {
    // Declarar campos de instancia para almacenar información relacionada con las inasistencias.
    int idInasistencia;         // Identificador único de la inasistencia.
    int idTipoLlegadaTarde;     // Identificador del tipo de llegada tarde (motivo de la inasistencia).
    int idEstudiante;           // Identificador del estudiante relacionado con la inasistencia.
    int idDocente;              // Identificador del docente relacionado con la inasistencia.
    int idPeriodo;              // Identificador del período relacionado con la inasistencia.
    String estado;              // Estado de la inasistencia (por ejemplo, aprobada, pendiente).
    String fecha;               // Fecha de la inasistencia en formato de texto.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public Inasistencias(int idInasistencia, int idTipoLlegadaTarde, int idEstudiante, int idDocente, int idPeriodo, String estado, String fecha) {
        this.idInasistencia = idInasistencia;
        this.idTipoLlegadaTarde = idTipoLlegadaTarde;
        this.idEstudiante = idEstudiante;
        this.idDocente = idDocente;
        this.idPeriodo = idPeriodo;
        this.estado = estado;
        this.fecha = fecha;
    }
}

   

