/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Cliente;
import negocio.Mensajero;
import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author CRISTIAN CAMILO
 */
public class ClienteDAO {

    private Cliente c;

    public Cliente iniciarSesion(String email, long password) throws CaException {
        Cliente c = null;
        Connection conexion = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            String strSQL = "SELECT o_email, k_nroDoc FROM cliente WHERE o_email = ? AND k_nroDoc = ?";
            conexion = ServiceLocator.getInstance().tomarConexion();
            prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setString(1, email);
            prepStmt.setLong(2, password);

            rs = prepStmt.executeQuery();

            while (rs.next()) {
                c = new Cliente();
                c.setEmail(rs.getString("o_email"));
                c.setNroDoc(rs.getLong("k_nroDoc"));
            }
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No pudo recuperar los hechizos" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

        return c;
    }
}
