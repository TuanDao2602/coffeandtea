package ra.model.service;

import ra.model.entity.CoffeAndTea;
import ra.model.entity.Topping;

import java.util.List;

public interface ToppingService {
    List<Topping> findAll();
    Topping finById(int toppingId);
    Topping saveAndUpdate(Topping topping);
    void delete(int toppingId);
    List<Topping> searchByName(String toppingName);

}
