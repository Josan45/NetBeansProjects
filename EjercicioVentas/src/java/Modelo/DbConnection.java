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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static ArrayList<Venta> consultaVentas(String cod) {
        ArrayList<Venta> lista = new ArrayList();
        Venta venta;

        Connection cnn = null;

        try {
            cnn = CrearConexion();
            
            String sql = "SELECT comerciales.nombre as NombreComercial, "
                    + "productos.nombre as NombreProducto, "
                    + "ventas.cantidad ,"
                    + "productos.precio, "
                    + "ROUND((ventas.cantidad*productos.precio),2) as Total,"
                    + "productos.descuento, "
                    + "ROUND(productos.precio-(productos.precio*(productos.descuento/100)),2) as TotalDescuento, "
                    + "ventas.fecha "
                    + "FROM ventas_comerciales.comerciales, ventas_comerciales.productos, ventas_comerciales.ventas "
                    + "WHERE productos.referencia=ventas.refProducto "
                    + "AND comerciales.codigo=ventas.codComercial "
                    + "AND comerciales.codigo='"+cod+"';";
            
            Statement st=cnn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            
            while(rs.next()){
                String nombreComercial=rs.getString("NombreComercial");
                String nombreProducto=rs.getString("NombreProducto");
                int cantidad=rs.getInt("cantidad");
                double precio=rs.getDouble("precio");
                double precioTotal=rs.getDouble("Total");
                int descuento=rs.getInt("descuento");
                double totalDescuento=rs.getDouble("TotalDescuento");
                String fecha=rs.getString("fecha");
                
                venta=new Venta(nombreComercial, nombreProducto, fecha, cantidad, descuento, precio, precioTotal, totalDescuento);
                lista.add(venta);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public static ArrayList<Comercial> consultaComerciales() {
        ArrayList<Comercial> comercial = new ArrayList();
        Comercial comerciales;

        Connection con = null;

        try {
            con = CrearConexion();
            String sql = "SELECT codigo,nombre FROM comerciales;";
            
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                comerciales=new Comercial(rs.getInt("codigo"), rs.getString("nombre"));
                comercial.add(comerciales);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return comercial;
    }
    
    public static ArrayList<Usuario>consultaUsu(String nombre,String pass){
        ArrayList<Usuario>Usu=new ArrayList<>();
        Usuario usuario;
        
        Connection con=null;
        
        try {
            con=CrearConexion();
            
            String sql="SELECT usuario,password FROM usuario WHERE usuario='"+nombre+"' AND password='"+pass+"'";
            
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                String nom=rs.getString("usuario");
                String pas=rs.getString("password");
                
                usuario=new Usuario(nom, pas);
                Usu.add(usuario);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Usu;
    }
    
    public static ArrayList<Producto>consultaProducto(){
        
        ArrayList<Producto>productos=new ArrayList();
        Producto produc;
        
        Connection con=null;
        
        try {
            con=CrearConexion();
            
            String sql="SELECT * FROM productos";
            
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                String referencia=rs.getString("referencia");
                String nombre=rs.getString("nombre");
                String descripcion=rs.getString("descripcion");
                double precio=rs.getDouble("precio");
                int descuento=rs.getInt("descuento");
                
                produc=new Producto(referencia, nombre, descripcion, descuento, precio);
                productos.add(produc);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productos;
    }
    
    public static boolean altaProductos(Altas alta){
        boolean agregado=false;
        
        Connection con=null;
        
        try {
            con=CrearConexion();
            
            String sql="INSERT INTO ventas VALUES(?,?,?,?)";
            
            PreparedStatement pst=con.prepareStatement(sql);
                        
            pst.setInt(1, alta.codigo);
            pst.setString(2, alta.referencia);
            pst.setInt(3, alta.cantidad);
            pst.setString(4, alta.fecha);
            
            pst.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return agregado=true;
    }

    public static boolean modificarVenta(String cantidad, String cantidadOriginal, String comercial, String fecha) {
        boolean modificado=false;
        Connection con=null;
        
        try{
            con=CrearConexion();
            Statement st=con.createStatement();
            String sql="UPDATE ventas SET cantidad='"+cantidad+"' WHERE codComercial='"+comercial+"' AND fecha='"+fecha+"' AND cantidad='"+cantidadOriginal+"'";
            st.executeUpdate(sql);
            modificado=true;
        }catch(Exception e){
            
        }
        return modificado;
    }
}
