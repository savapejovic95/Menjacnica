package menjacnica;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Kurs {

	double prodajni;
	double kupovni;
	double srednji;
	GregorianCalendar datum;
	
	public Kurs(double prodajni, double kupovni, double srednji, GregorianCalendar datum) {
		super();
		this.prodajni = prodajni;
		this.kupovni = kupovni;
		this.srednji = srednji;
		this.datum = datum;
	}

	public double getProdajni() {
		return prodajni;
	}
	
	public void setProdajni(double prodajni) {
		if(prodajni <= 0){
			throw new RuntimeException("Greska! Prodajni kurs mora biti veci od 0");
		}
		this.prodajni = prodajni;
	}
	
	public double getKupovni() {
		return kupovni;
	}
	
	public void setKupovni(double kupovni) {
		if(kupovni <= 0){
			throw new RuntimeException("Greska! Kupovni kurs mora biti veci od 0");
		}
		this.kupovni = kupovni;
	}
	
	public double getSrednji() {
		return srednji;
	}
	
	public void setSrednji(double srednji) {
		if(srednji <= 0){
			throw new RuntimeException("Greska! Srednji kurs mora biti veci od 0");
		}
		this.srednji = srednji;
	}
	
	public GregorianCalendar getDatum() {
		return datum;
	}
	
	public void setDatum(GregorianCalendar datum) {
		if(datum == null){
			throw new RuntimeException("Greska! Datum nije pravilno unesen");
		}
		this.datum = datum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		long temp;
		temp = Double.doubleToLongBits(kupovni);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prodajni);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(srednji);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kurs other = (Kurs) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (Double.doubleToLongBits(kupovni) != Double.doubleToLongBits(other.kupovni))
			return false;
		if (Double.doubleToLongBits(prodajni) != Double.doubleToLongBits(other.prodajni))
			return false;
		if (Double.doubleToLongBits(srednji) != Double.doubleToLongBits(other.srednji))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyyy.");
		return "Kurs [prodajni=" + prodajni + ", srednji=" + srednji + ", kupovni=" + kupovni + ", " + sf.format(datum.getTime()) + "]";
	}
	
	
	
}
