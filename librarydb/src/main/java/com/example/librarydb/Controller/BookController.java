package com.example.librarydb.Controller;

import com.example.librarydb.Domain.Books;
import com.example.librarydb.Dto.BookDTO;
import com.example.librarydb.LibrarydbApplication;
import com.example.librarydb.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> findAllBooks() {
        List<BookDTO> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BookDTO> findBookById(@PathVariable("id") Long id) {
        BookDTO books = bookService.findBookById(id);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BookDTO> addBook(@RequestBody Books books) {
        BookDTO newBook = bookService.addBook(books);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<BookDTO> updateBook(@RequestBody Books books) {
        BookDTO updatedBook = bookService.updateBook(books);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @GetMapping("/find/isbn/{isbn}")
    public ResponseEntity<BookDTO> findBookByIsbn(@PathVariable String isbn) {
        BookDTO books = bookService.findBookByIsbn(isbn);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/author/{author}")
    public ResponseEntity<List<BookDTO>> findBookByAuthor(@RequestParam String author) {
        List<BookDTO> books = bookService.findBookByAuthor(author);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/find/title/{title}")
    public ResponseEntity<List<BookDTO>> findBookByTitle(@RequestParam String title) {
        List<BookDTO> books = bookService.findBookByTitle(title);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/find/authorandtitle/{author}/{title}")
    public ResponseEntity<List<BookDTO>> findBookByAuthorAndTitle(@RequestParam String author, @RequestParam String title) {
        List<BookDTO> books = bookService.findBookByAuthorAndTitle(author, title);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @GetMapping("/short")
    public ResponseEntity<List<BookDTO>> findShortBooks(@RequestParam Integer maxPages) {
        List<BookDTO> books = bookService.findShortBooks(maxPages);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }


    @GetMapping("/long")
    public ResponseEntity<List<BookDTO>> findLongBooks(@RequestParam Integer minPages) {
        List<BookDTO> books = bookService.findLongBooks(minPages);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }


    @GetMapping("/pages")
    public ResponseEntity<List<BookDTO>> findBooksByPageRange(
            @RequestParam Integer min,
            @RequestParam Integer max
    ) {
        List<BookDTO> books = bookService.findBetween(min, max);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }



}
