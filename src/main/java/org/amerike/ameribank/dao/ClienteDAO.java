package org.amerike.ameribank.dao;


import org.amerike.ameribank.config.ConexionDB;
import org.amerike.ameribank.model.cliente;


import java.sql.Connection;
import java.sql.PreparedStatement;


public class ClienteDAO {
    public void registrarCliente(cliente c) throws Exception {
        String sql = "CALL RegistraCliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, c.getNumeroCliente());
            stmt.setString(2, c.getNombre());
            stmt.setString(3, c.getApellidoPat());
            stmt.setString(4, c.getApellidoMat());
            stmt.setDate(5, java.sql.Date.valueOf(c.getFechaNac()));
            stmt.setString(6, c.getRfc());
            stmt.setString(7, c.getCurp());
            stmt.setString(8, c.getEmail());
            stmt.setString(9, c.getCelular());
            stmt.setString(10, c.getDireccion());
            stmt.setString(11, c.getCiudad());
            stmt.setString(12, c.getEstado());
            stmt.setString(13, c.getCp());
            stmt.setString(14, c.getEstatus());


            stmt.executeUpdate();
        }
    }

    public void actualizarCliente(cliente c) throws Exception {
        String sql = "CALL ActualizarCliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getClienteId());
            stmt.setString(2, c.getNumeroCliente());
            stmt.setString(3, c.getNombre());
            stmt.setString(4, c.getApellidoPat());
            stmt.setString(5, c.getApellidoMat());
            stmt.setDate(6, java.sql.Date.valueOf(c.getFechaNac()));
            stmt.setString(7, c.getRfc());
            stmt.setString(8, c.getCurp());
            stmt.setString(9, c.getEmail());
            stmt.setString(10, c.getCelular());
            stmt.setString(11, c.getDireccion());
            stmt.setString(12, c.getCiudad());
            stmt.setString(13, c.getEstado());
            stmt.setString(14, c.getCp());
            stmt.setString(15, c.getEstatus());

            stmt.executeUpdate();
        }
    }




}

