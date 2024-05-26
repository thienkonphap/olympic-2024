package dauphine.miageif.site.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Activite {

    @Id
    private Long id;
    private String sport;
    private String date;
    private String site;

    // Getters and Setters
}
