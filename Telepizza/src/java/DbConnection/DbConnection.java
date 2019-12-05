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
       public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3306";
    public static String basedatos = "telepizza";

    public static Connection CrearConexion() {

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://" + servidor + "/" + basedatos;

            try {
                con = DriverManager.getConnection(url, usuario, password);
            } catch (SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;

    }
    
    public static ArrayList<Usuario> consultaUsu(String usu,String contra){
        
        ArrayList<Usuario>lista=new ArrayList();
        
        Connection con=null;
        
        String url="SELECT * FROM usuarios WHERE User_name='"+usu+"' AND User_password='"+contra+"';";
        
        con=CrearConexion();
        
        Usuario person;
        
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(url);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String usua=rs.getString("User_name");
                String contrase=rs.getString("User_password");
                String direccion=rs.getString("User_address");
                String email=rs.getString("User_email");
                String telefono=rs.getString("User_phone");
                String nombre=rs.getString("Nombre");
                String apellidos=rs.getString("Apellidos");
                
                person=new Usuario(id, usua, contrase, direccion, email, telefono, nombre, apellidos);
                
                lista.add(person);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public static ArrayList<ofertas> consultaOfertas(){
        
        ArrayList<ofertas>lista=new ArrayList();
        
        Connection con=null;
        
        String url="SELECT * FROM ofertas;";
        
        con=CrearConexion();
        
        ofertas ofer;
        
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(url);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String descripcion=rs.getString("descriptcion");
                
                ofer=new ofertas(id, descripcion);
                
                lista.add(ofer);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public static ArrayList<menus> consultaMenus(){
        
        ArrayList<menus>lista=new ArrayList();
        
        Connection con=null;
        
        String url="SELECT * FROM menus;";
        
        con=CrearConexion();
        
        menus men;
        
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(url);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String descripcion=rs.getString("descripcion");
                
                men=new menus(id, descripcion);
                
                lista.add(men);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public static ArrayList<pizzas> consultaPizzas(){
        
        ArrayList<pizzas>lista=new ArrayList();
        
        Connection con=null;
        
        String url="SELECT * FROM pizzas;";
        
        con=CrearConexion();
        
        pizzas piz;
        
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(url);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String nompizzas=rs.getString("nompizzas");
                int idpizza=rs.getInt("idpizza");
                
                piz=new pizzas(id, nompizzas,idpizza);
                
                lista.add(piz);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
     public static ArrayList<entrante> consultaEntrantes(){
        
        ArrayList<entrante>lista=new ArrayList();
        
        Connection con=null;
        
        String url="SELECT * FROM entrante;";
        
        con=CrearConexion();
        
        entrante ent;
        
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(url);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String tipo=rs.getString("tipo");
                String descripcion=rs.getString("descripcion");
                
                ent=new entrante(id, tipo, descripcion);
                
                lista.add(ent);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
     
     public static ArrayList<hamburguesa> consultaHamburguesa(){
        
        ArrayList<hamburguesa>lista=new ArrayList();
        
        Connection con=null;
        
        String url="SELECT * FROM hambueguesa;";
        
        con=CrearConexion();
        
        hamburguesa ham;
        
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(url);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String nomHamburguesa=rs.getString("nomhambueguesa");
                
                ham=new hamburguesa(id, nomHamburguesa);
                
                lista.add(ham);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public static ArrayList<pasta> consultaPasta(){
        
        ArrayList<pasta>lista=new ArrayList();
        
        Connection con=null;
        
        String url="SELECT * FROM pasta;";
        
        con=CrearConexion();
        
        pasta past;
        
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(url);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String descripcion=rs.getString("Descripcion");
                
                past=new pasta(id, descripcion);
                
                lista.add(past);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public static ArrayList<ensaladas> consultaEnsalada(){
        
        ArrayList<ensaladas>lista=new ArrayList();
        
        Connection con=null;
        
        String url="SELECT * FROM ensaladas;";
        
        con=CrearConexion();
        
        ensaladas ens;
        
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(url);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String descripcion=rs.getString("nomensaladas");
                
                ens=new ensaladas(id, descripcion);
                
                lista.add(ens);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public static ArrayList<bebidas> consultaBebidas(){
        
        ArrayList<bebidas>lista=new ArrayList();
        
        Connection con=null;
        
        String url="SELECT * FROM bebidas;";
        
        con=CrearConexion();
        
        bebidas beb;
        
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(url);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String descripcion=rs.getString("nombebidas");
                
                beb=new bebidas(id, descripcion);
                
                lista.add(beb);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public static ArrayList<postre> consultaPostre(){
        
        ArrayList<postre>lista=new ArrayList();
        
        Connection con=null;
        
        String url="SELECT * FROM postre;";
        
        con=CrearConexion();
        
        postre pos;
        
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(url);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String descripcion=rs.getString("nompostre");
                
                pos=new postre(id, descripcion);
                
                lista.add(pos);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
}
