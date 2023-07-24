/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expoescritorio.Models;

/**
 *
 * @author thatsgonzalez
 */

import lombok.Data;

@Data
public class ComunicadosModel {
    int idComunicado;
    int idGrado;
    String detalle;
    String fecha;
    String archivo;
    
    public ComunicadosModel(int idComunicado, int idGrado, String detalle, String fecha, String archivo){
        this.idComunicado = idComunicado;
        this.idGrado = idGrado;
        this.detalle = detalle;
        this.fecha = fecha;
        this.archivo = archivo;
    }
    
    public ComunicadosModel(){
        
    }
    
}
