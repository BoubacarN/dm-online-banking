package fr.ndiaye.clientmanagement.banking.repositories;


import fr.ndiaye.clientmanagement.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
    List<ClientEntity> findAll();
}
