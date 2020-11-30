import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitTesting_OrthoCategoryPage {

	
	OrthoCategory orthocategorypage = new OrthoCategory("A", 58, "Ortho");
	
	@Test
	void CategoryButtonGroupClearCheck() {
		assertEquals(null, OrthoCategory.Category.getSelection());
	}
	
	@Test
	void RoutingOrthoCheck() {
		assertEquals("Ortho", orthocategorypage.pspeciality);
	}
	
	@Test
	void InitalRatingCheck() {
		assertEquals(0, orthocategorypage.rating);
	}
}
