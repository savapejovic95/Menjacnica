package menjacnica;

import java.util.GregorianCalendar;

import interfejs.MenjacnicaInterfejs;

public class Menjacnica implements MenjacnicaInterfejs {

	@Override
	public void dodajKurs(String nazivValute, String skraceniNaziv, GregorianCalendar datum, double prodajni, double srednji, double kupovni) {
		

	}

	@Override
	public void dodajKurs(String skraceniNazivValute, GregorianCalendar datum, double prodajni, double srednji, double kupovni) {

	}

	@Override
	public void obrisiKurs(String skraceniNazivValute, GregorianCalendar datum) {
		
	}

	@Override
	public double[] pronadjiKurs(String skraceniNazivValute, GregorianCalendar datum) {
		
		return null;
	}

}
