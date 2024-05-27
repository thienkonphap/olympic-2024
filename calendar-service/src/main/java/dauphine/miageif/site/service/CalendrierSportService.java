package dauphine.miageif.site.service;

import dauphine.miageif.site.model.CalendrierSport;
import dauphine.miageif.site.repository.CalendrierSportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

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

    public void deleteCalendrierSport(String id) {
        calendrierSportRepository.deleteById(id);
    }
    public List<CalendrierSport> getCalendrierSportsByDate(String date) {
        return calendrierSportRepository.findByDate(date);
    }
    public Optional<CalendrierSport> getCalendrierSportById(String id) {
        return calendrierSportRepository.findById(id);
    }
}
