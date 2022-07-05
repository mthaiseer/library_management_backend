package io.code.library.repository;

import io.code.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByUuid(String uuid);
}
