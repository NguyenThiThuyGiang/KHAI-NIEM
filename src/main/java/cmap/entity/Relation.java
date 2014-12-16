package cmap.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "relation")
public class Relation {

	@Id
	@GeneratedValue
	private int id;
	private String title;

	// --- Mapping
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "from_concept")
	private Concept from;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "to_concept")
	private Concept to;

	@ManyToOne(fetch = FetchType.EAGER)
	private CMap cmap;

	// Constructor mặc định
	public Relation() {

	}
	


	public Relation(Concept from, Concept to, String title, CMap cmap) {
		this.title = title;
		this.cmap = cmap;
		this.from = from;
		this.to = to;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Concept getFrom() {
		return from;
	}

	public void setFrom(Concept from) {
		this.from = from;
	}

	public Concept getTo() {
		return to;
	}

	public void setTo(Concept to) {
		this.to = to;
	}

	public CMap getCmap() {
		return cmap;
	}

	public void setCmap(CMap cmap) {
		this.cmap = cmap;
	}

	
}
