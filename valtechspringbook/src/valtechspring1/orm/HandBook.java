package valtechspring1.orm;

import javax.persistence.Entity;

@Entity
public class HandBook extends Book {
    
	
	private int isbn;
	private float price;
	private String publishedYear;
	private int editions;
	
	public HandBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HandBook(int isbn, float price, String publishedYear, int editions) {
		super();
		this.isbn = isbn;
		this.price = price;
		this.publishedYear = publishedYear;
		this.editions = editions;
	}

	@Override
	public String toString() {
		return "handBook [isbn=" + isbn + ", price=" + price + ", publishedYear=" + publishedYear + ", editions="
				+ editions + "]";
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(String publishedYear) {
		this.publishedYear = publishedYear;
	}

	public int getEditions() {
		return editions;
	}

	public void setEditions(int editions) {
		this.editions = editions;
	}
	
	
	
}
