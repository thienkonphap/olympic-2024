package dauphine.miageif.site.service;

import dauphine.miageif.site.entity.Sport;
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

class SportServiceTest {

    @Mock
    private SportRepository sportRepository;

    @InjectMocks
    private SportService sportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllSports() {
        Sport sport1 = new Sport(1L, "Basketball", new String[]{"olympic"}, null);
        Sport sport2 = new Sport(2L, "Swimming", new String[]{"olympic"}, null);

        when(sportRepository.findAll()).thenReturn(Arrays.asList(sport1, sport2));

        List<Sport> sports = sportService.getAllSports();
        assertEquals(2, sports.size());
        assertEquals("Basketball", sports.get(0).getName());
        assertEquals("Swimming", sports.get(1).getName());
    }

    @Test
    void testSaveSport() {
        Sport sport = new Sport(1L, "Basketball", new String[]{"olympic"}, null);

        when(sportRepository.save(sport)).thenReturn(sport);

        Sport savedSport = sportService.save(sport);
        assertEquals("Basketball", savedSport.getName());
    }

    @Test
    void testDeleteSport() {
        Sport sport = new Sport(1L, "Basketball", new String[]{"olympic"}, null);

        when(sportRepository.findById(1L)).thenReturn(Optional.of(sport));
        doNothing().when(sportRepository).delete(sport);

        sportService.deleteSport(1L);
        verify(sportRepository, times(1)).delete(sport);
    }

    @Test
    void testUpdateSport() {
        Sport existingSport = new Sport(1L, "Basketball", new String[]{"olympic"}, null);
        Sport updatedDetails = new Sport(1L, "Basketball Updated", new String[]{"olympic"}, null);

        when(sportRepository.findById(1L)).thenReturn(Optional.of(existingSport));
        when(sportRepository.save(existingSport)).thenReturn(existingSport);

        Sport updatedSport = sportService.updateSport(1L, updatedDetails);

        assertEquals("Basketball Updated", updatedSport.getName());
    }
}
