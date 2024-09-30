package com.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PR115cp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Has d'indicar dues rutes d'arxiu.");
            System.out.println("Ús: PR115cp <origen> <destinació>");
            return;
        }

        String rutaOrigen = args[0];
        String rutaDesti = args[1];

        copiarArxiu(rutaOrigen, rutaDesti);
    }
    public static void copiarArxiu(String rutaOrigen, String rutaDesti) {
        File fitxerOrigen = new File(rutaOrigen);
        
        if (!fitxerOrigen.exists() || !fitxerOrigen.isFile() || !rutaOrigen.endsWith(".txt")) {
            System.out.println("Error: El fitxer d'origen no existeix o no és un fitxer de text.");
            return;
        }

        File fitxerDesti = new File(rutaDesti);
        if (fitxerDesti.exists()) {
            System.out.println("Advertència: L'arxiu de destinació ja existeix. Serà sobreescrit.");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fitxerOrigen, StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fitxerDesti, StandardCharsets.UTF_8))) {

            String linea;
            boolean ultimaLineaEnBlanc = false;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea);
                writer.newLine();
                ultimaLineaEnBlanc = linea.isEmpty();
            }
            if (ultimaLineaEnBlanc) {
                writer.newLine();
            }

            System.out.println("Còpia realitzada correctament.");

        } catch (IOException e) {
            System.out.println("Error durant la còpia: " + e.getMessage());
        }
    }
}
