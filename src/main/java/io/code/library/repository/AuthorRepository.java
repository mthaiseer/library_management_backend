package io.code.library.repository;

import io.code.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findAuthorsByAuthorNameAndAndEmail(String name, String email);

}
