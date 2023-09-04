package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Personas
@Data
public class Personas {
    // Declarar campos de instancia para almacenar información relacionada con las personas.
    private int idPersona;             // Identificador único de la persona.
    private String codigo;             // Código asociado a la persona.
    private String nombrePersona;      // Nombre de la persona.
    private String apellidoPersona;    // Apellido de la persona.
    private String nacimientoPersona;  // Fecha de nacimiento de la persona en formato de texto.
    private int idTipoPersona;         // Identificador del tipo de persona.
    private String correo;             // Dirección de correo electrónico de la persona.
    private String claveCredenciales;  // Clave o contraseña de credenciales de la persona.
    private String foto;               // URL o ubicación de la foto de la persona.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public Personas(int idPersona, String codigo, String nombrePersona, String apellidoPersona, String nacimientoPersona, int idTipoPersona, String correo, String claveCredenciales, String foto) {
        this.idPersona = idPersona;
        this.codigo = codigo;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.nacimientoPersona = nacimientoPersona;
        this.idTipoPersona = idTipoPersona;
        this.correo = correo;
        this.claveCredenciales = claveCredenciales;
        this.foto = foto;
    }
}

