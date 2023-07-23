package expoescritorio.Models;

import lombok.Data;


@Data
public class Inasistencias {
    int idInasistencia;
    int idTipoLlegadaTarde;
    int idEstudiante;
    int idDocente;
    int idPeriodo;
    String estado;
    String fecha;
    
    /**
     *
     * @param idInasistencia
     * @param idTipoLlegadaTarde
     * @param idEstudiante
     * @param idDocente
     * @param idPeriodo
     * @param estado
     * @param fecha
     */
    public Inasistencias(int idInasistencia, int idTipoLlegadaTarde, int idEstudiante, int idDocente, int idPeriodo, String estado, String fecha) {
        this.idInasistencia = idInasistencia;
        this.idTipoLlegadaTarde = idTipoLlegadaTarde;
        this.idEstudiante = idEstudiante;
        this.idDocente = idDocente;
        this.idPeriodo = idPeriodo;
        this.estado = estado;
        this.fecha = fecha;
        this.idEstudiante = idEstudiante;
    }
    
}
   

