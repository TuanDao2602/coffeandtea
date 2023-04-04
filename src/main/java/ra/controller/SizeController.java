package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Catalog;
import ra.model.entity.Size;
import ra.model.service.SizeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1/auth/size")
public class SizeController {
    @Autowired
    private SizeService sizeService;
    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Size> getAllSize(){
        return sizeService.findAll();
    }
    @GetMapping("/{sizeID}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")

    public Size findSizeById(@PathVariable("sizeID")int sizeID){
        return sizeService.findById(sizeID);
    }
    @PostMapping()
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")

    public Size createSize(@RequestBody Size size){
        return sizeService.saveAndUpdate(size);
    }
    @PutMapping("/{sizeId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Size updateSize(@PathVariable("sizeID")int sizeID,@RequestBody Size size){
        Size sizeUpdate = sizeService.findById(sizeID);
        sizeUpdate.setSizeName(size.getSizeName());
        sizeUpdate.setStatus(size.isStatus());
//        sizeUpdate.setListProductDetail(size.getListProductDetail());
        return sizeService.saveAndUpdate(sizeUpdate);
    }
    @DeleteMapping("/{sizeID}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deleteSize(@PathVariable("sizeID")int sizeID){
        sizeService.delete(sizeID);
    }
    @GetMapping("/search")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Size> searchSizeByName(@RequestParam("sizeName") String sizeName){
        return  sizeService.searchByName(sizeName);
    }
}
