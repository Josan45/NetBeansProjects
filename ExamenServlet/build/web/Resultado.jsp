<%-- 
    Document   : Resultado
    Created on : 23-oct-2019, 12:03:55
    Author     : Examen
--%>

<%@page import="Modelo.ListaParte"%>
<%@page import="Modelo.Listado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Partes</title>
        <style>
            table{
                margin-top: 10%;
                margin-left: 25%;
                border: 2px black solid;
            }
            td{
                border:2px black solid;
            }
            button{
                margin-left: 40%;
                margin-top: 10%;
            }
        </style>
    </head>
    <body>
        <table>
            <tr>
                <td>Nº SS</td>
                <td>Apellido1</td>
                <td>Apellido2</td>
                <td>Nombre</td>
                <td>CIF</td>
                <td>Empresa</td>
                <td>Descripcion</td>
            </tr>
            
            <%
              for(int x=0;x<Listado.lista.size();x++){
                String nombre=Listado.lista.get(x).getNombre();
                String apellido1=Listado.lista.get(x).getApellido1();
                String apellido2=Listado.lista.get(x).getApellido2();
                String nss=Listado.lista.get(x).getNss();
                String cif=Listado.lista.get(x).getCif();
                String razsoc=Listado.lista.get(x).getRazsoc();
                String texto=Listado.lista.get(x).getTexto();
              
            %>
            
            <tr>
                <td><%=nss%></td>
                <td><%=apellido1%></td>
                <td><%=apellido2%></td>
                <td><%=nombre%></td>
                <td><%=cif%></td>
                <td><%=razsoc%></td>
                <td><%=texto%></td>
            </tr>
            <%}%>
        </table>
        <button>
            <a href="Formulario.html">Seguir Añadiendo Partes</a>
        </button>
    </body>
</html>
