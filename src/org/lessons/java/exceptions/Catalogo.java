package org.lessons.java.exceptions;

import java.util.Scanner;

public class Catalogo {
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

    }

}
