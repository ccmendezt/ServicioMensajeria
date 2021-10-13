/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
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
            
            prepStmt.setString(1, s.getF_inicial());
            prepStmt.setString(2, s.getF_horaInicial());
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
}
