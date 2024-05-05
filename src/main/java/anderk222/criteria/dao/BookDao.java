package anderk222.criteria.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import anderk222.criteria.domain.Book;
import anderk222.criteria.domain.BookDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class BookDao implements IBookDao {


    EntityManager em;

    public BookDao(EntityManager _em){

        this.em= _em;
    }

    @Override
    public List<Book> search(BookDTO book) {

    CriteriaBuilder cb = em.getCriteriaBuilder();
    
    CriteriaQuery<Book> cq = cb.createQuery(Book.class);

    Root<Book> root = cq.from(Book.class);
    
    List<Predicate> predicates = new ArrayList<>();
    
    if ( book.getId() != null) {
        predicates.add(cb.equal(root.get("id"), book.getId()));
    }

    if ( book.getName() != null) {
        predicates.add(cb.like(root.get("name"), '%'+book.getName()+'%'));
    }

    if ( book.getYear() != null) {
        predicates.add(cb.lessThanOrEqualTo(root.get("year"), book.getYear()));
    }


    if ( book.getPrice() != null) {
        predicates.add(cb.le(root.get("price"), book.getPrice()));
    }

    cq.where(predicates.toArray(new Predicate[0]));

    return em.createQuery(cq).getResultList();

        
    }
    
}
