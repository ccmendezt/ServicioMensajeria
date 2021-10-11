/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        try {
            String strSQL = "INSERT INTO servicio (n_nombrePersonaje, q_vida, q_ataque, q_mana, n_foto, n_estilo) VALUES(?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            /*prepStmt.setString(1, magoBlanco.getNombre());
            prepStmt.setInt(2, magoBlanco.getVida());
            prepStmt.setInt(3, magoBlanco.getAtaque());
            prepStmt.setInt(4, magoBlanco.getMana());
            prepStmt.setString(5, magoBlanco.getFoto());
            prepStmt.setString(6, magoBlanco.getEstilo());
            prepStmt.executeUpdate();
            prepStmt.close();*/
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PersonajeDAO", "No pudo crear el personaje" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
}
