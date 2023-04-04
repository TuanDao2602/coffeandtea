package ra.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.model.entity.CoffeAndTea;

import java.util.List;

public interface CoffeAndTeaService {
    List<CoffeAndTea> findAll();
    CoffeAndTea findById(int coffeId);
    CoffeAndTea saveOrUpdate(CoffeAndTea coffeAndTea);
    void delete(int coffeId);
    List<CoffeAndTea> searchByNameOrId(String coffeName,int coffeId);
//    List<CoffeAndTea> sortBookByName(String direction);
    List<CoffeAndTea> sortBookByNameAndPrice(String directionName,String directionPrice);
//    List<CoffeAndTea> sortByName_Price_Id(String directionName,String directionPrice,String directionId);
    Page<CoffeAndTea> getPagging(Pageable pageable);


}
