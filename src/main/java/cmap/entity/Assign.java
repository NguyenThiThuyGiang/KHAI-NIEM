package cmap.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assign")
public class Assign {

	@Id
	@GeneratedValue
	private int id;
	private String topic;
	private String info;
	private Date deadline;
	private Date date_create;

	// --- Mapping
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cmap_id")
	private CMap cmap;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "assign")
	private Set<FeedBack> feedbacks = new HashSet<FeedBack>(0);

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "assigns")
	private Set<Member> members = new HashSet<Member>(0);

	public Assign() {

	}

	public Assign(String topic, String info, Date deadline,
			Date date_create, CMap cmap) {

		this.topic = topic;
		this.info = info;
		this.deadline = deadline;
		this.date_create = date_create;
		this.cmap = cmap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getDate_create() {
		return date_create;
	}

	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}

	public CMap getCmap() {
		return cmap;
	}

	public void setCmap(CMap cmap) {
		this.cmap = cmap;
	}

	public Set<FeedBack> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Set<FeedBack> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Set<Member> getMembers() {
		return members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}





}
