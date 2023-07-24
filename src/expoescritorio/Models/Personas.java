/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expoescritorio.Models;

import lombok.Data;

@Data
public class Personas {
     private int idPersona;
    private String codigo;
    private String nombrePersona;
    private String apellidoPersona;
    private String nacimientoPersona;
    private int idTipoPersona;
    private String correo;
    private String claveCredenciales;
    private String foto;
    public Personas(int idPersona, String codigo, String nombrePersona, String apellidoPersona, String nacimientoPersona, int idTipoPersona, String correo, String claveCredenciales, String foto) {
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
