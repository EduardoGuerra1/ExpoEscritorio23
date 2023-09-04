package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

import java.time.DateTimeException;

// Declarar la clase RangosHoras
@Data
public class RangosHoras {
    // Declarar campos de instancia para almacenar información relacionada con los rangos de horas.
    int idRangoHora;     // Identificador único del rango de horas.
    String titulo;       // Título o nombre del rango de horas.
    String inicio;       // Hora de inicio del rango de horas en formato de texto.
    String finals;       // Hora de finalización del rango de horas en formato de texto.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public RangosHoras(int idRangoHora, String titulo, String inicio, String finals) {
        this.idRangoHora = idRangoHora;
        this.titulo = titulo;
        this.inicio = inicio;
        this.finals = finals;
    }
}
