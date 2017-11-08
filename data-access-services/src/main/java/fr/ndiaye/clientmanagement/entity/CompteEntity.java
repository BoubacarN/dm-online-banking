package fr.ndiaye.clientmanagement.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "Compte")
public class CompteEntity {


    @Override
    public String toString() {
        return "CompteEntity{" +
                "id=" + id +
                ", numero_compte='" + numero_compte + '\'' +
                ", type_compte='" + type_compte + '\'' +
                ", client=" + client +
                ", solde=" + solde +
                '}';
    }

    @Id

    @GeneratedValue
    private Long id;
    public String numero_compte;
    public String type_compte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientEntity client;
private float solde;

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public CompteEntity(Long id, String numero_compte, String type_compte, ClientEntity client, float solde) {
        this.id = id;
        this.numero_compte = numero_compte;
        this.type_compte = type_compte;
        this.client = client;
        this.solde = solde;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public CompteEntity() {
    }

    public CompteEntity(Long id, String numero_compte, String type_compte, ClientEntity client) {
        this.id = id;

        this.numero_compte = numero_compte;
        this.type_compte = type_compte;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_compte() {
        return numero_compte;
    }

    public void setNumero_compte(String numero_compte) {
        this.numero_compte = numero_compte;
    }

    public String getType_compte() {
        return type_compte;
    }

    public void setType_compte(String type_compte) {
        this.type_compte = type_compte;
    }

    public ClientEntity getClient() {
        return client;
    }


}
