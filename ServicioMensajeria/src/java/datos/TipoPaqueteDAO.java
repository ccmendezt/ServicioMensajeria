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
import negocio.TipoPaquete;
/**
 *
 * @author CRISTIAN CAMILO
 */
public class TipoPaqueteDAO {
    public TipoPaquete getTipoP(int idTipoP) throws CaException {
        TipoPaquete tp = null;
        Connection conexion = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            String strSQL = "SELECT * FROM tipo_paquete WHERE k_idTipoP = ?";
            conexion = ServiceLocator.getInstance().tomarConexion();
            prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, idTipoP);

            rs = prepStmt.executeQuery();

            while (rs.next()) {
                tp = new TipoPaquete();
                tp.setIdTipoPaquete(rs.getInt("k_idTipoP"));
                tp.setNombreTipoP(rs.getString("n_nombreTipoP"));
                tp.setTarifaPaquete(rs.getFloat("q_tarifaPaquete"));
            }
        } catch (SQLException e) {
            throw new CaException("TipoPaqueteDAO", "No pudo recuperar el tipo de Paquete" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return tp;
    }
}
