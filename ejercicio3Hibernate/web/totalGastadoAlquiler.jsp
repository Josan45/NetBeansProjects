<%-- 
    Document   : totalGastadoAlquiler
    Created on : 04-feb-2020, 14:33:15
    Author     : Jose Antonio
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="dvdRental.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            ServletContext contexto = request.getServletContext();

            int tienda = (int) contexto.getAttribute("tienda1");
            int cliente = (int) contexto.getAttribute("cliente1");
            int desde = (int) contexto.getAttribute("desde");
            int hasta = (int) contexto.getAttribute("hasta");

            double total = 0;

            FilmHelp film = new FilmHelp();
            
            List<Store> tien = film.consultaTienda5(tienda);

        %>
        <table border="solid">
            <tr>
                <td>Cliente</td><td>Total alquiler</td>
            </tr>


            <% for (Iterator it = tien.get(0).getCustomers().iterator(); it.hasNext();) {
                        Customer client = (Customer) it.next();

                        total = 0;
                        
                        if (client.getCustomerId() == cliente) {%>
                        
            <tr><td><%=client.getFirstName()%> <%=client.getLastName()%></td>
                
                <%    for (Iterator i = client.getPayments().iterator(); i.hasNext();) {
                        Payment pago = (Payment) i.next();

                        if (pago.getStaff().getStaffId() == tienda) {
                            if (pago.getPaymentDate().getMonth() > desde && pago.getPaymentDate().getMonth() < hasta) {
                                total = total + pago.getAmount();
                            }

                            }
                        }%>
                <td><%=total%></td>
            </tr>
            <%   }
                }
            %>
        </table>

    </body>
</html>
