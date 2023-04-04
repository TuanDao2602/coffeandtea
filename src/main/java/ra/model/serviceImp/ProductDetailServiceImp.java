package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.ProducDetail;
import ra.model.repository.ProductDetailResitory;
import ra.model.service.ProductDetailService;

import java.util.List;

@Service
public class ProductDetailServiceImp implements ProductDetailService {
    @Autowired
    private ProductDetailResitory productDetailResitory;

    @Override
    public ProducDetail findById(int productDetailId) {
        return productDetailResitory.findById(productDetailId).get();
    }

    @Override
    public List<ProducDetail> finAllProductDetail() {
        return productDetailResitory.findAll();
    }

    @Override
    public ProducDetail saveAndUpdate(ProducDetail producDetail) {
        return productDetailResitory.save(producDetail);
    }

    @Override
    public void delete(int producDetailId) {
        productDetailResitory.deleteById(producDetailId);
    }
}
