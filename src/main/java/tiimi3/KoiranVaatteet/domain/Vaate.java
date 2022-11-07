package tiimi3.KoiranVaatteet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Vaate {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String type;
	private double price;
	
	@ManyToOne
	@JsonIgnoreProperties("vaatteet")
	@JoinColumn(name = ("valmistajaid"))
	private Valmistaja valmistaja;
	
	public Vaate () {
		
	}
	
	public Vaate (String name, String type, double price, Valmistaja valmistaja) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.valmistaja = valmistaja;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	public Valmistaja getValmistaja() {
		return valmistaja;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setValmistaja(Valmistaja valmistaja) {
		this.valmistaja = valmistaja;
	}

	@Override
	public String toString() {
		if (this.valmistaja != null)
			return "KoiranVaatteet [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", valmistaja="
				+ this.getValmistaja() + "]";
		else
			return "KoiranVaatteet [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + "]";
	}
	
}
