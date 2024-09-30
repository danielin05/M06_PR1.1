package com.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PR113sobreescriu {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        escriureFrases(camiFitxer);
    }

    public static void escriureFrases(String camiFitxer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(camiFitxer, StandardCharsets.UTF_8))) {
            writer.write("I can only show you the door");
            writer.newLine();
            writer.write("You're the one that has to walk through it");
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error escrivint a l'arxiu: " + e.getMessage());
        }
    }
}