package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
//import ra.model.dto.CoffeandteaDTO;
import ra.model.entity.CoffeAndTea;
import ra.model.service.CoffeAndTeaService;
import ra.sercurity.CustomUserDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1/auth/coffe")
public class CoffeAndTeaController {
    @Autowired
    private CoffeAndTeaService coffeAndTeaService;
    @GetMapping
    public List<CoffeAndTea>getAllCoffe(){
        return coffeAndTeaService.findAll();
    }

//    @GetMapping
//    public List<CoffeandteaDTO>getDto(){
//       List<CoffeAndTea>coffeAndTeaList = coffeAndTeaService.findAll();
//       List<CoffeandteaDTO> listcoffeAndTeaDTO = new ArrayList<>();
//        for (CoffeAndTea coffe :coffeAndTeaList) {
//            CoffeandteaDTO coffeandteaDTO = new CoffeandteaDTO();
//            coffeandteaDTO.setCoffeId(coffe.getCoffeId());
//            coffeandteaDTO.setCoffeName(coffe.getCoffeName());
//            coffeandteaDTO.setCatalogName(coffe.getCatalog().getCatalogName());
//            coffeandteaDTO.setImage(coffe.getImage());
//            coffeandteaDTO.setPrice(coffe.getPrice());
//            coffeandteaDTO.setStatus(coffe.isStatus());
//             coffeandteaDTO.setListToppingName(coffe.getListTopping());
//            coffeandteaDTO.setListSizeName(coffe.getListSize());
//            listcoffeAndTeaDTO.add(coffeandteaDTO);
//
//        }
//
//
//        return listcoffeAndTeaDTO;
//    }




    @GetMapping("/{coffeId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")

    public CoffeAndTea getCoffeId(@PathVariable("coffeId")int coffeId){
        return coffeAndTeaService.findById(coffeId);
    }
    @PostMapping
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")

    public CoffeAndTea createCoffe(@RequestBody CoffeAndTea coffeAndTea){
        return coffeAndTeaService.saveOrUpdate(coffeAndTea);
    }
    @PutMapping("/{coffeId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")

    public CoffeAndTea updateCoffe(@PathVariable("coffeId")int coffeId,@RequestBody CoffeAndTea coffeAndTea){
        CoffeAndTea coffeAndTeaUpdate =coffeAndTeaService.findById(coffeId);
        coffeAndTeaUpdate.setCoffeName(coffeAndTea.getCoffeName());
        coffeAndTeaUpdate.setPrice(coffeAndTea.getPrice());
        coffeAndTeaUpdate.setStatus(coffeAndTea.isStatus());
        coffeAndTeaUpdate.setImage(coffeAndTea.getImage());
        coffeAndTeaUpdate.setCatalog(coffeAndTea.getCatalog());

        return coffeAndTeaService.saveOrUpdate(coffeAndTeaUpdate);
    }
    @DeleteMapping("/{coffeId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")

    public void Delete(@PathVariable("coffeId")int coffeId){
        coffeAndTeaService.delete(coffeId);
    }
    @GetMapping("/search")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<CoffeAndTea> searchByName(@RequestParam("coffeName") String coffeName,@RequestParam("coffeId") int coffeId){
        return  coffeAndTeaService.searchByNameOrId(coffeName,coffeId);
    }
    @GetMapping("/sortByNameAndPrice")
    public ResponseEntity<List<CoffeAndTea>> sortBookByNameAnPrice(@RequestParam("directionName")String directionName,
                                                            @RequestParam("directionPrice")String directionPrice){
        List<CoffeAndTea> listCoffeAndTea=coffeAndTeaService.sortBookByNameAndPrice(directionName,directionPrice);
        return new ResponseEntity<>(listCoffeAndTea, HttpStatus.OK);
    }
    @GetMapping("/getPagging")
    public ResponseEntity<Map<String ,Object>> getPagging(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<CoffeAndTea> pageCoffe=coffeAndTeaService.getPagging(pageable);
        Map<String,Object>data =new HashMap<>();
        data.put("Coffe",pageCoffe.getContent());
        data.put("total",pageCoffe.getSize());
        data.put("totalItems",pageCoffe.getTotalElements());
        data.put("totalPages",pageCoffe.getTotalPages());
        return  new ResponseEntity<>(data,HttpStatus.OK);

    }
//    @GetMapping("getAllWishlist")
//    public List<CoffeandteaDTO> getAllWishlist(){
//        List<CoffeandteaDTO> listProductShort = new ArrayList<>();
//        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List<CoffeAndTea> listProduct = coffeAndTeaService.(customUserDetails.getUserId());
//        for (Product pro : listProduct){
//            ProductShort productShort = new ProductShort();
//            productShort.setProductId(pro.getProductId());
//            productShort.setProductName(pro.getProductName());
//            productShort.setProductPrice(pro.getProductPrice());
//            productShort.setProductQuantity(pro.getProductQuantity());
//            productShort.setProductBirthOfDate(pro.getProductBirthOfDate());
//            productShort.setProductStatus(pro.isProductStatus());
//            productShort.setCatalog(pro.getCatalog());
//            productShort.getListImage().addAll(pro.getListImage());
//            listProductShort.add(productShort);
//        }
//        return listProductShort;
//    }
//
}













