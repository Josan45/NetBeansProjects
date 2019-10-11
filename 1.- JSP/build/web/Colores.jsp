
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Color de fondo a la carta</title>
    </head>
        <%
            String color=request.getParameter("color");
            String nombre=request.getParameter("nombre");
            
    if(nombre==null){ %>
    <%@ include file="/FormuColores.jsp" %>
    
    <% }else if(color.length()==0 || nombre.length()==0){ %>
        <%@ include file="/FormuColoresConAviso.jsp" %>
    <% }else{ %>
    <body bgcolor="<%= color %>">
        <h2>Datos introducidos</h2>
        Nombre: <font color="red"><%= nombre %></font><p>
        Color de fondo: <font color="blue"><%= color %></font>
        <%}%>
    </body>
</html>
