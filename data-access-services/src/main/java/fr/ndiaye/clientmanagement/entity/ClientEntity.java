package fr.ndiaye.clientmanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "Client")
public class ClientEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String tel;
    private String adresse;

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tel='" + tel + '\'' +
                ", adresse='" + adresse + '\'' +
                ", conseiller=" + conseiller +
                ", compte=" + compte +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientEntity)) return false;
        if (!super.equals(o)) return false;

        ClientEntity that = (ClientEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
            return false;
        if (getTel() != null ? !getTel().equals(that.getTel()) : that.getTel() != null) return false;
        if (getAdresse() != null ? !getAdresse().equals(that.getAdresse()) : that.getAdresse() != null) return false;
        if (getConseiller() != null ? !getConseiller().equals(that.getConseiller()) : that.getConseiller() != null)
            return false;
        return getCompte() != null ? getCompte().equals(that.getCompte()) : that.getCompte() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getTel() != null ? getTel().hashCode() : 0);
        result = 31 * result + (getAdresse() != null ? getAdresse().hashCode() : 0);
        result = 31 * result + (getConseiller() != null ? getConseiller().hashCode() : 0);
        result = 31 * result + (getCompte() != null ? getCompte().hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cons_id")
    private ConseillerEntity conseiller;


    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CompteEntity> compte = new ArrayList<>();

    public List<CompteEntity> getCompte() {
        return compte;
    }

    public ClientEntity(Long id, String firstName, String lastName, String tel, String adresse, ConseillerEntity conseiller, List<CompteEntity> compte) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.adresse = adresse;
        this.conseiller = conseiller;
        this.compte = compte;
    }

    public void setCompte(List<CompteEntity> compte) {
        this.compte = compte;
    }

    public ClientEntity(Long id, String firstName, String lastName, String tel, String adresse, ConseillerEntity conseiller) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.adresse = adresse;
        this.conseiller = conseiller;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ConseillerEntity getConseiller() {
        return conseiller;
    }




    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity() {
    }

    public ClientEntity(Long id, String firstName, String lastName, ConseillerEntity conseiller) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.conseiller = conseiller;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setConseiller(ConseillerEntity conseiller) {
        this.conseiller = conseiller;
    }

}

