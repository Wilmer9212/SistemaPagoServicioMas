/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.controller;

import com.sistema.modelo.UnidadesMedidaDTO;
import com.sistema.modelo.UsuarioDTO;
import com.sistema.util.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author wilmer
 */
public class UsuariosController {
    
    
    conexion con = new conexion();
    Statement stmt;
    ResultSet rs;
    String sql = "";
    Connection connect = null;
    PreparedStatement ps;

    public UsuarioDTO usuarioByNombre(String nombre) {
        UsuarioDTO user = new UsuarioDTO();
        try {
            connect = con.connectDatabase();
            sql = "SELECT * FROM usuarios WHERE nombre='"+nombre+"'";
            stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setPassword(rs.getString(3));                
            }
            connect.close();
        } catch (Exception e) {
            System.out.println("Error al obtener usuario por nombre:" + e.getMessage());
        }
        return user;
    }
}
