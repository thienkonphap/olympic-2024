package dauphine.miageif.site.service;

import dauphine.miageif.site.model.CalendrierSport;
import dauphine.miageif.site.repository.CalendrierSportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendrierSportService {

    @Autowired
    private CalendrierSportRepository calendrierSportRepository;

    public CalendrierSport createCalendrierSport(CalendrierSport calendrierSport) {
        return calendrierSportRepository.save(calendrierSport);
    }

    public List<CalendrierSport> getAllCalendrierSports() {
        return calendrierSportRepository.findAll();
    }

    public CalendrierSport updateCalendrierSport(String id, CalendrierSport calendrierSport) {
        calendrierSport.setId(id);
        return calendrierSportRepository.save(calendrierSport);
    }

    public void deleteCalendrierSport(Long id) {
        calendrierSportRepository.deleteById(id);
    }
}
