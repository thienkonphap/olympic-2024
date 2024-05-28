package dauphine.miageif.site.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import javax.persistence.*;

@Document(collection = "planningActivite")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Planning {

    @Id

    private String id;
    private String nom;
    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Activite> activites;

}
