package ra.model.service;


import ra.model.entity.Orders;

import java.util.List;

public interface OrderService {
    List<Orders>finAllOrder();
    Orders findByUserID(int userId);
    Orders saveAndUpdate(Orders orDer);
    Orders finById(int orderId);
    void delete(int orderId);
    List<Orders>searchByName(String orDerName);
    List<Orders>listStatus1();
    List<Orders>listStatus2();
    List<Orders>listStatus3();
    List<Orders>listStatus4();
    List<Orders> getOrderByUserId(int userId);
    List<Orders>getOrderConfirm(int userId);
}










































//package ra.model.service;
//import ra.model.entity.Orders;
//import java.util.List;
//
//public interface OrderService<T,V> {
//    List<T> getAll();
//    T saveAndUpdate(T t);
//    void delete(V id);
//    T getById(V id);
//    Orders getOrdersByUserMana_UserId(int userID);
//
//}