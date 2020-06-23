package de.wbstraining.ocp.lotto;

import java.time.LocalDate;

public interface IGebuehrService {
	
	public GebuehrDto gebuehrFuerDatum(LocalDate date);

}
