package fr.ndiaye.clientmanagement.models;

import fr.ndiaye.clientmanagement.entity.CompteEntity;
import fr.ndiaye.clientmanagement.entity.ConseillerEntity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ToString
public class ClientDto {

    private String id;
    private String firstName;
    private String lastName;
    private String tel;
    private String adresse;
    private ConseillerEntity conseiller;
    private List<CompteEntity> compte = new ArrayList<>();
}
