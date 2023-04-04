package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ra.model.dto.ProductDetalsDTO;
import ra.model.entity.CoffeAndTea;
import ra.model.entity.ProducDetail;
import ra.model.service.ProductDetailService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1/auth/detail")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService ;
    @GetMapping
    public List<ProductDetalsDTO> getAllDetail(){
        List<ProducDetail>listProductDetails=productDetailService.finAllProductDetail();
        List<ProductDetalsDTO>listDTO = new ArrayList<>();
        String status="";
        for (ProducDetail pro:listProductDetails) {
            if (pro.isStatusDetail()){
                status="hoạt đôộng";
            }else {
                status="không hoạt động";
            }
            ProductDetalsDTO productDetalsDTO=new ProductDetalsDTO();
            productDetalsDTO.setProducDetailId(pro.getProducDetailId());
            productDetalsDTO.setPriceDetail(pro.getTopping().getPrice() + pro.getCoffeAndTea().getPrice());
            productDetalsDTO.setSizeName(pro.getSize().getSizeName());
            productDetalsDTO.setTitleDetail(pro.getTitleDetail());
            productDetalsDTO.setCoffeAndTeaName(pro.getCoffeAndTea().getCoffeName());
            productDetalsDTO.setToppingName(pro.getTopping().getToppingName());
            productDetalsDTO.setStatusDetail(status);
            listDTO.add(productDetalsDTO);
        }return listDTO;
    }
    @GetMapping("/{producDetailId}")
    public ProducDetail getProductDetailId(@PathVariable("producDetailId")int producDetailId){
        return productDetailService.findById(producDetailId);
    }

    @PostMapping
    public ProducDetail createrDetail(@RequestBody ProducDetail producDetail){
        producDetail.setStatusDetail(true);

        producDetail.setPriceDetail(producDetail.getTopping().getPrice()+producDetail.getCoffeAndTea().getPrice());

        return productDetailService.saveAndUpdate(producDetail);

    }
//
//    @DeleteMapping("/{producDetailId}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<?> Delete(@PathVariable("producDetailId")int producDetailId){
//        productDetailService.delete(producDetailId);
//        return ResponseEntity.ok("oke");
//    }
}
