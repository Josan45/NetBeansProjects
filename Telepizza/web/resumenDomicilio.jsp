<%-- 
    Document   : resumenDomicilio
    Created on : 05-dic-2019, 17:16:42
    Author     : José Antonio
--%>

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

    try {


%>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta charset="UTF-8">
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

            long hora = sesion.getLastAccessedTime();
            
            Date fechaFinal = new Date(hora);
            Date horaFinal = new Date(hora);

            SimpleDateFormat formatoHora = new SimpleDateFormat("kk:mm:ss");
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            
            String oferta=(String) sesion.getAttribute("oferta");
            int cantidadOferta=(int)sesion.getAttribute("cantidadOferta");

            String menu=(String) sesion.getAttribute("menu");
            int cantidadMenu=(int)sesion.getAttribute("cantidadMenu");
            
            String pizza=(String) sesion.getAttribute("pizza");
            int cantidadPizza=(int)sesion.getAttribute("cantidadPizza");
            
            String entrante=(String) sesion.getAttribute("entrante");
            int cantidadEntrante=(int)sesion.getAttribute("cantidadEntrante");
            
            String hamburguesa=(String) sesion.getAttribute("hamburguesa");
            int cantidadHamburguesa=(int)sesion.getAttribute("cantidadHamburguesa");
            
            String pasta=(String) sesion.getAttribute("pasta");
            int cantidadPasta=(int)sesion.getAttribute("cantidadPasta");
            
            String ensalada=(String) sesion.getAttribute("ensalada");
            int cantidadEnsalada=(int)sesion.getAttribute("cantidadEnsalada");
            
            String bebida=(String) sesion.getAttribute("bebidas");
            int cantidadBebida=(int)sesion.getAttribute("cantidadBebidas");
            
            String postre=(String) sesion.getAttribute("postre");
            int cantidadPostre=(int)sesion.getAttribute("cantidadPostre");  
        %>

        <form action="compruebaPedidos" method="POST">
            <table width="100%" border="0">
                <tr bordercolor="#FF0000" bgcolor="#FF0000">
                    <td width="4%" bgcolor="#FFFFFF">&nbsp;</td>
                    <td colspan="3" class="inicio"><a href="index.html">Salir </a></td>
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
                    <td>Gracias <%=usuario%>, tu pedido ha sido tramitado a las  <%=formatoHora.format(horaFinal)%> del <%=formatoFecha.format(fechaFinal)%>, y <br> consta de los siguientes productos:</td>
                    <td></td>
                    <td></td>
                </tr>
                <tr style="">
                    <td></td>
                    <td>
                        <%
                        if(cantidadOferta==0){
                            
                        }else{
                          out.print("OFERTA <li>"+cantidadOferta+" ---> "+oferta+" </li><br>");  
                        }
                        
                        if(cantidadMenu==0){
                            
                        }else{
                           out.print("MENU <li>"+cantidadMenu+" ---> "+menu+" </li><br>");
                        }
                        
                        if(cantidadPizza==0){
                            
                        }else{
                            out.print("PIZZA <li>"+cantidadPizza+" ---> "+pizza+" </li><br>");
                        }
                        
                        if(cantidadEntrante==0){
                            
                        }else{
                           out.print("ENTRANTES <li>"+cantidadEntrante+" ---> "+entrante+" </li><br>");
                        }
                        
                        if(cantidadHamburguesa==0){
                            
                        }else{
                            out.print("HAMBURGUESAS <li>"+cantidadHamburguesa+" ---> "+hamburguesa+" </li><br>");
                        }
                        
                        if(cantidadPasta==0){
                            
                        }else{
                           out.print("PASTA <li>"+cantidadPasta+" ---> "+pasta+" </li><br>");
                        }
                        
                        if(cantidadEnsalada==0){
                            
                        }else{
                          out.print("ENSALADAS <li>"+cantidadEnsalada+" ---> "+ensalada+" </li><br>");
                        }
                        
                        if(cantidadBebida==0){
                            
                        }else{
                          out.print("BEBIDAS <li>"+cantidadBebida+" ---> "+bebida+" </li><br>");
                        }
                        
                        if(cantidadPostre==0){
                            
                        }else{
                           out.print("POSTRE <li>"+cantidadPostre+" ---> "+postre+" </li><br>");
                        }
                        %>
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                    
                    <tr>
                        <td></td>
                        <td>Aproximadamente en 30 minutos estará su pedido en su domicilio</td>
                        <td></td>
                        <td></td>
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