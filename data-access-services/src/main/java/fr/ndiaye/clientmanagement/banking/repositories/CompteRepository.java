package fr.ndiaye.clientmanagement.banking.repositories;

import fr.ndiaye.clientmanagement.entity.CompteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompteRepository extends CrudRepository<CompteEntity, Long> {
    List<CompteEntity> findAll();
}
