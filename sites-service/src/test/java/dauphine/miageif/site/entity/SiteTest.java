package dauphine.miageif.site.entity;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class SiteTest {

    @Test
    void testGettersAndSetters() {
        // Create Sport objects
        Sport sport1 = new Sport();
        sport1.setSportId(1L);
        sport1.setName("Basketball");
        sport1.setType(new String[]{"olympic"});

        Sport sport2 = new Sport();
        sport2.setSportId(2L);
        sport2.setName("Swimming");
        sport2.setType(new String[]{"olympic"});

        // Create Site object
        Site site = new Site();
        site.setSiteId(1L);
        site.setName("Stade de France");
        site.setLocation("Paris");
        site.setLongitude(2.3601);
        site.setLatitude(48.9244);
        site.setSports(Arrays.asList(sport1, sport2));

        // Test getters
        assertEquals(1L, site.getSiteId());
        assertEquals("Stade de France", site.getName());
        assertEquals("Paris", site.getLocation());
        assertEquals(2.3601, site.getLongitude());
        assertEquals(48.9244, site.getLatitude());
        assertEquals(2, site.getSports().size());
        assertEquals("Basketball", site.getSports().get(0).getName());
        assertEquals("Swimming", site.getSports().get(1).getName());
    }

    @Test
    void testNoArgsConstructor() {
        // Test no-args constructor
        Site site = new Site();
        assertNotNull(site);
    }

    @Test
    void testAllArgsConstructor() {
        // Create Sport objects
        Sport sport1 = new Sport(1L, "Basketball", new String[]{"olympic"}, null);
        Sport sport2 = new Sport(2L, "Swimming", new String[]{"olympic"}, null);

        // Create Site object using all-args constructor
        Site site = new Site(1L, "Stade de France", "Paris", 2.3601, 48.9244, Arrays.asList(sport1, sport2));

        // Test getters
        assertEquals(1L, site.getSiteId());
        assertEquals("Stade de France", site.getName());
        assertEquals("Paris", site.getLocation());
        assertEquals(2.3601, site.getLongitude());
        assertEquals(48.9244, site.getLatitude());
        assertEquals(2, site.getSports().size());
        assertEquals("Basketball", site.getSports().get(0).getName());
        assertEquals("Swimming", site.getSports().get(1).getName());
    }
}
