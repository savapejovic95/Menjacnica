package menjacnica;

import java.util.ArrayList;

public class Valuta {

	String naziv;
	String skraceniNaziv;
	ArrayList<Kurs> kursevi;
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}
	
	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}
	
	public ArrayList<Kurs> getKursevi() {
		return kursevi;
	}
	
	public void setKursevi(ArrayList<Kurs> kursevi) {
		this.kursevi = kursevi;
	}
	
}
