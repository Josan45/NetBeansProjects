/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author José Antonio
 */
public class DbConnection {
    public static String usuario="root";
    public static String pass="";
    public static String servidor="localhost:3306";
    public static String basedatos="books";    

     public static Connection abrirConexion() throws SQLException {
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://"+servidor+"/"+basedatos;
            con=DriverManager.getConnection(url,usuario,pass);

        } catch (ClassNotFoundException ex) {
            System.out.println("Error en la conexion");
        }
        return con;
    }

public static ArrayList<Libro> consultaTitulos(String dato){
    ArrayList<Libro> lista=new ArrayList<Libro>();
    Libro ebook;
    Connection con=null;
        try {
            con=abrirConexion();
            String sql="SELECT Titulo,ISBN, CONCAT(Nombre,\", \",Apellido) as Autor, NameEditorial as Editorial, "
                        + "Descripcion FROM titulos,autor,editorial WHERE titulos.IDautor=autor.IDAutor AND "
                        +"titulos.IDeditorial=editorial.IDEditorial AND Titulo LIKE '%"+dato+"%'";
            
            PreparedStatement smt=con.prepareStatement(sql);
            smt.setString(1,"%"+dato+"%");
            ResultSet rs=smt.executeQuery();
            
            while(rs.next()){
                String titulo=rs.getString("titulo");
                String isbn=rs.getString("isbn");
                String autor=rs.getString("autor");
                String editorial=rs.getString("editorial");
                String descripcion=rs.getString("descripcion");
                
                ebook=new Libro(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(ebook);
            }
            
        } catch (SQLException e) {
            System.out.println("Controlador JDBC no encontrado"+e.toString());
        }catch(Exception e){
            System.out.println("Otra excepcion"+e.toString());
        }
    
    return lista;
    }
}