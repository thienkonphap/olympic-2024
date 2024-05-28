package dauphine.miageif.site.model;


import lombok.*;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Activite {

    @Id
    private String id;
    private String sport;
    private String date;
    private String site;

    // Getters and Setters
}
