package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase LlegadasTardeString
@Data
public class LlegadasTardeString {
    // Declarar campos de instancia para almacenar información relacionada con las llegadas tarde en formato de texto.
    int idLlegadaTarde;           // Identificador único de la llegada tarde.
    String TipoLlegadaTarde;      // Tipo de llegada tarde (por ejemplo, motivo de la llegada tarde).
    String Estudiante;            // Nombre o descripción del estudiante.
    int idPeriodo;                // Identificador del período relacionado con la llegada tarde.
    String Docente;               // Nombre o descripción del docente relacionado con la llegada tarde.
    int estado;                   // Estado de la llegada tarde (por ejemplo, aprobada, pendiente).
    String fecha;                 // Fecha de la llegada tarde en formato de texto.
    int idEstudiante;             // Identificador del estudiante relacionado con la llegada tarde.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public LlegadasTardeString(int idLlegadaTarde, String TipoLlegadaTarde, String Estudiante, int idPeriodo, String Docente, int estado, String fecha, int idEstudiante) {
        this.idLlegadaTarde = idLlegadaTarde;
        this.TipoLlegadaTarde = TipoLlegadaTarde;
        this.Estudiante = Estudiante;
        this.idPeriodo = idPeriodo;
        this.Docente = Docente;
        this.estado = estado;
        this.fecha = fecha;
        this.idEstudiante = idEstudiante;
    }
}
