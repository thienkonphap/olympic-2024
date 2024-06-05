package dauphine.miageif.site.repository;
import dauphine.miageif.site.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
    public List<Site> findAll();
    public List<Site> findByName(String name);
    @Query("SELECT s FROM Site s JOIN s.sports sp WHERE sp.name = :sportName")
    List<Site> findBySportName(@Param("sportName") String sportName);
}
