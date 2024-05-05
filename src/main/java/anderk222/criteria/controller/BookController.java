package anderk222.criteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import anderk222.criteria.domain.Book;
import anderk222.criteria.domain.BookDTO;
import anderk222.criteria.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/book")
public class BookController {
    
    @Autowired
    BookService service;

    @PostMapping()
    public Book save(@RequestBody Book book) {
        
        return this.service.save(book);
    }

    @PostMapping("search")
    public List<Book> search(@RequestBody BookDTO book) {
        
        return this.service.search(book);
    }

}
