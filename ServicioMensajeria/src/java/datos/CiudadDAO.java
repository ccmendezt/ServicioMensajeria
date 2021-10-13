/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import util.CaException;
import util.ServiceLocator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Ciudad;

/**
 *
 * @author CRISTIAN CAMILO
 */
public class CiudadDAO {

    public Ciudad buscarCiudad(int idCiudad) throws CaException {
        Ciudad c = null;
        Connection conexion = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            String strSQL = "SELECT * FROM ciudad WHERE k_idCiudad = ?";
            conexion = ServiceLocator.getInstance().tomarConexion();
            prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, idCiudad);

            rs = prepStmt.executeQuery();

            while (rs.next()) {
                c = new Ciudad();
                c.setIdCiudad(rs.getInt("k_idCiudad"));
                c.setNombreCiudad(rs.getString("n_nombreciudad"));
                c.setPrecioTrayecto(rs.getInt("q_precioTrayecto"));
                c.setPorcentajeComision(rs.getFloat("t_porcentajeComision"));
            }
        } catch (SQLException e) {
            throw new CaException("CiudadDAO", "No pudo recuperar la ciudad" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return c;
    }
}
