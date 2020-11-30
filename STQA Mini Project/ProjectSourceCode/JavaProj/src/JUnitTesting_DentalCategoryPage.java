import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitTesting_DentalCategoryPage {

	DentalCategory dentalcategorypage = new DentalCategory("A", 58, "Dental");
	
	@Test
	void CategoryButtonGroupClearCheck() {
		assertEquals(null, DentalCategory.Category.getSelection());
	}
	
	@Test
	void RoutingDentalCheck() {
		assertEquals("Dental", dentalcategorypage.pspeciality);
	}
	
	@Test
	void InitalRatingCheck() {
		assertEquals(0, dentalcategorypage.rating);
	}
}
