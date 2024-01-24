package week3.day3.esercizio_relazioni.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    UUID id;
    private String nome;
    private String citta;

    @OneToMany(mappedBy = "location")
    private List<Partecipazione> partecipazione;

    public Location() {}

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Partecipazione> getPartecipazione() {
        return partecipazione;
    }

    public void setPartecipazione(List<Partecipazione> partecipazione) {
        this.partecipazione = partecipazione;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                ", partecipazione=" + partecipazione +
                '}';
    }
}
