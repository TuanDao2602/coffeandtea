package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ra.model.entity.Orders;
import ra.model.repository.OrderResitory;
import ra.model.service.OrderService;

import java.util.List;
@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private  OrderResitory orderResitory;


    @Override
    public List<Orders> finAllOrder() {
        return orderResitory.findAll();
    }

    @Override
    public Orders findByUserID(int userId) {
        return orderResitory.findByUsers_UserId(userId);
    }

    @Override
    public Orders saveAndUpdate(Orders orDer) {
        return orderResitory.save(orDer);
    }

    @Override
    public Orders finById(int orderId) {
        return orderResitory.findById(orderId).get();
    }

    @Override
    public void delete(int orderId) {
        orderResitory.deleteById(orderId);

    }

    @Override
    public List<Orders> searchByName(String orDerName) {
        return null;
    }

    @Override
    public List<Orders> listStatus1() {
        return orderResitory.status1();
    }

    @Override
    public List<Orders> listStatus2() {
        return orderResitory.status2();
    }

    @Override
    public List<Orders> listStatus3() {
        return orderResitory.status3();
    }

    @Override
    public List<Orders> listStatus4() {
        return orderResitory.status4();
    }

    @Override
    public List<Orders> getOrderByUserId(int userId) {
        return orderResitory.getOrDersByUsersID(userId);
    }

    @Override
    public List<Orders> getOrderConfirm(int userId) {
        return orderResitory.getOrDersByConFirm(userId);
    }
}




















































//package ra.model.serviceImp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import ra.model.entity.Orders;
//import ra.model.repository.OrderRespository;
//import ra.model.service.OrderService;
//
//import java.util.List;
//@Service
//public class OrderServiceImp implements OrderService<Orders, Integer> {
//    @Autowired
//    private OrderRespository orderRespository;
//
//    @Override
//    public List<Orders> getAll() {
//        return orderRespository.findAll();
//    }
//
//    @Override
//    public Orders saveAndUpdate(Orders orders) {
//        return orderRespository.save(orders);
//    }
//
//    @Override
//    public void delete(Integer id) {
//        orderRespository.deleteById(id);
//    }
//
//    @Override
//    public Orders getById(Integer id) {
//        return orderRespository.findById(id).get();
//    }
//
//    @Override
//    public Orders getOrdersByUserMana_UserId(int userID) {
//        return orderRespository.findOrder(userID);
//    }
//}