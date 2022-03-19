package com.github.hugodorne.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "borrow", schema = "public", catalog = "ddft0v81e8ep51")
public class BorrowEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "borrow_id", nullable = false)
	private int borrowId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private PersonEntity personId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private BookEntity bookId;

	@Basic(optional = false)
	@Column(name = "borrow_date", nullable = false)
	private Instant borrowDate;

	@Basic
	@Column(name = "borrow_return")
	private Instant borrowReturn;


	public int getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}

	public PersonEntity getPersonId() {
		return personId;
	}

	public void setPersonId(PersonEntity personId) {
		this.personId = personId;
	}

	public BookEntity getBookId() {
		return bookId;
	}

	public void setBookId(BookEntity bookId) {
		this.bookId = bookId;
	}

	public Instant getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Instant borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Instant getBorrowReturn() {
		return borrowReturn;
	}

	public void setBorrowReturn(Instant borrowReturn) {
		this.borrowReturn = borrowReturn;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BorrowEntity that = (BorrowEntity) o;

		if (borrowId != that.borrowId) return false;
		if (personId != that.personId) return false;
		if (bookId != that.bookId) return false;
		if (!Objects.equals(borrowDate, that.borrowDate)) return false;
		return Objects.equals(borrowReturn, that.borrowReturn);
	}

	@Override
	public int hashCode() {
		int result = borrowId;
		result = 31 * result + (bookId != null ? bookId.hashCode() : 0);
		result = 31 * result + (personId != null ? personId.hashCode() : 0);
		result = 31 * result + (borrowDate != null ? borrowDate.hashCode() : 0);
		result = 31 * result + (borrowReturn != null ? borrowReturn.hashCode() : 0);
		return result;
	}
}
