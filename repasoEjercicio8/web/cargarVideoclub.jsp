<%-- 
    Document   : cargarVideoclub
    Created on : 28-ene-2020, 9:05:01
    Author     : Jose Antonio
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/xml" pageEncoding="UTF-8"%>

<%
            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost/sakila";
            
            Connection con=null;
            
            try{
                
                Class.forName(driver);
                con=DriverManager.getConnection(url,"root","");
                String sql="SELECT * FROM store";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                out.print("<tiendas>");
                
                while(rs.next()){
                    String codigo=rs.getString("store_id");
                    String video=rs.getString("nombre");
                    out.print("<videoclub>"
                            + "<codigo>"+codigo+"</codigo>"
                            + "<nombre>"+video+"</nombre>"
                            + "</videoclub>");
                }
                
                out.print("</tiendas>");
                
            }catch(ClassNotFoundException e){
                
            }  
%>
