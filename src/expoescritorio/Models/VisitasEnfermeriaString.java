package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase VisitasEnfermeriaString
@Data
public class VisitasEnfermeriaString {
    // Campos de instancia para almacenar información sobre la visita de enfermería
    int idVisitaEnfermeria;    // Identificador único de la visita de enfermería.
    String Persona;            // Nombre de la persona relacionada con la visita (en formato de cadena de texto).
    int idPeriodo;             // Identificador del período de tiempo de la visita.
    String fecha;              // Fecha de la visita.
    String detalleVisitia;     // Detalle de la visita de enfermería.
    int idPersona;            // Identificador de la persona relacionada con la visita.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public VisitasEnfermeriaString(int idVisitaEnfermeria, String Persona, int idPeriodo, String fecha, String detalleVisitia, int idPersona) {
        this.idVisitaEnfermeria = idVisitaEnfermeria;
        this.Persona = Persona;
        this.idPeriodo = idPeriodo;
        this.fecha = fecha;
        this.detalleVisitia = detalleVisitia;
        this.idPersona = idPersona;
    }
}
