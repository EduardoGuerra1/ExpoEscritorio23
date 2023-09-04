package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase SeccionesBachillerato
@Data
public class SeccionesBachillerato {
    // Declarar campos de instancia para almacenar información relacionada con las secciones de bachillerato.
    int idSeccionBachillerato;    // Identificador único de la sección de bachillerato.
    String seccionBachillerato;   // Nombre o identificador de la sección de bachillerato.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public SeccionesBachillerato(int idSeccionBachillerato, String seccionBachillerato) {
        this.idSeccionBachillerato = idSeccionBachillerato;
        this.seccionBachillerato = seccionBachillerato;
    }
}

