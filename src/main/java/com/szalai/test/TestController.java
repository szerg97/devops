package com.szalai.test;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    private final List<Book> books;

    public TestController() {
        books = new ArrayList<>();
        books.addAll(List.of(
                new Book("Star Wars II", new Author("Mr. Xx Zz")),
                new Book("Harry Potter III", new Author("J. K. Rowling")),
                new Book("The Mandalorian II", new Author("Mr. Yyy "))));
    }

    @GetMapping(path = "/books")
    public List<Book> getBooks(){
        return books;
    }

    @PostMapping(path = "/books")
    public List<Book> addBooks(@RequestBody BookDto dto){
        books.add(new Book(dto.getTitle(), new Author(dto.getAuthor())));
        return books;
    }


}
