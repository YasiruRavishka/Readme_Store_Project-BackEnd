package edu.icet.repository;

import edu.icet.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findByName(String name);
    List<BookEntity> OrderByIdDesc();
}
