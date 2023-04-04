package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CoffeAndTea")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoffeAndTea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CoffeId")
    private int coffeId;
    @Column(name = "CoffeName",columnDefinition = "nvarchar(50)")
    private String coffeName;
    @Column(name = "Price")
    private int price;
    @Column(name = "Image")
    private String image;
    @Column(name = "Status")
    private boolean status=true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "catalogId")
    private Catalog catalog;

    @OneToMany(mappedBy = "coffeAndTea",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProducDetail> listProductDetail =new ArrayList<>();
//
//    @ManyToMany(fetch = FetchType.LAZY)
//
//    @JoinTable(name ="CoffeTopping",joinColumns =@JoinColumn(name = "CoffeId"),inverseJoinColumns =@JoinColumn(name = "ToppingId") )
//    @JsonIgnore
//    private List<Topping> listTopping =new ArrayList<>();
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name ="CoffeSize",joinColumns =@JoinColumn(name = "CoffeId"),inverseJoinColumns =@JoinColumn(name = "sizeID") )
//
//    private List<Size> listSize =new ArrayList<>();


}
