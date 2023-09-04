package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase TiposInasistencias
@Data
public class TiposInasistencias {
    // Declarar campos de instancia para almacenar información relacionada con los tipos de inasistencias.
    int idTipoInasistencia;    // Identificador único del tipo de inasistencia.
    String tipoInasistencias;  // Descripción o nombre del tipo de inasistencia.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public TiposInasistencias(int idTipoInasistencia, String tipoInasistencias) {
        this.idTipoInasistencia = idTipoInasistencia;
        this.tipoInasistencias = tipoInasistencias;
    }
}

