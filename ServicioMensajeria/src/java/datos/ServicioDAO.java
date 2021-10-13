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
    //private Servicio s;
    
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
    
}
