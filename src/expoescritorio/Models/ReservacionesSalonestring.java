package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase ReservacionesSalonestring
@Data
public class ReservacionesSalonestring {
    // Declarar campos de instancia para almacenar información relacionada con las reservaciones de salones en formato de texto.
    int idReservacionSalon;  // Identificador único de la reservación del salón.
    String Salon;            // Nombre del salón reservado.
    String Inicio;           // Hora de inicio de la reserva en formato de texto.
    String Final;            // Hora de finalización de la reserva en formato de texto.
    String Reservante;       // Nombre del reservante.
    String motivoReserva;    // Motivo de la reserva del salón.
    int idReservante;        // Identificador del reservante.
    int Estado;              // Estado de la reserva.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public ReservacionesSalonestring(int idReservacionSalon, String Salon, String Inicio, String Final, String Reservante, String motivoReserva, int idReservante, int Estado) {
        this.idReservacionSalon = idReservacionSalon;
        this.Salon = Salon;
        this.Inicio = Inicio;
        this.Final = Final;
        this.Reservante = Reservante;
        this.motivoReserva = motivoReserva;
        this.idReservante = idReservante;
        this.Estado = Estado;
    }
}

