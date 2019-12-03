<%-- 
    Document   : pedirTelefono
    Created on : 03-dic-2019, 9:26:12
    Author     : José Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Telefono</title>
    </head>
    <body>
        
        <% 
            ServletContext contexto=request.getServletContext();
            RequestDispatcher rd;
        
        try {   
        
            
            
            HttpSession sesion=request.getSession();
            
            String usuario=(String)sesion.getAttribute("usuario");
            
            if (usuario.equals("null")) {
                rd = contexto.getRequestDispatcher("/index.html");
                rd.forward(request, response);
            }
        %>
        
        <form method="post" action="compruebaTelefono">
        <table>
            <tr><td><img src="images/img-logo-head.gif"></td><td></td></tr>
            <tr><td></td><td style="color:green; text-align: center;"><%=usuario %>,por favor indica su telefono para confirmar la dirección del envío.<br><input type="number" name="telefono"></td></tr>
        
        </table>
        
        <input type="submit" value="Confirmar pedido" style="margin-left: 16%;">
        </form>
    </body>
</html>
<% 

    } catch (NullPointerException e) {
                rd=contexto.getRequestDispatcher("/index.html");
                rd.forward(request, response);
            }

%>
