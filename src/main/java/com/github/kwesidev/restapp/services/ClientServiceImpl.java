package com.github.kwesidev.restapp.services;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import com.github.kwesidev.restapp.models.Client;
import com.github.kwesidev.restapp.exceptions.ClientNotFoundException;
import com.github.kwesidev.restapp.utils.ClientUtility;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

	private static List<Client> clients = new ArrayList<Client>();
	@Override
	public void add(Client client) {
		synchronized (client) {
			// Check for duplicates
			for (int i = 0 ; i < clients.size(); i++) {
				if (clients.get(i).getIdNumber().equals(client.getIdNumber())) {
					throw  new RuntimeException("ID Number already exists on the system");
				}
				else if (clients.get(i).getMobileNumber().equals(client.getMobileNumber())) {
					throw new RuntimeException("Mobile number exists on the system");
				}
			}
			// check if id number is valid before adding 
			if (!ClientUtility.isValidSouthAfricanId(client.getIdNumber())) {
				throw new RuntimeException("South African Id Number is Invalid");
			}
			clients.add(client);
		}
	}

	@Override
	public List<Client> list() {
		return clients;
	}
	
	@Override
	public Client search(String searchPhrase)  {
		boolean found = false;
		Client client = new Client();
		synchronized (clients) {
			for (int i =0 ; i < clients.size(); i++) {
				if (clients.get(i).getIdNumber().equals(searchPhrase) || clients.get(i).getFirstName().toLowerCase().equals(searchPhrase.toLowerCase()) || clients.get(i).getMobileNumber().equals(searchPhrase)) {
					client =  clients.get(i);
					found = true;
					break;
				}
			}
		}
		if (!found) {
			throw new ClientNotFoundException();
		}
		return client;
		
	}
}
