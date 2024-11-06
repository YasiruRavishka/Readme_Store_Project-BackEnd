package edu.icet.repository;

import edu.icet.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findByName(String name);

    @Query(value = "SELECT * FROM Book b ORDER BY b.id DESC LIMIT :limit", nativeQuery = true)
    List<BookEntity> latestBookList(@Param("limit") Integer limit);
}
