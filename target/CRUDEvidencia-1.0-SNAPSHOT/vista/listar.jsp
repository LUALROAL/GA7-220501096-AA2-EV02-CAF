<%-- Document : listar Created on : 9/04/2025, 4:45:14 p. m. Author : alejo --%>

    <%@ page contentType="text/html" pageEncoding="UTF-8" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7"
                    crossorigin="anonymous">
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
                    integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
                    crossorigin="anonymous" referrerpolicy="no-referrer" />
                <title>Empleados</title>
            </head>

            <body>
                <div class="container mt-4">
                    <div class="card">
                        <div class="card-body">
                            <h2 class="text-center">Lista de Empleados</h2>
                            <hr>
                            <a href="EmpleadoControlador?accion=nuevo" class="btn btn-primary mb-2">
                                <i class="fa fa-plus-circle"></i> Nuevo Empleado
                            </a>


                            <jsp:include page="/componets/Mensaje.jsp" />
                            <table class="table table-striped table-bordered table-hover mt-2">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Fecha de ingreso</th>
                                        <th>Sueldo</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="empleado" items="${empleados}">
                                        <tr>
                                            <td>${empleado.id}</td>
                                            <td>${empleado.nombres}</td>
                                            <td>${empleado.apellidos}</td>
                                            <td>${empleado.fecha_ingreso}</td>
                                            <td>${empleado.sueldo}</td>
                                            <td>
                                                <a href="EmpleadoControlador?accion=editar&id=${empleado.id}"
                                                    class="btn btn-info">
                                                    <i class="fa fa-edit"></i>
                                                </a>
                                                |
                                                <a href="EmpleadoControlador?accion=eliminar&id=${empleado.id}" class="btn btn-danger btn-sm"
                                                    onclick="return confirm('¿Está seguro de eliminar este empleado?');">
                                                    <i class="fa fa-trash"></i>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${empty empleados}">
                                        <tr>
                                            <td colspan="6">No hay empleados registrados.</td>
                                        </tr>
                                    </c:if>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </body>

            </html>