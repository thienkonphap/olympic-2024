package dauphine.miageif.site.repository;


import dauphine.miageif.site.model.CalendrierSport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CalendrierSportRepository extends MongoRepository<CalendrierSport, Long> {
    void deleteById(String id);
    List<CalendrierSport> findByDate(String date);

    Optional<CalendrierSport> findById(String id);

    List<CalendrierSport> findBySite(String site);
}