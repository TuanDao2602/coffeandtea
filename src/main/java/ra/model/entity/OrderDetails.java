package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OrderDetail")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  ="orderDetailID")
    private int orderDetailID;
    @Column(name = "orderDetailQuantity")
    private int quantity;
    @Column(name = "orderDetaiPrice")
    private float price;
    @Column(name = "Note")
    private String note;
    @Column(name = "TotalAmount")
    private float totalAmount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "Orders")
    private Orders order;
//    @ManyToOne
//    @JoinColumn(name = "CoffeAndTea")
//    private CoffeAndTea coffeId;
    @ManyToOne
    @JoinColumn(name = "ProductDetail")
    private ProducDetail producDetailId;





}





























//package ra.model.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import ra.model.entity.Orders;
//import ra.model.entity.ProducDetail;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "oderDetails")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class OrderDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "OrderDetailsId")
//    private int orderDetailsId;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "orderId")
//    private Orders orders;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "ProductDetailId")
//    private ProducDetail productDetails;
//    //    @ManyToOne(fetch = FetchType.EAGER)
////    @JoinColumn(name = "userId",referencedColumnName = "UserId")
////    private UserMana userMana;
//    @Column(name = "CreateDateOr")
//    private LocalDate createDateOr;
//    @Column(name = "TotalAmount")
//    private float totalAmount;
//    @Column(name = "Quantity")
//    private int quantity;
//    @Column(name = "OderStatus")
//    private int orderStatus;
//}
