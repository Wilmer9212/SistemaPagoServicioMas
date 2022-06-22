/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wilmer
 */
public class conexion {

    public Connection connectDatabase() {
        String db = "gateway";
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        //String url = "jdbc:mysql://localhost:3306/gateway?autoReconnect=true&amp;failOverReadOnly=false&amp;maxReconnects=10&amp;removeAbandonedTimeout=60&amp;testWhileIdle=true&amp;timeBetweenEvictionRunsMillis=300000";
        Connection con = null;

        try {
            /* try {
                //Class.forName("org.postgresql.Driver");
                Class.forName("com.mysql.jdbc.Driver");
                
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }   
            // Database connect
            // Conectamos con la base de datos
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/sivent",
                    "postgres", "root");
           
            
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
              
           }*/

            Class.forName("com.mysql.jdbc.Driver"); 
           con = DriverManager.getConnection(url, user, pass);

        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
