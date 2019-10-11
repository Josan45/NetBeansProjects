
<%@page info="Curso de Programacion J2EE" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,java.text.*" %>
<html>
    <head>
        <title>
            Segunda pagina jsp
        </title>
    </head>
    <body>
        <%
            Date hoy=new Date();
            DateFormat df=DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM,Locale.getDefault());
        %>
        Fecha en castellano y con formato medio: <%=df.format(hoy)%><p>
        <hr>
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
