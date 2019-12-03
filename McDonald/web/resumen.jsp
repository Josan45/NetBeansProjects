<%-- 
    Document   : resumen
    Created on : 03-dic-2019, 9:39:11
    Author     : José Antonio
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resumen</title>
    </head>
    <body>
        
        <% 
        RequestDispatcher rd;
        
        HttpSession sesion=request.getSession();
            
        ServletContext contexto=request.getServletContext();
        
        try {
        
        String usuario=(String)sesion.getAttribute("usuario");
        long fecha=sesion.getLastAccessedTime();
        Date fechaUltima=new Date(fecha);
        Date horaUltima=new Date(fecha);
        
        String menu=(String)contexto.getAttribute("menu");
        String sandwis=(String)contexto.getAttribute("sandwis");
        String complementos=(String)contexto.getAttribute("complementos");
        String ensalada=(String)contexto.getAttribute("ensalada");
        String bebidas=(String)contexto.getAttribute("bebida");
        
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora=new SimpleDateFormat("kk:mm:ss");

        if (usuario.equals("null")) {
                rd = contexto.getRequestDispatcher("/cerrarSesion.html");
                rd.forward(request, response);
            }
        
        %>
        
        <form method="post" action="cerrarSesion">
        <table>
            <tr><td><img src="images/img-logo-head.gif"></td><td style="text-align: right" colspan="2">Gracias <%=usuario %><br>Tu pedido ha sido tramitado a las <%=formatoFecha.format(fechaUltima) %> <%=formatoHora.format(horaUltima) %><br> y consta de los siguientes productos:</td><td></td></tr>
            <tr><td></td><td><ul><li>MENU: <%=menu %></li></ul></td></tr>
            <tr><td></td><td><ul><li>SANDWISH <%=sandwis %></li></ul></td></tr>
            <tr><td></td><td><ul><li>COMPLEMENTO: <%=complementos %></li></ul></td></tr>
            <tr><td></td><td><ul><li>ENSALADA: <%=ensalada %></li></ul></td></tr>
            <tr><td></td><td><ul><li>BEBIDA: <%=bebidas %></li></ul></td></tr>
        </table>
        
        <input type="submit" value="Salir" style="margin-left: 18%;">
        </form>
    </body>
</html>
<% 

    } catch (NullPointerException e) {
                rd=contexto.getRequestDispatcher("/cerrarSesion.html");
                rd.forward(request, response);
            }

%>