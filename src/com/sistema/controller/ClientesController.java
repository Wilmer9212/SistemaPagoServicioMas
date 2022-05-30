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

    public List<ClienteDTO> findAll() {
        sql = "SELECT * FROM clientes";
        List<ClienteDTO> listaClientes = new ArrayList<>();
        try {
            connect = con.connectDatabase();
            stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setIdcliente(result.getInt(1));
                cliente.setNombre(result.getString(2));
                cliente.setAppaterno(result.getString(3));
                cliente.setApmaterno(result.getString(4));
                cliente.setMail(result.getString(5));
                cliente.setTelefono(result.getInt(6));
                cliente.setApmaterno(sql);
                listaClientes.add(cliente);
            }
            connect.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de tipos venta:" + ex.getMessage());
        }

        return listaClientes;
    }
    
    
}
