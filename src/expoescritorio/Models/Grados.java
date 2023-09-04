package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Grados
@Data
public class Grados {
    // Declarar campos de instancia para almacenar información relacionada con los grados.
    int idGrado;                   // Identificador único del grado.
    int idNivelAcademico;          // Identificador del nivel académico al que pertenece el grado.
    int idSeccion;                 // Identificador de la sección del grado.
    int idSeccionBachillerato;     // Identificador de la sección de bachillerato del grado.
    int idDocenteEncargado;        // Identificador del docente encargado del grado.
    int idEspecialidad;            // Identificador de la especialidad del grado.
    int idGrupoTecnico;            // Identificador del grupo técnico al que pertenece el grado.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public Grados(int idGrado, int idNivelAcademico, int idSeccion, int idSeccionBachillerato, int idDocenteEncargado, int idEspecialidad, int idGrupoTecnico) {
        this.idGrado = idGrado;
        this.idNivelAcademico = idNivelAcademico;
        this.idSeccion = idSeccion;
        this.idSeccionBachillerato = idSeccionBachillerato;
        this.idDocenteEncargado = idDocenteEncargado;
        this.idEspecialidad = idEspecialidad;
        this.idGrupoTecnico = idGrupoTecnico;
    }
}

