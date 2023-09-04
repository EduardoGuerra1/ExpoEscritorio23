package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase GradosView
@Data
public class GradosView {
    // Declarar campos de instancia para almacenar información relacionada con los grados en formato de texto.
    int idGrado;                          // Identificador único del grado.
    String idNivelAcademico;              // Nombre o descripción del nivel académico.
    String idSeccion;                     // Nombre o descripción de la sección.
    String idSeccionBachillerato;         // Nombre o descripción de la sección de bachillerato.
    String idDocenteEncargado;            // Nombre o descripción del docente encargado.
    String idEspecialidad;                // Nombre o descripción de la especialidad.
    String idGrupoTecnico;                // Nombre o descripción del grupo técnico.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public GradosView(int idGrado, String idNivelAcademico, String idSeccion, String idSeccionBachillerato, String idDocenteEncargado, String idEspecialidad, String idGrupoTecnico) {
        this.idGrado = idGrado;
        this.idNivelAcademico = idNivelAcademico;
        this.idSeccion = idSeccion;
        this.idSeccionBachillerato = idSeccionBachillerato;
        this.idDocenteEncargado = idDocenteEncargado;
        this.idEspecialidad = idEspecialidad;
        this.idGrupoTecnico = idGrupoTecnico;
    }
}

