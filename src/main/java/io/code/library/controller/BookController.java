package io.code.library.controller;

import io.code.library.entity.Book;
import io.code.library.request.BookRequest;
import io.code.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {


    @Autowired
    private BookService bookService;

    @GetMapping("/ping")
    private String ping(){
        return "ping book";
    }

    @PostMapping
    private Book createBook(@Valid @RequestBody BookRequest bookRequest) throws Exception {
        Book book = bookService.createBook(bookRequest.to());
        return book;
    }

    @GetMapping()
    private Book findById(@RequestParam("id") String  id){
        return bookService.findByUUID(id);
    }

    @GetMapping("/all")
    private List<Book> getAllBooks(){
        return bookService.findAllBooks();
    }
}
