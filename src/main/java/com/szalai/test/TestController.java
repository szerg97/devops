package com.szalai.test;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v14")
public class TestController {

    private final List<Book> books;

    public TestController() {
        books = new ArrayList<>();
        books.addAll(List.of(
                new Book("Star Wars II"),
                new Book("Harry Potter III"),
                new Book("The Mandalorian II")));
    }

    @GetMapping(path = "/books")
    public List<Book> getBooks(){
        return books;
    }

    @PostMapping(path = "/books")
    public List<Book> addBooks(@RequestBody BookDto dto){
        books.add(new Book(dto.getTitle()));
        return books;
    }


}
