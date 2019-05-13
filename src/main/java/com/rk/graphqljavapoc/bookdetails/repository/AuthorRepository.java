package com.rk.graphqljavapoc.bookdetails.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rk.graphqljavapoc.bookdetails.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

	public Author findAuthorByfirstNameAndLastName(String firstName, String lastName);

	public List<Author> findAll();
}
