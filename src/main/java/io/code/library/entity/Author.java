package io.code.library.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author extends BaseEntity{

    @NotNull
    private String authorName;

    @NotNull
    @Email
    private String email;

    private String phone;

    @OneToMany(mappedBy = "author")
    @JsonIgnoreProperties("author")
    private List<Book> bookList;
}
