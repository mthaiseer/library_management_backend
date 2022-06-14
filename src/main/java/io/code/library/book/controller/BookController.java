package io.code.library.book.controller;

import io.code.library.book.entity.Book;
import io.code.library.book.request.BookRequest;
import io.code.library.book.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private BookService bookService;

    Logger logger  = LoggerFactory.getLogger(BookController.class);


    @PostMapping("book")
    public Book createBook(@Valid @RequestBody BookRequest request){
        Book book  = request.to();
        return bookService.save(book);
    }

    @GetMapping("book")
    private List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("book/{id}")
    private Book findById(@PathVariable(name="id", required = true) String id){

        logger.info("Book id {}", id);
        Book book =   bookService.findById(id);
        return book;

    }



}
