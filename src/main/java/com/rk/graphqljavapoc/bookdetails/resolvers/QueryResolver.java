package com.rk.graphqljavapoc.bookdetails.resolvers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rk.graphqljavapoc.bookdetails.model.Author;
import com.rk.graphqljavapoc.bookdetails.model.Book;
import com.rk.graphqljavapoc.bookdetails.repository.AuthorRepository;
import com.rk.graphqljavapoc.bookdetails.repository.BookRepository;

@Component
public class QueryResolver implements GraphQLQueryResolver {

	@Autowired
	private BookRepository		bookRepository;

	@Autowired
	private AuthorRepository	authorRepository;

	private Optional<Author>	authorOpt	= null;

	private Author				author		= null;

	public Book getBookById(Long id) {

		Optional<Book> bookOption = bookRepository.findById(id);
		if (bookOption.isPresent()) return bookOption.get();
		return null;
	}

	public List<Book> getBookList() {

		return bookRepository.findAll();
	}

	public Book getBookByName(String name) {

		Book book = bookRepository.findBookByName(name);
		System.out.println("Book-id " + book.getId());
		System.out.println("Book-pageCount " + book.getPageCount());
		System.out.println("Book-authors " + book.getAuthor());
		return book;
	}

	public List<Book> bookByAuthor(Long authorId) {

		List<Book> bookList = bookRepository.findAllByAuthorId(authorId);

		if (bookList == null || bookList.isEmpty()) throw new RuntimeException();
		return bookList;
	}

	public Author getAuthor(Long id) {

		Optional<Author> author = authorRepository.findById(id);
		if (author.isPresent()) return author.get();
		return null;
	}

	public Author getAuthorByName(String firstName, String lastName) {

		author = authorRepository.findAuthorByfirstNameAndLastName(firstName, lastName);
		if (authorOpt != null) throw new RuntimeException("Author dosn't exist by given first and last name");
		return author;

	}

	public List<Author> getAuthorList() {

		return authorRepository.findAll();
	}

}
