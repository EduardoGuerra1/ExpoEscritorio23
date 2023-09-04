package expoescritorio.Models;

// Importar la anotación Lombok para generar automáticamente métodos getter, setter, equals, hashCode y toString.
import lombok.Data;

// Declarar la clase ReservacionesSalones
@Data
public class ReservacionesSalones {
    // Declarar campos de instancia para almacenar información relacionada con las reservaciones de salones.
    int idReservacionSalon;  // Identificador único de la reservación del salón.
    int idSalon;             // Identificador del salón reservado.
    int idRangoHora;         // Identificador del rango de horas de la reserva.
    int idReservante;        // Identificador del reservante.
    String motivoReserva;    // Motivo de la reserva del salón.

    // Constructor de la clase que toma varios parámetros para inicializar los campos.
    public ReservacionesSalones(int idReservacionSalon, int idSalon, int idRangoHora, int idReservante, String motivoReserva) {
        this.idReservacionSalon = idReservacionSalon;
        this.idSalon = idSalon;
        this.idRangoHora = idRangoHora;
        this.idReservante = idReservante;
        this.motivoReserva = motivoReserva;
    }
}
