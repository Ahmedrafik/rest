package tprest;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

	@JsonProperty
	private String title;
	@JsonProperty
	private int id;
	@JsonProperty
	private String isbn;
	@JsonProperty
	private Collection<String> authors;
	
	public Book(){}
	
	public Book(String title, int id, String isbn) {
		super();
		this.title = title;
		this.id = id;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Collection<String> getAuthors() {
		return authors;
	}
	
	public void addAuthor(String author){
		this.authors.add(author);
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", id=" + id + ", isbn=" + isbn + ", authors=" + authors + "]";
	}
	
	
	
	
}
