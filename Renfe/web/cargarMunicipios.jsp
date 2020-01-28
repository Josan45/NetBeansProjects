<%-- 
    Document   : cargarMunicipios
    Created on : 24-ene-2020, 8:50:17
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
            
            String id=request.getParameter("idc");
            
            Connection con=null;
            
                Class.forName(driver);
                con=DriverManager.getConnection(url,"root","");
                String sql="SELECT * FROM municipios where codprov="+id;
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                 %><respuesta><%
                    while(rs.next()){
                        %><codigo><%out.print(rs.getString(1));%></codigo><%
                        %><municipios><%out.print(rs.getString(3));%></municipios><%
                    }
                    %></respuesta><%
            con.close();
            
            %>