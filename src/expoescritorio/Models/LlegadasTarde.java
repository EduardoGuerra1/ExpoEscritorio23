package expoescritorio.Models;

import lombok.Data;

@Data
public class LlegadasTarde {
    int idLlegadaTarde;
    int idTipoLlegadaTarde;
    int idEstudiante;
    int idPeriodo;
    int idDocente;
    String estado;
    String fecha;
    
    public LlegadasTarde(int idLlegadaTarde, int idTipoLlegadaTarde, int idEstudiante, int idPeriodo, int idDocente, String estado, String fecha) {
        this.idLlegadaTarde = idLlegadaTarde;
        this.idTipoLlegadaTarde = idTipoLlegadaTarde;
        this.idEstudiante = idEstudiante;
        this.idPeriodo = idPeriodo;
        this.idDocente = idDocente;
        this.estado = estado;
        this.fecha = fecha;
    }
}
    