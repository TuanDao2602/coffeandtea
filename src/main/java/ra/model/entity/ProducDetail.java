package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "ProductDetail")
@Entity
@Data
public class ProducDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductDetailId")
    private int producDetailId;
    @Column(name = "PriceDetail")
    private int priceDetail;
    @Column(name = "title")
    private String titleDetail;
    @Column(name = "StatusDetail")
    private boolean statusDetail=true;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "sizeID",referencedColumnName = "sizeID")
    private Size size;
     @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "toppingId",referencedColumnName = "toppingId")
    private Topping topping;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "coffeId",referencedColumnName = "coffeId")
    private CoffeAndTea coffeAndTea;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "cartId", referencedColumnName = "cartId")
//    @JsonIgnore
//    private Cart cart;

}
