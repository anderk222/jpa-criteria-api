package anderk222.criteria.dao;

import java.util.List;

import anderk222.criteria.domain.Book;
import anderk222.criteria.domain.BookDTO;

public interface IBookDao {
 
    List<Book> search(BookDTO book);


}