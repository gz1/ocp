package de.wbstraining.ocp.nim;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NimTest {

	@Test
	public void constructorIntIntShouldThrowExceptionIfInvalidArgs() {
		Assertions.assertThrows(NimException.class, () -> {
			new Nim(-1, 2);
		});
	}

	@Test
	public void constructorIntArrayShouldThrowExceptionIfInvalidArgs() {
		Assertions.assertThrows(NimException.class, () -> {
			new Nim(new int[] { 1, 2, 3, -4 });
		});
	}

	@Test
	public void isOverShouldReturnTrueAfterLastMove() {
		fail("not yet implemented...");
	}

	@Test
	public void isOverShouldReturnFalseBeforeFirstMove() {
		fail("not yet implemented...");
	}

	@Test
	public void isWinnableShouldReturnTrueIfWinnable() {
		Nim nim = new Nim(new int[] { 1, 2, 3, 4, 5 });
		boolean expected = true;
		boolean actual = nim.isWinnable();
		assertEquals(expected, actual);
	}

	@Test
	public void isWinnableShouldReturnFalseIfNotWinnable() {
		Nim nim = new Nim(new int[] { 1, 2, 3, 4, 4 });
		boolean expected = false;
		boolean actual = nim.isWinnable();
		assertEquals(expected, actual);
	}

	@Test
	public void isLegalMoveShouldReturnTrueIfMoveIsLegal() {
		Nim nim = new Nim(new int[] { 1, 2, 3, 4, 5 });
		NimMove move = new NimMove(0, 0);
		boolean expected = true;
		boolean actual = nim.isLegalMove(move);
		assertEquals(expected, actual);
	}

	@Test
	public void isLegalMoveShouldReturnFalseIfMoveIsNotLegal() {
		Nim nim = new Nim(new int[] { 1, 2, 3, 4, 5 });
		NimMove move = new NimMove(0, 1);
		boolean expected = false;
		boolean actual = nim.isLegalMove(move);
		assertEquals(expected, actual);
	}

	@Test
	public void suggestMoveShouldReturnOptimalMoveIfWinnable() {
		fail("not yet implemented...");
	}

	@Test
	public void suggestMoveShouldReturnLegalMoveIfNotWinnable() {
		fail("not yet implemented...");
	}

	@Test
	public void makeMoveShouldThrowExceptionIfMoveIsNotLegal() {
		fail("not yet implemented...");
	}
}