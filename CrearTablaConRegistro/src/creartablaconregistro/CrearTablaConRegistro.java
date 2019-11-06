/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creartablaconregistro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno_2DAW
 */
public class CrearTablaConRegistro {

    public static void main(String[] args) throws SQLException {

        // TODO code application logic here
       String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/mibasedatos";
        Connection con=null;

        Scanner dato = new Scanner(System.in);

        System.out.println("¿Que opción elijes? ¿A o B?");
        String opcion = dato.next();

        String[] sentencia = new String[2];
        String borrado="DROP TABLE mitabla";
        String[] opc = new String[2];

        int opcion1=0;

        if (opcion.equals("A")) {
            opcion1 = 0;
        }

        if (opcion.equals("B")) {
            opcion1 = 1;
        }

        
            sentencia[0] = "CREATE TABLE mitabla("
                    + "nombre VARCHAR(45) NOT NULL,"
                    + "apellidos VARCHAR(45) NOT NULL,"
                    + "edad VARCHAR(45) NOT NULL,"
                    + "telefono VARCHAR(45)"
                    + ");";

            opc[0] = "INSERT INTO mitabla VALUES ("
                    + "'Jesus','Fernandez Ortega','28','941200639'),"
                    + "('Pepe','Botella Ruiz','26','941212365'),"
                    + "('Carlos','Ruiz Gil','26','941124541'"
                    + ");";

        
            sentencia[1] = "CREATE TABLE mitabla("
                    + "nombre VARCHAR(45) NOT NULL,"
                    + "apellidos VARCHAR(45) NOT NULL,"
                    + "edad VARCHAR(45) NOT NULL,"
                    + "lugarresidencia VARCHAR(45),"
                    + "fechanacimiento DATE"
                    + ");";

            opc[1] = "INSERT INTO mitabla VALUES ("
                    + "'Jesus','Fernandez Ortega','28','Logroño','1975-03-22'),"
                    + "('Pepe','Botella Ruiz','26','Madrid','1975-10-12'),"
                    + "('Carlos','Ruiz Gil','26','Barcelona','1976-11-25'"
                    + ");";
        

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "root", "");
            Statement st = con.createStatement();
            
            st.executeUpdate(borrado);
            st.executeUpdate(sentencia[opcion1]);
            st.executeUpdate(opc[opcion1]);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearTablaConRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}