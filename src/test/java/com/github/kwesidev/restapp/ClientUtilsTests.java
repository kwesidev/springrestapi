package com.github.kwesidev.restapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import com.github.kwesidev.restapp.utils.ClientUtility;

public class ClientUtilsTests {

	@Test
	@DisplayName("Expecting to ID to be valid ")
	public void testSouthAfricanIdNumber() {
		String idNumber = "9001146167183";
		assertEquals(true, ClientUtility.isValidSouthAfricanId(idNumber));
	}

	@Test
	@DisplayName("Expecting ID to be Invalid")
	public void testInvalidIdNumber() {
		String idNumber = "9292929201111112";
		assertEquals(false, ClientUtility.isValidSouthAfricanId(idNumber));
	}
}
