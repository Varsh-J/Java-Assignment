package valtechspring1.orm;

import javax.persistence.Entity;

@Entity
public class Article extends Book {
	
	
	private String url;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(String url) {
		super();
		this.url = url;
	}
	
	

	@Override
	public String toString() {
		return "Artical [url=" + url + "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
