/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
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
    public static String baseDatos="macdonals";
    
    public static Connection CrearConexion(){
    
        Connection con=null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://"+servidor+"/"+baseDatos;
            con=DriverManager.getConnection(url,usuario,pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
        
    }
    
    public static ArrayList<Usuario>consultaUsu(String usuarios,String claves){
        ArrayList<Usuario>usu=new ArrayList<Usuario>();
        
        Connection con=null;
        
        con=CrearConexion();
        String sql="SELECT * FROM usuario WHERE usuario='"+usuarios+"' AND pass='"+claves+"';";
        Usuario usuari;
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt("id");
                int usuario=rs.getInt("usuario");
                int pass=rs.getInt("pass");
                String nombre=rs.getString("nombre");
                
                usuari=new Usuario(id,usuario,pass,nombre);
                
                usu.add(usuari);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usu;
    }
    
    public static ArrayList<Menus>consultaMenu(){
        ArrayList<Menus>menu=new ArrayList<Menus>();
        
        Connection con=null;
        
        con=CrearConexion();
        String sql="SELECT * FROM menus;";
        Menus men;
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt("id");
                String descripcion=rs.getString("descripcion");
                
                men=new Menus(id, descripcion);
                
                menu.add(men);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return menu;
    }
    
    public static ArrayList<Sandwiches>consultaSandwis(){
        ArrayList<Sandwiches>sand=new ArrayList<Sandwiches>();
        
        Connection con=null;
        
        con=CrearConexion();
        String sql="SELECT * FROM sandwiches;";
        Sandwiches sandwis;
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt("id");
                String descripcion=rs.getString("descripcion");
                
                sandwis=new Sandwiches(id, descripcion);
                
                sand.add(sandwis);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sand;
    }
    
    public static ArrayList<Complementos>consultaComplementos(){
        ArrayList<Complementos>comple=new ArrayList();
        
        Connection con=null;
        
        con=CrearConexion();
        String sql="SELECT * FROM complementos;";
        Complementos complemen;
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt("id");
                String descripcion=rs.getString("descripcion");
                
                complemen=new Complementos(id, descripcion);
                
                comple.add(complemen);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return comple;
    }
    
    public static ArrayList<Ensaladas>consultaEnsalada(){
        ArrayList<Ensaladas>ensa=new ArrayList();
        
        Connection con=null;
        
        con=CrearConexion();
        String sql="SELECT * FROM ensaladas;";
        Ensaladas ensala;
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt("id");
                String descripcion=rs.getString("descripcion");
                
                ensala=new Ensaladas(id, descripcion);
                
                ensa.add(ensala);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ensa;
    }
    
    public static ArrayList<Bebidas>consultaBebidas(){
        ArrayList<Bebidas>bebi=new ArrayList();
        
        Connection con=null;
        
        con=CrearConexion();
        String sql="SELECT * FROM bebidas;";
        Bebidas beb;
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt("id");
                String descripcion=rs.getString("descripcion");
                
                beb=new Bebidas(id, descripcion);
                
                bebi.add(beb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bebi;
    }
}
