package com.github.kwesidev.restapp;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.github.kwesidev.restapp.services.ClientService;
import com.github.kwesidev.restapp.services.ClientServiceImpl;
import com.github.kwesidev.restapp.models.Client;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTests {

	static ClientService clientService;

	static {
		clientService = new ClientServiceImpl();
		Client client = new Client();
		client.setFirstName("John");
		client.setLastName("Doe");
		client.setIdNumber("9611165800082");
		client.setMobileNumber("0731482947");
		clientService.add(client);
	}

	@Test
	@DisplayName("Expecting to save without any issues")
	public void saveWithoutFailure() {
		clientService = new ClientServiceImpl();
		Client client = new Client();
		client.setFirstName("Alice");
		client.setLastName("Doe");
		client.setIdNumber("9702100176082");
		client.setMobileNumber("0731482945");
		clientService.add(client);
		assertEquals(2, clientService.list().size());
	}

	@Test
	@DisplayName("Expecting to Throw Runtime Exception For Invalid Id Number when saving ")
	public void saveWithFailiure() {
		Client client = new Client();
		client.setFirstName("Alice");
		client.setLastName("Crypto");
		client.setIdNumber("92001146167173");
		client.setMobileNumber("0741482947");
		RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
			clientService.add(client);
		}, "South African Id Number is Invalid");

		assertEquals("South African Id Number is Invalid", thrown.getMessage());
	}

	@Test
	@DisplayName("Expecting to Throw Runtime Exception For Duplicate ID Number when saving ")
	public void saveWithFailiureDuplicateID() {
		Client client = new Client();
		client.setFirstName("Charles Assare");
		client.setLastName("Majid");
		client.setIdNumber("9611165800082");
		client.setMobileNumber("0111122211");
		RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
			clientService.add(client);
		}, "ID Number already exists on the system");

		assertEquals("ID Number already exists on the system", thrown.getMessage());
	}

	@Test
	@DisplayName("Expecting to Throw Runtime Exception For Duplicate Mobile Number when saving ")
	public void saveWithDuplicateMobileNumber() {
		Client client = new Client();
		client.setFirstName("Charles Assare");
		client.setLastName("Majid");
		client.setIdNumber("9702100176082");
		client.setMobileNumber("0731482947");
		RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
			clientService.add(client);
		}, "Mobile number exists on the system ");

		assertEquals("Mobile number exists on the system", thrown.getMessage());
	}

	@Test
	@DisplayName("Expecting to search first name without failiure")
	public void searchFirstNameWithSuccess() {
		Client client = clientService.search("John");
		assertEquals("John", client.getFirstName());
	}

	@Test
	@DisplayName("Expecting to search Mobile number without failiure")
	public void searchMobileNumberWithSuccess() {
		Client client = clientService.search("0731482947");
		assertEquals("0731482947", client.getMobileNumber());
	}

	@Test
	@DisplayName("Expecting to Search Id Number without Failiure")
	public void searchIdNumberWithSuccess() {
		Client client = clientService.search("9611165800082");
		assertEquals("9611165800082", client.getIdNumber());

	}

}
