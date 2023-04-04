package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Catalog;
import ra.model.entity.Size;

import java.util.List;

@Repository
public interface SizeResitory extends JpaRepository<Size,Integer> {
    List<Size> searchSizeBySizeNameContaining(String sizeName);
}
