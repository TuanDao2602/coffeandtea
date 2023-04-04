package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private int orderId;
    @ManyToOne
    @JoinColumn(name = "UserId")
    @JsonIgnore
    private Users users;
    @Column(name="Created")
    private LocalDate created;
//    @Column(name = "TotolAmountOrder")
//    private int totolAmountOrder;
//    @Column(name = "Note")
//    private String note;
    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Adress",columnDefinition = "text")
    private String adress;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "Email")
    private String email;

    @Column(name = "Status")
    private int orderStatus;
    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<OrderDetails> listOrderDetail =new ArrayList<>();
}





















































//package ra.model.entity;


















































//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;

//@Entity
//@Table(name = "Orders")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Orders {
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private int ordersId;
// @OneToMany(mappedBy = "orders")
// private List<OrderDetails> orderDetails = new ArrayList<>();
// @ManyToOne(fetch = FetchType.EAGER)
// @JoinColumn(name = "Users")
// private Users userMana;
// @Column(name = "userID")
// private int userID;
// @Column(name = "totalAmount")
// private float totalAmount;
// @Column(name = "CreateDate")
// private LocalDate createDate;
//
//}