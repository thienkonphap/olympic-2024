package dauphine.miageif.site.service;

import dauphine.miageif.site.entity.Site;
import dauphine.miageif.site.entity.Sport;
import dauphine.miageif.site.repository.SiteRepository;
import dauphine.miageif.site.repository.SportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SiteServiceTest {

    @Mock
    private SiteRepository siteRepository;

    @Mock
    private SportRepository sportRepository;

    @InjectMocks
    private SiteService siteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllSites() {
        Site site1 = new Site(1L, "Stade de France", "Paris", 2.3601, 48.9244, null);
        Site site2 = new Site(2L, "Aquatics Center", "Paris", 2.3414, 48.8357, null);

        when(siteRepository.findAll()).thenReturn(Arrays.asList(site1, site2));

        List<Site> sites = siteService.getAllSites();
        assertEquals(2, sites.size());
        assertEquals("Stade de France", sites.get(0).getName());
        assertEquals("Aquatics Center", sites.get(1).getName());
    }

    @Test
    void testGetSiteById() {
        Site site = new Site(1L, "Stade de France", "Paris", 2.3601, 48.9244, null);

        when(siteRepository.findById(1L)).thenReturn(Optional.of(site));

        Optional<Site> foundSite = siteService.getSiteById(1L);
        assertTrue(foundSite.isPresent());
        assertEquals("Stade de France", foundSite.get().getName());
    }

    @Test
    void testUpdateSite() {
        Site site = new Site(1L, "Stade de France", "Paris", 2.3601, 48.9244, null);
        Site updatedDetails = new Site(null, "Stade de France Updated", "Paris Updated", 0, 0, null);

        when(siteRepository.findById(1L)).thenReturn(Optional.of(site));
        when(siteRepository.save(any(Site.class))).thenReturn(site);

        Site updatedSite = siteService.updateSite(1L, updatedDetails);

        assertEquals("Stade de France Updated", updatedSite.getName());
        assertEquals("Paris Updated", updatedSite.getLocation());
    }

    @Test
    void testDeleteSite() {
        Site site = new Site(1L, "Stade de France", "Paris", 2.3601, 48.9244, null);

        when(siteRepository.findById(1L)).thenReturn(Optional.of(site));
        doNothing().when(siteRepository).delete(site);

        siteService.deleteSite(1L);
        verify(siteRepository, times(1)).delete(site);
    }

    @Test
    void testSaveSite() {
        Site site = new Site(1L, "Stade de France", "Paris", 2.3601, 48.9244, null);

        when(siteRepository.save(site)).thenReturn(site);

        Site savedSite = siteService.save(site);
        assertEquals("Stade de France", savedSite.getName());
    }

    @Test
    void testGetSitesByName() {
        Site site = new Site(1L, "Stade de France", "Paris", 2.3601, 48.9244, null);

        when(siteRepository.findByName("Stade de France")).thenReturn(Arrays.asList(site));

        List<Site> sites = siteService.getSitesByName("Stade de France");
        assertEquals(1, sites.size());
        assertEquals("Stade de France", sites.get(0).getName());
    }

    @Test
    void testGetSportsBySiteId() {
        Sport sport = new Sport(1L, "Basketball", new String[]{"olympic"}, null);
        Site site = new Site(1L, "Stade de France", "Paris", 2.3601, 48.9244, Arrays.asList(sport));

        when(siteRepository.findById(1L)).thenReturn(Optional.of(site));

        List<Sport> sports = siteService.getSportsBySiteId(1L);
        assertEquals(1, sports.size());
        assertEquals("Basketball", sports.get(0).getName());
    }
}
