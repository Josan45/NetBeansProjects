/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author José Antonio
 */
public class DbConnection {
    
 
    public static String usuario="root";
    public static String pass="";
    public static String servidor="localhost:3306";
    public static String baseDatos = "ventas_comerciales";

    public static Connection CrearConexion() throws SQLException {
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://"+servidor+"/"+baseDatos;
            con=DriverManager.getConnection(url,usuario,pass);

        } catch (ClassNotFoundException ex) {
            System.out.println("Error en la conexion");
        }
        return con;
    }
}
