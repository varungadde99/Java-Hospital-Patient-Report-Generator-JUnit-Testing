import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class JUnitTesting_TransactionPage {

	JUnitTesting_TransactionPage()
	{}
	
	Transaction transactionPage = new Transaction("A", 58, "Dental",7 , "Fracture","ICU");

	@Test
	void TranscationInitialAmtLabelCheck() {
		assertNotEquals("", transactionPage.totalAmtLabel);
	}

	@Test
	void TransactionParameterAgeInitialCheck() {
		assertNotEquals(0, transactionPage.page);
	}
	
	@Test
	void TranscationInitialAmtValueCheck() {
		assertNotEquals(null, transactionPage.baseCostTextField);	
	}
	
	@Test
	void TranscationRecordNameCheck() {
		assertEquals("A", transactionPage.pname);	
	}
	
	
}
