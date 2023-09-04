package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase GruposTecnicos
@Data
public class GruposTecnicos {
    // Declarar campos de instancia para almacenar información relacionada con los grupos técnicos.
    int idGrupoTecnico;     // Identificador único del grupo técnico.
    String grupoTecnico;    // Nombre o descripción del grupo técnico.

    // Constructor de la clase que toma dos parámetros para inicializar los campos.
    public GruposTecnicos(int idGrupoTecnico, String grupoTecnico) {
        this.idGrupoTecnico = idGrupoTecnico;
        this.grupoTecnico = grupoTecnico;
    }
}
