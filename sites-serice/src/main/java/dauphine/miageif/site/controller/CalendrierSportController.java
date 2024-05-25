package dauphine.miageif.site.controller;

import dauphine.miageif.site.model.CalendrierSport;
import dauphine.miageif.site.service.CalendrierSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendrier-sports")
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
    public CalendrierSport updateCalendrierSport(@PathVariable Long id, @RequestBody CalendrierSport calendrierSport) {
        return calendrierSportService.updateCalendrierSport(id, calendrierSport);
    }

    @DeleteMapping("/{id}")
    public void deleteCalendrierSport(@PathVariable Long id) {
        calendrierSportService.deleteCalendrierSport(id);
    }
}
