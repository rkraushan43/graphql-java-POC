package com.rk.graphqljavapoc.bookdetails.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "book")
public class Book {

	@Transient
	protected final Logger	logger	= LoggerFactory.getLogger(getClass());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long			id;

	private String			name;

	private int				pageCount;

	@ManyToOne
	private Author			author;

	public Book() {

		super();
	}

	public Book(String name, int pageCount, Author author) {

		super();
		this.name = name;
		this.pageCount = pageCount;
		this.author = author;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getName() {

		logger.debug("Called getName for Book.");
		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public int getPageCount() {

		return pageCount;
	}

	public void setPageCount(int pageCount) {

		this.pageCount = pageCount;
	}

	public Author getAuthor() {

		logger.debug("Called getAuthor for Book.");
		return author;
	}

	public void setAuthor(Author author) {

		this.author = author;
	}

}
