package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Inasisitenciastring
@Data
public class Inasisitenciastring {
    // Declarar campos de instancia para almacenar información relacionada con la inasistencia en formato de texto.
    int idInasistencia;            // Identificador único de la inasistencia.
    String TipoLlegadaTarde;       // Tipo de llegada tarde (por ejemplo, motivo de la inasistencia).
    String Estudiante;             // Nombre o descripción del estudiante.
    String Docente;                // Nombre o descripción del docente relacionado con la inasistencia.
    int idPeriodo;                 // Identificador del período relacionado con la inasistencia.
    int estado;                    // Estado de la inasistencia (por ejemplo, aprobada, pendiente).
    String fecha;                  // Fecha de la inasistencia en formato de texto.
    int idEstudiante;              // Identificador del estudiante relacionado con la inasistencia.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public Inasisitenciastring(int idInasistencia, String TipoLlegadaTarde, String Estudiante, String Docente, int idPeriodo, int estado, String fecha, int idEstudiante) {
        this.idInasistencia = idInasistencia;
        this.TipoLlegadaTarde = TipoLlegadaTarde;
        this.Estudiante = Estudiante;
        this.Docente = Docente;
        this.idPeriodo = idPeriodo;
        this.estado = estado;
        this.fecha = fecha;
        this.idEstudiante = idEstudiante;
    }
}

