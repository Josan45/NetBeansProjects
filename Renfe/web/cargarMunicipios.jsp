<%-- 
    Document   : cargarMunicipios
    Created on : 24-ene-2020, 8:50:17
    Author     : Jose Antonio
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <% 
        
            
    String driver="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost/andalucia";
        
    Connection conexion=null;
    
    String texto="";
    
    boolean correcto=false;
    
        try {
            Class.forName(driver);
            
            conexion=DriverManager.getConnection(url,"root","");
            Statement estatement=conexion.createStatement();
            
            String codigo=request.getParameter("codigo");
            String cadena=request.getParameter("texto");
            
            String sentenciaSQL="SELECT nombre from municipios where nombre like '"+cadena+"%' and codprov="+codigo;
            
            ResultSet rs=estatement.executeQuery(sentenciaSQL);
            
            //texto="{'provincias':[";
            texto="[";
            rs.last(); 
            int numRows = rs.getRow(); 
            rs.beforeFirst();
            
            
            int total=0;
            if (cadena!=""){
            
            while (rs.next()){ 
            
            total++;
            
            if (total==numRows){
                texto+=("'"+rs.getString("nombre")+"'"); 
            } else {
                texto+=("'"+rs.getString("nombre")+"',"); 
            }
            
            }
            }

            

            texto+="]";
            
            
        } catch (Exception e) {
        }
        
            out.print(texto);
        
        %>
