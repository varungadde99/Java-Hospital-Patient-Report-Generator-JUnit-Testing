import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class JUnitTesting_AddPatientPage {

	AddPatient addPatientPage = new AddPatient();
	JUnitTesting_AddPatientPage()
	{}
	
	@Test
	void SpecialityButtonGroupClearCheck() {
		assertEquals(null, AddPatient.Speciality.getSelection());
	}
	
	@Test
	void PatientNameCheck() {
		assertNotEquals(null, addPatientPage.pnameTextField);	
	}

	@Test
	void PatientAgeNullCheck() {
		assertNotEquals(null, addPatientPage.pageTextField);	
	}
	
	@Test
	void PatientAgeValidCheck() {
		assertNotEquals(0, addPatientPage.pageTextField);	
	}
	
}
