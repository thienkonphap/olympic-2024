package dauphine.miageif.site.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "sites")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long siteId;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(name = "longitude")
    private double longitude;
    @Column(name = "latitude")
    private double latitude;

    @ManyToMany
    @JoinTable(
            name = "hosted_sports",
            joinColumns = @JoinColumn(name = "site_id"),
            inverseJoinColumns = @JoinColumn(name = "sport_id")
    )
    private List<Sport> sports;

}
