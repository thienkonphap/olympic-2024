package dauphine.miageif.site.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "sports")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sportId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar[]")
    private String[] type;

    @ManyToMany(mappedBy = "sports")
    @JsonBackReference
    private List<Site> sites;
}
