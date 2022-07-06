package io.code.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student  extends BaseEntity{

    private String studentId;
    private String name;
    private String email;

    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties("student")
    private List<Transaction> transactionList;


    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties("student")
    private List<Book> bookList;




}
