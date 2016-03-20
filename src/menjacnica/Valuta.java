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
		if(naziv.isEmpty() || naziv == null){
			throw new RuntimeException("Greska! Naziv valute nije unet");
		}
		this.naziv = naziv;
	}
	
	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}
	
	public void setSkraceniNaziv(String skraceniNaziv) {
		if(skraceniNaziv.isEmpty() || skraceniNaziv == null){
			throw new RuntimeException("Greska! Skraceni naziv valute nije unet");
		}
		if(skraceniNaziv.length() > 3){
			throw new RuntimeException("Greska! Skraceni naziv valute ne sme imati vise od 3 karaktera");
		}
		this.skraceniNaziv = skraceniNaziv;
	}
	
	public ArrayList<Kurs> getKursevi() {
		return kursevi;
	}
	
	public void setKursevi(ArrayList<Kurs> kursevi) {
		if(kursevi == null){
			throw new RuntimeException("Greska! Kursevi nisu dobro prosledjeni");
		}
		this.kursevi = kursevi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kursevi == null) ? 0 : kursevi.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((skraceniNaziv == null) ? 0 : skraceniNaziv.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if(!(obj instanceof Valuta)){
			return false;
		}
		Valuta other = (Valuta) obj;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (skraceniNaziv == null) {
			if (other.skraceniNaziv != null)
				return false;
		} else if (!skraceniNaziv.equals(other.skraceniNaziv))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Valuta [naziv=" + naziv + ", skraceniNaziv=" + skraceniNaziv + ", ima kurseve=" + kursevi + "]";
	}
	
	
	
}
