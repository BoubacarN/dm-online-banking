package fr.ndiaye.clientmanagement.services;


import fr.ndiaye.clientmanagement.banking.repositories.ClientRepository;
import fr.ndiaye.clientmanagement.banking.repositories.CompteRepository;
import fr.ndiaye.clientmanagement.models.CompteDto;
import fr.ndiaye.clientmanagement.entity.ClientEntity;
import fr.ndiaye.clientmanagement.entity.CompteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {
    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private final CompteRepository compteRepository;

    public ClientService(ClientRepository clientRepository,CompteRepository compteRepository) {
        this.clientRepository = clientRepository;
        this.compteRepository = compteRepository;
    }
    @Override
    public CompteDto retirerOuDeposer(CompteDto compteDto, float montant) {

        ClientEntity clientEntity = clientRepository.findOne(compteDto.getClient().getId());
        CompteEntity compteEntity = new CompteEntity();
        float currentAmount=clientEntity.getCompte().get(clientEntity.getCompte().size()).getSolde();
        compteEntity.setId(compteDto.getId());
        compteEntity.setClient(clientEntity);
        compteEntity.setNumero_compte(compteDto.getNumero_compte());
        compteEntity.setType_compte(compteDto.getType_compte());
        compteEntity.setClient(clientEntity);
        compteEntity.setSolde(currentAmount+montant);

        compteRepository.save(compteEntity);


        return CompteDto.builder()
                .id(compteEntity.getId())
                .numero_compte(compteEntity.getNumero_compte())
                .type_compte(compteEntity.getType_compte())
                .solde(compteEntity.getSolde())
                .build();
    }




}
