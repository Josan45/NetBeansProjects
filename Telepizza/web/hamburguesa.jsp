<%-- 
    Document   : hamburguesa
    Created on : 05-dic-2019, 16:39:43
    Author     : José Antonio
--%>

<%@page import="DbConnection.DbConnection"%>
<%@page import="DbConnection.hamburguesa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ServletContext contexto = request.getServletContext();
    RequestDispatcher rd;

    HttpSession sesion = request.getSession();

    String usuario = (String) sesion.getAttribute("usuario");
    String contra = (String) sesion.getAttribute("contra");

    if(usuario==null){
         rd = contexto.getRequestDispatcher("/index.html");
         rd.forward(request, response);     
    }
    
    try {


%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Documento sin título</title>

        </style>
        <style type="text/css">
            .inicio {
                text-align: right;
                font-weight: bold;
            }

        </style>
    </head>

    <body>

        <%
            long hora = sesion.getCreationTime();

            Date fechaInicio = new Date(hora);
            Date horaInicio = new Date(hora);

            SimpleDateFormat formatoHora = new SimpleDateFormat("kk:mm:ss");
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

            ArrayList<hamburguesa> lista = new ArrayList();
            lista = DbConnection.consultaHamburguesa();

        %>

        <form action="compruebaHamburguesa" method="POST">
            <table width="100%" border="0">
                <tr bordercolor="#FF0000" bgcolor="#FF0000">
                    <td width="4%" bgcolor="#FFFFFF">&nbsp;</td>
                    <td colspan="3" class="inicio"></td>
                    <td width="7%" bgcolor="#FFFFFF">&nbsp;</td>
                </tr>
                <tr bordercolor="#FF0000" bgcolor="#FF0000">
                    <td width="4%" bgcolor="#FFFFFF">&nbsp;</td>
                    <td colspan="3"><img src="images/images_2016/logo_telepizza.gif"  /><br />
                        <a href="ofertas.jsp"><img src="images/images_2016/ofertas.gif" width="73" height="31" longdesc="http://ofertas.jsp" /></a><a href="menus.jsp"><img src="images/images_2016/menus.gif" width="66" height="31" longdesc="http://ASD" /></a><a href="pizzas.jsp"><img src="images/images_2016/pizzas.gif" width="66" height="31" longdesc="http://SDFG" /></a><a href="entrantes.jsp"><img src="images/images_2016/entrantes.gif" width="85" height="31" longdesc="http://DFGSD" /></a><a href="hamburguesa.jsp"><img src="images/images_2016/hamburguesa.gif" width="123" height="31" longdesc="http://DFGDF" /></a><a href="pasta.jsp"><img src="images/images_2016/pasta.gif" width="58" height="31" longdesc="http://DFGH" /></a><a href="ensalada.jsp"><img src="images/images_2016/ensaladas.gif" width="94" height="31" longdesc="http://DFGH" /></a><a href="bebidas.jsp"><img src="images/images_2016/bebidas.gif" width="76" height="31" longdesc="http://SFGHDF" /></a><a href="postre.jsp"><img src="images/images_2016/postres.gif" width="70" height="31" alt="" longdesc="http://SDF" /></a></td>
                    <td width="7%" bgcolor="#FFFFFF">&nbsp;</td>
                </tr>
                <tr bordercolor="#FF0000" bgcolor="#FF0000">
                    <td width="4%" bgcolor="#FFFFFF">&nbsp;</td>
                    <td width="46%">&nbsp;</td>
                    <td colspan="2">&nbsp;</td>
                    <td width="7%" bgcolor="#FFFFFF">&nbsp;</td>
                </tr>
                <tr style="color: red;">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td style="text-align: right;">Bienvenido <%=usuario%><br> Usted a accedido a nuestra zona de pedidos a las: <%=formatoHora.format(horaInicio)%> del <%=formatoFecha.format(fechaInicio)%></td>
                </tr>
                <tr>
                    <td></td>
                    <td style="text-align: center;">Hamburguesa: <br>
                            <select name="hamburguesa">
                                <option>------------------------</option>
                                <%
                                    for (int x = 0; x < lista.size(); x++) {%>
                                <option><% out.print(lista.get(x).getNomhamburguesa()); %></option>
                                <% }
                                %>
                            </select>

                            <select name="cantidad">
                                <option>0</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                            <br><br>
                            <input type="submit" value="Elegir pasta">
                    </td>
                            <td></td>
                            <td style="text-align: center;"><img src="images/images_2016/entrantes.png"></td>
                </tr>
                <tr bgcolor="#990000" >
                    <td width="4%" bgcolor="#FFFFFF">&nbsp;</td>
                    <td align="left" width="46%"><img src="images/images_2016/telepizza_espana.gif" width="133" height="30" /></td>
                    <td align="right" colspan="2"><img src="images/images_2016/ico_facebook.gif" width="31" height="30" /> <img src="images/images_2016/ico_twitter.gif" width="31" height="30" /> <img src="images/images_2016/ico_youtube.gif" width="31" height="30" /> <img src="images/images_2016/ico_google.gif" width="31" height="30" /> <img src="images/images_2016/ico_instagram.gif" width="31" height="30" />&nbsp; </td>
                    <td width="7%" bgcolor="#FFFFFF">&nbsp;</td>
                </tr>
            </table>
        </form>

    </body>
</html>
<%

} catch (NullPointerException e) {                                                    
        rd = contexto.getRequestDispatcher("/index.html");
        rd.forward(request, response);                                                       
    }

%>