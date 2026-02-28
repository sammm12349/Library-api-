package com.example.librarydb.Repo;

import com.example.librarydb.Domain.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepo extends JpaRepository<Books,Long> {
    Optional<Books> findByIsbn(String isbn);
    void deleteById(long id);
    List<Books> findByAuthor(String author);
    List<Books> findByTitle(String title);
    List<Books> findByAuthorAndTitle(String author, String title);
    List<Books> findByPagesLessThan(Integer pages);
    List<Books> findByPagesGreaterThan(Integer pages);
    List<Books> findByPagesBetween(Integer min, Integer max);


}
