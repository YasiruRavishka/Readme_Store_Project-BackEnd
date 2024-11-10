package edu.icet.service.impl;

import edu.icet.dto.Book;
import edu.icet.entity.BookEntity;
import edu.icet.repository.BookDao;
import edu.icet.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookDao repository;
    private final ModelMapper mapper;

    @Override
    public List<Book> getAll() {
        return this.map(repository.findAll());
    }

    @Override
    public void addBook(Book book) {
        repository.save(mapper.map(book, BookEntity.class));
    }

    @Override
    public void updateBook(Book book) {
        repository.save(mapper.map(book, BookEntity.class));
    }

    @Override
    public void deleteBookById(Integer id) {
        updateBook(searchBookById(id).setDisable(true));
    }

    @Override
    public Book searchBookById(Integer id) {
        Optional<BookEntity> value = repository.findById(id);
        return value.isEmpty() ? null : mapper.map(value, Book.class);
    }

    @Override
    public List<Book> searchBookByName(String name) {
        return this.map(repository.findByName(name));
    }

    @Override
    public List<Book> latestBook(Integer count) {
        return this.map(repository.latestBookList(Math.abs(count)));
    }

    private List<Book> map(List<BookEntity> bookEntityList) {
        List<Book> bookList = new ArrayList<>();
        for (BookEntity entity : bookEntityList) {
            bookList.add(mapper.map(entity, Book.class));
        }
        return bookList;
    }
}
