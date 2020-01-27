<%-- 
    Document   : cargarProvincias
    Created on : 24-ene-2020, 8:48:35
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
                Class.forName(driver);
                con=DriverManager.getConnection(url,"root","");
                String sql="SELECT * FROM provincias";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                String codigo="";
                String nombre="";
                
                %><respuesta><%
                    while(rs.next()){
                        %><codigo><%out.print(rs.getString(1));%></codigo><%
                        %><ciudades><%out.print(rs.getString(2));%></ciudades><%
                    }
                %></respuesta><%
            con.close();
            
            %>