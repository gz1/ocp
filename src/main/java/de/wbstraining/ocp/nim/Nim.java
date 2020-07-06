package de.wbstraining.ocp.nim;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Nim implements Serializable {

	private static final long serialVersionUID = 1L;

	protected int[] rows;
	protected int xorOverAllRows;
	protected int notEmptyRows;

	// ein konstruktor erzeugt eine vorgegebene ausgangsstellung
	// ein konstruktor erzeugt die ausgangsstellung per randomizer.

	public Nim(int[] rows) throws NimException {
		if (rows.length < 1) {
			throw new NimException("invalid...");
		}
		this.rows = new int[rows.length];
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] < 1) {
				throw new NimException("invalid...");
			}
			this.rows[i] = rows[i];
			xorOverAllRows ^= this.rows[i];
		}
		notEmptyRows = rows.length;
	}

	// die anzahl der reihen und die maximale anzahl von spielsteinen
	// pro reihe wird vorgegeben.

	public Nim(int rows, int maxTokensPerRow) throws NimException {
		if (rows < 1 || maxTokensPerRow < 1) {
			throw new NimException("invalid...");
		}
		this.rows = new int[rows];
		for (int i = 0; i < rows; i++) {
			this.rows[i] = ThreadLocalRandom.current().nextInt(maxTokensPerRow) + 1;
			xorOverAllRows ^= this.rows[i];
		}
		notEmptyRows = rows;
	}

	public boolean isLegalMove(NimMove move) {
		int index = move.getIndex();
		int remainingTokens = move.getRemainingTokens();
		return (index >= 0 && index < rows.length
				&& remainingTokens >= 0 &&
				remainingTokens < rows[index]);
	}

	public boolean isOver() {
		return notEmptyRows == 0;
	}

	public boolean isWinnable() {
		return xorOverAllRows != 0;
	}

	public NimMove suggestMove() throws NimException {
		return null;
	}

	public Nim makeMove(NimMove move) throws NimException {
		// prüfe, ob der zug legal ist
		// aktualisiere rows[]
		// aktualisiere ggf. notEmptyRows
		// aktualisiere xorOverAllRows
		if (!isLegalMove(move)) {
			throw new NimException("not a legal move...");
		}
		
		int index = move.getIndex();
		int remainingTokens = move.getRemainingTokens();
		if (remainingTokens == 0) {
			notEmptyRows--;
		}
		xorOverAllRows ^= rows[index];
		xorOverAllRows ^= remainingTokens;
		rows[index] = remainingTokens;
		return this;
	}

	@Override
	public String toString() {
		return null;
	}
}
