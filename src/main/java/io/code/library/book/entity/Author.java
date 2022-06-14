package io.code.library.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.code.library.common.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Author extends BaseEntity {

    private String name;
    private String email;

    @OneToMany(mappedBy = "author")
    @JsonIgnoreProperties(value = { "author"})
    List<Book> books;


}
