package com.ironhack.bookformatservice.Controller.Interfaces;

import com.ironhack.bookformatservice.Classes.BookFormat;

public interface BookFormatController {
    String getBookFormat(long ISBN);
    BookFormat postBookFormat(BookFormat bookFormat);
}
