package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;
import java.util.Date;

// Declarar la clase TiposLlegadasTarde
@Data
public class TiposLlegadasTarde {
    // Declarar campos de instancia para almacenar información relacionada con los tipos de llegadas tarde.
    int idTipoLlegadaTarde;    // Identificador único del tipo de llegada tarde.
    String TipoLlegadaTarde;   // Descripción o nombre del tipo de llegada tarde.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public TiposLlegadasTarde(int idTipoLlegadaTarde, String TipoLlegadaTarde) {
        this.idTipoLlegadaTarde = idTipoLlegadaTarde;
        this.TipoLlegadaTarde = TipoLlegadaTarde;
    }
}

