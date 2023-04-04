package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.model.entity.Catalog;
import ra.model.entity.CoffeAndTea;

import java.util.List;

@Repository
public interface CatalogResitory extends JpaRepository<Catalog,Integer> {
    List<Catalog> searchCatalogByCatalogNameContaining(String coffeName);
    @Query(value = "from Catalog c where c.catalogStatus=true ")
    List<Catalog>findAllCatalog();
}
