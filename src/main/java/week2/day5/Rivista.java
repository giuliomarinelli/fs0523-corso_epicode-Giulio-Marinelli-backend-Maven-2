package week2.day5;

public class Rivista extends FonteLeggibile {

    private Periodicita periodicita;

    public Rivista(String titolo, int annoDiPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Rivista(String ISBN, String titolo, int annoDiPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(ISBN, titolo, annoDiPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "ISBN='" + getISBN() + '\'' +
                ", titolo='" + getTitolo() + '\'' +
                ", annoDiPubblicazione=" + getAnnoDiPubblicazione() +
                ", numeroPagine=" + getNumeroPagine() +
                ", periodicita=" + periodicita +
                '}';
    }
}
