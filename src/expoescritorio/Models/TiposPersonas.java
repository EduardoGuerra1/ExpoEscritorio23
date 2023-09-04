package expoescritorio.Models;

import java.util.List;

// Declaración de la clase TiposPersonas
public class TiposPersonas {
    // Campos privados para almacenar datos de tipos de personas
    private int idTipoPersona;
    private String tipoPersona;

    // Constructor con parámetros para inicializar campos
    public TiposPersonas(int idTipoPersona, String tipoPersona) {
        this.idTipoPersona = idTipoPersona;
        this.tipoPersona = tipoPersona;
    }

    // Constructor sin parámetros (por defecto)
    public TiposPersonas() {
    }

    // Getter para obtener el valor del campo tipoPersona
    public String getTipoPersona() {
        return tipoPersona;
    }

    // Setter para establecer el valor del campo tipoPersona
    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    // Getter para obtener el valor del campo idTipoPersona
    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    // Setter para establecer el valor del campo idTipoPersona
    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    // Método de tipo void llamado "add" que recibe una lista de TiposPersonas como parámetro.
    public void add(List<TiposPersonas> TiposPersonas) {
    }
}

