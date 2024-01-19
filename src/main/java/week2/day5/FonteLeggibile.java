package week2.day5;

import java.util.ArrayList;
import java.util.List;

public abstract class FonteLeggibile {
    private String ISBN;
    private String titolo;
    private int annoDiPubblicazione;
    private int numeroPagine;

    private static List<String> ISBNGenerati = new ArrayList<>();
    public FonteLeggibile(String ISBN, String titolo, int annoDiPubblicazione, int numeroPagine) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }
    public FonteLeggibile(String titolo, int annoDiPubblicazione, int numeroPagine) {
        ISBN = generaISBN();
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    private int generaNumeroCasuale(int min,int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }



    private String generaISBN() {

        StringBuilder ISBN = new StringBuilder();
        for (int i = 0; i < 17; i++) {
            ISBN.append(i != 3 && i != 6 && i != 12 && i != 15 ? generaNumeroCasuale(0, 9) : "-");
        }
        return ISBN.toString();

    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(int annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

}
