package com.coronado.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coronado.BookStore.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,String>{

}
