package io.code.library.controller;

import io.code.library.entity.Transaction;
import io.code.library.request.TransactionRequest;
import io.code.library.response.TransactionResponse;
import io.code.library.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/issue")
    public TransactionResponse issueBook(@Valid @RequestBody TransactionRequest request) throws Exception {
        Transaction transactionFromDB = transactionService.issueBook(request);
        return TransactionResponse.from(transactionFromDB);
    }

    @PostMapping("/return")
    public TransactionResponse returnBook(@Valid @RequestBody TransactionRequest request) throws Exception {
        Transaction transactionFromDB = transactionService.returnBook(request);
        return TransactionResponse.from(transactionFromDB);
    }



}
