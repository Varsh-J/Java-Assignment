package valtechspring1.orm;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Author {
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String name;
	private long phone;
	 @OneToOne(targetEntity=AddressBook.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.LAZY,mappedBy="author")
	 private AddressBook addressBook;
	
	 @ManyToMany(targetEntity=Book.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.EAGER) 
	 private Set<Book> books;
	 
	 public void setBooks(Set<Book> books) {
		this.books = books;
	}
	 
	 public Set<Book> getBooks() {
		return books;
	}
	 
	public Author() {
		super();
	}

	public void setAddressBook(AddressBook addressBook) {
		this.addressBook = addressBook;
	}
	
	public AddressBook getAddressBook() {
		return addressBook;
	}
	
	public Author(String name, long phone) {
		super();
		//this.id = id;
		this.name = name;
		this.phone = phone;
	}
	
	

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", phone=" + phone + "]";
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
	
	

}
