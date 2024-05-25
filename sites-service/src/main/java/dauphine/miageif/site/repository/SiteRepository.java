package dauphine.miageif.site.repository;
import dauphine.miageif.site.entity.Site;
import dauphine.miageif.site.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
    public List<Site> findAll();
    public List<Site> findByName(String name);
}
