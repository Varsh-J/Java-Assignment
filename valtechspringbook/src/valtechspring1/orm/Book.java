package valtechspring1.orm;



import java.util.Date;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String name;
	private Date whenPublished;
	@ManyToOne(targetEntity=Publisher.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.EAGER)
	@JoinColumn(name="publisher_id",referencedColumnName="id")
	private Publisher publisher;
	
	@ManyToMany(targetEntity=Author.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.EAGER)
	@JoinColumn(name="author_id",referencedColumnName="id")
	private Set<Author> authors;
	
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	public Set<Author> getAuthors() {
		return authors;
	}
	
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}
	
	public Book() {
		super();
	}

	
	public Book(int id, String name, Date whenPublished) {
		super();
		this.id = id;
		this.name = name;
		this.whenPublished = whenPublished;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getWhenPublished() {
		return whenPublished;
	}


	public void setWhenPublished( Date  whenPublished) {
		this.whenPublished = whenPublished;
	}
	
	

}
