package de.wbstraining.ocp.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.wbstraining.ocp.lotto.LottoUtil;

public class LottoUtilTest {

	private static long tipp1;
	private static long tipp2;
	private static long tipp3;
	private static long[] tipps;
	
	// more
	long ziehungsZahlen = 0b1111110L;
	
	long tipp6Matches = 0b1111110L;
	long tipp5Matches = 0b11111100L;
	long tipp4Matches = 0b111111000L;
	long tipp3Matches = 0b1111110000L;
	long tipp2Matches = 0b11111100000L;
	long tipp1Matches = 0b111111000000L;
	long tipp0Matches = 0b1111110000000L;


	@BeforeEach
	public void beforeEach() {
		System.out.println("BeforeEach");
	}

	@AfterEach
	public void afterEach() {
		System.out.println("AfterEach");
	}

	@BeforeAll
	public static void beforeAll() {
		System.out.println("BeforeAll");
		tipp1 = LottoUtil.createTipp(1, 2, 3, 4, 5, 6);
		tipp2 = LottoUtil.createTipp(49, 48, 47, 46, 45, 44);
		tipp3 = LottoUtil.createTipp(10, 11, 12, 13, 14, 15);
		tipps = new long[] { tipp1, tipp2, tipp3 };
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("AfterAll");
	}

	@Test
	public void testCountMatches() {

		long tipp = LottoUtil.createTipp(1, 2, 3, 4, 5, 6);

		int expected = 6;
		int actual;

		actual = LottoUtil.countMatches(tipp, tipps[0]);

		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void testParameterized(int tipp) {
		assertTrue(Long.bitCount(LottoUtil.createTipp(tipp)) == 6);
	}

	@Test
	void testExpectedException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			LottoUtil.createTipp(1, 2, 3, 4, 5, 6, 7);
		});
	}
	
	// more tests
	
	@Test
	public void gkl6Aus49_6_Matches_NoMatchingSuperzahl_ShouldGiveGkl2() {
		int expected = 2;
		int actual = LottoUtil.gkl6Aus49(ziehungsZahlen, tipp6Matches, false);

		assertEquals(expected, actual);
	}
	
	

}
