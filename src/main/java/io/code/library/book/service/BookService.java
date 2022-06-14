package io.code.library.book.service;

import io.code.library.book.entity.Author;
import io.code.library.book.entity.Book;
import io.code.library.book.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookRepository bookRepository;

    Logger logger  = LoggerFactory.getLogger(BookService.class);


    /**
     *
     * @param book
     * @return
     */
    public Book save(Book book) {

        logger.info("Entering BookService.save");
        Author author = authorService.find(book.getAuthor());
        book.setAuthor(author);
        bookRepository.save(book);

        logger.info("Exiting BookService.save");
        return book;
    }

    /**
     *
     * @return
     */
    public List<Book> findAll() {

        logger.info("Entering BookService.findAll");
        List<Book> books = StreamSupport
                .stream( bookRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        logger.info("Exiting BookService.findAll");

        return books;

    }

    /**
     *
     * @param id
     * @return
     */
    public Book findById(String id) {
        return bookRepository.findBookByBookId(id);
    }
}
