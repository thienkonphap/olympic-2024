package dauphine.miageif.site.repository;


import dauphine.miageif.site.model.Planning;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanningRepository extends MongoRepository<Planning, Long> {
    void deleteById(String id);

    Optional<Planning> findById(String id);
}