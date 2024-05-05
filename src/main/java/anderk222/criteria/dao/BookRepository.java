package anderk222.criteria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import anderk222.criteria.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
