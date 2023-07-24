/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expoescritorio.Models;

import lombok.Data;

@Data
public class Recu {
    int idPersona;
    int idTipoPersona;
    String correo;

    public Recu(int idPersona, int idTipoPersona, String correo) {
        this.idPersona = idPersona;
        this.idTipoPersona = idTipoPersona;
        this.correo = correo;
    }
}