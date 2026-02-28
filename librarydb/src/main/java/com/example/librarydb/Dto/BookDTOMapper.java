
package com.example.librarydb.Dto;

import com.example.librarydb.Domain.Books;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class BookDTOMapper implements Function<Books, BookDTO> {


    @Override
    public BookDTO apply(Books book) {
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPages(),
                book.getIsbn(),
                book.getPublisher()

        );
    }
}
