package com.example.librarydb.Service;

import com.example.librarydb.Domain.Books;
import com.example.librarydb.Dto.BookDTO;
import com.example.librarydb.Dto.BookDTOMapper;
import com.example.librarydb.Exception.BookNotFoundException;
import com.example.librarydb.Repo.BookRepo;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class BookService {
    private final BookRepo bookRepo;

    private final BookDTOMapper bookDTOMapper;

    public BookService(BookRepo bookRepo, BookDTOMapper bookDTOMapper) {
        this.bookRepo = bookRepo;
        this.bookDTOMapper = bookDTOMapper;
    }


    public List<BookDTO>findAllBooks(){
        return bookRepo.findAll().stream()
                .map(bookDTOMapper)
                .collect(Collectors.toList());
   }
   public BookDTO findBookById(Long id){
       Books book = bookRepo.findById(id)
               .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
       return bookDTOMapper.apply(book);
   }
   public BookDTO addBook(Books book){
        Books savebooks = bookRepo.save(book);
        return bookDTOMapper.apply(savebooks);
   }
   public BookDTO updateBook(Books book){
        Books updatedBook = bookRepo.save(book);
        return bookDTOMapper.apply(updatedBook);
   }
   public void deleteBookById(Long id){
        if(!bookRepo.existsById(id)){
            throw new BookNotFoundException("Book not found with id: " + id);
        }

            bookRepo.deleteById(id);
   }
   public BookDTO findBookByIsbn(String isbn){
        Books findbook = bookRepo.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException("Book by Isbn " + isbn + " not found"));
        return bookDTOMapper.apply(findbook);
   }
   public List<BookDTO> findBookByTitle(String title){
        return bookRepo.findByTitle(title).stream()
                .map(bookDTOMapper)
                .collect(Collectors.toList());
   }
   public List<BookDTO> findBookByAuthor(String author){
        return bookRepo.findByAuthor(author).stream()
                .map(bookDTOMapper).collect(Collectors.toList());
   }
   public List<BookDTO> findBookByAuthorAndTitle(String author, String title){
        return bookRepo.findByAuthorAndTitle(author,title).stream()
                .map(bookDTOMapper).collect(Collectors.toList());
   }
   public List<BookDTO> findShortBooks(Integer MaxPages){
        return bookRepo.findByPagesLessThan(MaxPages).stream()
                .map(bookDTOMapper).collect(Collectors.toList());
   }
   public List<BookDTO> findLongBooks(Integer MaxPages){
        return bookRepo.findByPagesGreaterThan(MaxPages).stream()
                .map(bookDTOMapper).collect(Collectors.toList());
   }
   public List<BookDTO> findBetween(Integer min, Integer max){
        return bookRepo.findByPagesBetween(min, max).stream()
                .map(bookDTOMapper).collect(Collectors.toList());
   }
}
