/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saivent.reportes;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author Elliot
 */
public class PlantillaReporteVenta {

    public PlantillaReporteVenta(String fechaInit) {
    }

    public String generar() {
        File file;
        try {
            Document doc = new Document();
            FileOutputStream archivo = new FileOutputStream("/C:\\Users\\Elliot\\Documents\\IText7\\example.pdf");

            Paragraph TituloReporte = new Paragraph("REPORTE VENTAS", FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.BLACK));
            Paragraph Empresa = new Paragraph("VETERINARIA DEL CAMPO S.A de C.V", FontFactory.getFont("arial", 15, Font.BOLD, BaseColor.BLACK));
            Paragraph FechaReporte = new Paragraph("Reporte del : " + "04-04-2002 al 25-05-2022", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
            HeaderFooterPageEvent footer = new HeaderFooterPageEvent();
            // Se crea el documento
            Document documento = new Document();
            // Se asocia el documento al OutputStream y se indica que el espaciado entre
            // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
            PdfWriter writer = PdfWriter.getInstance(documento, archivo);
            // Se abre el documento.
            TituloReporte.setAlignment(1);
            Empresa.setAlignment(1);
            FechaReporte.setAlignment(2);
            documento.open();
            documento.add(TituloReporte);
            documento.add(Empresa);
            documento.add(Chunk.NEWLINE);
            documento.add(FechaReporte);
            documento.add(Chunk.NEWLINE);
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            PdfPCell celdaNombre = new PdfPCell(new Phrase("Nombre"));
            PdfPCell celdaAppaterno = new PdfPCell(new Phrase("Nombre"));
            PdfPCell celdaAppMaterno = new PdfPCell(new Phrase("Nombre"));
            celdaNombre.setBackgroundColor(BaseColor.ORANGE);
            tabla.addCell(celdaNombre);
            tabla.addCell(celdaAppaterno);
            tabla.addCell(celdaAppMaterno);
            for (int i = 0; i < 15; i++) {
                tabla.addCell("celda " + i);
            }
            documento.add(tabla);
            writer.setPageEvent(footer);
            documento.close();

        } catch (Exception e) {
            System.out.println("Error de pdf:" + e.getMessage());
        }

        return "";
    }
}
