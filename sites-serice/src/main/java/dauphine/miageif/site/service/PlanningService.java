package dauphine.miageif.site.service;

import dauphine.miageif.site.model.Planning;
import dauphine.miageif.site.repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanningService {

    @Autowired
    private PlanningRepository planningRepository;

    public Planning createPlanning(Planning planning) {
        return planningRepository.save(planning);
    }

    public List<Planning> getAllPlannings() {
        return planningRepository.findAll();
    }

    public Planning updatePlanning(Long id, Planning planning) {
        planning.setId(id);
        return planningRepository.save(planning);
    }

    public void deletePlanning(Long id) {
        planningRepository.deleteById(id);
    }
}
