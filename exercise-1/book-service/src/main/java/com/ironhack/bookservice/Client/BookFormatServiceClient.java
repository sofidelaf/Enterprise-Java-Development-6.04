package com.ironhack.bookservice.Client;

import com.ironhack.bookservice.Model.BookFormat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient("book-format-service")
public interface BookFormatServiceClient {

    @GetMapping("/book-formats/{ISBN}")
    String getBookFormat(@PathVariable(name = "ISBN") long ISBN);

    @PostMapping("/book-formats")
    BookFormat postBookFormat(@RequestBody @Valid BookFormat bookFormat);

}
