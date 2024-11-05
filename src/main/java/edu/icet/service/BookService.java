package edu.icet.service;

import edu.icet.dto.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBookById(Integer id);

    Book searchBookById(Integer id);

    List<Book> searchBookByName(String name);

    List<Book> latestBook(Integer count) throws IndexOutOfBoundsException;

    Integer length();
}
