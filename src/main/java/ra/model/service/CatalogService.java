package ra.model.service;

import ra.model.entity.Catalog;

import java.util.List;

public interface CatalogService {
    List<Catalog>findAll();
    Catalog finbyId(int catalogId);
    Catalog saveAndUpdate(Catalog catalog);
    void deleteCatalog(int catalogId);
    List<Catalog> searchCatalogByCatalogNameContaining(String coffeName);

}
