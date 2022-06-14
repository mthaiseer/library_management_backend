package io.code.library.book.request;

import io.code.library.book.entity.Author;
import io.code.library.book.entity.Book;
import io.code.library.book.entity.Genere;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    @NotNull
    private String name;

    @NotNull
    @Positive
    private int cost;

    @NotNull
    private String authorName;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String genere;


    public Book to() {

        return Book.builder()
                .name(name)
                .cost(cost)
                .bookId(UUID.randomUUID().toString())
                .genere(Genere.valueOf(genere))
                .author(
                        Author.builder()
                                .name(authorName)
                                .email(email)
                                .build()
                )
                .build();
    }

}
