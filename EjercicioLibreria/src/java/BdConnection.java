
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author José Antonio
 */

public class BdConnection {

    public static void main(String[] args) {
        // TODO code application logic here
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/libreriaonline";
        Connection con=null;
        
        try{
            Class.forName(driver);
            
            con=DriverManager.getConnection(url,"root","");
            
        }catch(ClassNotFoundException e){
            System.out.println("Controlador JDBC no encontrado: "+e.toString());
        }catch(SQLException e){
            System.out.println("Excepcion capturada de SQL: "+e.toString());
        }
    }
}