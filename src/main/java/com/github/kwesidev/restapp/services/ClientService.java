package com.github.kwesidev.restapp.services;
import java.util.List;
import com.github.kwesidev.restapp.models.Client;
public interface ClientService {
	/**
	 * This function add's clients
	 * @param client Domain class for the client
	 */
	public void add(Client client);
	/**
	 * This function lists clients
	 * @return a list of clients
	 */
	public List<Client> list();
	
	
	/**
	 * This function searches a client
	 * @param searchPhrase a string containing the search phrase
	 * @return client
	 */
	public Client search(String searchPhrase);
	
}
