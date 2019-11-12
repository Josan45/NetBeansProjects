package Modelo;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import Modelo.Libro;


public class DbConnection {
    public static String usuario="root";
    public static String pass="";

    public static Connection abrirConexion() throws SQLException {
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/libreriaonline";
            con=DriverManager.getConnection(url,usuario,pass);

        } catch (ClassNotFoundException ex) {
            System.out.println("Error en la conexion");
        }
        return con;
    }

public static ArrayList<Libro> consultaTitulos(){
    ArrayList<Libro> lista=new ArrayList();
    Libro ebook;
    Connection con=null;
        try {
            con=abrirConexion();
            String sql="SELECT * FROM libros;";
            
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()){
                ebook=new Libro(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6));
                lista.add(ebook);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion");
        }
    
    return lista;
}

public static ArrayList<Libro> añadirLibros(int codigo, String titulo, String autor, String fecha, int pagina,double precio){
    ArrayList<Libro> nuevo=new ArrayList();
    ArrayList<Libro> existe=new ArrayList();
    Libro exis;
    Connection con=null;
        try {
            con=abrirConexion();
            
            String buscar="SELECT * FROM libros WHERE titulo='"+titulo+"'";
            String sql="INSERT INTO libros VALUES (?,?,?,?,?,?);";
            
            PreparedStatement pst=null;
            
            pst=con.prepareStatement(buscar);
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()){
                exis=new Libro(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6));
                existe.add(exis);
            }
                                
            if(existe.size()==1){
                nuevo=null;
            }else{
                                        
            pst=con.prepareStatement(sql);
            //Cojo cada interrogacion y la cambio por cada variable
            pst.setInt(1, codigo);
            pst.setString(2, titulo);
            pst.setString(3, autor);
            pst.setString(4, fecha);
            pst.setInt(5, pagina);
            pst.setDouble(6, precio);
            
            pst.executeUpdate();//Actualizo la base de datos añadiendole el libro
            
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion");
        }
    
    return nuevo;
}
}