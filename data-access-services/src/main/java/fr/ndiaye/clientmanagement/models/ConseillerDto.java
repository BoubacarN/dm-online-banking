package fr.ndiaye.clientmanagement.models;


import fr.ndiaye.clientmanagement.entity.ClientEntity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ToString
public class ConseillerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<ClientEntity> clients = new ArrayList<>();
}
