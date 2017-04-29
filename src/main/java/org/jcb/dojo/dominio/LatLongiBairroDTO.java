package org.jcb.dojo.dominio;

public class LatLongiBairroDTO {
	
	private double lat;
	private double longi;
	private String bairro;
	
	
	public LatLongiBairroDTO(double lat, double longi, String bairro) {
		super();
		this.lat = lat;
		this.longi = longi;
		this.bairro = bairro;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLongi() {
		return longi;
	}
	public void setLongi(double longi) {
		this.longi = longi;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	@Override
	public String toString() {
		return "LatLongiBairroDTO [lat=" + lat + ", longi=" + longi + ", bairro=" + bairro + "]";
	}
	

}
