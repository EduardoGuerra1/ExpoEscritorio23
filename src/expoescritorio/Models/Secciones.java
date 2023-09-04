package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Secciones
@Data
public class Secciones {
    // Declarar campos de instancia para almacenar información relacionada con las secciones.
    int idSeccion;    // Identificador único de la sección.
    String seccion;   // Nombre o identificador de la sección.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public Secciones(int idSeccion, String seccion) {
        this.idSeccion = idSeccion;
        this.seccion = seccion;
    }
}

