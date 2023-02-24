package com.mafr.redisbook.repository;

import com.mafr.redisbook.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
}
