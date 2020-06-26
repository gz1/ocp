package de.wbstraining.ocp.lotto;

// 

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AbgabeKostenErmittelnTest {

	private IAbgabeKostenErmitteln kostenErmitteln;
	private IGebuehrService gebuehrService;

	private GebuehrDto gebuehrDto;
	private KostenErmittelnDto kostenDto;

	private final int GRUNDGEBUEHR = 60;
	private final int EINSATZ_PRO_TIPP = 100;
	private final int EINSATZ_SPIEL_77 = 250;
	private final int EINSATZ_SUPER_6 = 125;

	private final Laufzeit LAUFZEIT = Laufzeit.EINE_WOCHE;
	private final int ANZAHL_TIPPS = 1;
	private boolean IS_SUPER_6 = false;
	private boolean IS_SPIEL_77 = false;
	private Teilnahme teilnahme = Teilnahme.MITTWOCH;

	private final LocalDate DATE = LocalDate.now();

	@BeforeEach
	public void setupMock() {
		kostenErmitteln = new AbgabeKostenErmitteln();
		gebuehrService = mock(IGebuehrService.class);
		gebuehrDto = new GebuehrDto(GRUNDGEBUEHR, EINSATZ_PRO_TIPP, EINSATZ_SPIEL_77, EINSATZ_SUPER_6);
		kostenDto = new KostenErmittelnDto(LAUFZEIT, ANZAHL_TIPPS, IS_SUPER_6, IS_SPIEL_77, teilnahme);
		kostenErmitteln.setGebuehrService(gebuehrService);

		when(gebuehrService.gebuehrFuerDatum(DATE)).thenReturn(gebuehrDto);
	}

	@Test
	public void kostenErmittelnTest() {
		int expectedKosten = 160;
		int result = kostenErmitteln.abgabeKosten(kostenDto);
		assertTrue(expectedKosten == result);
	}

	@Test
	public void serviceCallTest() {
		kostenErmitteln.abgabeKosten(kostenDto);
		verify(gebuehrService, atLeastOnce()).gebuehrFuerDatum(DATE);

	}
}
