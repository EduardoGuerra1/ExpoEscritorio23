package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase Crede
@Data
public class Crede {
    // Declarar campos de instancia para almacenar información relacionada con las credenciales de una persona.
    private int idPersona;                 // Identificador único de la persona.
    private String codigo;                 // Código asociado a la persona.
    private String nombrePersona;          // Nombre de la persona.
    private String apellidoPersona;        // Apellido de la persona.
    private String nacimientoPersona;      // Fecha de nacimiento de la persona.
    private int idTipoPersona;             // Identificador del tipo de persona.
    private String correo;                 // Correo electrónico de la persona.
    private String claveCredenciales;      // Clave o contraseña de las credenciales de la persona.
    private byte[] foto;                   // Datos binarios de la foto de la persona.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public Crede(int idPersona, String codigo, String nombrePersona, String apellidoPersona, String nacimientoPersona, int idTipoPersona, String correo, String claveCredenciales, byte[] foto) {
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

