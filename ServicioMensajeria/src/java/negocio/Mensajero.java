/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author CRISTIAN CAMILO
 */
public class Mensajero {

    private long nroDoc, nroCelular;
    private String tipoDoc, nombres, apellidos, sexo, tipoTransporte, tipoMedio, email, nacionalidad, fNac;
    private boolean seguridadSocial;

    public Mensajero(){}
    
    public Mensajero(long nroDoc, long nroCelular, String tipoDoc, String nombres, String apellidos, String sexo, String tipoTransporte, String tipoMedio, String email, String nacionalidad, String fNac, boolean seguridadSocial) {
        this.nroDoc = nroDoc;
        this.nroCelular = nroCelular;
        this.tipoDoc = tipoDoc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.tipoTransporte = tipoTransporte;
        this.tipoMedio = tipoMedio;
        this.email = email;
        this.nacionalidad = nacionalidad;
        this.fNac = fNac;
        this.seguridadSocial = seguridadSocial;
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

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public String getTipoMedio() {
        return tipoMedio;
    }

    public void setTipoMedio(String tipoMedio) {
        this.tipoMedio = tipoMedio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getfNac() {
        return fNac;
    }

    public void setfNac(String fNac) {
        this.fNac = fNac;
    }

    public boolean isSeguridadSocial() {
        return seguridadSocial;
    }

    public void setSeguridadSocial(boolean seguridadSocial) {
        this.seguridadSocial = seguridadSocial;
    }

}
