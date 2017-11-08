package fr.ndiaye.clientmanagement.banking.repositories;

import fr.ndiaye.clientmanagement.entity.ConseillerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConseillerRepository extends CrudRepository<ConseillerEntity, Long> {
    List<ConseillerEntity> findAll();
}
