package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Catalog;
import ra.model.entity.CoffeAndTea;
import ra.model.service.CatalogService;
import ra.model.service.CoffeAndTeaService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1/auth/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;
    @GetMapping

    public List<Catalog> getAllCatalog(){
        return catalogService.findAll();
    }
    @GetMapping("/{catalogId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")

    public Catalog getCaralogById(@PathVariable("catalogId")int catalogId){
        return catalogService.finbyId(catalogId);
    }
    @PostMapping
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")

    public Catalog createCatalog(@RequestBody Catalog catalog){
        return catalogService.saveAndUpdate(catalog);
    }
    @PutMapping("/{catalogId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Catalog updateCatalog(@PathVariable("catalogId")int catalogId,@RequestBody Catalog catalog){
        Catalog catalogUpdate =catalogService.finbyId(catalogId);
        catalogUpdate.setCatalogName(catalog.getCatalogName());
        catalogUpdate.setCatalogStatus(catalog.isCatalogStatus());
        return catalogService.saveAndUpdate(catalogUpdate);
    }
    @DeleteMapping("/{catalogId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")

    public void Delete(@PathVariable("catalogId")int catalogId){
        catalogService.deleteCatalog(catalogId);
    }
    @GetMapping("/search")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Catalog> searchCatalogByName(@RequestParam("catalogName") String catalogName){
        return  catalogService.searchCatalogByCatalogNameContaining(catalogName);
    }
}
