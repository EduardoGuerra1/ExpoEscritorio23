package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Periodos
@Data
public class Periodos {
    // Declarar campos de instancia para almacenar información relacionada con los períodos.
    int idPeriodo;     // Identificador único del período.
    String inicio;     // Fecha de inicio del período en formato de texto.
    String finals;     // Fecha de finalización del período en formato de texto.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public Periodos(int idPeriodo, String inicio, String finals) {
        this.idPeriodo = idPeriodo;
        this.inicio = inicio;
        this.finals = finals;
    }
}
