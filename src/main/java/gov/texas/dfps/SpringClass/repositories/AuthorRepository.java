package gov.texas.dfps.SpringClass.repositories;

import gov.texas.dfps.SpringClass.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
