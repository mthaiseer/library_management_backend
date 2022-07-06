package io.code.library.service;

import io.code.library.entity.Author;
import io.code.library.entity.Book;
import io.code.library.repository.BookRepository;
import io.code.library.request.BookRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {


    Logger logger = LoggerFactory.getLogger(BookService.class);
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) throws Exception {


        /**
         * 1. check author is exists else create new author
         * 2. create new book with author
         *
         *
         */
        if(book == null ) {
            throw new Exception("book request cannot be invalid");
        }

        Author authorFromDB = authorService.createOrGet(book.getAuthor());
        book.setUuid(UUID.randomUUID().toString());
        book.setAuthor(authorFromDB);
        Book bookcreatedFromDB = bookRepository.save(book);
        return bookcreatedFromDB;
    }


    public Book findByUUID(String id){
        Book bookObj = bookRepository.findBookByUuid(id);
        logger.info(bookObj.toString());
        return bookObj;
    }

    public Book findById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Book book){
        return bookRepository.save(book);
    }
}
