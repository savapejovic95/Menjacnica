package menjacnica;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import interfejs.MenjacnicaInterfejs;

public class Menjacnica implements MenjacnicaInterfejs {

private ArrayList<Valuta> valute = new ArrayList<Valuta>();
	
	public ArrayList<Valuta> getValute() {
		return valute;
	}

	public void setValute(ArrayList<Valuta> valute) {
		if(valute == null)
			throw new RuntimeException("Greska!");
		this.valute = valute;
	}

	@Override
	public void dodajKurs(String nazivValute, String skraceniNaziv, GregorianCalendar datum, double prodajni, double srednji, double kupovni) {
		
		boolean uslov = false;
		Kurs kurs = new Kurs(prodajni, kupovni, srednji, datum);
		ArrayList<Kurs> kursevi;
		
		if(nazivValute == null || skraceniNaziv == null || datum == null)
			throw new RuntimeException("Greska pri unosu parametara");
		
		for(int i = 0; i < valute.size(); i++){
			if(valute.get(i).getNaziv().equals(nazivValute) && valute.get(i).getSkraceniNaziv().equals(skraceniNaziv)){
				kursevi = valute.get(i).getKursevi();
				kursevi.add(kurs);
				valute.get(i).setKursevi(kursevi);
				uslov = true;
				break;
			}
		}
		if(!uslov){
			kursevi = new ArrayList<Kurs>();
			kursevi.add(kurs);
			Valuta v = new Valuta();
			v.setNaziv(nazivValute);
			v.setSkraceniNaziv(skraceniNaziv);
			v.setKursevi(kursevi);
			valute.add(v);
		}
	}

	@Override
	public void obrisiKurs(String skraceniNazivValute, GregorianCalendar datum) {
		
	}

	@Override
	public double[] pronadjiKurs(String skraceniNazivValute, GregorianCalendar datum) {
		
		return null;
	}

}
