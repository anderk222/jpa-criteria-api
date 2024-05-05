package anderk222.criteria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import anderk222.criteria.dao.BookDao;
import anderk222.criteria.dao.BookRepository;
import anderk222.criteria.domain.Book;
import anderk222.criteria.domain.BookDTO;

@Service
public class BookService {
    
    private BookRepository repository;

    private BookDao criteria;

    public BookService(BookRepository _Repository, BookDao _criteria){

        this.repository = _Repository;
        this.criteria=_criteria;

    }

    public List<Book> search(BookDTO book){

        return this.criteria.search(book);

    }

    public Book save(Book book){

        return this.repository.save(book);

    }

}
