package expoescritorio.Models;
import lombok.Data;

import java.util.Date;

@Data
public class TiposLlegadasTarde {
    int idTipoLlegadaTarde;
    String TipoLlegadaTarde;
    public TiposLlegadasTarde (int idTipoLlegadaTarde, String TipoLlegadaTarde){
        this.idTipoLlegadaTarde = idTipoLlegadaTarde;
        this.TipoLlegadaTarde = TipoLlegadaTarde;
    }

}
