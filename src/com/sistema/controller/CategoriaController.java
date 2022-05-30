/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.controller;

import com.sistema.modelo.CategoriaDTO;
import com.sistema.util.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wilmer
 */
public class CategoriaController {
        
    conexion con = new conexion();
    Connection connect = null;
    Statement stmt;
    ResultSet rs;
    String sql = "";

    public List<CategoriaDTO> categoriasAll() {
        List<CategoriaDTO> lista = new ArrayList<>();
        connect = con.connectDatabase();
        try {
            sql = "SELECT * FROM categorias";
            stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CategoriaDTO cat = new CategoriaDTO();
                cat.setIdcategoria(rs.getInt(1));
                cat.setDescripcion(rs.getString(2));
                
                lista.add(cat);
            }
            connect.close();
        } catch (Exception ex) {
            System.out.println("Error al obtener lista de categorias:" + ex.getMessage());
        }
        return lista;
    }

    public CategoriaDTO categoriaById(int id) {
        CategoriaDTO categoria = new CategoriaDTO();
        connect = con.connectDatabase();
        try {
            sql = "SELECT * FROM categorias WHERE idcategoria =" + id;
            stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                categoria.setIdcategoria(rs.getInt(1));
                categoria.setDescripcion(rs.getString(2));
            }
            connect.close();
        } catch (Exception ex) {
            System.out.println("Error al obtener categoria por id:" + ex.getMessage());
        }
        return categoria;
    }
    
       public CategoriaDTO categoriaByNombre(String nombre) {
        CategoriaDTO categoria = new CategoriaDTO();
        connect = con.connectDatabase();
        try {
            sql = "SELECT * FROM categorias WHERE descripcion='"+nombre+"'";
            stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                categoria.setIdcategoria(rs.getInt(1));
                categoria.setDescripcion(rs.getString(2));
            }
            connect.close();
        } catch (Exception ex) {
            System.out.println("Error al obtener categoria por nombre:" + ex.getMessage());
        }
        return categoria;
    }
}
