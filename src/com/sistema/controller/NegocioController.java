/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.controller;

import com.sistema.modelo.CategoriaDTO;
import com.sistema.util.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wilmer
 */
public class NegocioController {

    conexion con = new conexion();
    Connection connect = null;
    Statement stmt;
    ResultSet rs;
    String sql = "";
    PreparedStatement ps;

    public String nombre() {
        String name = "";
        connect = con.connectDatabase();
        try {
            sql = "SELECT nombre FROM nombre_negocio LIMIT 1";

            stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                name = rs.getString(1);
            }
            connect.close();
        } catch (Exception ex) {
            System.out.println("Error al obtener nombre negocio:" + ex.getMessage());
        }
        return name;
    }

    public boolean save(String name) {
        boolean bandera = false;
        connect = con.connectDatabase();
        try {
            sql = "INSERT INTO nombre_negocio VALUES(?)";
            ps = connect.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
            connect.close();
            bandera = true;
        } catch (Exception e) {
            System.out.println("Error al insertar nombre negocio:" + e.getMessage());
        }
        return bandera;
    }
    
     public boolean update(String name) {
        boolean bandera = false;
        connect = con.connectDatabase();
        try {
            sql = "UPDATE nombre_negocio SET nombre=?";
            ps = connect.prepareStatement(sql);
            ps.setString(1,name);
            ps.executeUpdate();
            connect.close();
            bandera = true;
        } catch (Exception e) {
            System.out.println("Error al modificar nombre negocio:" + e.getMessage());
        }
        return bandera;
    }

}
