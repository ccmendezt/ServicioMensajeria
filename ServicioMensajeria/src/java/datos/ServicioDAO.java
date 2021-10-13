/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ServiceLocator;
import negocio.Servicio;
import util.CaException;

/**
 *
 * @author CRISTIAN CAMILO
 */
public class ServicioDAO {
    
    public void programarServicio(Servicio s) throws CaException {
        Connection conexion = null;
        PreparedStatement prepStmt = null;
        try {
            String strSQL = "INSERT INTO servicio (f_inicial, f_horainicial, i_idayvuelta, v_costo, i_mediopago, k_idciudad, k_tipodoccli, k_nrodoccli, k_idtipopaquete) VALUES (?,?,?,?,?,?,?,?,?)";
            conexion = ServiceLocator.getInstance().tomarConexion();
            prepStmt = conexion.prepareStatement(strSQL);
            java.sql.Date fechaInicial = java.sql.Date.valueOf(s.getF_inicial());
            java.sql.Time fHoraInicial = java.sql.Time.valueOf(s.getF_horaInicial() + ":00");
            prepStmt.setDate(1, fechaInicial);
            prepStmt.setTime(2, fHoraInicial);
            prepStmt.setString(3, s.getIdaYVuelta());
            prepStmt.setFloat(4, s.getCosto());
            prepStmt.setString(5, s.getMedioPago());
            prepStmt.setInt(6, s.getIdCiudad());
            prepStmt.setString(7, s.getTipoDocCli());
            prepStmt.setLong(8, s.getNroDocCli());
            prepStmt.setString(9, s.getIdTipoPa());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ServicioDAO", "No pudo crear el servicio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public Servicio buscarServicio(String fInicio, String fHoraInicio, String volumenPaquete) throws CaException {
        Servicio s = null;
        Connection conexion = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            String strSQL = "SELECT k_idServicio, f_inicial, f_horainicial, k_idtipopaquete FROM servicio WHERE f_inicial = ? AND f_horainicial = ? AND k_idtipopaquete = ?";
            conexion = ServiceLocator.getInstance().tomarConexion();
            prepStmt = conexion.prepareStatement(strSQL);
            java.sql.Date fechaInicial = java.sql.Date.valueOf(fInicio);
            java.sql.Time fHoraInicial = java.sql.Time.valueOf(fHoraInicio + ":00");
            prepStmt.setDate(1, fechaInicial);
            prepStmt.setTime(2, fHoraInicial);
            prepStmt.setString(3, volumenPaquete);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                s = new Servicio();
                s.setIdServicio(rs.getInt("k_idServicio"));
            }
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ServicioDAO", "No pudo encontrar el servicio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return s;
    }
    
    public ResultSet buscarServicioById(int idServicio) throws CaException {
        Servicio s = null;
        Connection conexion = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            String strSQL = "SELECT * FROM servicio WHERE k_idservicio = ?";
            conexion = ServiceLocator.getInstance().tomarConexion();
            prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, idServicio);
            
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                s = new Servicio();
                s.setIdServicio(rs.getInt("k_idServicio"));
                s.setF_inicial(rs.getString("f_inicial"));
                s.setF_horaInicial(rs.getString("f_horainicial"));
                s.setIdaYVuelta(rs.getString("i_idayvuelta"));
                s.setCosto(rs.getFloat("v_costo"));
                s.setF_cambioEstado(rs.getString("f_cambioestado"));
                s.setCmtCambioEstado(rs.getString("n_cmtcambioestado"));
                s.setMedioPago(rs.getString("i_mediopago"));
                s.setIdCiudad(rs.getInt("k_idciudad"));
                s.setTipoDocCli(rs.getString("k_tipodoccli"));
                s.setNroDocCli(rs.getLong("k_nrodoccli"));
                s.setCalificacion(rs.getInt("q_calificacion"));
                s.setIdTipoPa(rs.getString("k_idtipopaquete"));
                s.setTipoDocMen(rs.getString("k_tipodocmen"));
                s.setNroDocMensajero(rs.getLong("k_tipodocmen"));
            }
            
        } catch (SQLException e) {
            throw new CaException("ServicioDAO", "No pudo encontrar el servicio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return rs;
    }
    
    public ResultSet buscarServicioByDate(String fecha) throws CaException {
        Servicio s = null;
        Connection conexion = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            String strSQL = "SELECT * FROM servicio WHERE f_inicial = ?";
            conexion = ServiceLocator.getInstance().tomarConexion();
            prepStmt = conexion.prepareStatement(strSQL);
            java.sql.Date fechaInicial = java.sql.Date.valueOf(fecha);
            prepStmt.setDate(1, fechaInicial);
            
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                s = new Servicio();
                s.setIdServicio(rs.getInt("k_idServicio"));
                s.setF_inicial(rs.getString("f_inicial"));
                s.setF_horaInicial(rs.getString("f_horainicial"));
                s.setIdaYVuelta(rs.getString("i_idayvuelta"));
                s.setCosto(rs.getFloat("v_costo"));
                s.setF_cambioEstado(rs.getString("f_cambioestado"));
                s.setCmtCambioEstado(rs.getString("n_cmtcambioestado"));
                s.setMedioPago(rs.getString("i_mediopago"));
                s.setIdCiudad(rs.getInt("k_idciudad"));
                s.setTipoDocCli(rs.getString("k_tipodoccli"));
                s.setNroDocCli(rs.getLong("k_nrodoccli"));
                s.setCalificacion(rs.getInt("q_calificacion"));
                s.setIdTipoPa(rs.getString("k_idtipopaquete"));
                s.setTipoDocMen(rs.getString("k_tipodocmen"));
                s.setNroDocMensajero(rs.getLong("k_tipodocmen"));
            }
        } catch (SQLException e) {
            throw new CaException("ServicioDAO", "No pudo encontrar el servicio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return rs;
    }
    
    public ResultSet buscarServicioByCliente(String tipoDoc, Long nroDoc) throws CaException {
        Servicio s = null;
        Connection conexion = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            String strSQL = "SELECT * FROM servicio WHERE WHERE k_tipodoccli = ? AND k_nrodoccli = ?";
            conexion = ServiceLocator.getInstance().tomarConexion();
            prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, tipoDoc);
            prepStmt.setLong(2, nroDoc);
            
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                s = new Servicio();
                s.setIdServicio(rs.getInt("k_idServicio"));
                s.setF_inicial(rs.getString("f_inicial"));
                s.setF_horaInicial(rs.getString("f_horainicial"));
                s.setIdaYVuelta(rs.getString("i_idayvuelta"));
                s.setCosto(rs.getFloat("v_costo"));
                s.setF_cambioEstado(rs.getString("f_cambioestado"));
                s.setCmtCambioEstado(rs.getString("n_cmtcambioestado"));
                s.setMedioPago(rs.getString("i_mediopago"));
                s.setIdCiudad(rs.getInt("k_idciudad"));
                s.setTipoDocCli(rs.getString("k_tipodoccli"));
                s.setNroDocCli(rs.getLong("k_nrodoccli"));
                s.setCalificacion(rs.getInt("q_calificacion"));
                s.setIdTipoPa(rs.getString("k_idtipopaquete"));
                s.setTipoDocMen(rs.getString("k_tipodocmen"));
                s.setNroDocMensajero(rs.getLong("k_tipodocmen"));
            }

        } catch (SQLException e) {
            throw new CaException("ServicioDAO", "No pudo encontrar el servicio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return rs;
    }
    
}
