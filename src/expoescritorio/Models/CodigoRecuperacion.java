/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expoescritorio.Models;

import lombok.Data;

@Data
public class CodigoRecuperacion {
    String Codigo; 

    public CodigoRecuperacion(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public CodigoRecuperacion() {
    }
    
    
    
    
}
