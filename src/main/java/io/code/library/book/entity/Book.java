package io.code.library.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.code.library.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {

    private String bookId;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Genere genere;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value = {"books"})
    private Author author;

    private int cost;

}
