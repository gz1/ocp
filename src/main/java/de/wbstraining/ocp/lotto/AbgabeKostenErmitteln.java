package de.wbstraining.ocp.lotto;

import java.time.LocalDate;

public class AbgabeKostenErmitteln implements IAbgabeKostenErmitteln {
	
	private IGebuehrService gebuehrService;
	
	@Override
	public int abgabeKosten(KostenErmittelnDto kostenDto) {
		
		LocalDate date = LocalDate.now();
		GebuehrDto gebuehrDto = gebuehrService.gebuehrFuerDatum(date);
		
		int kosten = 0;
		
		Laufzeit laufzeit = kostenDto.getLaufzeit();
		int anzahlTipps = kostenDto.getAnzahlTipps();
		boolean isSuper6 = kostenDto.isSuper6();
		boolean isSpiel77 = kostenDto.isSpiel77();
		//int einsatzProTipp = kostenDto.
		
		int grundGebuehr = gebuehrDto.grundGebuehr;
		int einsatzProTipp = gebuehrDto.einsatzProTipp;
		int einsatzspiel77 = gebuehrDto.einsatzSpiel77;
		int einsatzSuper6 = gebuehrDto.einsatzSuper6;
		
		int teilnahmeFaktor = kostenDto.getTeilnahme().getFaktor();
		
		kosten += grundGebuehr;
		
		kosten += einsatzProTipp * laufzeit.getAnzahl() * anzahlTipps * teilnahmeFaktor;
		
		if(isSpiel77) {
			kosten += laufzeit.getAnzahl() * einsatzspiel77 * teilnahmeFaktor;
		}
		
		if(isSuper6) {
			kosten += laufzeit.getAnzahl() * einsatzSuper6 * teilnahmeFaktor;
		}
		
		return kosten;
	}

	@Override
	public void setGebuehrService(IGebuehrService gebuehrService) {
		this.gebuehrService = gebuehrService;
	}

}
