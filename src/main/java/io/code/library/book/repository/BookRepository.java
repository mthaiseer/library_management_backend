package io.code.library.book.repository;

import io.code.library.book.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findBookByBookId(String id);
}
