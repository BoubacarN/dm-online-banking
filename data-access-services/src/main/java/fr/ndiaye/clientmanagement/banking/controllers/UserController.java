package fr.ndiaye.clientmanagement.banking.controllers;


import fr.ndiaye.clientmanagement.services.ClientService;
import fr.ndiaye.clientmanagement.models.CompteDto;
import fr.ndiaye.clientmanagement.services.ConseillerService;


import fr.ndiaye.clientmanagement.models.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/banking")
public class UserController {

	private final ConseillerService conseillerService;
	private final ClientService clientService;

	@Autowired
	public UserController(ClientService clientService,ConseillerService conseillerService ) {

		this.conseillerService=conseillerService;
		this.clientService=clientService;
	}


	/*
     creating new client
     */
	@RequestMapping(value="/create_client",method = RequestMethod.POST)
	public HttpStatus newClient(@RequestBody ClientDto client) {
		ClientDto clDto =conseillerService.create(client);
		if(clDto!=null) return HttpStatus.OK;
		return HttpStatus.NOT_FOUND;
	}

	/*
	creating new account for client
 */
	@RequestMapping(value="/create_account",method = RequestMethod.POST)
	public HttpStatus create_account(@RequestBody CompteDto compte) {
		CompteDto clDto =conseillerService.createNewAccount(compte);
		return HttpStatus.OK;
	}

	@RequestMapping(value="/deposer_retirer/{montant}",method = RequestMethod.PUT)
	public HttpStatus updateBalance(@RequestBody CompteDto compte,@PathVariable("montant") String montant) {
		float amount=Float.valueOf(montant);
		CompteDto clDto =clientService.retirerOuDeposer(compte,amount);
		return HttpStatus.OK;
	}

	/*
	updating client inforamtion
	 */
	@RequestMapping(value="/update_client_information",method = RequestMethod.POST)
	public HttpStatus create_updateInfos(@RequestBody ClientDto client) {
		ClientDto clDto =conseillerService.MajInfosClient(client);
		return HttpStatus.OK;
	}

/*
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody UserDto user) {
		// TODO
		return new ResponseEntity<>(HttpStatus.OK);
	}

*/

}
