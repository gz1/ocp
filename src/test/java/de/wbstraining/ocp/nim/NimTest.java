package de.wbstraining.ocp.nim;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;

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
		fail("not yet implemented...");
	}

	@Test
	public void isWinnableShouldReturnFalseIfNotWinnable() {
		fail("not yet implemented...");
	}

	@Test
	public void isLegalMoveShouldReturnTrueIfMoveIsLegal() {
		fail("not yet implemented...");
	}

	@Test
	public void isLegalMoveShouldReturnFalseIfMoveIsNotLegal() {
		fail("not yet implemented...");
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