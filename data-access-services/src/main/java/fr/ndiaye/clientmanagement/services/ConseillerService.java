package fr.ndiaye.clientmanagement.services;


import fr.ndiaye.clientmanagement.banking.repositories.ClientRepository;
import fr.ndiaye.clientmanagement.banking.repositories.CompteRepository;
import fr.ndiaye.clientmanagement.models.ClientDto;
import fr.ndiaye.clientmanagement.models.CompteDto;
import fr.ndiaye.clientmanagement.entity.ClientEntity;
import fr.ndiaye.clientmanagement.entity.CompteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ConseillerService  implements IConseillerService{
    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private final CompteRepository compteRepository;

    public ConseillerService(ClientRepository clientRepository,CompteRepository compteRepository) {
        this.clientRepository = clientRepository;
        this.compteRepository=compteRepository;
    }

    @Override
    public Optional<ClientDto> getClientById(String id) {
        ClientEntity clientEntity = clientRepository.findOne(Long.parseLong(id));
        return (clientEntity != null) ?
                Optional.of(
                        ClientDto.builder()
                                .id(String.valueOf(clientEntity.getId()))
                                .firstName(clientEntity.getFirstName())
                                .lastName(clientEntity.getLastName())
                                .conseiller(clientEntity.getConseiller())
                                .build()
                )
                : Optional.empty();
    }

    /* the advisopr create new client*/
    @Override
    public ClientDto create(ClientDto clientDto) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFirstName(clientDto.getFirstName());
        clientEntity.setLastName(clientDto.getLastName());
        clientEntity.setTel(clientDto.getTel());
        clientEntity.setAdresse(clientDto.getAdresse());
        clientEntity.setConseiller(clientDto.getConseiller());

        ClientEntity clientEntity1 = clientRepository.save(clientEntity);
        return ClientDto.builder()
                .id(String.valueOf(clientEntity1.getId()))
                .firstName(clientEntity1.getFirstName())
                .lastName(clientEntity1.getLastName())
                .conseiller(clientEntity1.getConseiller())
                .adresse(clientEntity1.getAdresse())
                .tel(clientEntity1.getTel())

                .build();
    }

    @Override
    public void update(String id, ClientDto clientDto) {

    }

/*
create new accompte for customer
 */

    public CompteDto createNewAccount(CompteDto compteDto)
    {


        ClientEntity clientEntity = clientRepository.findOne(compteDto.getClient().getId());
        CompteEntity compteEntity = new CompteEntity();


            compteEntity.setClient(clientEntity);
            compteEntity.setNumero_compte(compteDto.getNumero_compte());
            compteEntity.setType_compte(compteDto.getType_compte());
            compteEntity.setClient(clientEntity);
            compteEntity.setSolde(compteDto.getSolde());

            compteRepository.save(compteEntity);


        return CompteDto.builder()
                .id(compteEntity.getId())
                .type_compte(compteEntity.getType_compte())
                .numero_compte(compteEntity.getNumero_compte())
                .client(compteEntity.getClient())
                .solde(compteEntity.getSolde())
                .build();

}

    /*

    update tel or/and adresse
     */
    @Override
    public ClientDto MajInfosClient(ClientDto cldto){
        ClientEntity clientEntity = clientRepository.findOne(Long.parseLong(cldto.getId()));
        if(clientEntity!=null){
            if(cldto.getAdresse()!=null)  clientEntity.setAdresse(clientEntity.getAdresse());
            if(cldto.getTel()!=null)clientEntity.setTel(cldto.getTel());
            clientRepository.save(clientEntity);
        }
        return ClientDto.builder()
                .id(String.valueOf(clientEntity.getId()))
                .firstName(clientEntity.getFirstName())
                .lastName(clientEntity.getLastName())
                .conseiller(clientEntity.getConseiller())
                .adresse(clientEntity.getAdresse())
                .tel(clientEntity.getTel())
                .build();
    }


    @Override
    public Optional<ClientDto> getUserById(String id) {
        ClientEntity clientEntity = clientRepository.findOne(Long.parseLong(id));
        return (clientEntity != null) ?
                Optional.of(
                        ClientDto.builder()
                                .id(String.valueOf(clientEntity.getId()))
                                .firstName(clientEntity.getFirstName())
                                .lastName(clientEntity.getLastName())
                                .build()
                )
                : Optional.empty();
    }
}


