package expoescritorio.Models;
// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Especialidades
@Data
public class Especialidades {
    // Declarar campos de instancia para almacenar información relacionada con las especialidades.
    int idEspecialidad;       // Identificador único de la especialidad.
    String especialidad;      // Nombre o descripción de la especialidad.

    // Constructor de la clase que toma dos parámetros para inicializar los campos.
    public Especialidades(int idEspecialidad, String especialidad) {
        this.idEspecialidad = idEspecialidad;
        this.especialidad = especialidad;
    }
}

