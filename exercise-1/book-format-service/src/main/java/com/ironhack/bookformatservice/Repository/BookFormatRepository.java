package com.ironhack.bookformatservice.Repository;

import com.ironhack.bookformatservice.Classes.BookFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFormatRepository extends JpaRepository<BookFormat, Long> {

}
