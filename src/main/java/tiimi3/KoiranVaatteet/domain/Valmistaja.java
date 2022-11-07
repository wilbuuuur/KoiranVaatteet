package tiimi3.KoiranVaatteet.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Valmistaja {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long valmistajaid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "valmistaja")
	private List<Vaate> vaatteet;
	
	public Valmistaja() {}
	
	public Valmistaja(String name) {
		super();
		this.name = name;
	}

	public Long getValmistajaid() {
		return valmistajaid;
	}

	public String getName() {
		return name;
	}

	public List<Vaate> getVaatteet() {
		return vaatteet;
	}

	public void setValmistajaid(Long valmistajaid) {
		this.valmistajaid = valmistajaid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVaatteet(List<Vaate> vaatteet) {
		this.vaatteet = vaatteet;
	}

	@Override
	public String toString() {
		return "Valmistaja [valmistajaid=" + valmistajaid + ", name=" + name + ", vaatteet=" + vaatteet + "]";
	}
	
}
