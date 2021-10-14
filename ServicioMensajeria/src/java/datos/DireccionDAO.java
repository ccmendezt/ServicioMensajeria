/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import negocio.Direccion;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author CRISTIAN CAMILO
 */
public class DireccionDAO {
    public void programarServicio(Direccion d) throws CaException {
        Connection conexion = null;
        PreparedStatement prepStmt = null;
        try {
            String strSQL = "INSERT INTO direccion (k_idservicio, n_direccion, n_actividad) VALUES (?,?,?)";
            conexion = ServiceLocator.getInstance().tomarConexion();
            prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, d.getIdServicio());
            prepStmt.setString(2, d.getDireccion());
            prepStmt.setString(3, d.getActividad());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("DireccionDAO", "No pudo crear la direccion" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
}
