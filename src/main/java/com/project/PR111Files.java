package com.project;

import java.io.File;
import java.io.IOException;

public class PR111Files {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/pr111";
        gestionarArxius(camiFitxer);
    }

    public static void gestionarArxius(String camiFitxer) {
        String rutaMyFiles = camiFitxer + "/myFiles";
        File carpetaMyFiles = new File(rutaMyFiles);

        if (!carpetaMyFiles.exists()) {
            if (carpetaMyFiles.mkdirs()) {
                System.out.println("S'ha creat la carpeta: " + carpetaMyFiles.getAbsolutePath());
            } else {
                System.err.println("No s'ha pogut crear la carpeta.");
                return;
            }
        }

        File file1 = new File(carpetaMyFiles, "file1.txt");
        File file2 = new File(carpetaMyFiles, "file2.txt");

        try {
            if (file1.createNewFile()) {
                System.out.println("S'ha creat l'arxiu: " + file1.getName());
            }
            if (file2.createNewFile()) {
                System.out.println("S'ha creat l'arxiu: " + file2.getName());
            }
        } catch (IOException e) {
            System.err.println("Error al crear els arxius: " + e.getMessage());
        }

        File renamedFile = new File(carpetaMyFiles, "renamedFile.txt");
        if (file2.renameTo(renamedFile)) {
            System.out.println("S'ha renombrat file2.txt a renamedFile.txt");
        } else {
            System.err.println("Error en renombrar file2.txt.");
        }

        mostrarLlistatArxius(carpetaMyFiles, "Els arxius de la carpeta són:");

        if (file1.delete()) {
            System.out.println("S'ha eliminat l'arxiu: file1.txt");
        } else {
            System.err.println("Error en eliminar file1.txt.");
        }

        mostrarLlistatArxius(carpetaMyFiles, "Els arxius de la carpeta són:");
    }

    public static void mostrarLlistatArxius(File carpeta, String missatge) {
        String[] arxius = carpeta.list();
        if (arxius != null && arxius.length > 0) {
            System.out.println(missatge);
            for (String arxiu : arxius) {
                System.out.println("- " + arxiu);
            }
        } else {
            System.out.println("La carpeta està buida o no es pot accedir.");
        }
    }
}
