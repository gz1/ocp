package de.wbstraining.ocp.lotto;

public interface IAbgabeKostenErmitteln {
	
	public int abgabeKosten(KostenErmittelnDto dto);
	public void setGebuehrService(IGebuehrService service);

}
