
package fr.ndiaye.clientmanagement.services;



import fr.ndiaye.clientmanagement.models.ClientDto;
import fr.ndiaye.clientmanagement.models.CompteDto;

import java.util.Optional;

public interface IConseillerService {

    Optional<ClientDto> getClientById(String id);//Consulter infos client

    ClientDto create(ClientDto clientDto);//créer client

    void update(String id, ClientDto clientDto);//mettre à jour infos client


    CompteDto createNewAccount(CompteDto clientDto);//créer client

    ClientDto MajInfosClient(ClientDto clientDto);
    public Optional<ClientDto> getUserById(String id);
}