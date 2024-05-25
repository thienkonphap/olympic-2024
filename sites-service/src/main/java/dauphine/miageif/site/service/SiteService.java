package dauphine.miageif.site.service;

import dauphine.miageif.site.entity.Site;
import dauphine.miageif.site.entity.Sport;
import dauphine.miageif.site.repository.SiteRepository;
import dauphine.miageif.site.repository.SportRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SiteService {
    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private SportRepository sportRepository;
    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    public Optional<Site> getSiteById(Long siteId) {
        return siteRepository.findById(siteId);
    }
    public Site updateSite(Long siteId, Site siteDetails) {
        Site site = siteRepository.findById(siteId)
                .orElseThrow(() -> new RuntimeException("Site not found with id " + siteId));
        site.setName(siteDetails.getName());
        site.setLocation(siteDetails.getLocation());
        return siteRepository.save(site);
    }
    public void deleteSite(Long siteId) {
        Site site = siteRepository.findById(siteId)
                .orElseThrow(() -> new RuntimeException("Site not found with id " + siteId));
        siteRepository.delete(site);
    }

    public Site save(Site site) {
        return siteRepository.save(site);
    }
    public List<Site> getSitesByName(String name) {
        return siteRepository.findByName(name);
    }
    public List<Sport> getSportsBySiteId(Long siteId) {
        Site site = siteRepository.findById(siteId).orElse(null);
        return site != null ? site.getSports() : null;
    }
    public Site addSportToSite(Long siteId, Long sportId) {
        Site site = siteRepository.findById(siteId).orElse(null);
        Sport sport = sportRepository.findById(sportId).orElse(null);
        if (site != null && sport != null) {
            site.getSports().add(sport);
            return siteRepository.save(site);
        }
        return null;
    }
    public Site removeSportFromSite(Long siteId, Long sportId) {
        Site site = siteRepository.findById(siteId).orElse(null);
        Sport sport = sportRepository.findById(sportId).orElse(null);
        if (site != null && sport != null) {
            site.getSports().remove(sport);
            return siteRepository.save(site);
        }
        return null;
    }
}
