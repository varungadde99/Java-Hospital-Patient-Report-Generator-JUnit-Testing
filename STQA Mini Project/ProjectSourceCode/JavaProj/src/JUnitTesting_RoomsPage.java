import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitTesting_RoomsPage {

	Rooms roomspage = new Rooms("A", 58, "Ortho",5,"Fracture");
	
	@Test
	void RoomsCategoryButtonGroupClearCheck() {
		assertEquals(null, Rooms.Category.getSelection());
	}

	@Test
	void PatientRatingCheck() {
		assertNotEquals(null, roomspage.rating);	
	}
	
	@Test
	void RoomsNutritionCheckboxClearCheck() {
		assertEquals(null, Rooms.Cbox.getSelection());
	}
	
}
