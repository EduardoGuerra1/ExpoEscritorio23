package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase CodigoRecuperacion
@Data
public class CodigoRecuperacion {
    // Declarar un campo de instancia llamado 'Codigo' para almacenar un código de recuperación.
    String Codigo;

    // Constructor que toma un parámetro 'Codigo' para inicializar la instancia de la clase.
    public CodigoRecuperacion(String Codigo) {
        this.Codigo = Codigo;
    }

    // Método getter para obtener el valor del campo 'Codigo'.
    public String getCodigo() {
        return Codigo;
    }

    // Constructor vacío por defecto.
    public CodigoRecuperacion() {
    }
}

