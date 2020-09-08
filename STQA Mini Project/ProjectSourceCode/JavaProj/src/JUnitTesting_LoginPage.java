import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitTesting_LoginPage {

	LoginTest loginPage = new LoginTest();
	
	@Test
	void LoginButtonDisableCheck() {
		assertEquals(false, loginPage.loginButton.isEnabled());
	}
	
	@Test
	void ViewPasswordButtonDisableCheck() {
		assertEquals(false, loginPage.showPassword.isSelected());
	}
	
	@Test
	void LoginNameCheck() {
		assertNotEquals(null, loginPage.usernameTextField);	
	}

	@Test
	void LoginPasswordCheck() {
		assertNotEquals(null, loginPage.passwordField);	
	}
}
