package dauphine.miageif.site.controller;

import dauphine.miageif.site.entity.Sport;
import dauphine.miageif.site.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sports")
public class SportController {
    @Autowired
    private SportService sportService;

    @GetMapping
    public List<Sport> getAllSports() {
        return sportService.getAllSports();
    }
    @PostMapping
    public Sport createSport(@RequestBody Sport sport) {
        System.out.println(sport.getName());
        return sportService.save(sport);
    }
    @PutMapping("/{id}")
    public Sport updateSport(@PathVariable Long id, @RequestBody Sport sportDetails) {
        return sportService.updateSport(id, sportDetails);
    }
    @DeleteMapping("/{id}")
    public void deleteSport(@PathVariable Long id) {
        sportService.deleteSport(id);
    }
}
