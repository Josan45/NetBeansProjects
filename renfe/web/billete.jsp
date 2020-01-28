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
            String origen=request.getParameter("origen");
            String destino=request.getParameter("destino");
            String fechasalida=request.getParameter("salida");
            String horariosalida=request.getParameter("hSalida");
            String fecharegreso=request.getParameter("regreso");
            String horarioregreso=request.getParameter("hRegreso");
            
            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost/andalucia";
            Connection conexion=null;
            Class.forName(driver);
            conexion=DriverManager.getConnection(url,"root","");
            Statement st=conexion.createStatement();
            String sentenciaSQL="SELECT * FROM `provincias` WHERE `codpro`='"+origen+"'";
            ResultSet rs=st.executeQuery(sentenciaSQL);
            
            while(rs.next()){
                origen=rs.getString(2);
            }
            Statement st2=conexion.createStatement();
            String sentenciaSQL2="SELECT * FROM `municipios` WHERE `cod`='"+destino+"'";
            ResultSet rs2=st2.executeQuery(sentenciaSQL2);
            
            while(rs2.next()){
                destino=rs2.getString(3);
            }
            conexion.close();
            
            String horario="";
            
            if(horariosalida=="1"){
                horario="Mañana";
            }else if(horariosalida=="2"){
                horario="Tarde";
            }else{
                horario="Noche";
            }
            
        %>
    <center>
        <h1>Billete de Renfe</h1><br>
        <h2>Salida:</h2><br>
        <b>Origen:</b><%=origen%><br>
        <b>Fecha de salida:</b><%=fechasalida%><br>
        <b>Horario de salida:</b><%=horario%><br>
        <h2>Regreso:</h2><br>
        <b>Destino:</b><%=destino%><br>
        <b>Fecha de regreso:</b><%=fecharegreso%><br>
        <b>Horario de regreso:</b><%=horarioregreso%><br>
    </center>
    </body>
</html>
