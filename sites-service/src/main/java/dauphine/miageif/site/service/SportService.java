package dauphine.miageif.site.service;

import dauphine.miageif.site.entity.Sport;
import dauphine.miageif.site.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService {
    @Autowired
    private SportRepository sportRepository;

    public List<Sport> getAllSports() {
        return sportRepository.findAll();
    }
    public Sport save(Sport sport) {
        return sportRepository.save(sport);
    }
    public void deleteSport(Long sportId) {
        Sport sport = sportRepository.findById(sportId)
                .orElseThrow(() -> new RuntimeException("Sport not found with id " + sportId));
        sportRepository.delete(sport);
    }
    public Sport updateSport(Long sportId, Sport sportDetails) {
        Sport sport = sportRepository.findById(sportId)
                .orElseThrow(() -> new RuntimeException("Sport not found with id " + sportId));
        sport.setName(sportDetails.getName());
        return sportRepository.save(sport);
    }
}
