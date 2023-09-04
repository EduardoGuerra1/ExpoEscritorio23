package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase TiposPermisos
@Data
public class TiposPermisos {
    // Declarar campos de instancia para almacenar información relacionada con los tipos de permisos.
    int idTipoPermiso;    // Identificador único del tipo de permiso.
    String tipoPermiso;   // Descripción o nombre del tipo de permiso.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public TiposPermisos(int idTipoPermiso, String tipoPermiso) {
        this.idTipoPermiso = idTipoPermiso;
        this.tipoPermiso = tipoPermiso;
    }
}

