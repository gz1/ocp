package de.wbstraining.ocp.lotto;

// 

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoUtilTest {

	private static long tipp1;
	private static long tipp2;
	private static long tipp3;
	private static long[] tipps;

	// spiel77
	private int zahlSpiel77 = 7654321;

	private int spiel77_0_matching_end_digits = 7654320;
	private int spiel77_1_matching_end_digits = 7654301;
	private int spiel77_2_matching_end_digits = 7654021;
	private int spiel77_3_matching_end_digits = 7650321;
	private int spiel77_4_matching_end_digits = 7604321;
	private int spiel77_5_matching_end_digits = 7054321;
	private int spiel77_6_matching_end_digits = 9654321;
	private int spiel77_7_matching_end_digits = 7654321;

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

	// neue methoden

	@Test
	void createTippShouldThrowExceptionIfTooManyArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			LottoUtil.createTipp(1, 2, 3, 4, 5, 6, 7);
		});
	}

	@Test
	void createTippShouldThrowExceptionIfDuplicates() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			LottoUtil.createTipp(1, 1);
		});
	}

	@Test
	void createTippShouldThrowExceptionIfInvalidRange() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			LottoUtil.createTipp(50);
		});
	}

	@Test
	void createTippCreatedTippShouldContainTheGivenNumbers() {
		long mytipp = 0b1110L;
		long tipp = LottoUtil.createTipp(1, 2, 3);
		int expected = 3;
		int actual = Long.bitCount(mytipp & tipp);
		assertEquals(expected, actual);
	}

	@Test
	public void gklSpiel77_0_MatchingEndDigits_ShouldGiveGkl_0() {
		int expected = 0;
		int actual = LottoUtil.gklSpiel77(zahlSpiel77, spiel77_0_matching_end_digits);
		assertEquals(expected, actual);
	}

	@Test
	public void gklSpiel77_1_MatchingEndDigits_ShouldGiveGkl_7() {
		int expected = 7;
		int actual = LottoUtil.gklSpiel77(zahlSpiel77, spiel77_1_matching_end_digits);
		assertEquals(expected, actual);
	}

	@Test
	public void gklSpiel77_2_MatchingEndDigits_ShouldGiveGkl_6() {
		int expected = 6;
		int actual = LottoUtil.gklSpiel77(zahlSpiel77, spiel77_2_matching_end_digits);
		assertEquals(expected, actual);
	}

	@Test
	public void gklSpiel77_3_MatchingEndDigits_ShouldGiveGkl_5() {
		int expected = 5;
		int actual = LottoUtil.gklSpiel77(zahlSpiel77, spiel77_3_matching_end_digits);
		assertEquals(expected, actual);
	}

	@Test
	public void gklSpiel77_4_MatchingEndDigits_ShouldGiveGkl_4() {
		int expected = 4;
		int actual = LottoUtil.gklSpiel77(zahlSpiel77, spiel77_4_matching_end_digits);
		assertEquals(expected, actual);
	}

	@Test
	public void gklSpiel77_5_MatchingEndDigits_ShouldGiveGkl_3() {
		int expected = 3;
		int actual = LottoUtil.gklSpiel77(zahlSpiel77, spiel77_5_matching_end_digits);
		assertEquals(expected, actual);
	}

	@Test
	public void gklSpiel77_6_MatchingEndDigits_ShouldGiveGkl_2() {
		int expected = 2;
		int actual = LottoUtil.gklSpiel77(zahlSpiel77, spiel77_6_matching_end_digits);
		assertEquals(expected, actual);
	}

	@Test
	public void gklSpiel77_7_MatchingEndDigits_ShouldGiveGkl_1() {
		int expected = 1;
		int actual = LottoUtil.gklSpiel77(zahlSpiel77, spiel77_7_matching_end_digits);
		assertEquals(expected, actual);
	}
	
	// wir testen die methode tippAsString()
	// für einen zufällig erzeugten tipp
	
	@Test
	void randomTippAsStringShouldReturnStringWith6NumbersBetween1And49() {
		long tipp = LottoUtil.createTipp();  // besser selber erzeugen...
		boolean expected = true;
		boolean actual;
		String tippAsString = LottoUtil.tippAsString(tipp);
		String[] tokens = tippAsString.split(" ");
		NavigableSet<Integer> set = new TreeSet<>();
		for (String token : tokens) {
			set.add(Integer.parseInt(token));
		}
		actual = Collections.min(set) >= 1 &&
				Collections.max(set) <= 49 && set.size() == 6;
		assertEquals(expected, actual);
	}
}