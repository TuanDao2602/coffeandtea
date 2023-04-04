package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import ra.model.dto.CartDto;
import ra.model.dto.OrderDTO;
import ra.model.dto.OrderDetailsDTO;
import ra.model.entity.*;
import ra.model.service.*;
import ra.sercurity.CustomUserDetails;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private CoffeAndTeaService coffeAndTeaService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailsService orderDetailService;
    @Autowired
    private ProductDetailService productDetailService;

    @PostMapping("/addToCart")
    public OrderDetails addToCart(@RequestBody CartDto cartDto) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users users = userService.findUserById(customUserDetails.getUserId());
        Orders findByIdUser = orderService.findByUserID(users.getUserId());
        OrderDetails detail = new OrderDetails();
        if (findByIdUser != null) {
            if (findByIdUser.getUsers().getUserId()==users.getUserId()){
                ProducDetail producDetail= productDetailService.findById(cartDto.getProducDetailId());
                detail.setOrder(findByIdUser);
                detail.setProducDetailId(producDetail);
                detail.setQuantity(cartDto.getQuantity());
                detail.setPrice(producDetail.getPriceDetail());
                detail.setNote(cartDto.getNote());
                detail.setTotalAmount(cartDto.getQuantity()* producDetail.getPriceDetail());
                orderDetailService.saveOrUpdate(detail);
            }else {
                Orders orDer = new Orders();
                orDer.setUsers(users);
                orDer.setOrderStatus(1);
                Orders orDer1 = orderService.saveAndUpdate(orDer);
                ProducDetail producDetail = productDetailService.findById(cartDto.getProducDetailId());
                detail.setOrder(orDer1);
                detail.setProducDetailId(producDetail);
                detail.setQuantity(cartDto.getQuantity());
                detail.setPrice(producDetail.getPriceDetail());
                detail.setNote(cartDto.getNote());
                detail.setTotalAmount(cartDto.getQuantity() * producDetail.getPriceDetail());
                orderDetailService.saveOrUpdate(detail);
            }

        }else {
            Orders orDer = new Orders();
            orDer.setUsers(users);
            orDer.setOrderStatus(1);
            Orders orDer1 = orderService.saveAndUpdate(orDer);
            ProducDetail producDetail = productDetailService.findById(cartDto.getProducDetailId());
            detail.setOrder(orDer1);
            detail.setProducDetailId(producDetail);
            detail.setQuantity(cartDto.getQuantity());
            detail.setPrice(producDetail.getPriceDetail());
            detail.setNote(cartDto.getNote());
            detail.setTotalAmount(cartDto.getQuantity() * producDetail.getPriceDetail());
            orderDetailService.saveOrUpdate(detail);
        }
        return detail;
    }
    @PostMapping("/checkOut")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Orders checkOut(){

        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users users = userService.findUserById(customUserDetails.getUserId());
        Orders ordersCheckOut = orderService.finById(users.getUserId());
        ordersCheckOut.setCreated(LocalDate.now());
        ordersCheckOut.setAdress(users.getAdress());
        ordersCheckOut.setEmail(users.getEmail());
        ordersCheckOut.setOrderStatus(2);
        ordersCheckOut.setFullName(users.getFullName());
        ordersCheckOut.setPhoneNumber(users.getPhone());
        ordersCheckOut.setUsers(users);
        orderService.saveAndUpdate(ordersCheckOut);
        return ordersCheckOut;
    }
/*
    public Integer totalAmount(List<OrderDetails>cartList){
        Integer totalAmount = 0;
        for (OrderDetails cart:cartList) {
            totalAmount +=cart.getTotalAmount();

        }
        return totalAmount;
    }
*/


}












































