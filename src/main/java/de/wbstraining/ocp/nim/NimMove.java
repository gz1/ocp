package de.wbstraining.ocp.nim;

import java.io.Serializable;

public class NimMove implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected int index;
	protected int remainingTokens;
	
	public NimMove(int index, int remainingTokens) {
		this.index = index;
		this.remainingTokens = remainingTokens;
	}

	public int getIndex() {
		return index;
	}

	public int getRemainingTokens() {
		return remainingTokens;
	}

}
