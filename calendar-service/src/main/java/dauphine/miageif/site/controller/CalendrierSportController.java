package dauphine.miageif.site.controller;

import dauphine.miageif.site.model.CalendrierSport;
import dauphine.miageif.site.service.CalendrierSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/calendrier-sports")
@CrossOrigin(origins = "http://localhost:3000")
public class CalendrierSportController {

    @Autowired
    private CalendrierSportService calendrierSportService;

    @PostMapping
    public CalendrierSport createCalendrierSport(@RequestBody CalendrierSport calendrierSport) {
        return calendrierSportService.createCalendrierSport(calendrierSport);
    }

    @GetMapping
    public List<CalendrierSport> getAllCalendrierSports() {
        return calendrierSportService.getAllCalendrierSports();
    }

    @PutMapping("/{id}")
    public CalendrierSport updateCalendrierSport(@PathVariable String id, @RequestBody CalendrierSport calendrierSport) {
        return calendrierSportService.updateCalendrierSport(id, calendrierSport);
    }

    @DeleteMapping("/{id}")
    public void deleteCalendrierSport(@PathVariable String id) {
        calendrierSportService.deleteCalendrierSport(id);
    }
    @GetMapping("/filter")
    public List<CalendrierSport> getCalendrierSportsByDate(@RequestParam String date) {
        return calendrierSportService.getCalendrierSportsByDate(date);
    }

    @GetMapping("/filterSite")
    public List<CalendrierSport> getCalendrierSportsBySite(@RequestBody String site) {
        System.out.println(site);
        return calendrierSportService.getCalendrierSportsBySite(site);
    }

    @GetMapping("/{id}")
    public Optional<CalendrierSport> getCalendrierSportById(@PathVariable String id) {
        return calendrierSportService.getCalendrierSportById(id);
    }
}
