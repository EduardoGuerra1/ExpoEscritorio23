package expoescritorio.Models;


// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase NivelesCodigosConductuales
@Data
public class NivelesCodigosConductuales {
    // Declarar campos de instancia para almacenar información relacionada con los niveles de códigos conductuales.
    int idNivelCodigoConductual;     // Identificador único del nivel de código conductual.
    String nivelCodigoConductual;    // Nombre o descripción del nivel de código conductual.

    // Constructor de la clase que toma dos parámetros para inicializar los campos.
    public NivelesCodigosConductuales(int idNivelCodigoConductual, String nivelCodigoConductual) {
        this.idNivelCodigoConductual = idNivelCodigoConductual;
        this.nivelCodigoConductual = nivelCodigoConductual;
    }
}
