package interfejs;

import java.util.GregorianCalendar;

public interface MenjacnicaInterfejs {

	public void dodajKurs(String nazivValute, String skraceniNaziv, GregorianCalendar datum, double prodajni, double srednji, double kupovni);
	public void obrisiKurs(String skraceniNazivValute, GregorianCalendar datum);
	public double[] pronadjiKurs(String skraceniNazivValute, GregorianCalendar datum);
	
}
