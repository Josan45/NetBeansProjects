
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Boletin de Noticias</title>
    </head>
    <body>
        <h1>Boletin de noticias que precisa una constante actualizacion</h1>
        Resumen de noticias:<p>
        <ol>
            <li><jsp:include page="/Noticia1.html"/><hr><p>
            <li><jsp:include page="/Noticia2.html"/><hr><p>
            <li><jsp:include page="/Noticia3.jsp">
                <jsp:param name="origen" value="El Pais" />
            </jsp:include><hr><p>
        </ol>
    </body>
</html>
