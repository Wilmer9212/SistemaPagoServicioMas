/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.controller;

import com.sistema.modelo.TiposVentaDTO;
import com.sistema.modelo.VentaRealizadaDTO;
import com.sistema.util.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wilmer
 */
public class VentasController {   
    conexion con=new conexion();   
    Statement stmt;
    Connection connect = null;
    PreparedStatement ps;
    String sql = "";
    public List<TiposVentaDTO> tiposVenta(){        
        sql = "SELECT * FROM tiposventa";        
        List<TiposVentaDTO>listaTiposVenta = new ArrayList<>();
        try {
            connect = con.connectDatabase();    
            stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while(result.next()){
                TiposVentaDTO tipo = new TiposVentaDTO();
                tipo.setIdtipoventa(result.getInt(1));
                tipo.setDescripcion(result.getString(2));
                listaTiposVenta.add(tipo);
            }            
         connect.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de tipos venta:"+ex.getMessage());
        }   
        
        return listaTiposVenta;
    }   
    
    public int insertarVentaRealizada(VentaRealizadaDTO venta){
         sql = "INSERT INTO ventas_realizadas VALUES(?,?,?,?,?)";
         int registros = 0;
         try {
             connect = con.connectDatabase();    
             ps = connect.prepareStatement(sql);
             ps.setInt(1,venta.getIdticket());
             ps.setTimestamp(2, venta.getFecha());
             ps.setString(3, venta.getTipoventa());
             ps.setDouble(4, venta.getTotalventa());
             ps.setInt(5, venta.getIdUsuario());
            registros = ps.executeUpdate();
             connect.close();
         } catch (Exception e) {
             System.out.println("Error al insertar ventas realizadas:"+e.getMessage());
         }
        return registros;
    }
    
    public int insertarDetalleVenta(){
       
        return 0;
    }
    
    
}
