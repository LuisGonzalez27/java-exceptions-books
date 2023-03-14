package org.lessons.java.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Catalogo {
    private final static String FILE_PATH = "./books.txt";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numeroLibri = 0;

        do {
            try {
                System.out.print("Quanti libri vuoi inserire? : ");
                numeroLibri = Integer.parseInt(scan.nextLine());
                if (numeroLibri < 1)
                    System.out.println("Numero non valido deve essere < 1");
            } catch (Exception error) {
                System.out.println("Input non valido. Inserire solo un numero intero!");
            }

        } while (numeroLibri < 1);

        Book [] catalogoLibri = new Book[numeroLibri];

        try {
            for (int i = 0; i < numeroLibri; i++) {
                System.out.print("Inserisci titolo del libro: ");
                String titolo = scan.nextLine();

                System.out.print("Inserisci numero delle pagina del libro: ");
                int numeroPagine = Integer.parseInt(scan.nextLine());

                System.out.print("Inserisci nome dell'autore: ");
                String autore = scan.nextLine();

                System.out.print("Inserisci nome dell'editore: ");
                String editore = scan.nextLine();

                Book libro = new Book(titolo, numeroPagine, autore, editore);
                catalogoLibri[i] = libro;

            }
        } catch (Exception error) {
            System.out.println("Errore: uno o più campi non sono vuoti o non sono validi!");
        }

        scan.close();

        //scrivere tutti i dati dei libri in un file
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(FILE_PATH, true);
            for (Book currenBook : catalogoLibri) {
                myWriter.write(currenBook.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Impossibile creare il file.");
            System.out.println(e.getMessage());
        } finally {
            if(myWriter !=null){
                try {
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //lettura del file
        Scanner myScanner = null;
        try {
            myScanner = new Scanner(new File(FILE_PATH));
            while (myScanner.hasNext()){
                String line = myScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (myScanner!=null){
                try {
                    myScanner.close();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
