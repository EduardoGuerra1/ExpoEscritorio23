/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expoescritorio.Models;

import lombok.Data;

@Data
public class CodigosString {
    int idCodigoConductual;
    String nivelCodigoConductual;
    String codigoConductual;

    public CodigosString(int idCodigoConductual, String nivelCodigoConductual, String codigoConductual) {
        this.idCodigoConductual = idCodigoConductual;
        this.nivelCodigoConductual = nivelCodigoConductual;
        this.codigoConductual = codigoConductual;
    }
}
