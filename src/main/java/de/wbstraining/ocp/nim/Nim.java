package de.wbstraining.ocp.nim;

public class Nim {
	
	// ein konstruktor erzeugt eine vorgegebene ausgangsstellung
	// ein konstruktor erzeugt die ausgangsstellung per randomizer.
	
	// die anzahl der reihen und die maximale anzahl von spielsteinen
	// pro reihe wird vorgegeben.
	
	public Nim(int[] rows) throws NimException {
		
	}
	
	public Nim(int rows, int maxTokensPerRow) throws NimException {
		
	}
	
	public boolean isLegalMove(NimMove move) {
		return false;
	}
	
	public boolean isOver() {
		return false;
	}
	
	public boolean isWinnable() {
		return false;
	}
	
	public NimMove suggestMove() throws NimException {
		return null;
	}
	
	public Nim makeMove(NimMove move) throws NimException {
		// ...
		return this;
	}

	@Override
	public String toString() {
		return null;
	}
}
