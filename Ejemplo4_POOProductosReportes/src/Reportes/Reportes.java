/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

import Datos.Producto;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author polares
 */
public class Reportes {
    
    public static void generarReportePDF(Producto[] productos) {
        //Se importa la clase documento de la libreria itext
        Document documento = new Document();

        try {
            PdfWriter.getInstance(documento, new FileOutputStream("productos.pdf"));
            documento.open();

            Paragraph titulo = new Paragraph("Reporte de Productos",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            documento.add(Chunk.NEWLINE);

            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);

            tabla.addCell("Id");
            tabla.addCell("Nombre");
            tabla.addCell("Precio");
            tabla.addCell("Cantidad");
            
            //Id - Nombre - Precio - Cantidad
            for (Producto producto: productos) {
                if(producto != null) {
                    tabla.addCell(Integer.toString(producto.getId()));
                    tabla.addCell(producto.getNombre());
                    tabla.addCell(Double.toString(producto.getPrecio()));
                    tabla.addCell(Integer.toString(producto.getCantidad()));
                }
            }
            //1, Sopa, 100, 900
            documento.add(tabla);
            System.out.println("PDF generado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            documento.close();
        }
    }
    
    public static void generarReporteTxt(Producto[] productos) {
        try (FileWriter writer = new FileWriter("productos.txt")) {
            
            writer.write("Id -  Nombre - Precio - Cantidad\n");
            for (Producto producto : productos) {
                if(producto != null) {
                    String linea = producto.getId() + " - " 
                             + producto.getNombre() + " - " 
                             + producto.getPrecio() + " - " 
                             + producto.getCantidad();
                    writer.write(linea);
                    writer.write("\n");
                }
                //1 - Sopa - 100 - 900
            }
            System.out.println("Archivo TXT generado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
