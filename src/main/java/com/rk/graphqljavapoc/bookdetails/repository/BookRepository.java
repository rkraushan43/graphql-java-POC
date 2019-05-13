package com.rk.graphqljavapoc.bookdetails.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rk.graphqljavapoc.bookdetails.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	public Book findBookByName(String name);

	public List<Book> findAll();

	public List<Book> findAllByAuthorId(Long authorId);

}
