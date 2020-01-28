<%-- 
    Document   : billete
    Created on : 28-ene-2020, 14:22:07
    Author     : Jose Antonio
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String salida=request.getParameter("ciudades");
            String salidamuicipio=request.getParameter("municipios");
            String fechasalida=request.getParameter("fechasalida");
            String horariosalida=request.getParameter("horarios");
            String fecharegreso=request.getParameter("fecharegreso");
            String horarioregreso=request.getParameter("horarior");
            
            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost/andalucia";
            Connection conexion=null;
            Class.forName(driver);
            conexion=DriverManager.getConnection(url,"root","");
            Statement st=conexion.createStatement();
            String sentenciaSQL="SELECT * FROM `provincias` WHERE `codpro`='"+salida+"'";
            ResultSet rs=st.executeQuery(sentenciaSQL);
            
            while(rs.next()){
                salida=rs.getString(2);
            }
            Statement st2=conexion.createStatement();
            String sentenciaSQL2="SELECT * FROM `municipios` WHERE `cod`='"+salidamuicipio+"'";
            ResultSet rs2=st2.executeQuery(sentenciaSQL2);
            
            while(rs2.next()){
                salidamuicipio=rs2.getString(3);
            }
            conexion.close();
            
        %>
        <h1>Billete de Renfe</h1><br>
        <h2>Salida:</h2><br>
        <a><%=salida%>,<%=salidamuicipio%></a><br>
        <b>Fecha de salida:</b><%=fechasalida%><br>
        <b>Horario de salida:</b><%=horariosalida%><br>
        <h2>Regreso:</h2><br>
        <b>Fecha de regreso:</b><%=fecharegreso%><br>
        <b>Horario de regreso:</b><%=horarioregreso%><br>
        
    </body>
</html>
