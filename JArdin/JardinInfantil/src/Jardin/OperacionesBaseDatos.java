/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jardin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LACOBO
 */
public class OperacionesBaseDatos {
    static Connection con;
    
    public static void conectarBaseDatos() throws Exception {
        con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
    
    public static void desconectarBD() throws SQLException {
        con.close();
    }
    
    public static void insertarnino(int identificacion, String nombre,String apellido,int edad) throws SQLException {
        String SQL = "INSERT INTO jardin VALUES (?, ?,?,?)";
        try (PreparedStatement s = con.prepareStatement(SQL)) {
            s.setInt(1, identificacion);
            s.setString(2, nombre);
            s.setString(3, apellido);
            s.setInt(4,edad);
            
            s.executeUpdate();
        }
    }
    
    public static ResultSet obtenerninos() throws Exception {
        String SQL = "SELECT * FROM jardin";
        Statement s = con.createStatement();
        return s.executeQuery(SQL);
    }
    
    public static void borrarnino(int identificacion) throws Exception {
        String SQL = "DELETE FROM jardin WHERE identificador = ?";
        PreparedStatement s = con.prepareCall(SQL);
        
        s.setInt(1, identificacion);
        
        s.executeUpdate();
        s.close();
    }
    
}
