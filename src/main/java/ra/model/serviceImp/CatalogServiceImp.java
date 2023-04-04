package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.model.entity.Catalog;
import ra.model.repository.CatalogResitory;
import ra.model.service.CatalogService;

import java.sql.SQLException;
import java.util.List;
@Service
@Transactional(rollbackFor = SQLException.class)
public class CatalogServiceImp implements CatalogService {
    @Autowired
    private CatalogResitory catalogResitory;
    @Override
    public List<Catalog> findAll() {
        return catalogResitory.findAllCatalog();
    }

    @Override
    public Catalog finbyId(int catalogId) {
        return catalogResitory.findById(catalogId).get();
    }

    @Override
    public Catalog saveAndUpdate(Catalog catalog) {
        return catalogResitory.save(catalog);
    }

    @Override
    public void deleteCatalog(int catalogId) {
        catalogResitory.deleteById(catalogId);

    }

    @Override
    public List<Catalog> searchCatalogByCatalogNameContaining(String coffeName) {
        return catalogResitory.searchCatalogByCatalogNameContaining(coffeName);
    }
}
