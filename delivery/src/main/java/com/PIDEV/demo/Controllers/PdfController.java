package com.PIDEV.demo.Controllers;

import com.PIDEV.demo.Entities.Delivery;
import com.PIDEV.demo.Services.IDeliveryService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Api1")
public class PdfController {

   // http://localhost:8888/pidev/Api1/generate-pdf

    @GetMapping(value = "/generate-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdf() throws IOException, DocumentException, SQLException {

        // Create a document object
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        // Create a byte array output stream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Create a PDF writer object
        PdfWriter.getInstance(document, baos);

        // Open the document
        document.open();



        Image logo = Image.getInstance("src/main/resources/Logo.png");
        // Positionner le logo en haut à gauche de la page
        logo.setAbsolutePosition(20, 760);
        // Définir la largeur et la hauteur maximales
        float maxWidth = 60f;
        float maxHeight = 60f;
        // Redimensionner le logo pour qu'il s'adapte à la taille maximale
        logo.scaleToFit(maxWidth, maxHeight);


        // Créer une police personnalisée pour le titre
        Font fontTitle = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.RED);
        fontTitle.setSize(28);
        Paragraph paragraph = new Paragraph("Delivery", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(30);


        // Ajouter le logo au document
        document.add(logo);
        // Add content to the document
        document.add(paragraph);
        // Ajouter un saut de ligne après le titre
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));


        // Établir une connexion à la base de données
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pidev", "root", "mysql");
        // Créer une requête pour récupérer les données de la table livraison
        String query = "SELECT * FROM delivery";
        PreparedStatement stmt = conn.prepareStatement(query);
        // Exécuter la requête et stocker les résultats dans un ResultSet
        ResultSet rs = stmt.executeQuery();
        // Parcourir les résultats du ResultSet et stocker les données dans une liste de livraisons
        List<Delivery> deliveries = new ArrayList<>();
        while (rs.next()) {
            int idd = rs.getInt("idd");
            String reference = rs.getString("reference");
            Date date = rs.getDate("date");
            int idD = rs.getInt("deliverer_id");
            int idR = rs.getInt("rely_point_id_rp");
            Delivery delivery = new Delivery(idd, reference, date);
            deliveries.add(delivery);
        }


        // Créer une table pour afficher les données des livraisons
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        // Ajouter des en-têtes de colonne à la table
        PdfPCell cell1 = new PdfPCell(new Phrase("ID"));
        PdfPCell cell2 = new PdfPCell(new Phrase("Reference"));
        PdfPCell cell3 = new PdfPCell(new Phrase("Date"));
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        // Ajouter les données des livraisons à la table
        for (Delivery delivery : deliveries) {
            table.addCell(String.valueOf(delivery.getIdD()));
            table.addCell(delivery.getReference());
            table.addCell(String.valueOf(delivery.getDate()));
        }


        // Ajouter la table au document PDF
        document.add(table);

        // Fermer les ressources JDBC
        rs.close();
        stmt.close();
        conn.close();

        // Close the document
        document.close();

        // Set the response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "Delivery.pdf");

        // Return the response entity with the PDF content
        return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);
    }
}
