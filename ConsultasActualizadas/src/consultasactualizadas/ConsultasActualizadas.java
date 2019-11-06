/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultasactualizadas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultasActualizadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/ordenadores";
        Connection con = null;

        String borrado = "DELETE FROM ventasordenadores WHERE Unidades>60";
        String mayor = "SELECT * FROM ventasordenadores";
        String insertar = "UPDATE ventasordenadores SET Vendedores='yo'";
        String cucu = "UPDATE ventasordenadores SET Vendedores='cucu' WHERE Unidades>55";

        try {
            Class.forName(driver);

            con = DriverManager.getConnection(url, "root", "");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(mayor);
            ResultSetMetaData meta = rs.getMetaData();
            meta.getColumnCount();
            String num;
            String[] nomColum = new String[meta.getColumnCount() + 1];
            //System.out.println(num);
            int columna = meta.getColumnCount();

            for (int x = 1; x <= meta.getColumnCount(); x++) {
                num = meta.getColumnName(x);
                nomColum[x] = num;//Guardo cada nombre de columnas
                System.out.println(nomColum[x]);
            }

            int cont = 0;
            int fila = 0;
            System.out.println("Fila "+columna+" afectada");

            //System.out.println(tabla[3][2]);
            rs = st.executeQuery(mayor);
            meta = rs.getMetaData();

            while (rs.next()) {
                fila++;
            }
            System.out.println("Fila "+fila+" afectada");

            String tabla[][] = new String[fila][columna];

            rs = st.executeQuery(mayor);

            fila = 0;
            while (rs.next()) {
                for (int x = 1; x < columna + 1; x++) {
                    tabla[(fila)][(x - 1)] = rs.getString(rs.getMetaData().getColumnName(x));
                    //System.out.println(tabla[(fila)][(x-1)]);
                }
                fila++;
            }
            
            st.executeUpdate(borrado);//Borro todos los que sus unidades sean mayores a 60

            for (int x = 0; x < tabla.length; x++) {
                String unidades = tabla[x][1];
                int uni = Integer.parseInt(unidades);
                if (uni > 60) {
                        String añadir = "INSERT INTO ventasordenadores VALUE ('" + tabla[x][0] + "','" + tabla[x][1] + "','" + tabla[x][2] + "');";
                        st.executeUpdate(añadir);
                        //System.out.println();
                }
            }
            st.executeUpdate(insertar);//Actualizo el nombre de vendedores a yo
            st.executeUpdate(cucu);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConsultasActualizadas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasActualizadas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
