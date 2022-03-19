package com.github.hugodorne.model;

import com.github.hugodorne.enumeration.Disponibilite;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "public", catalog = "ddft0v81e8ep51")
public class BookEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "book_id", nullable = false)
	private int bookId;

	@Basic(optional = false)
	@Column(name = "book_title", nullable = false)
	private String bookTitle;

	@Basic(optional = false)
	@Column(name = "book_authors", nullable = false)
	private String bookAuthors;

	@Enumerated(EnumType.STRING)
	@Column(name = "book_dispo", nullable = false, length = 63)
	private Disponibilite bookDispo;


	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthors() {
		return bookAuthors;
	}

	public void setBookAuthors(String bookAuthors) {
		this.bookAuthors = bookAuthors;
	}

	public Disponibilite getBookDispo() {
		return bookDispo;
	}

	public void setBookDispo(Disponibilite bookDispo) {
		this.bookDispo = bookDispo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BookEntity that = (BookEntity) o;

		if (bookId != that.bookId) return false;
		if (!Objects.equals(bookTitle, that.bookTitle)) return false;
		if (!Objects.equals(bookAuthors, that.bookAuthors)) return false;
		return Objects.equals(bookDispo, that.bookDispo);
	}

	@Override
	public int hashCode() {
		int result = bookId;
		result = 31 * result + (bookTitle != null ? bookTitle.hashCode() : 0);
		result = 31 * result + (bookAuthors != null ? bookAuthors.hashCode() : 0);
		result = 31 * result + (bookDispo != null ? bookDispo.hashCode() : 0);
		return result;
	}
}
