package com.mafr.redisbook.controller;

import com.mafr.redisbook.dto.BaseResponse;
import com.mafr.redisbook.dto.BookRequest;
import com.mafr.redisbook.model.Book;
import com.mafr.redisbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public BaseResponse<List<Book>> getAll() {
        List<Book> books = new ArrayList<>();

        bookRepository.findAll().forEach(books::add);

        BaseResponse<List<Book>> response = new BaseResponse<>(
                "Success",
                "All Book",
                books
        );

        return response;
    }

    @PostMapping("/{id}")
    public BaseResponse<Book> getByID(@PathVariable String id) {
        Optional<Book> books = bookRepository.findById(id);

        if (books.isEmpty()) {
            return new BaseResponse<>(
                    "Failed",
                    "Book not found...",
                    null
            );
        }

        return new BaseResponse<>(
                "Success",
                "Book found...",
                books.get()
        );
    }

    @PostMapping
    public BaseResponse<Book> create(@RequestBody BookRequest request) {
        UUID uuid = UUID.randomUUID();

        Book book = new Book(uuid.toString(), request.getJudul(), request.getIsbn(), request.getPenulis(), request.getDeskripsi(), request.getKategori());

        Book createdBook = bookRepository.save(book);

        BaseResponse<Book> response = new BaseResponse<>(
                "Success",
                "Create book",
                createdBook
        );

        return response;
    }

    @PutMapping("/{id}")
    public BaseResponse<Book> updateByID(@PathVariable String id, @RequestBody BookRequest request) {
        Optional<Book> books = bookRepository.findById(id);

        if (books.isEmpty()) {
            return new BaseResponse<>(
                    "Failed",
                    "Book not found...",
                    null
            );
        }

        Book book = new Book(books.get().getId(), request.getJudul(), request.getIsbn(), request.getPenulis(), request.getDeskripsi(), request.getKategori());
        Book createdBook = bookRepository.save(book);

        return new BaseResponse<>(
                "Success",
                "Update Book",
                createdBook
        );
    }

    @DeleteMapping("/{id}")
    public BaseResponse<Book> deleteByID(@PathVariable String id) {
        Optional<Book> books = bookRepository.findById(id);

        if (books.isEmpty()) {
            return new BaseResponse<>(
                    "Failed",
                    "Book not found...",
                    null
            );
        }

        bookRepository.deleteById(books.get().getId());

        return new BaseResponse<>(
                "Success",
                "Delete Book",
                books.get()
        );
    }
}
