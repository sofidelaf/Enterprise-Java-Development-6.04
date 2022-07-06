package com.ironhack.bookservice.Controller.Interfaces;

import com.ironhack.bookservice.Model.Book;
import com.ironhack.bookservice.Controller.DTO.BookDTO;

public interface BookController {
    BookDTO getBookInformation(long ISBN);
    Book postBookFormat(Book book);
}