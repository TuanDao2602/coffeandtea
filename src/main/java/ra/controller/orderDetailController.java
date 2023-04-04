package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.OrderDetails;
import ra.model.service.OrderDetailsService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1/orderdetail")
public class orderDetailController {
    @Autowired
    private OrderDetailsService orderDetailService;
    @GetMapping
    public List<OrderDetails>finAllDetail(){
        return orderDetailService.findAll();
    }
    @PostMapping("/createOrder")
    public OrderDetails createOrderDetail(@RequestBody OrderDetails orderDetail){
        return orderDetailService.saveOrUpdate(orderDetail);

    }
    @GetMapping("/{orderDetailID}")
    public OrderDetails finByIdDetail(@PathVariable("orderDetailID")int orderDetailID){
        return orderDetailService.findById(orderDetailID);
    }



}

