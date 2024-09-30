package com.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class PR114linies {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";

        generarNumerosAleatoris(camiFitxer);
    }

    public static void generarNumerosAleatoris(String camiFitxer) {
        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(camiFitxer, StandardCharsets.UTF_8))) {
            for (int i = 0; i < 10; i++) {
                int numero = random.nextInt(100); 
                writer.write(Integer.toString(numero));

                if (i < 9) {
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error escrivint a l'arxiu: " + e.getMessage());
        }
    }
}
