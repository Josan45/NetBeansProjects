package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author José Antonio
 */
public class DbConnection {
    
    public static String usuario="root";
    public static String pass="";
    public static String servidor="localhost:3306";
    public static String baseDatos = "ciclodaw";

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
    
    public static ArrayList<Alumnos> muestraAlumnos(){
        ArrayList<Alumnos> lista=new ArrayList();
        Alumnos alum;
        Connection con=null;
            try {
                con=CrearConexion();
                String sql="SELECT * FROM alumnos;";

                PreparedStatement pst=con.prepareStatement(sql);
                ResultSet rs=pst.executeQuery();

                while(rs.next()){
                    alum=new Alumnos(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                    lista.add(alum);
                }

            } catch (SQLException ex) {
                System.out.println("Error en la conexion");
            }

        return lista;
    }
    
public static ArrayList<Alumnos> añadirAlumnos(String nombre, String apellidos, String dawes, String dawec, String diw, String daw, String fct, String proyecto){
    ArrayList<Alumnos> nuevo=new ArrayList();
    Alumnos exis;
    Connection con=null;
        try {
            con=CrearConexion();
            
            String sql="INSERT INTO alumnos VALUES (?,?,?,?,?,?,?,?);";
            
                                        
            PreparedStatement pst=con.prepareStatement(sql);
            //Cojo cada interrogacion y la cambio por cada variable
            pst.setString(1, nombre);
            pst.setString(2, apellidos);
            pst.setString(3, dawes);
            pst.setString(4, dawec);
            pst.setString(5, diw);
            pst.setString(6, daw);
            pst.setString(7, fct);
            pst.setString(8, proyecto);
            
            pst.executeUpdate();//Actualizo la base de datos añadiendole el libro
            
            
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion");
        }
    
    return nuevo;
}
}