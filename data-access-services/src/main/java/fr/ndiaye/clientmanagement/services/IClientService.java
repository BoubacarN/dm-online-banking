package fr.ndiaye.clientmanagement.services;


import fr.ndiaye.clientmanagement.models.CompteDto;

public interface IClientService {

    CompteDto retirerOuDeposer(CompteDto clientDto, float montant);//créer client

}
