package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase CodigosString
@Data
public class CodigosString {
    // Declarar campos de instancia para almacenar información relacionada con los códigos en formato String.
    int idCodigoConductual;          // Identificador único del código conductual.
    String nivelCodigoConductual;    // Nivel del código conductual en formato String.
    String codigoConductual;         // Código conductual en formato String.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public CodigosString(int idCodigoConductual, String nivelCodigoConductual, String codigoConductual) {
        this.idCodigoConductual = idCodigoConductual;
        this.nivelCodigoConductual = nivelCodigoConductual;
        this.codigoConductual = codigoConductual;
    }
}
