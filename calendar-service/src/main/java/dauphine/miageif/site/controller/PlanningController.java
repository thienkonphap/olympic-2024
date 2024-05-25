package dauphine.miageif.site.controller;

import dauphine.miageif.site.model.Planning;
import dauphine.miageif.site.service.PlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planning")
public class PlanningController {

    @Autowired
    private PlanningService planningService;

    @PostMapping
    public Planning createPlanning(@RequestBody Planning planning) {
        return planningService.createPlanning(planning);
    }

    @GetMapping
    public List<Planning> getAllPlannings() {
        return planningService.getAllPlannings();
    }

    @PutMapping("/{id}")
    public Planning updatePlanning(@PathVariable Long id, @RequestBody Planning planning) {
        return planningService.updatePlanning(id, planning);
    }

    @DeleteMapping("/{id}")
    public void deletePlanning(@PathVariable Long id) {
        planningService.deletePlanning(id);
    }
}
