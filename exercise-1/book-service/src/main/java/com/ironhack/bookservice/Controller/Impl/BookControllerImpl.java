package com.ironhack.bookservice.Controller.Impl;

import com.ironhack.bookservice.Client.BookFormatServiceClient;
import com.ironhack.bookservice.Model.Book;
import com.ironhack.bookservice.Controller.DTO.BookDTO;
import com.ironhack.bookservice.Controller.Interfaces.BookController;
import com.ironhack.bookservice.Repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class BookControllerImpl implements BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookFormatServiceClient bookFormatServiceClient;
    private final Logger logger = LoggerFactory.getLogger(BookControllerImpl.class);

    @GetMapping("/books/{ISBN}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO getBookInformation(@PathVariable(name = "ISBN") long ISBN) {

        Optional<Book> bookOptional = bookRepository.findById(ISBN);
        if(!bookOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        String bookFormat = bookFormatServiceClient.getBookFormat(ISBN);
        BookDTO bookDTO = new BookDTO(ISBN, bookOptional.get().getTitle(), bookOptional.get().getAuthor(),
                bookOptional.get().getGenre(), bookFormat);

        return bookDTO;
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBookFormat(@RequestBody @Valid Book book) {
        return bookRepository.save(book);
    }
}