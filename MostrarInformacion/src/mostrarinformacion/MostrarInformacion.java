
package mostrarinformacion;

import java.sql.*;

public class MostrarInformacion {

    public static void main(String[] args) {
        // TODO code application logic here
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/productosinformaticos";
        Connection con=null;
        
        try{
            Class.forName(driver);
            
            con=DriverManager.getConnection(url,"root","");
            
            Statement stmt=con.createStatement();
            
            String sentenciaSQL="SELECT * FROM impresorasmicros";
            ResultSet rs=stmt.executeQuery(sentenciaSQL);
            int fila=1;
            
            while(rs.next()){
                System.out.println("Filas: "+fila);
                for(int x=1;x<=rs.getMetaData().getColumnCount();x++){
                    System.out.print(rs.getMetaData().getColumnName(x)+": "+rs.getString(x)+", ");
                }
                System.out.println("");
                fila++;
            }
            
        }catch(ClassNotFoundException e){
            System.out.println("Controlador JDBC no encontrado: "+e.toString());
        }catch(SQLException e){
            System.out.println("Excepcion capturada de SQL: "+e.toString());
        }
    }
}