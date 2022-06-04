package com.taecel.conexionservicio;

import com.google.gson.Gson;
import org.json.JSONObject;

import com.taecel.modelo.BalanceDTO;
import com.taecel.modelo.ProductsDTO;
import com.taecel.modelo.StatusDTO;
import com.taecel.modelo.TransaccionDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class metodosHTTP {

    conexionhttp conect = new conexionhttp();
    Gson gson = new Gson();

    public BalanceDTO getBalance() {
        BalanceDTO balanceResponse = null;
        try {
            JSONObject json = conect.urlConnect("POST", "https://taecel.com/app/api/getBalance", "");
            balanceResponse = gson.fromJson(json.toString(), BalanceDTO.class);

        } catch (Exception e) {
            System.out.println("Error al realizar el consumo:" + e.getMessage());
        }
        return balanceResponse;
    }

    public BalanceDTO getSales(String fecha, String idBolsa) {
        BalanceDTO balanceResponse = null;
        try {
            JSONObject json = conect.urlConnect("POST", "https://taecel.com/app/api/getSales", "&fecha=" + fecha + "&bolsa=" + idBolsa);

            balanceResponse = gson.fromJson(json.toString().replace("\\\\", ""), BalanceDTO.class);

        } catch (Exception e) {
            System.out.println("Error al realizar el consumo:" + e.getMessage());
        }
        return balanceResponse;
    }

    public ProductsDTO getProducts() {
        ProductsDTO productsResponse = null;
       try {
            JSONObject json = conect.urlConnect("POST", "https://taecel.com/app/api/getProducts", "");
            productsResponse = gson.fromJson(json.toString(), ProductsDTO.class);

        } catch (Exception e) {
            System.out.println("Error al realizar el consumo getProducts:" + e.getMessage());
        }
        return productsResponse;
    }

    public TransaccionDTO getTransaccion(String producto, String referencia, String monto) {
        TransaccionDTO transaccionResponse = null;
        try {
            JSONObject json = conect.urlConnect("POST", "https://taecel.com/app/api/RequestTXN", "&producto=" + producto + "&referencia=" + referencia + "&monto=" + monto);
            System.out.println("Json:"+json);
            transaccionResponse = gson.fromJson(json.toString(), TransaccionDTO.class);           
        } catch (Exception e) {
            System.out.println("Error al realizar el consumo de productos:" + e.getMessage());
        }
        return transaccionResponse;
    }

    public StatusDTO getStatus(String idtransaccion) {
        StatusDTO statusResponse = null;
        try {
            JSONObject json = conect.urlConnect("POST", "https://taecel.com/app/api/StatusTXN", "&transID=" + idtransaccion);
            statusResponse = gson.fromJson(json.toString(), StatusDTO.class);

        } catch (Exception e) {
            System.out.println("Error al realizar el consumo:" + e.getMessage());
        }
        return statusResponse;
    }

    public String productosTaecel(String contenido) {
        String contenidoResultado = "";
        try {
          File file = new File(System.getProperty("user.home") + System.getProperty("file.separator") + ".taecel");
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
            }

            String rutaFile = System.getProperty("user.home") + System.getProperty("file.separator") + ".taecel";
            File foundFile = new File(rutaFile);
            if (foundFile.exists()) {
                FileReader fileRead = new FileReader(foundFile);
                BufferedReader br = new BufferedReader(fileRead);
                String linea;
                while ((linea = br.readLine()) != null) {
                    contenidoResultado = contenidoResultado + linea;
                }
            } else {
                System.out.println("El fichero no existe: " + rutaFile);

            }

        } catch (Exception e) {
            System.out.println("Error al crear archivo productos:" + e.getMessage());
        }
        
        return contenidoResultado;

    }

}
