package fr.ndiaye.clientmanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "Conseiller")
public class ConseillerEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ClientEntity> clients = new ArrayList<>();

    public ConseillerEntity() {
    }

    @Override
    public String toString() {
        return "ConseillerEntity{" +

                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", clients=" + clients +
                '}';
    }

    public ConseillerEntity(Long id, String firstName, String lastName, List<ClientEntity> clients) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.clients = clients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ClientEntity> getClients() {
        return clients;
    }

    public void setClients(List<ClientEntity> clients) {
        this.clients = clients;
    }
}
