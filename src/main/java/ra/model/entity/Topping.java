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

@Table(name = "Topping")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ToppingId")
    private int toppingId;
    @Column(name = "ToppingName")
    private String toppingName;
    @Column(name = "Price")
    private int price;
    @Column(name = "ToppingStatus")
    private boolean status=true;
    @OneToMany(mappedBy = "topping",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProducDetail> listProductDetail =new ArrayList<>();

}