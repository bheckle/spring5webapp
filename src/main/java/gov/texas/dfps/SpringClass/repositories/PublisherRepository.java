package gov.texas.dfps.SpringClass.repositories;

import gov.texas.dfps.SpringClass.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
