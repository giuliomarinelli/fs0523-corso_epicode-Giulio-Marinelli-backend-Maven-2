package week3.day3.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "clienti")
public class Cliente {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "sequenza_clienti")
    @SequenceGenerator(name = "sequenza_clienti", initialValue = 10)
    int id;
    private String nome;
    private String cognome;
    @Column(name = "data_inserimento")
    private LocalDate dataInserimento;
    private String indirizzo;

    public Cliente() {}

    public Cliente(int id, String nome, String cognome, LocalDate dataInserimento, String indirizzo) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataInserimento = dataInserimento;
        this.indirizzo = indirizzo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(LocalDate dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataInserimento=" + dataInserimento +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }
}
