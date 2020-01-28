<%-- 
    Document   : cargarPeliculas
    Created on : 28-ene-2020, 9:51:14
    Author     : Jose Antonio
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/xml" pageEncoding="UTF-8"%>

<%
    
            String catego=request.getParameter("catego");
            String tienda=request.getParameter("video");
            
            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost/sakila";
            
            Connection con=null;
            
            try{
                
                Class.forName(driver);
                con=DriverManager.getConnection(url,"root","");
                String sql="SELECT distinct f.title FROM sakila.film f,sakila.film_category fc,sakila.inventory i "
                        + "WHERE f.film_id=fc.film_id AND fc.category_id="+catego+" AND f.film_id=i.film_id AND i.store_id="+tienda+";";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                out.print("<categorias>");
                
                while(rs.next()){
                    String nombre=rs.getString("title");
                    out.print("<tienda>"
                            + "<pelicula>"+nombre+"</pelicula>"
                            + "</tienda>");
                }
                
                out.print("</categorias>");
                
            }catch(ClassNotFoundException e){
                
            }  
%>
