package expoescritorio.Models;

/**
 *
 * @author thatsgonzalez
 */

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase ComunicadosModel
@Data
public class ComunicadosModel {
    // Declarar campos de instancia para almacenar información relacionada con los comunicados.
    int idComunicado;   // Identificador único del comunicado.
    int idGrado;        // Identificador del grado al que está dirigido el comunicado.
    String detalle;     // Detalle o contenido del comunicado.
    String fecha;       // Fecha del comunicado.
    String archivo;     // Nombre del archivo adjunto al comunicado.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public ComunicadosModel(int idComunicado, int idGrado, String detalle, String fecha, String archivo) {
        this.idComunicado = idComunicado;
        this.idGrado = idGrado;
        this.detalle = detalle;
        this.fecha = fecha;
        this.archivo = archivo;
    }

    // Constructor vacío por defecto.
    public ComunicadosModel() {
    }
}
