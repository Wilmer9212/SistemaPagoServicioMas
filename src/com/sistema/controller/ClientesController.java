/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.controller;

import com.sistema.modelo.ClienteDTO;
import com.sistema.util.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientesController {

    conexion con = new conexion();
    Statement stmt;
    Connection connect = null;
    PreparedStatement ps;
    String sql = "";
    ResultSet rs;
    
    public List<ClienteDTO> findAll(String valor) {
        if (!valor.equals("")) {
            sql = "SELECT * FROM clientes WHERE nombre LIKE '%"+valor+"%'";
        } else {
            sql = "SELECT * FROM clientes";
        }
        List<ClienteDTO> listaClientes = new ArrayList<>();
        try {
            connect = con.connectDatabase();
            stmt = connect.createStatement();
              rs= stmt.executeQuery(sql);
            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setIdcliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setAppaterno(rs.getString(3));
                cliente.setApmaterno(rs.getString(4));
                cliente.setDomicilio(rs.getString(5));
                cliente.setMail(rs.getString(6));
                cliente.setTelefono(rs.getString(7));
                cliente.setActivo(rs.getBoolean(8));
                cliente.setGenero(rs.getString(9));
                cliente.setIdcolonia(rs.getInt(10));
                
                listaClientes.add(cliente);
            }
            connect.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de tipos venta:" + ex.getMessage());
        }

        return listaClientes;
    }

    public ClienteDTO clienteById(Integer id) {
        ClienteDTO cliente = new ClienteDTO();
        try {
            connect = con.connectDatabase();
            sql = "SELECT * FROM clientes WHERE idcliente=" + id;
            stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cliente.setIdcliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setAppaterno(rs.getString(3));
                cliente.setApmaterno(rs.getString(4));
                cliente.setDomicilio(rs.getString(5));
                cliente.setMail(rs.getString(6));
                 cliente.setTelefono(rs.getString(7));
                cliente.setActivo(rs.getBoolean(8));
                cliente.setGenero(rs.getString(9));
                cliente.setIdcolonia(rs.getInt(10));
            }
            connect.close();
        } catch (Exception e) {
            System.out.println("Error al obtener estado por id:" + e.getMessage());
        }
        return cliente;
    }

    public ClienteDTO clienteByNombre(String nombre) {
        ClienteDTO cliente = new ClienteDTO();
        try {
            connect = con.connectDatabase();
            sql = "SELECT * FROM clientes WHERE nombre='" + nombre + "'";
            stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                 cliente.setIdcliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setAppaterno(rs.getString(3));
                cliente.setApmaterno(rs.getString(4));
                cliente.setDomicilio(rs.getString(5));
                cliente.setMail(rs.getString(6));
                 cliente.setTelefono(rs.getString(7));
                cliente.setActivo(rs.getBoolean(8));
                cliente.setGenero(rs.getString(9));
                cliente.setIdcolonia(rs.getInt(10));
            }
            connect.close();
        } catch (Exception e) {
            System.out.println("Error al cliente por nombre:" + e.getMessage());
        }
        return cliente;
    }

    public boolean save(ClienteDTO cliente) {
        boolean bandera = false;
        connect = con.connectDatabase();
        try {
            sql = "INSERT INTO clientes VALUES(?,?,?,?,?,?,?,?,?,?)";
            ps = connect.prepareStatement(sql);
            ps.setInt(1, cliente.getIdcliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3,cliente.getAppaterno());
            ps.setString(4, cliente.getApmaterno());
            ps.setString(5, cliente.getDomicilio());
            ps.setString(6, cliente.getMail());
            ps.setString(7 ,cliente.getTelefono());
            ps.setBoolean(8, cliente.isActivo());
            ps.setString(9, cliente.getGenero());
            ps.setInt(10, cliente.getIdcolonia());
            ps.executeUpdate();
            connect.close();
            bandera = true;
        } catch (Exception e) {
            System.out.println("Error al insertar cliente:" + e.getMessage());
        }
        return bandera;
    }

    public boolean update(ClienteDTO cliente) {
        boolean bandera = false;
        connect = con.connectDatabase();
        try {
            sql = "UPDATE clientes set nombre=?,"
                                    + "appaterno=?,"
                                    + "apmaterno=?,"
                                    + "domicilio=?,"
                                    + "email=?,"
                                    + "telefono=?,"
                                    + "activo=?,"
                                    + "sexo=?,"
                                    + "idcolonia=? WHERE idcliente=?";
            ps = connect.prepareStatement(sql);
            ps.setInt(10, cliente.getIdcliente());
            ps.setString(1, cliente.getNombre());
            ps.setString(2,cliente.getAppaterno());
            ps.setString(3, cliente.getApmaterno());
            ps.setString(4, cliente.getDomicilio());
            ps.setString(5, cliente.getMail());
            ps.setString(6, cliente.getTelefono());
            ps.setBoolean(7, cliente.isActivo());
            ps.setString(8, cliente.getGenero());
            ps.setInt(9, cliente.getIdcolonia());
            ps.executeUpdate();
            connect.close();
            bandera = true;
        } catch (Exception e) {
            System.out.println("Error al modificar cliente:" + e.getMessage());
        }
        return bandera;
    }

    public boolean delete(int id) {
        boolean bandera = false;
        connect = con.connectDatabase();
        try {
            sql = "DELETE FROM clientes WHERE idcliente =?";
            ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            connect.close();
            bandera = true;
        } catch (Exception e) {
            System.out.println("Error al  al eliminar cliente:" + e.getMessage());
        }
        return bandera;
    }

    public int generarSecuenciaId() {
        int c = 0;
        connect = con.connectDatabase();

        try {
            sql = "SELECT * FROM clientes ORDER BY idcliente DESC LIMIT 1";
            stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = rs.getInt(1);
            }
            if (c == 0) {
                c = 1;
            } else {
                c = c + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al generar numeracion clientes:" + ex.getMessage());
        }
        return c;
    }
}
