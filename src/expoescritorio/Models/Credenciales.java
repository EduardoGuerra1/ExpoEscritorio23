package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

import java.util.Date;

// Declarar la clase Credenciales
@Data
public class Credenciales {
    // Declarar campos de instancia para almacenar información relacionada con las credenciales de una persona.
    int idPersona;                     // Identificador único de la persona.
    String codigo;                     // Código asociado a la persona.
    String nombrePersona;              // Nombre de la persona.
    String apellidoPersona;            // Apellido de la persona.
    String nacimientoPersona;          // Fecha de nacimiento de la persona (puede ser reformulada para utilizar el tipo Date).
    int idTipoPersona;                 // Identificador del tipo de persona.
    String correo;                     // Correo electrónico de la persona.
    String claveCredenciales;          // Clave o contraseña de las credenciales de la persona.
    byte[] foto;                       // Datos binarios de la foto de la persona.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public Credenciales(int idPersona, String codigo, String nombrePersona, String apellidoPersona, String nacimientoPersona,
                        int idTipoPersona, String correo, String claveCredenciales, byte[] foto) {
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
