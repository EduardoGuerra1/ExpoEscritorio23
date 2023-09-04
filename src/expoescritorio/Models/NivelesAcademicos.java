package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase NivelesAcademicos
@Data
public class NivelesAcademicos {
    // Declarar campos de instancia para almacenar información relacionada con los niveles académicos.
    int idNivelAcademico;     // Identificador único del nivel académico.
    String nivelAcademico;    // Nombre o descripción del nivel académico.

    // Constructor vacío de la clase.
    public NivelesAcademicos() {
    }

    // Constructor de la clase que toma dos parámetros para inicializar los campos.
    public NivelesAcademicos(int idNivelAcademico, String nivelAcademico) {
        this.idNivelAcademico = idNivelAcademico;
        this.nivelAcademico = nivelAcademico;
    }
}
