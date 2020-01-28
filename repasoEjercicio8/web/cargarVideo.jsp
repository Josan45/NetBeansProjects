<%-- 
    Document   : cargarVideo
    Created on : 28-ene-2020, 11:57:17
    Author     : Jose Antonio
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

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
                
                out.print("<videoclubs>");
                
                while(rs.next()){
                    String codigo=rs.getString("store_id");
                    String nombre=rs.getString("nombre");
                    out.print("<videoclub>"
                            + "<codigo>"+codigo+"</codigo>"
                            + "<nombre>"+nombre+"</nombre>"
                            + "</videoclub>");
                }
                out.print("</videoclubs>");
                
            }catch(ClassNotFoundException ex){
                
            }
            
        %>