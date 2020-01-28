<%-- 
    Document   : cargarProvincia
    Created on : 28-ene-2020, 13:10:31
    Author     : Jose Antonio
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%@page contentType="text/xml" pageEncoding="UTF-8"%>

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
                
                out.print("<provincias>");
                
                while(rs.next()){
                    codigo=rs.getString("codpro");
                    nombre=rs.getString("nombre");
                    out.print("<provincia>"
                            + "<codigo>"+codigo+"</codigo>"
                            + "<nombre>"+nombre+"</nombre>"
                            + "</provincia>");
                }
                out.print("</provincias>");
                
            }catch(ClassNotFoundException ex){
                
            }
            
            %>

