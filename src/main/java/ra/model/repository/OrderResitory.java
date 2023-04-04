package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.model.entity.Orders;


import java.util.List;

@Repository
public interface OrderResitory extends JpaRepository<Orders,Integer> {
//    OrDer findByUsers_UserId(int userID);
    @Query(value = "from Orders od WHERE od.orderStatus = 1 ")
    List<Orders> status1();
    @Query(value = "from Orders od WHERE od.orderStatus = 2 ")
    List<Orders> status2();
    @Query(value = "from Orders od WHERE od.orderStatus = 3 ")
    List<Orders> status3();
    @Query(value = "from Orders od WHERE od.orderStatus = 4 ")
    List<Orders> status4();
    @Query(value = "from Orders od WHERE od.orderStatus = 1 ")
    Orders findByUsers_UserId(Integer userID);
    @Query(value = "from Orders od WHERE od.orderStatus = 1 ")
    List<Orders> getOrDersByConFirm(@Param("userID") Integer userID);
    @Query(value = "from Orders od WHERE od.orderStatus = 1 ")
    List<Orders> getOrDersByUsersID(@Param("userID") Integer userID);


}












































//package ra.model.repository;

//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;

//@Repository
//public interface OrderRespository extends JpaRepository<Orders,Integer> {
//    @Query(value = "from Orders o where o.userID=:userID")
//    Orders findOrder(@Param("userID") int userID);
//
//}
