package com.coronado.BookStore.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronado.BookStore.Entity.Book;
import com.coronado.BookStore.Repository.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public List<Book> getProducts() {
		return this.bookRepository.findAll();
	}

	@PostMapping
	public Book create(@Valid @RequestBody Book book) {
		return this.bookRepository.save(book);
	}

	@GetMapping("/{isbn}")
	public Optional<Book> getById(@PathVariable String isbn) {
		return this.bookRepository.findById(isbn);
	}
	
	@PutMapping("/{isbn}")
	public Optional<Book> update(@PathVariable String isbn, @Valid @RequestBody Book book) {
		return this.bookRepository.findById(isbn).map(b -> {
			b.setAuthor(book.getAuthor());
			b.setBinding(book.getBinding());
			b.setNumberPages(book.getNumberPages());
			b.setPrice(book.getPrice());
			b.setPublicationYear(book.getPublicationYear());
			b.setPublisher(book.getPublisher());
			b.setStock(book.getStock());
			b.setTitle(book.getTitle());
			return this.bookRepository.save(b);
		});
	}

	@DeleteMapping("/{isbn}")
	public Optional<Object> delete(@PathVariable String isbn) {
		return this.bookRepository.findById(isbn).map(book -> {
			this.bookRepository.delete(book);
			return ResponseEntity.ok().build();
		});
	}
}