//package ra.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//import ra.model.dto.OrderDTO;
//import ra.model.entity.OrderDetails;
//import ra.model.entity.Orders;
//import ra.model.entity.Users;
//import ra.model.serviceImp.OrderDetailsServiceImp;
//import ra.model.serviceImp.UserServiceImp;
//import ra.sercurity.CustomUserDetails;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@CrossOrigin(origins = "http://localhost:8080")
//@RestController
//@RequestMapping("m/auth/OrderController")
//public class OrderController {
//    @Autowired
//    private OrderDetailsServiceImp orderServiceImp;
//    @Autowired
//    private OrderDetailsServiceImp orderDetailsServiceImp;
//    @Autowired
//    private UserServiceImp userServiceImp;
//
//    @GetMapping("/getAll")
//    public List<OrderDTO> getAll(){
//        List<Orders> ordersList=orderServiceImp.getAll();
//        List<OrderDTO> orderDTOList=new ArrayList<>();
//        List<String> statusOrder=new ArrayList<>();
//        for (Orders or:ordersList) {
//            List<OrderDetails> orderDetailsList=orderDetailsServiceImp.getAllOderDetailByOrder(or.getOrdersId());
//            float price=0;
//            int quantity=0;
//            int paid=0;
//
//            String status="";
//            String statusDisplay="";
//            for (OrderDetails ord:orderDetailsList) {
//                price += ord.getProductDetails().getPriceDetail();
//                quantity=ord.getQuantity();
//                if (ord.getOrderStatus()==3){
//                    status="Đang giao hàng";
//                    statusOrder.add(status);
//                }
//                if (ord.getOrderStatus()==4){
//                    paid+=(ord.getProductDetails().getPriceDetail()*ord.getQuantity());
//
//                }
//            }
//            if (statusOrder.size()==orderDetailsList.size()){
//                statusDisplay="Đang giao hàng";
//            }else {
//                statusDisplay="Đang chuẩn bị hàng";
//            }
//
//            price*=quantity;
//            OrderDTO orderDTO=new OrderDTO(
//                    or.getUserMana().getUserName(),
//                    (price+ or.getTotalAmount()-paid),
//                    statusDisplay
//
//            );
//            orderDTOList.add(orderDTO);
//        }
//        return orderDTOList;
//    }
//
//    @GetMapping
//    @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<?> createOrder(@RequestBody Orders orders) {
//        CustomUserDetails usersChangePass = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Users users = userServiceImp.findByUserName(usersChangePass.getUsername());
//        List<Orders> orders1 = orderServiceImp.getAll();
//        String mess = "";
//        if (orders1.size()!=0){
//            for (Orders getOrder : orders1) {
//                if (getOrder.getUserMana().getUserId()==users.getUserId()){
//                    Orders ordersOld = orderServiceImp.getOrdersByUserMana_UserId(users.getUserId());
//                    if (ordersOld.getCreateDate()==getOrder.getCreateDate()){
//                        ordersOld.setOrdersId(ordersOld.getOrdersId());
//                        ordersOld.setUserMana(users);
//                        ordersOld.setTotalAmount(14);
//                        ordersOld.setUserID(users.getUserId());
//                        ordersOld.setCreateDate(ordersOld.getCreateDate());
//                        orderServiceImp.s(ordersOld);
//                        mess = "Mua đi ngại gì ^-^";
//                    }else {
//                        orders.setUserMana(users);
//                        orders.setTotalAmount(14);
//                        orders.setUserID(users.getUserId());
//                        orders.setCreateDate(LocalDate.now());
//                        orderServiceImp.saveAndUpdate(orders);
//                        mess = "Lâu lắm rồi mới thấy bạn "+users.getUserName()+" quay lại!";
//                    }
//                }else {
//                    orders.setUserMana(users);
//                    orders.setTotalAmount(14);
//                    orders.setUserID(users.getUserId());
//                    orders.setCreateDate(LocalDate.now());
//                    orderServiceImp.saveAndUpdate(orders);
//                    mess = "Chúc "+users.getUserName()+" có những trải nghiệm vui vẻ ở Cửa Hàng!";
//                }
//            }
//        }else {
//            orders.setUserMana(users);
//            orders.setTotalAmount(14);
//            orders.setCreateDate(LocalDate.now());
//            orders.setUserID(users.getUserId());
//            orderServiceImp.saveAndUpdate(orders);
//            mess = "Cảm ơn bạn "+users.getUserName()+" đã tin tưởng ở cửa hàng chúng tôi!";
//        }
//
//        return ResponseEntity.ok(mess);
//    }

//    @DeleteMapping("/delete")
//    private Orders orders(){
//        List<OrderDetails> getAllOrderDetailsByOrder=orderDetailsServiceImp.getAllOderDetailByOrder()
//        for (Orders orders:orderServiceImp.getAll()) {
//
//        }
//    }

