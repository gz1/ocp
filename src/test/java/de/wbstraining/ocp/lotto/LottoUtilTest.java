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

}
