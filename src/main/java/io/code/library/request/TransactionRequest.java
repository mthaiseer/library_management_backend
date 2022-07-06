package io.code.library.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionRequest {

    @NotNull
    private Long studentId;

    @NotNull
    private Long bookId;

}
