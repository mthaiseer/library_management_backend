package io.code.library.book.service;

import io.code.library.book.entity.Author;
import io.code.library.book.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    Logger logger  = LoggerFactory.getLogger(AuthorService.class);

    public Author find(Author author) {

        logger.info("Entering AuthorService.find");

        Author authorFromDB = authorRepository.findAuthorsByEmail(author.getEmail());
        if(authorFromDB == null){
            return  authorRepository.save(author);
        }

        logger.info("Exiting AuthorService.find");
        return authorFromDB;
    }
}
