<%-- Document : nuevo Created on : 9/04/2025, 5:53:36 p. m. Author : alejo --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
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
                <title>Formulario Empleado</title>
            </head>

            <body>
                <div class="container mt-4">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="text-center">${empleado.id == 0 ? "Nuevo": "Editar"} Empleado</h2>
                        </div>
                        <div class="card-body">
                            <form action="EmpleadoControlador" method="post">
                                <div class="mb-3">
                                    <label class="form-label">Nombre</label>
                                    <input type="text" value="${empleado.nombres}" class="form-control" name="nombres" required>
                                    <div class="invalid-feedback">
                                        Este campo es obligatorio.
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Apellido</label>
                                    <input type="text" value="${empleado.apellidos}" class="form-control" name="apellidos" required>
                                    <div class="invalid-feedback">
                                        Este campo es obligatorio.
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label  class="form-label">Fecha de ingreso</label>
                                    <input type="date" value="${empleado.fecha_ingreso}" class="form-control"  name="fecha_ingreso" required>
                                    <div class="invalid-feedback">
                                        Este campo es obligatorio.
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label  class="form-label">Sueldo</label>
                                    <input type="number" value="${empleado.sueldo}" class="form-control"  name="sueldo" required>
                                    <div class="invalid-feedback">
                                        Este campo es obligatorio.
                                    </div>
                                </div>
                                
                                <div class="d-flex justify-content-between">
                                    <input type="hidden" name="id" value="${empleado.id}">
                                    <input type="hidden" name="accion" value="guardar">
                                    <a href="EmpleadoControlador?accion=listar" class="btn btn-secondary">
                                        <i class="fa fa-arrow-left"></i>
                                        Volver
                                    </a>
                                    <button type="submit" class="btn btn-primary">
                                        <i class="fa fa-save"></i>
                                        Guardar
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                
            </body>

            </html>