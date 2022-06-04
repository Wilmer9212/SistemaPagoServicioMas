/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author wilmer
 */
public class conexion {

    Connection con = null;
    public Connection connectDatabase()  {
        try {
           try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }   
            // Database connect
            // Conectamos con la base de datos
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/test",
                    "saicoop", "slufpana?");
            
           if(con != null){
              // System.out.println("Connection Exitosa....");
           }else{
               JOptionPane.showMessageDialog(null,"ERROR AL CONECTAR A BASE DE DATOS","",JOptionPane.ERROR_MESSAGE);
               System.out.println("Error en conexion\n Saliendo del sistema...");
               try {
                    Thread.sleep(3000);
                    System.exit(0);
               } catch (Exception e) {
               }
              
           }
                
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }        
        return con;
    }
}
