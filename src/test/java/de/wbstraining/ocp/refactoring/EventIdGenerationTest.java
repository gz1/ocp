package de.wbstraining.ocp.refactoring;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import de.wbstraining.ocp.refactoring.bo.Event;
import de.wbstraining.ocp.refactoring.exercise.EventIdGeneration;

@RunWith(Parameterized.class)
public class EventIdGenerationTest {

	private Event actualEvent;
	
	private String expectedEventId;
	
	public EventIdGenerationTest(Event event, String eventId) {
		super();
		this.actualEvent = event;
		this.expectedEventId = eventId;
	}

	@Test
	public void test() {
		EventIdGeneration sut = new EventIdGeneration();
		sut.addEventId(actualEvent);
		assertEquals(expectedEventId, actualEvent.getEventId());
	}

	@Parameters
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][] {
			{EventTestData.classicConcert(), "CLASSICCONCERT"},
			{EventTestData.classicConcertWithDinner(), "CLASSICCONCERT_DINNER"},
			{EventTestData.halfdayHikeSpringSelf(), "HALFDAYHIKE_SELF"},
			{EventTestData.halfdayHikeSpringWithPicNic(), "HALFDAYHIKE_PICNIC"},
			{EventTestData.halfdayHikeSummerSelf(), "HALFDAYHIKE_SELF"},
			{EventTestData.halfdayHikeSummerWithPicNic(), "HALFDAYHIKE_PICNIC"},
			{EventTestData.rockConcert(), "ROCKCONCERT"},
			{EventTestData.sightseeingLondon(), "WEEKENDSIGHTSEEINGLONDON"},
			{EventTestData.weekendHikeMountainCampingSpring(), "WEEKENDHIKE_CAMPING"},
			{EventTestData.weekendHikeMountainCampingSummer(), "WEEKENDHIKE_CAMPING"},
			{EventTestData.weekendHikeMountainHutSpring(), "WEEKENDHIKE_HUT"},
			{EventTestData.weekendHikeMountainHutSummer(), "WEEKENDHIKE_HUT"},
			{EventTestData.weekendSnowboard(), "WEEKENDSNOWBOARD_HUT"},
			{EventTestDataUnsupportedEvents.classicConcertWithPicNic(), "UNSUPPORTED_EVENT"},
			{EventTestDataUnsupportedEvents.concertNotLive(), "UNSUPPORTED_EVENT"},
			{EventTestDataUnsupportedEvents.halfdayHikeFall(), "UNSUPPORTED_EVENT"},
			{EventTestDataUnsupportedEvents.halfdayHikeMenue(), "UNSUPPORTED_EVENT"},
			{EventTestDataUnsupportedEvents.hikingForAMonth(), "UNSUPPORTED_EVENT"},
			{EventTestDataUnsupportedEvents.sightseeingLondonMountainHut(), "UNSUPPORTED_EVENT"},
			{EventTestDataUnsupportedEvents.weekendHikeMountainHotel(), "UNSUPPORTED_EVENT"},
		});
	}
}
