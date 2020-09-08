import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitTesting_TransactionPage {

	Transaction transactionPage = new Transaction("A",58,"Ortho");

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
