package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ra.model.entity.ProducDetail;

import java.util.List;

public interface ProductDetailResitory extends JpaRepository<ProducDetail,Integer> {
    List<ProducDetail> searchByProducDetailId( int ProducDetailId );

}
