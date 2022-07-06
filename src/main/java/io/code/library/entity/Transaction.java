package io.code.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends  BaseEntity{

    private String transactionId;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("transactionList")
    private Student student;


    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("transactionList")
    private Book book;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Enumerated(EnumType.STRING)
    private TransactionType type;





}
