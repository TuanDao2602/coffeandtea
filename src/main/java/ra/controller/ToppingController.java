package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Catalog;
import ra.model.entity.Topping;
import ra.model.repository.ToppingResitory;
import ra.model.service.ToppingService;

import java.util.List;

@RestController

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1/auth/topping")
public class ToppingController {
    @Autowired
    private ToppingService toppingService;
    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
   public List<Topping> getAllTopping(){
        return  toppingService.findAll();
    }

    @GetMapping("/{toppingId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Topping getToppingById(@PathVariable("toppingId")int toppingId){
        return toppingService.finById(toppingId);
    }
 @PostMapping
 @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Topping createTopping(@RequestBody Topping topping){
        return toppingService.saveAndUpdate(topping);
 }
 @PutMapping("/{toppingId}")
 @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Topping toppingUpdate(@PathVariable("toppingId")int toppingId,@RequestBody Topping topping){
        Topping toppingUpdate = toppingService.finById(toppingId);
        toppingUpdate.setToppingName(topping.getToppingName());
        toppingUpdate.setPrice(topping.getPrice());
        toppingUpdate.setStatus(topping.isStatus());
//        toppingUpdate.setListProductDetail(topping.getListProductDetail());
        return toppingService.saveAndUpdate(toppingUpdate);
 }
 @DeleteMapping("/{toppingId}")
 @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void delete(@PathVariable("toppingId")int toppingId){
        toppingService.delete(toppingId);
 }
    @GetMapping("/search")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Topping> searchToppingByName(@RequestParam("toppingName") String toppingName){
        return  toppingService.searchByName(toppingName);
    }



}
