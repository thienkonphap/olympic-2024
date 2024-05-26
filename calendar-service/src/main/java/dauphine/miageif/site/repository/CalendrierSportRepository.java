package dauphine.miageif.site.repository;


import dauphine.miageif.site.model.CalendrierSport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendrierSportRepository extends MongoRepository<CalendrierSport, Long> {
}
