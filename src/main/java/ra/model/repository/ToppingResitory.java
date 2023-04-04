package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.model.entity.Topping;

import java.util.List;
@Repository
public interface ToppingResitory extends JpaRepository<Topping,Integer> {
    List<Topping>findByToppingNameContaining(String toppingName);
//    @Query(value = " select ToppingId,Price,ToppingStatus,ToppingName\n" +
//            "        from topping\n" +
//            "            where ToppingId in (select toppingid\n" +
//            "                                from coffetopping\n" +
//            "                                where CoffeId=:cfId)",nativeQuery = true)
//    List<Topping>findByCaffeandTeaId(@Param("cfId") int cfId);
}
