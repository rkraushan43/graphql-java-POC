package com.rk.graphqljavapoc.bookdetails.resolvers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.rk.graphqljavapoc.bookdetails.model.Author;
import com.rk.graphqljavapoc.bookdetails.model.Book;
import com.rk.graphqljavapoc.bookdetails.repository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {

	protected final Logger		logger	= LoggerFactory.getLogger(getClass());
	@Autowired
	private AuthorRepository	authorRepository;

	public List<Author> getAuthors() {

		logger.debug("Called getAuthors for BookResolver");
		return authorRepository.findAll();
	}
}
