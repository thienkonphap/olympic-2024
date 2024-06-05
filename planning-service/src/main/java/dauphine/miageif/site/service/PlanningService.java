package dauphine.miageif.site.service;


import dauphine.miageif.site.model.Planning;
import dauphine.miageif.site.repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Planning updatePlanning(String id, Planning planning) {
        planning.setId(id);
        return planningRepository.save(planning);
    }

    public void deletePlanning(String id) {
        planningRepository.deleteById(id);
    }

    public Optional<Planning> findById(String id){return planningRepository.findById(id);}

    public void save(Planning planning) {
        planningRepository.save(planning);
    }

    public Optional<Planning> getPlanningById(String id) {
        return planningRepository.findById(id);
    }
}
