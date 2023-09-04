package expoescritorio.Models;

import lombok.Data;

import java.util.Date;

// Declarar la clase TiposCodigosConductuales
@Data
public class TiposCodigosConductuales {
    // Declarar campos de instancia para almacenar información relacionada con los tipos de códigos conductuales.
    int idTipoCodigoConductual;    // Identificador único del tipo de código conductual.
    String tipoCodigoConductual;   // Nombre o descripción del tipo de código conductual.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public TiposCodigosConductuales(int idTipoCodigoConductual, String tipoCodigoConductual) {
        this.idTipoCodigoConductual = idTipoCodigoConductual;
        this.tipoCodigoConductual = tipoCodigoConductual;
    }
}






