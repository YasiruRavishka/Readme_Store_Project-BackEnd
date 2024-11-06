package edu.icet.controller;

import edu.icet.dto.Book;
import edu.icet.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAll(){
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
        service.addBook(book);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBook(@RequestBody Book book){
        service.updateBook(book);
    }

    @DeleteMapping("/delete-by-id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBookById(@RequestParam Integer id){
        service.deleteBookById(id);
    }

    @GetMapping("/search-by-id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book searchBookById(@RequestParam Integer id){
        return service.searchBookById(id);
    }

    @GetMapping("/search-by-name")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> searchBookByName(@RequestParam String name){
        return service.searchBookByName(name);
    }

    @GetMapping("/latest/{count}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> getLatestBook(@PathVariable Integer count){
        return service.latestBook(count);
    }
}
