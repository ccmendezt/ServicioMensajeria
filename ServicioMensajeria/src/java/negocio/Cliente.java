/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author CRISTIAN CAMILO
 */
public class Cliente {

    private String tipoDoc;
    private long nroDoc, nroCelular;
    private String nombres, apellidos, email;

    public Cliente(){}
    
    public Cliente(String tipoDoc, long nroDoc, long nroCelular, String nombres, String apellidos, String email) {
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.nroCelular = nroCelular;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public long getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(long nroDoc) {
        this.nroDoc = nroDoc;
    }

    public long getNroCelular() {
        return nroCelular;
    }

    public void setNroCelular(long nroCelular) {
        this.nroCelular = nroCelular;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
