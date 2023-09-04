package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Notificacionesstring
@Data
public class Notificacionesstring {
    // Declarar campos de instancia para almacenar información relacionada con las notificaciones en formato de texto.
    int idInasistencia;          // Identificador único de la notificación.
    String detalle;              // Detalle o contenido de la notificación.
    String TipoNotificacion;     // Tipo de notificación (por ejemplo, tipo de mensaje).
    int idPersona;               // Identificador de la persona relacionada con la notificación.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public Notificacionesstring(int idInasistencia, String detalle, String TipoNotificacion, int idPersona) {
        this.idInasistencia = idInasistencia;
        this.detalle = detalle;
        this.TipoNotificacion = TipoNotificacion;
        this.idPersona = idPersona;
    }
}

