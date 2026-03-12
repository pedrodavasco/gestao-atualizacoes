package com.gestatualizacaonovo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:h2:~/test"; 
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConexao() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
