/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.evidencia.pe.modelo.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.evidencia.pe.modelo.Empleado;
import com.evidencia.pe.config.Conexion;

/**
 *
 * @author alejo
 */
public class EmpleadoDAO {
    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Empleado> ListarTodos() {
        ArrayList<Empleado> lista = new ArrayList<>();

        String sql = "SELECT * FROM empleado";
        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado obj = new Empleado();
                obj.setId(rs.getInt("id"));
                obj.setNombres(rs.getString("nombres"));
                obj.setApellidos(rs.getString("apellidos"));
                obj.setFecha_ingreso(rs.getString("fecha_ingreso"));
                obj.setSueldo(rs.getDouble("sueldo"));
                // Agregar el objeto a la lista
                lista.add(obj);
            }
        } catch (Exception e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return lista;
}


public int registrar(Empleado obj) {
    int resultado = 0;
    String sql = "INSERT INTO empleado (nombres, apellidos, fecha_ingreso, sueldo) VALUES (?, ?, ?, ?)";
    try {
        cn = Conexion.getConnection();
        ps = cn.prepareStatement(sql);
        ps.setString(1, obj.getNombres());
        ps.setString(2, obj.getApellidos());
        ps.setString(3, obj.getFecha_ingreso());
        ps.setDouble(4, obj.getSueldo());
        resultado = ps.executeUpdate();
    } catch (Exception e) {
        System.out.println("Error al registrar empleado: " + e.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
    return resultado;
}


public Empleado buscarPorId(int id) {
    Empleado obj = null;

    String sql = "SELECT * FROM empleado WHERE id = ?";
    try {
        cn = Conexion.getConnection();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            obj = new Empleado();
            obj.setId(rs.getInt("id"));
            obj.setNombres(rs.getString("nombres"));
            obj.setApellidos(rs.getString("apellidos"));
            obj.setFecha_ingreso(rs.getString("fecha_ingreso"));
            obj.setSueldo(rs.getDouble("sueldo"));
        }
    } catch (Exception e) {
        System.out.println("Error al listar empleados: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
    return obj;
}



public int editar(Empleado obj) {
    int resultado = 0;
    String sql = "UPDATE empleado SET nombres = ?, apellidos = ?, fecha_ingreso = ?, sueldo = ? WHERE id = ?";
    try {
        cn = Conexion.getConnection();
        ps = cn.prepareStatement(sql);
        ps.setString(1, obj.getNombres());
        ps.setString(2, obj.getApellidos());
        ps.setString(3, obj.getFecha_ingreso());
        ps.setDouble(4, obj.getSueldo());
        ps.setInt(5, obj.getId());
        resultado = ps.executeUpdate();
    } catch (Exception e) {
        System.out.println("Error al registrar empleado: " + e.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
    return resultado;
}
public int eliminar(int id) {
    int resultado = 0;
    String sql = "DELETE FROM empleado WHERE id = ?";
    try {
        cn = Conexion.getConnection();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, id);
        resultado = ps.executeUpdate();
    } catch (Exception e) {
        System.out.println("Error al eliminar empleado: " + e.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
    return resultado;
}

}