package dauphine.miageif.site.controller;

import dauphine.miageif.site.entity.Site;
import dauphine.miageif.site.entity.Sport;
import dauphine.miageif.site.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sites")
public class SiteController {
    @Autowired
    private SiteService siteService;

    @GetMapping
    public List<Site> getAllSites() {
        return siteService.getAllSites();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Site> getSiteById(@PathVariable Long id) {
        Optional<Site> site = siteService.getSiteById(id);
        return site.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Site createSite(@RequestBody Site site) {
        return siteService.save(site);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Site> updateSite(@PathVariable Long id, @RequestBody Site siteDetails) {
        Site updatedSite = siteService.updateSite(id, siteDetails);
        return ResponseEntity.ok(updatedSite);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSite(@PathVariable Long id) {
        siteService.deleteSite(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{siteId}/sports/{sportId}")
    public ResponseEntity<Site> addSportToSite(@PathVariable Long siteId, @PathVariable Long sportId) {
        Site site = siteService.addSportToSite(siteId, sportId);
        return site != null ? ResponseEntity.ok(site) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{siteId}/sports/{sportId}")
    public ResponseEntity<Site> removeSportFromSite(@PathVariable Long siteId, @PathVariable Long sportId) {
        Site site = siteService.removeSportFromSite(siteId, sportId);
        return site != null ? ResponseEntity.ok(site) : ResponseEntity.notFound().build();
    }
}
