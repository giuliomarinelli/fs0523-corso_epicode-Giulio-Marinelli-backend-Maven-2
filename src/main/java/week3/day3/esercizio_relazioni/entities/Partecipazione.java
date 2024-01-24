package week3.day3.esercizio_relazioni.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Partecipazione {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    UUID id;
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;
    @ManyToOne
    @JoinColumn(name = "id_location")
    Location location;
    @Enumerated(EnumType.STRING)
    private StatoPartecipazione stato;

    public Partecipazione(){}

    public Partecipazione(Persona persona, Evento evento, StatoPartecipazione stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoPartecipazione getStato() {
        return stato;
    }

    public void setStato(StatoPartecipazione stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
