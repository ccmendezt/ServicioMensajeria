/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author CRISTIAN CAMILO
 */
public class TipoPaquete {

    private int idTipoPaquete;
    private String nombreTipoP;
    private float tarifaPaquete;

    public TipoPaquete() {
    }

    public int getIdTipoPaquete() {
        return idTipoPaquete;
    }

    public void setIdTipoPaquete(int idTipoPaquete) {
        this.idTipoPaquete = idTipoPaquete;
    }

    public String getNombreTipoP() {
        return nombreTipoP;
    }

    public void setNombreTipoP(String nombreTipoP) {
        this.nombreTipoP = nombreTipoP;
    }

    public float getTarifaPaquete() {
        return tarifaPaquete;
    }

    public void setTarifaPaquete(float tarifaPaquete) {
        this.tarifaPaquete = tarifaPaquete;
    }

}
