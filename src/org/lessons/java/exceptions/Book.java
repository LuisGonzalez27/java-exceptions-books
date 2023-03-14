package org.lessons.java.exceptions;

public class Book {
    String titolo;
    int numeroPagine;
    String autore;
    String editore;

    public Book(String titolo, int numeroPagine, String autore, String editore) throws Exception {
        setTitolo(titolo);
        setNumeroPagine(numeroPagine);
        setAutore(autore);
        setEditore(editore);
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) throws Exception {
        validaTitolo(titolo);
        this.titolo = titolo;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) throws Exception {
        validaNumeroPagine(numeroPagine);
        this.numeroPagine = numeroPagine;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) throws Exception{
        validaAutore(autore);
        this.autore = autore;
    }

    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) throws Exception {
        validaEditore(autore);
        this.editore = editore;
    }

    public void validaTitolo(String titolo) throws Exception{
        if(titolo.length() == 0) {
            throw new Exception();
        }
    }
    public void validaNumeroPagine(int numeroPagine) throws Exception {
        if (numeroPagine < 1) {
            throw new Exception();
        }
    }
    public void validaAutore(String autore) throws Exception {
        if (autore.length() == 0){
            throw new Exception();
        }
    }
    public void validaEditore(String editore) throws Exception {
        if (editore.length() == 0){
            throw new Exception();
        }
    }

    @Override
    public String toString() {
        return "Libro [titolo=" + titolo + ", numeroPagine=" + numeroPagine + ", autore=" + autore + ", editore=" + editore + "]";
    }

}
