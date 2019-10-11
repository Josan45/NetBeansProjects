
<%@page info="Curso de Programacion J2EE" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>
            Primera página jsp
        </title>
    </head>
    </body>
    <%
        String alumno=request.getParameter("nombre");
        if(alumno==null){
            alumno="Jose Antonio";
        }
    %>
    HOLA <font color="green"><b><%=alumno%></b></font>,como te va la vida?<p>
    <hr>
    <% out.println(getServletInfo());%>
</body>
</html>
