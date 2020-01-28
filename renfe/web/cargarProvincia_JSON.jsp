<%-- 
    Document   : cargarProvincia_JSON
    Created on : 28-ene-2020, 19:04:36
    Author     : Jose Antonio
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost/andalucia";
            
            Connection con=null;
            
            try{
                
                Class.forName(driver);
                con=DriverManager.getConnection(url,"root","");
                String sql="SELECT * FROM provincias";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                String codigo="";
                String nombre="";
                
                int cont=0;
                
                out.print("[");
                
                while(rs.next()){
                    codigo=rs.getString("codpro");
                    nombre=rs.getString("nombre");
                    
                    if(cont==0){
                        out.print("{codigo:'"+codigo+"',"
                            + "nombre:'"+nombre+"'}");
                    }else{
                        out.print(",{codigo:'"+codigo+"',"
                            + "nombre:'"+nombre+"'}");
                    }
                    cont++;
                }
                
                out.print("]");
                
            }catch(ClassNotFoundException e){
                
            }
            %>

