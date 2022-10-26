package tiimi3.KoiranVaatteet.domain;

public class KoiranVaatteet {
	private long id;
	private String nimi;
	private String tyyppi;
	private double hinta;
	private String valmistaja;
	
	public KoiranVaatteet () {
		
	}
	
	public KoiranVaatteet (String nimi, String tyyppi, double hinta, String valmistaja) {
		super();
		this.nimi = nimi;
		this.tyyppi = tyyppi;
		this.hinta = hinta;
		this.valmistaja = valmistaja;			
	}
	
	
	public long getId() {
		return id;
	}
	public String getNimi() {
		return nimi;
	}
	public String getTyyppi() {
		return tyyppi;
	}
	public double getHinta() {
		return hinta;
	}
	public String getValmistaja() {
		return valmistaja;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}
	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	public void setValmistaja(String valmistaja) {
		this.valmistaja = valmistaja;
	}

	@Override
	public String toString() {
		return "KoiranVaatteet [id=" + id + ", nimi=" + nimi + ", tyyppi=" + tyyppi + ", hinta=" + hinta
				+ ", valmistaja=" + valmistaja + "]";
	}	

}
