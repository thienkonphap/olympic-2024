package dauphine.miageif.site.repository;


import com.dauphine.miageif.site.model.CalendrierSport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendrierSportRepository extends JpaRepository<CalendrierSport, Long> {
}
