<%-- 
    Document   : cargarCategoria
    Created on : 28-ene-2020, 11:41:24
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
                String sql="SELECT * FROM category";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                out.print("<categorias>");
                
                while(rs.next()){
                    String codigo=rs.getString("category_id");
                    String nombre=rs.getString("name");
                    out.print("<categoria>"
                            + "<codigo>"+codigo+"</codigo>"
                            + "<nombre>"+nombre+"</nombre>"
                            + "</categoria>");
                }
                out.print("</categorias>");
                
            }catch(ClassNotFoundException ex){
                
            }
            
        %>