package valtechspring1.client;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


import valtechspring1.orm.AddressBook;
import valtechspring1.orm.Article;

import valtechspring1.orm.Author;

import valtechspring1.orm.Blog;

import valtechspring1.orm.HandBook;
import valtechspring1.orm.Publisher;


import java.util.Date;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;




import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import valtechspring1.orm.Book;

public class HibernateBook {

	
	public static void main(String[] args) {
		
		SessionFactory sf = new AnnotationConfiguration().configure().addAnnotatedClass(Book.class)
				.addAnnotatedClass(Publisher.class)
				.addAnnotatedClass(Author.class)
				.addAnnotatedClass(AddressBook.class)
				.addAnnotatedClass(Article.class)
				.addAnnotatedClass(Blog.class)
				.addAnnotatedClass(HandBook.class)
				.buildSessionFactory();
		
		
		
		 Session ses = sf.openSession();
	     Transaction tx = ses.beginTransaction();
	     
	    Book b= new Book(1,"AB2", new Date(1,3,90));
	     ses.save(b);
	     Publisher p = new Publisher(2, "ab","JP Nagar",987654321);
	     ses.save(p);
	     b.setPublisher(p);
	     ses.save(b);
	     Author au= new Author("author1",987654321);
	     
	     ses.save(au);
	     AddressBook ad = new AddressBook("7th main","Bangalore","Kar",56709);
	     ses.save(ad);
	     au.setAddressBook(ad);
	     ad.setAuthor(au);
	     Article ar = new Article("http://ab");
	     ses.save(ar);
	     Blog bl= new Blog("http://ab",2);
	     ses.save(bl);
	     HandBook hb= new HandBook(123,500,"1990",2);
	     ses.save(hb);
	     
	     
	     
	     
	        tx.commit();
	        ses.close();
	        sf.close();
	}
	
}
