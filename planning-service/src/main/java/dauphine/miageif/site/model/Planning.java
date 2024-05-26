package dauphine.miageif.site.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Planning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String type;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Activite> activites;

    // Getters and Setters
}
