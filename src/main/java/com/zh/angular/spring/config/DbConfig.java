package com.zh.angular.spring.config;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zh.angular.spring.domain.Book;
import com.zh.angular.spring.repository.MockBookRepository;

@Configuration
public class DbConfig {

	@Bean
	public JpaRepository<Book, Serializable> getBookRepository() {
		return new MockBookRepository();
	}
}
