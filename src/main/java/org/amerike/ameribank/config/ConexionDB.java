package org.amerike.ameribank.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/Ameribank?serverTimezone=UTC";
    private static final String USER = "usuario_java2";
    private static final String PASS = "TuContraseniaSegura123";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

