package io.code.library.service;

import io.code.library.entity.Author;
import io.code.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {


    @Autowired
    private AuthorRepository authorRepository;

    public Author createOrGet(Author author) {

        Author authorFromDatabase = authorRepository.findAuthorsByAuthorNameAndAndEmail(author.getAuthorName(), author.getEmail());

        if(authorFromDatabase == null){

             return authorRepository.save(Author.builder()
                    .authorName(author.getAuthorName())
                    .email(author.getEmail())
                    .build());


        }

        return authorFromDatabase;

    }
}
