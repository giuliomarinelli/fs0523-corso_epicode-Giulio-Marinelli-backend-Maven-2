//package week3.day2.esercizio_evento.entities;
//
//
//
//import jakarta.persistence.*;
//import java.time.LocalDate;
//import java.util.UUID;
//
//@Entity
//@Table(name = "evento")
//public class Evento {
//    @Id @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//
//    private String titolo;
//    @Column(name = "data_evento")
//    private LocalDate dataEvento;
//
//    private String descrizione;
//    @Column(name = "tipo_evento")
//    @Enumerated(EnumType.STRING)
//    private TipoEvento tipoEvento;
//
//    @Column(name = "numero_massimo_partecipanti")
//    private int numeroMassimoPartecipanti;
//
//    public Evento() {}
//
//    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
//        this.titolo = titolo;
//        this.dataEvento = dataEvento;
//        this.descrizione = descrizione;
//        this.tipoEvento = tipoEvento;
//        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public String getTitolo() {
//        return titolo;
//    }
//
//    public void setTitolo(String titolo) {
//        this.titolo = titolo;
//    }
//
//    public LocalDate getDataEvento() {
//        return dataEvento;
//    }
//
//    public void setDataEvento(LocalDate dataEvento) {
//        this.dataEvento = dataEvento;
//    }
//
//    public String getDescrizione() {
//        return descrizione;
//    }
//
//    public void setDescrizione(String descrizione) {
//        this.descrizione = descrizione;
//    }
//
//    public TipoEvento getTipoEvento() {
//        return tipoEvento;
//    }
//
//    public void setTipoEvento(TipoEvento tipoEvento) {
//        this.tipoEvento = tipoEvento;
//    }
//
//    public int getNumeroMassimoPartecipanti() {
//        return numeroMassimoPartecipanti;
//    }
//
//    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
//        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
//    }
//
//    @Override
//    public String toString() {
//        return "Evento{" +
//                "id=" + id +
//                ", titolo='" + titolo + '\'' +
//                ", dataEvento=" + dataEvento +
//                ", descrizione='" + descrizione + '\'' +
//                ", tipoEvento=" + tipoEvento +
//                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
//                '}';
//    }
//}
