package gov.texas.dfps.SpringClass.repositories;

import gov.texas.dfps.SpringClass.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
