<%-- 
    Document   : index
    Created on : 9/04/2025, 4:38:30 p. m.
    Author     : alejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        response.sendRedirect("EmpleadoControlador?accion=listar");
        %>
       
    </body>
</html>
