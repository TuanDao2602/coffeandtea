package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.OrderDetails;
import ra.model.repository.OrderDetailsResitory;
import ra.model.service.OrderDetailsService;

import java.util.List;

@Service
public class OrderDetailsImp implements OrderDetailsService {
    @Autowired
    private OrderDetailsResitory orderDetailsResitory;

    @Override
    public List<OrderDetails> findAll() {
        return orderDetailsResitory.findAll();
    }

    @Override
    public OrderDetails findById(int oderDetailId) {
        return orderDetailsResitory.findById(oderDetailId).get();
    }

    @Override
    public OrderDetails saveOrUpdate(OrderDetails orderDetail) {
        return orderDetailsResitory.save(orderDetail);
    }

    @Override
    public void delete(int orderDetail) {
        orderDetailsResitory.deleteById(orderDetail);

    }
}
