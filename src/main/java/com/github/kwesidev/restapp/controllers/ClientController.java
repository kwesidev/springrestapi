package com.github.kwesidev.restapp.controllers;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.github.kwesidev.restapp.models.Client;
import com.github.kwesidev.restapp.services.ClientService;
import org.springframework.validation.annotation.Validated;

@RestController
@Validated
@RequestMapping(value = "/clients")
public class ClientController {
	@Autowired
	ClientService clientService;

	@GetMapping("/")
	public List<Client> index() {
		return clientService.list();
	}

	@PostMapping(value = "/add", consumes = "application/json")
	public ResponseEntity<Client> add(@Valid @RequestBody Client clientRequest) {
		Client client = new Client();
		client.setFirstName(clientRequest.getFirstName());
		client.setLastName(clientRequest.getLastName());
		client.setIdNumber(clientRequest.getIdNumber());
		client.setMobileNumber(clientRequest.getMobileNumber());
		client.setAddress(clientRequest.getAddress());
		
		clientService.add(client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	@GetMapping(value = "/search/{searchPhrase}")
	public ResponseEntity<Client> query(@PathVariable String searchPhrase) throws Exception {
		Client client = clientService.search(searchPhrase);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

}
