package io.code.library.response;

import io.code.library.entity.Transaction;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private String transactionId;
    private String status;
    private String type;

    public static TransactionResponse from(Transaction transaction){
         return TransactionResponse.builder()
                .transactionId(transaction.getTransactionId())
                .type(transaction.getType().toString())
                .status(transaction.getStatus().toString())
                .build();

    }




}
