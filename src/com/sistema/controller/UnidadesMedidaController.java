/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.controller;

import com.sistema.modelo.UnidadesMedidaDTO;
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
public class UnidadesMedidaController {

    conexion con = new conexion();    
    Statement stmt;
    ResultSet rs;
    String sql = "";
    Connection connect = null;
    public UnidadesMedidaDTO unidadById(Integer id){
        UnidadesMedidaDTO unidad = new UnidadesMedidaDTO();
        try {
            connect = con.connectDatabase();
            sql = "SELECT * FROM unidadm WHERE idunidadm="+id;
            stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                unidad.setIdunidadm(rs.getInt(1));
                unidad.setDescripcion(rs.getString(2));
            }
            connect.close();
        } catch (Exception e) {
            System.out.println("Error al obtener undidad de medida por id:"+e.getMessage());
        }
        return unidad;
    }
    
     public List<UnidadesMedidaDTO> unidadesAll(){
        List<UnidadesMedidaDTO>ListaUnidad = new ArrayList<>();
        try {
            connect = con.connectDatabase();
            sql = "SELECT * FROM unidadm";
            stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                UnidadesMedidaDTO unidad = new UnidadesMedidaDTO();
                unidad.setIdunidadm(rs.getInt(1));
                unidad.setDescripcion(rs.getString(2));
                ListaUnidad.add(unidad);
            }
            connect.close();
        } catch (Exception e) {
            System.out.println("Error al obtener lista de unidades de medida:"+e.getMessage());
        }
        return ListaUnidad;
    }
     
       public UnidadesMedidaDTO unidadByNombre(String nombre){
        UnidadesMedidaDTO unidad = new UnidadesMedidaDTO();
        try {
            connect = con.connectDatabase();
            sql = "SELECT * FROM unidadm WHERE descripcion='"+nombre+"'";
            stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                unidad.setIdunidadm(rs.getInt(1));
                unidad.setDescripcion(rs.getString(2));
            }
            connect.close();
        } catch (Exception e) {
            System.out.println("Error al obtener undidad de medida por descripcion:"+e.getMessage());
        }
        return unidad;
    }
}
