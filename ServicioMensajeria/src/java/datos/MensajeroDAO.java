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
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Mensajero;

/**
 *
 * @author CRISTIAN CAMILO
 */
public class MensajeroDAO {

    public MensajeroDAO() {

    }

    public Mensajero iniciarSesion(String email, long password) throws NullPointerException {
        Mensajero m = null;
        Connection conexion = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            String strSQL = "SELECT o_email, k_nroDoc FROM mensajero WHERE o_email = ? AND k_nroDoc = ?";
            conexion = ServiceLocator.getInstance().tomarConexion();
            prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setString(1, email);
            prepStmt.setLong(2, password);

            prepStmt.executeQuery();

            while (rs.next()) {
                m = new Mensajero();
                m.setEmail(rs.getString("o_email"));
                m.setNroDoc(rs.getLong("k_nroDoc"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ServiceLocator.getInstance().liberarConexion();
            try {
                if (rs != null) {
                    rs.close();
                }

                if (prepStmt != null) {
                    prepStmt.close();
                }

                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return m;
    }

}
