/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.evidencia.pe.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.evidencia.pe.modelo.dao.EmpleadoDAO;
import com.evidencia.pe.modelo.Empleado;

/**
 *
 * @author alejo
 */
public class EmpleadoControlador extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EmpleadoDAO empDAO = new EmpleadoDAO();
    private final String pagListar = "/vista/listar.jsp";
    private final String pagNuevo = "/vista/nuevo.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("accion");

        if (action != null) {
            switch (action) {
                case "listar":
                    listar(request, response);
                    break;
                case "nuevo":
                    nuevo(request, response);
                    break;
                case "guardar":
                    guardar(request, response);
                    break;
                case "editar":
                    editar(request, response);
                    break;
                case "eliminar":
                    eliminar(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida");
                    break;
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el parámetro 'accion'");
        }
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int result = empDAO.eliminar(id);
        if (result > 0) {
            request.getSession().setAttribute("success", "Empleado eliminado con éxito" + " con ID: " + id);
        } else {
            request.getSession().setAttribute("error", "Error al eliminar el empleado" + " con ID: " + id);
        }
        response.sendRedirect("EmpleadoControlador?accion=listar");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Empleado obj = empDAO.buscarPorId(id);
        if (obj != null) {
            request.setAttribute("empleado", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        } else {
            request.getSession().setAttribute("error", "Empleado no encontrado" + " con ID: " + id);
            response.sendRedirect("EmpleadoControlador?accion=listar");
        }
    }

    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Empleado obj = new Empleado();
        obj.setId(Integer.parseInt(request.getParameter("id")));
        obj.setNombres(request.getParameter("nombres"));
        obj.setApellidos(request.getParameter("apellidos"));
        obj.setFecha_ingreso(request.getParameter("fecha_ingreso"));
        obj.setSueldo(Double.parseDouble(request.getParameter("sueldo")));

        int result;
        if (obj.getId() == 0) {
            result = empDAO.registrar(obj);
        } else {
            result = empDAO.editar(obj);
        }
        if (result > 0) {
            request.getSession().setAttribute("success", "Datos guardados");
            response.sendRedirect("EmpleadoControlador?accion=listar");
            // Redirigir a la lista de empleados después de guardar
        } else {
            request.getSession().setAttribute("error", "No se pudieron enviar datos");
            request.setAttribute("empleado", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }

    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("empleado", new Empleado());
        request.getRequestDispatcher(pagNuevo).forward(request, response);

    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("empleados", empDAO.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }

}
