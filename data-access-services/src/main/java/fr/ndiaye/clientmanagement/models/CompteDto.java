package fr.ndiaye.clientmanagement.models;

import fr.ndiaye.clientmanagement.entity.ClientEntity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class CompteDto {

    private Long id;
    public String numero_compte;
    public String type_compte;
    private ClientEntity client;
    private float solde;
}