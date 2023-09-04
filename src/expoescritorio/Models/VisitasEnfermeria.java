package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase VisitasEnfermeria
@Data
public class VisitasEnfermeria {
    // Campos de instancia para almacenar información sobre la visita de enfermería
    int idVisitaEnfermeria;    // Identificador único de la visita de enfermería.
    int idPersona;             // Identificador de la persona relacionada con la visita.
    int idPeriodo;             // Identificador del período de tiempo de la visita.
    String fecha;              // Fecha de la visita.
    String detalleVisitia;     // Detalle de la visita de enfermería.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public VisitasEnfermeria(int idVisitaEnfermeria, int idPersona, int idPeriodo, String fecha, String detalleVisitia) {
        this.idVisitaEnfermeria = idVisitaEnfermeria;
        this.idPersona = idPersona;
        this.idPeriodo = idPeriodo;
        this.fecha = fecha;
        this.detalleVisitia = detalleVisitia;
    }
}
