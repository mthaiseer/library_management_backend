package io.code.library.service;

import io.code.library.entity.*;
import io.code.library.repository.TransactionRepository;
import io.code.library.request.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {


    @Autowired
    private StudentService studentService;

    @Autowired
    private BookService bookService;

    @Autowired
    private TransactionRepository transactionRepository;

    /**
     *
     * @param request
     * @return
     * @throws Exception
     */
    public Transaction issueBook(TransactionRequest request) throws Exception {
        /**
         * 1. check student exists?
         * 2. check book present and available to issue (not issued by another student)
         * 3. check student quota not reached
         * 4. create a txn with pending status
         * 5. assign book to student and make book unavailable
         *    5.1 any error, rollback and make book available for another issue transaction
         * 6. make transaction complete || successful
         *
         */



        Long studentId = request.getStudentId();
        Student studentFromDB = studentService.findById(studentId);

        if(studentFromDB == null){
            throw new Exception("oops, student not found");
        }

        if(studentFromDB.getBookList()!= null && studentFromDB.getBookList().size() >= 3){
            throw new Exception("Oh, your maximum book subscription quota exceeded!");
        }

        Long bookId = request.getBookId();
        Book bookFromDB = bookService.findById(bookId);

        if(bookFromDB ==  null){
            throw new Exception("oops, book not available");
        }

        if(bookFromDB.getStudent() != null){
            throw new Exception("Sorry, Book already issued to another student");
        }

        Transaction transaction = Transaction.builder()
                .transactionId(UUID.randomUUID().toString())
                .book(bookFromDB)
                .student(studentFromDB)
                .status(TransactionStatus.PENDING)
                .type(TransactionType.ISSUE)
                .build();

        transactionRepository.save(transaction);

       try{
           bookFromDB.setStudent(studentFromDB);
           bookService.updateBook(bookFromDB);
           transaction.setStatus(TransactionStatus.SUCCESSFUL);
       }catch (Exception ex){

           bookFromDB.setStudent(null);
           bookService.updateBook(bookFromDB);
           transaction.setStatus(TransactionStatus.FAILED);
       }
        transactionRepository.save(transaction);
        return transaction;
    }

    /**
     *
     * @param request
     * @return
     */
    public Transaction returnBook(TransactionRequest request) throws Exception {
         /*
         * 1. check student exists?
         * 2. check book present and  issue to same student?
         * 3. calculate fine
         * 4. update txn with pending
         * 5. remove student from book and make book available
         *       5.1. if failed, rollback
         * 6. update txn success|| completed
         *
         */

        //TODO fine calculation
        Long studentId = request.getStudentId();
        Student studentFromDB = studentService.findById(studentId);

        Long bookId = request.getBookId();
        Book bookFromDB = bookService.findById(bookId);

        if(studentFromDB == null || bookFromDB == null){
            throw new Exception("Invalid book or student details!");
        }

        if(bookFromDB.getStudent() == null || bookFromDB.getStudent().getId() != request.getStudentId()){
            throw new Exception("Sorry, Book is not issued to current user");
        }


        Transaction transaction = Transaction.builder()
                .transactionId(UUID.randomUUID().toString())
                .book(bookFromDB)
                .student(studentFromDB)
                .status(TransactionStatus.PENDING)
                .type(TransactionType.RETURN)
                .build();


        transactionRepository.save(transaction);
        try {
            bookFromDB.setStudent(null);
            bookService.updateBook(bookFromDB);
            transaction.setStatus(TransactionStatus.SUCCESSFUL);
        }catch (Exception ex){
            transaction.setStatus(TransactionStatus.FAILED);
        }

        transactionRepository.save(transaction);
        return transaction;
    }
}
