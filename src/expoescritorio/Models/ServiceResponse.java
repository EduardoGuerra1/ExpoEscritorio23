package expoescritorio.Models;

public class ServiceResponse {
    public Boolean success;  // Campo público para indicar si la operación del servicio fue exitosa (true) o no (false).
    public String message;   // Campo público para almacenar un mensaje relacionado con la respuesta del servicio.

    // Método getter para obtener el valor del campo "message".
    public String getMessage() {
        return message;
    }

    // Método getter para obtener el valor del campo "success".
    public Boolean getSuccess() {
        return success;
    }

    // Método setter para establecer el valor del campo "success".
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    // Método setter para establecer el valor del campo "message".
    public void setMessage(String message) {
        this.message = message;
    }
}

