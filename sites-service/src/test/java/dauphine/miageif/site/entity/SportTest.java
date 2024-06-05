package dauphine.miageif.site.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class SportTest {

    @Test
    void testGettersAndSetters() {
        // Create Site objects
        Site site1 = new Site();
        site1.setSiteId(1L);
        site1.setName("Stade de France");
        site1.setLocation("Paris");
        site1.setLongitude(2.3601);
        site1.setLatitude(48.9244);

        Site site2 = new Site();
        site2.setSiteId(2L);
        site2.setName("Aquatics Center");
        site2.setLocation("Paris");
        site2.setLongitude(2.3414);
        site2.setLatitude(48.8357);

        // Create Sport object
        Sport sport = new Sport();
        sport.setSportId(1L);
        sport.setName("Basketball");
        sport.setType(new String[]{"olympic"});
        sport.setSites(Arrays.asList(site1, site2));

        // Test getters
        assertEquals(1L, sport.getSportId());
        assertEquals("Basketball", sport.getName());
        assertArrayEquals(new String[]{"olympic"}, sport.getType());
        assertEquals(2, sport.getSites().size());
        assertEquals("Stade de France", sport.getSites().get(0).getName());
        assertEquals("Aquatics Center", sport.getSites().get(1).getName());
    }

    @Test
    void testNoArgsConstructor() {
        // Test no-args constructor
        Sport sport = new Sport();
        assertNotNull(sport);
    }

    @Test
    void testAllArgsConstructor() {
        // Create Site objects
        Site site1 = new Site(1L, "Stade de France", "Paris", 2.3601, 48.9244, null);
        Site site2 = new Site(2L, "Aquatics Center", "Paris", 2.3414, 48.8357, null);

        // Create Sport object using all-args constructor
        Sport sport = new Sport(1L, "Basketball", new String[]{"olympic"}, Arrays.asList(site1, site2));

        // Test getters
        assertEquals(1L, sport.getSportId());
        assertEquals("Basketball", sport.getName());
        assertArrayEquals(new String[]{"olympic"}, sport.getType());
        assertEquals(2, sport.getSites().size());
        assertEquals("Stade de France", sport.getSites().get(0).getName());
        assertEquals("Aquatics Center", sport.getSites().get(1).getName());
    }
}
