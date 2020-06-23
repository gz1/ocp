package de.wbstraining.ocp.lotto;

import java.time.LocalDate;

public class AbgabeKostenErmitteln implements IAbgabeKostenErmitteln {
	
	private IGebuehrService gebuehrService;
	
	@Override
	public int abgabeKosten(KostenErmittelnDto kostenDto) {
		
		LocalDate date = LocalDate.now();
		GebuehrDto gebuehrDto = gebuehrService.gebuehrFuerDatum(date);
		
		int kosten = 0;
		
		int laufzeit = kostenDto.laufzeit;
		int anzahlTipps = kostenDto.anzahlTipps;
		boolean isSuper6 = kostenDto.isSuper6;
		boolean isSpiel77 = kostenDto.isSpiel77;
		boolean isMittwoch = kostenDto.isMittwoch;
		boolean isSamstag = kostenDto.isSamstag;
		
		int grundGebuehr = gebuehrDto.grundGebuehr;
		int einsatzProTipp = gebuehrDto.einsatzProTipp;
		int einsatzspiel77 = gebuehrDto.einsatzSpiel77;
		int einsatzSuper6 = gebuehrDto.einsatzSuper6;
		
		int faktor = 1;
		
		if(isMittwoch && isSamstag) {
			faktor = 2;
		}
		
		kosten += grundGebuehr;
		
		kosten += einsatzProTipp * laufzeit * anzahlTipps * faktor;
		
		if(isSpiel77) {
			kosten += laufzeit * einsatzspiel77 * faktor;
		}
		
		if(isSuper6) {
			kosten += laufzeit * einsatzSuper6 * faktor;
		}
		
		return kosten;
	}

	@Override
	public void setGebuehrService(IGebuehrService gebuehrService) {
		this.gebuehrService = gebuehrService;
	}

}
