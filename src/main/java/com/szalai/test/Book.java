package com.szalai.test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book{

    private String title;
    private Author author;
}
