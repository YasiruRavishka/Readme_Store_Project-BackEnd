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

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;
    private final ModelMapper mapper;

    @Override
    public List<Book> getAll() {
        return this.map(bookDao.findAll());
    }

    @Override
    public void addBook(Book book) {
        bookDao.save(mapper.map(book, BookEntity.class));
    }

    @Override
    public void updateBook(Book book) {
        bookDao.save(mapper.map(book, BookEntity.class));
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteById(id);
    }

    @Override
    public Book searchBookById(Integer id) {
        return mapper.map(bookDao.findById(id), Book.class);
    }

    @Override
    public List<Book> searchBookByName(String name) {
        return this.map(bookDao.findByName(name));
    }

    @Override
    public List<Book> latestBook(Integer count) throws IndexOutOfBoundsException {
        return this.map(bookDao.OrderByIdDesc().subList(0,count));
    }

    @Override
    public Integer length() {
        return (int) bookDao.count();
    }

    private List<Book> map(List<BookEntity> bookEntityList) {
        List<Book> bookList = new ArrayList<>();
        for (BookEntity entity : bookEntityList) {
            bookList.add(mapper.map(entity, Book.class));
        }
        return bookList;
    }
}
