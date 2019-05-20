package com.coronado.BookStore.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKS")
public class Book implements Serializable {

	@Id
	@Column(unique = true, nullable = false, name = "ISBN", length = 15)
	private String isbn;

	@Column(nullable = false, name = "TITLE", length = 30)
	private String title;

	@Column(nullable = false, name = "AUTHOR", length = 30)
	private String author;

	@Column(nullable = false, name = "PUBLISHER", length = 30)
	private String publisher;

	@Column(nullable = false, name = "PUBLICATION_YEAR")
	private int publicationYear;

	@Column(nullable = false, name = "BINDING", length = 30)
	private String binding;

	@Column(name = "NUMBER_PAGES", nullable = false)
	private int numberPages;

	@Column(nullable = false, name = "PRICE", precision = 4, scale = 2)
	private double price;

	@Column(name = "STOCK", nullable = false)
	private int stock;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public int getNumberPages() {
		return numberPages;
	}

	public void setNumberPages(int numberPages) {
		this.numberPages = numberPages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
