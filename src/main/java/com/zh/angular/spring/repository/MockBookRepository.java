package com.zh.angular.spring.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.zh.angular.spring.domain.Book;

public class MockBookRepository extends MockJpaRepository<Book, Long> {
	private AtomicLong counter = new AtomicLong();

	public MockBookRepository() {
		super(createDefaultBooks());
		counter.set(count());
	}
	
	@Override
	protected Long getId(Book entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Book entity, Long id) {
		entity.setId(id);
	}

	@Override
	protected Long nextId() {
		return counter.incrementAndGet();
	}

	private static List<Book> createDefaultBooks() {
		List<Book> books = new ArrayList<Book>();
		for (int i=0; i<3; i++) {
			Book b = new Book();
			b.setId((long)i);
			b.setName("name_" + i);
			books.add(b);
		}
		return books;
	}
}
