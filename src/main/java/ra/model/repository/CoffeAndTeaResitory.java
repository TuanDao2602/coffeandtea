package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.model.entity.CoffeAndTea;

import java.util.List;
@Repository
public interface CoffeAndTeaResitory extends JpaRepository<CoffeAndTea,Integer> {
    List<CoffeAndTea>searchByCoffeNameOrCoffeId(String coffeName,int coffeId);
    @Query(value = "from CoffeAndTea co where co.status=true ")
    List<CoffeAndTea>finAllCoffe();

}
