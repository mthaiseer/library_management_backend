package io.code.library.book.repository;

import io.code.library.book.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findAuthorsByEmail(String email);

}
