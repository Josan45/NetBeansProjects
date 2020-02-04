<%-- 
    Document   : index
    Created on : 04-feb-2020, 12:30:58
    Author     : Jose Antonio
--%>

<%@page import="java.util.List"%>
<%@page import="dvdRental.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Videoteca</title>

        <style>

            #capa{
                width: 40%;
            }

            p{
                background-color: blue;
                color: white;
            }

        </style>

    </head>
    <body>
        <%
            FilmHelp film = new FilmHelp();

            List<Store> tienda = film.consultaTienda();

            List<Customer> cliente = film.consultaCliente();

            //List<Film>pelis=film.consultaPelis();
        %>
    <center>

        <div id="capa">
            <img src="videoteca.gif">
            <hr>

            <form method="POST" action="compruebaDatos">
                <p>Listado de películas alquiladas por un cliente en un videoclub:</p>
                <table>
                    <tr>
                        <td>
                            Video Club:
                            <select name="tienda">
                                <option value="0">-----------</option>
                                <% for (int x = 0; x < tienda.size(); x++) {%>
                                    <option value="<%=tienda.get(x).getStoreId()%>"><%=tienda.get(x).getNombre()%></option>
                                <% } %>
                            </select>
                        </td>

                        <td>
                            Clientes:
                            <select name="cliente">
                                <option value="0">-----------</option>
                                <% for (int x = 0; x < cliente.size(); x++) {%>
                                    <option value="<%=cliente.get(x).getCustomerId()%>"><%=cliente.get(x).getFirstName()%> <%=cliente.get(x).getLastName()%></option>
                                <% } %>
                            </select>
                        </td>
                    <input type="hidden" value="0" name="t">
                        <td><button type="submit">Mostrar</button></td>
                    </tr>
                </table>
            </form>
            <form method="POST" action="compruebaDinero">

                <p>Total de dinero gastado por un cliente en el alquiler de peliculas de un videoclub en un mes:</p>
                <table>
                    <tr>
                        <td>
                            Video Club:
                            <select name="tienda1">
                                <option value="0">-----------</option>
                                <% for (int x = 0; x < tienda.size(); x++) {%>
                                    <option value="<%=tienda.get(x).getStoreId()%>"><%=tienda.get(x).getNombre()%></option>
                                <% } %>
                            </select>
                        </td>
                        <td>
                            Mes desde:
                            <select name="desde">
                                <option value="0">-----------</option>                                
                                <option value="3">Marzo</option>
                                <option value="4">Abril</option>
                                <option value="5">Mayo</option>
                                <option value="6">Junio</option>
                                <option value="7">Julio</option>
                                <option value="8">Agosto</option>                                
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Clientes:
                            <select name="cliente1">
                                <option value="0">-----------</option>
                                <% for (int x = 0; x < cliente.size(); x++) {%>
                                    <option value="<%=cliente.get(x).getCustomerId()%>"><%=cliente.get(x).getFirstName()%> <%=cliente.get(x).getLastName()%></option>
                                <% } %>
                            </select>
                        </td>
                        <td>
                            Mes hasta:
                            <select name="hasta">
                                <option value="0">-----------</option>
                                <option value="3">Marzo</option>
                                <option value="4">Abril</option>
                                <option value="5">Mayo</option>
                                <option value="6">Junio</option>
                                <option value="7">Julio</option>
                                <option value="8">Agosto</option>  
                            </select>
                        </td>
                        <td><button type="submit">Mostrar</button></td>
                    </tr>
                </table>

            </form>
            <form method="POST" action="compruebaDineroTotal">
                <p>Listado de clientes de un videoclub y el total gastado en el alquiler de peliculas</p>
                <table>
                    <tr>
                        <td>
                            Video Club:
                            <select name="tienda2">
                                <option value="0">-----------</option>
                                <% for (int x = 0; x < tienda.size(); x++) {%>
                                    <option value="<%=tienda.get(x).getStoreId()%>"><%=tienda.get(x).getNombre()%></option>
                                <% } %>
                            </select>
                        </td>
                          <input type="hidden" value="0" name="t2">
                        <td><button type="submit">Mostrar</button></td>
                    </tr>
                </table>
            </form>
            <form method="POST" action="compruebaPelisTotal">
                <p>Listado de las peliculas de un videoclub y el total de veces que han sido alquiladas</p>
                <table>
                    <tr>
                        <td>
                            Video Club:
                            <select name="tienda3">
                                <option value="0">-----------</option>
                                <% for (int x = 0; x < tienda.size(); x++) {%>
                                    <option value="<%=tienda.get(x).getStoreId()%>"><%=tienda.get(x).getNombre()%></option>
                                <% } %>
                            </select>
                        </td>
                          <input type="hidden" value="0" name="t3">
                        <td><button type="submit">Mostrar</button></td>
                    </tr>
                </table>
            </form>
            <form method="POST" action="compruebaActores">
                <p>Listado de actores que trabajan en una pelicula</p>
                <table>
                    <tr>
                        <td>
                            Pelicula:
                            <select name="pelis">
                                <option value="0">-----------</option>
                                
                            </select>
                        </td>
                        <td><button type="submit">Mostrar</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </center>
</body>
</html>
