package io.code.library.response;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BookResponse {

    private String bookName;
    private String authorName;
    private String genere;

}
