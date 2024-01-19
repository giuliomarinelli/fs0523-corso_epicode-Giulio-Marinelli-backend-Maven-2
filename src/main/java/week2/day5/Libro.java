package week2.day5;

public class Libro extends FonteLeggibile {
    private String autore;
    private String genere;

    public Libro(String titolo, int annoDiPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }
    public Libro(String ISBN, String titolo, int annoDiPubblicazione, int numeroPagine, String autore, String genere) {
        super(ISBN, titolo, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + getISBN() + '\'' +
                ", titolo='" + getTitolo() + '\'' +
                ", annoDiPubblicazione=" + getAnnoDiPubblicazione() +
                ", numeroPagine=" + getNumeroPagine() +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
