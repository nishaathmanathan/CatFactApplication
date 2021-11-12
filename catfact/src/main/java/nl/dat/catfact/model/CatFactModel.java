package nl.dat.catfact.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CatFactModel is a data model class corresponds to entity and table catfact.
 * 
 * @author Nisha
 *
 */
@Entity
@Table(name = "catfact")
public class CatFactModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@JsonProperty("fact")
	@Column(name = "catFacts")
	private String catFacts;

	public CatFactModel() {
	}

	public CatFactModel(long id, String catFacts) {
		super();
		this.id = id;
		this.catFacts = catFacts;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatFacts() {
		return catFacts;
	}

	public void setCatFacts(String catFacts) {
		this.catFacts = catFacts;
	}

	@Override
	public String toString() {
		return "CatFactModel [id=" + id + ", catFacts=" + catFacts + "]";
	}

}
