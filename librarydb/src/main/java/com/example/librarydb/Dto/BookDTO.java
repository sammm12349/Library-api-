package com.example.librarydb.Dto;

public record BookDTO(
        Long id,
        String title,
        String author,
        Integer pages,
        String isbn,
        String publisher

) {


}
