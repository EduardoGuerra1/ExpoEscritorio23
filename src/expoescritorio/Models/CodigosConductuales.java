package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase CodigosConductuales
@Data
public class CodigosConductuales {
    // Declarar campos de instancia para almacenar información relacionada con los códigos conductuales.
    int idCodigoConductual;           // Identificador único del código conductual.
    int idTipoCodigoConductual;       // Identificador del tipo de código conductual.
    int idNivelCodigoConductual;      // Identificador del nivel del código conductual.
    String codigoConductual;          // Código conductual en sí.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public CodigosConductuales(int idCodigoConductual, int idTipoCodigoConductual, int idNivelCodigoConductual, String codigoConductual) {
        this.idCodigoConductual = idCodigoConductual;
        this.idTipoCodigoConductual = idTipoCodigoConductual;
        this.idNivelCodigoConductual = idNivelCodigoConductual;
        this.codigoConductual = codigoConductual;
    }
}
