/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author CRISTIAN CAMILO
 */
public class Servicio {

    private int idServicio, idCiudad, calificacion;
    private Long nroDocCli, nroDocMensajero;
    private String f_inicial, f_horaInicial, idaYVuelta, f_cambioEstado, cmtCambioEstado, medioPago, tipoDocCli, tipoDocMen, idTipoPa;
    private float costo;

    public Servicio() {
    }

    public Servicio(int idCiudad, String tipoDocCli, Long nroDocCli, String idTipoPa, String f_inicial, String f_horaInicial, String idaYVuelta, String medioPago, float costo) {
        this.idCiudad = idCiudad;
        this.nroDocCli = nroDocCli;
        this.idTipoPa = idTipoPa;
        this.f_inicial = f_inicial;
        this.f_horaInicial = f_horaInicial;
        this.idaYVuelta = idaYVuelta;
        this.medioPago = medioPago;
        this.tipoDocCli = tipoDocCli;
        this.costo = costo;
    }

    public Servicio(int idServicio, int idCiudad, int calificacion, long nroDocMensajero, long nroDocCli, String f_inicial, String f_horaInicial, String idaYVuelta, String f_cambioEstado, String cmtCambioEstado, String medioPago, String tipoDocCli, String tipoDocMen, String idTipoPa, float costo) {
        this.idServicio = idServicio;
        this.idCiudad = idCiudad;
        this.calificacion = calificacion;
        this.nroDocMensajero = nroDocMensajero;
        this.nroDocCli = nroDocCli;
        this.f_inicial = f_inicial;
        this.f_horaInicial = f_horaInicial;
        this.idaYVuelta = idaYVuelta;
        this.f_cambioEstado = f_cambioEstado;
        this.cmtCambioEstado = cmtCambioEstado;
        this.medioPago = medioPago;
        this.tipoDocCli = tipoDocCli;
        this.tipoDocMen = tipoDocMen;
        this.idTipoPa = idTipoPa;
        this.costo = costo;
    }
    
    

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Long getNroDocCli() {
        return nroDocCli;
    }

    public void setNroDocCli(Long nroDocCli) {
        this.nroDocCli = nroDocCli;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getIdTipoPa() {
        return idTipoPa;
    }

    public void setIdTipoPa(String idTipoPa) {
        this.idTipoPa = idTipoPa;
    }

    public long getNroDocMensajero() {
        return nroDocMensajero;
    }

    public void setNroDocMensajero(long nroDocMensajero) {
        this.nroDocMensajero = nroDocMensajero;
    }

    public String getF_inicial() {
        return f_inicial;
    }

    public void setF_inicial(String f_inicial) {
        this.f_inicial = f_inicial;
    }

    public String getF_horaInicial() {
        return f_horaInicial;
    }

    public void setF_horaInicial(String f_horaInicial) {
        this.f_horaInicial = f_horaInicial;
    }

    public String getIdaYVuelta() {
        return idaYVuelta;
    }

    public void setIdaYVuelta(String idaYVuelta) {
        this.idaYVuelta = idaYVuelta;
    }

    public String getF_cambioEstado() {
        return f_cambioEstado;
    }

    public void setF_cambioEstado(String f_cambioEstado) {
        this.f_cambioEstado = f_cambioEstado;
    }

    public String getCmtCambioEstado() {
        return cmtCambioEstado;
    }

    public void setCmtCambioEstado(String cmtCambioEstado) {
        this.cmtCambioEstado = cmtCambioEstado;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getTipoDocCli() {
        return tipoDocCli;
    }

    public void setTipoDocCli(String tipoDocCli) {
        this.tipoDocCli = tipoDocCli;
    }

    public String getTipoDocMen() {
        return tipoDocMen;
    }

    public void setTipoDocMen(String tipoDocMen) {
        this.tipoDocMen = tipoDocMen;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

}
