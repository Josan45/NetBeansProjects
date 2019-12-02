<%@page import="DbConnection.DbConnection"%>
<%@page import="DbConnection.Bebidas"%>
<%@page import="DbConnection.Ensaladas"%>
<%@page import="DbConnection.Complementos"%>
<%@page import="DbConnection.Sandwiches"%>
<%@page import="DbConnection.Menus"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
    </head>
    <body>
        <% 
        ServletContext contexto=request.getServletContext();
        RequestDispatcher rd;
        
        try {    

        HttpSession sesion=request.getSession();
        
        String usuario=(String)sesion.getAttribute("usuario");
        
        if(usuario.equals("null")){
            rd=contexto.getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }
        
        String clave=(String)sesion.getAttribute("clave");
        long fecha=sesion.getCreationTime();
        Date fechaInicio=new Date(fecha);
        Date horaInicio=new Date(fecha);
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora=new SimpleDateFormat("kk:mm:ss");
        
        ArrayList<Menus>menu=new ArrayList();
        menu=DbConnection.consultaMenu();
            
        ArrayList<Sandwiches>sand=new ArrayList();
        sand=DbConnection.consultaSandwis();
        
        ArrayList<Complementos>comple=new ArrayList();
        comple=DbConnection.consultaComplementos();
        
        ArrayList<Ensaladas>ensa=new ArrayList();
        ensa=DbConnection.consultaEnsalada();

        ArrayList<Bebidas>bebi=new ArrayList();
        bebi=DbConnection.consultaBebidas();
            %>
            
            <form action="compruebaPedido" method="POST">
        <table>
            <tr><td><img src="images/img-logo-head.gif"></td><td style="text-align: right; color:green" colspan="2">Bienvenido <%=usuario %> <br>Usted a accedido a nuestra zona de pedidos a las <%=formatoHora.format(horaInicio) %> del <%=formato.format(fechaInicio) %></td></tr>
            <tr><td></td><td><img src="images/menus.gif"></td><td><select name="menu">
                                                                    <option>-----</option>
                                                                    <% for(int x=0;x<menu.size();x++){%>
                                                                    <option value="<% out.print(menu.get(x).getDescripcion()); %>"><% out.print(menu.get(x).getDescripcion()); %></option>
                                                                    <%}%>
                                                                  </select></td></tr>
            <tr><td></td><td><img src="images/sandwis.gif"></td><td><select name="sandwis">
                                                                        <option>-----</option>
                                                                        <% for(int x=0;x<sand.size();x++){%>
                                                                        <option value="<% out.print(sand.get(x).getDescripcion()); %>"><% out.print(sand.get(x).getDescripcion()); %></option>
                                                                        <%}%>
                                                                    </select></td></tr>
            <tr><td></td><td><img src="images/complementos.gif"></td><td><select name="complementos">
                                                                        <option>-----</option>
                                                                        <% for(int x=0;x<comple.size();x++){%>
                                                                        <option value="<% out.print(comple.get(x).getDescripcion()); %>"><% out.print(comple.get(x).getDescripcion()); %></option>
                                                                        <%}%>
                                                                    </select></td></tr>
            <tr><td></td><td><img src="images/ensaladas.gif"></td><td><select name="ensalada">
                                                                        <option>-----</option>
                                                                        <% for(int x=0;x<ensa.size();x++){%>
                                                                        <option value="<% out.print(ensa.get(x).getDescipcion()); %>"><% out.print(ensa.get(x).getDescipcion()); %></option>
                                                                        <%}%>
                                                                    </select></td></tr>
            <tr><td></td><td><img src="images/bebidas.gif"></td><td><select name="bebida">
                                                                        <option>-----</option>
                                                                        <% for(int x=0;x<bebi.size();x++){%>
                                                                        <option value="<% out.print(bebi.get(x).getDescripion()); %>"><% out.print(bebi.get(x).getDescripion()); %></option>
                                                                        <%}%>
                                                                    </select></td></tr>
            <tr><td><img src="images/img-24h.png"></td><td style="text-align: center;color:green;font-weight: bold;" colspan="2">Por favor seleccione los articulos y confirme su pedido <br> Gracias.</td></tr>
        </table>
            <br>
        <input type="submit" value="Confirmar pedido" style="margin-left: 10%;">
        </form>
    </body>
</html>
<% 

    } catch (NullPointerException e) {
                rd=contexto.getRequestDispatcher("/index.html");
                rd.forward(request, response);
            }

%>