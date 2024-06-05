package dauphine.miageif.site.controller;

import dauphine.miageif.site.model.Activite;
import dauphine.miageif.site.model.Planning;
import dauphine.miageif.site.service.PlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planning")
public class PlanningController {

    @Autowired
    private PlanningService planningService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public Planning createplanning(@RequestBody Planning planning) {
        return planningService.createPlanning(planning);
    }

    @GetMapping
    public List<Planning> getallplannings() {
        return planningService.getAllPlannings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planning> getPlanningById(@PathVariable String id) {
        Optional<Planning> planning = planningService.getPlanningById(id);
        return planning.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Planning updateplanning(@PathVariable String id, @RequestBody Planning planning) {
        return planningService.updatePlanning(id, planning);
    }

    @DeleteMapping("/{id}")
    public void deletePlanning(@PathVariable String id) {
        planningService.deletePlanning(id);
    }

    @PostMapping("{planningID}/addActivity/{activityID}")
    public ResponseEntity<?> addActivity(@PathVariable String planningID, @PathVariable String activityID) {

        try {
            String url = "http://localhost:8080/calendrier-sports/" + activityID;
            Activite activityFound = restTemplate.getForObject(url, Activite.class);

            if (activityFound == null) {
                return ResponseEntity.badRequest().body("Activity not found");
            }
            System.out.println(activityFound.getDate());
            System.out.println(activityFound.getSport());
            System.out.println(activityFound.getId());
            Optional<Planning> foundPlanning = planningService.findById(planningID);
            if (!foundPlanning.isPresent()) {
                return ResponseEntity.badRequest().body("Planning not found");
            }

            Planning planning = foundPlanning.get();
            if (planning.getActivites() == null) {
                planning.setActivites(new ArrayList<Activite>());
            }
            planning.getActivites().add(activityFound);
            planningService.save(planning); // Assuming you have a save method in your service

            return ResponseEntity.ok("Activity added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
    @GetMapping("/filter")
    public ResponseEntity<List<Planning>> getPlanningsByType(@RequestParam String type) {
        List<Planning> plannings = planningService.getPlanningsByType(type);
        return ResponseEntity.ok(plannings);
    }


}

