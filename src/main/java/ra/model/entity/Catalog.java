package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Catalog")
@Entity
@Data
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CatalogId")
    private int catalogId;
    @Column(name = "CatalogName")
    private String catalogName;
    @Column(name = "CatalogStatus")
    private boolean catalogStatus=true;

    @OneToMany(mappedBy = "catalog")
    @JsonIgnore
    private List<CoffeAndTea> listCoffeAndTea =new ArrayList<>();


}
