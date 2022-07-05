package io.code.library.request;


import io.code.library.entity.Author;
import io.code.library.entity.Book;
import io.code.library.entity.Genere;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String name;
    private String genere;
    private String authorName;
    private String email;


    public Book to(){

        Author author  =  Author.builder()
                .authorName(authorName)
                .email(email)
                .build();

        return Book.builder()
                .name(name)
                .genere(Genere.valueOf(genere))
                .author(author)
                .build();
    }



}
