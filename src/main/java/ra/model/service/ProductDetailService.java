package ra.model.service;

import org.springframework.stereotype.Service;

import ra.model.entity.Orders;
import ra.model.entity.ProducDetail;

import java.util.List;


@Service
public interface ProductDetailService {

    ProducDetail findById(int productDetailId);
    List<ProducDetail> finAllProductDetail();

    ProducDetail saveAndUpdate(ProducDetail producDetail);
    void delete(int producDetailId);

}
