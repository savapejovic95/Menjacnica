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
		
		Kurs kurs = new Kurs(prodajni, kupovni, srednji, datum);
		ArrayList<Kurs> kursevi;
		//uslov da li valuta kursa postoji u listi ili je potrebno da se doda
		boolean uslov = false;
		
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
		if(valute.isEmpty()){
			throw new RuntimeException("Greska! Ne postoji ni jedna valuta");
		}
		if(skraceniNazivValute == null || datum == null){
			throw new RuntimeException("Greska pri unosu naziva valute i datuma");
		}
		
		for(int i = 0; i < valute.size(); i++){
			Valuta v = valute.get(i);
			if(v.getSkraceniNaziv().equals(skraceniNazivValute)){
				for(int j = 0; j < v.getKursevi().size(); j++){
					if(v.getKursevi().get(j).getDatum().compareTo(datum)==0){
						v.getKursevi().remove(j);
						return;
					}
				}
			}
		}
	}

	@Override
	public double[] pronadjiKurs(String skraceniNazivValute, GregorianCalendar datum) {
		double[] trazeniKursevi = new double[3];
		for(int i = 0; i < valute.size(); i++){
			if(valute.get(i).getSkraceniNaziv().equals(skraceniNazivValute)){
				for(int j = 0; j < valute.get(i).getKursevi().size(); j++){
					if(valute.get(i).getKursevi().get(j).getDatum().compareTo(datum)==0){
						trazeniKursevi[0] = valute.get(i).getKursevi().get(j).getProdajni();
						trazeniKursevi[1] = valute.get(i).getKursevi().get(j).getKupovni();
						trazeniKursevi[2] = valute.get(i).getKursevi().get(j).getSrednji();
						return trazeniKursevi;
					}
				}
			}
		}
		
		return null;
	}

}
