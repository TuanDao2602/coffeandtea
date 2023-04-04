package ra.model.service;


import ra.model.entity.OrderDetails;
import ra.model.repository.OrderDetailsResitory;

import java.util.List;

public interface OrderDetailsService {
    List<OrderDetails> findAll();

    OrderDetails findById(int oderDetailId);

    OrderDetails saveOrUpdate(OrderDetails orderDetail);

    void delete(int orderDetail);

}












































//package ra.model.service;
//
//
//import ra.model.entity.OrderDetails;
//
//import java.util.List;
//
//public interface OrderDetailsService<T,V> {
//    List<T> getAll();
//    T saveAndUpdate(T t);
//    void delete(V id);
//    T getById(V id);
//    List<OrderDetails> getAllOrderDetailswaitForConfirmation();
//    List<OrderDetails> getAllOrderDetailSpreparingGoods();
//    List<OrderDetails> getAllOrderDetailsDelivering();
//    List<OrderDetails> getAllOrderDetailsFinish();
//    List<OrderDetails> getAllOrderDetailScancelOrder();
//
//    List<OrderDetails> getAllOderDetailByOrder(int ordersId);
//}