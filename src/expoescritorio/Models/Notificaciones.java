package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Notificaciones
@Data
public class Notificaciones {
    // Declarar campos de instancia para almacenar información relacionada con las notificaciones.
    int idNotificacion;          // Identificador único de la notificación.
    String detalle;              // Detalle o contenido de la notificación.
    int idTipoNotificacion;      // Identificador del tipo de notificación.
    int idPersona;               // Identificador de la persona relacionada con la notificación.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public Notificaciones(int idNotificacion, String detalle, int idTipoNotificacion, int idPersona) {
        this.idNotificacion = idNotificacion;
        this.detalle = detalle;
        this.idTipoNotificacion = idTipoNotificacion;
        this.idPersona = idPersona;
    }
}

