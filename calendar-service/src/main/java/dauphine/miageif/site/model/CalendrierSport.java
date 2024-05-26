package dauphine.miageif.site.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "calendrierSport")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CalendrierSport {

    @Id
    private String id;
    private String sport;
    private String date;
    private String site;

}
