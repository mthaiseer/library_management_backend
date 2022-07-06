package io.code.library.repository;

import io.code.library.entity.Transaction;
import io.code.library.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("select t from Transaction t where t.student.id = :studentId and t.type =:type")
    List<Transaction> findMaximumQuota(Long studentId, TransactionType type);

}
