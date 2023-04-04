package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.model.entity.CoffeAndTea;
import ra.model.repository.CoffeAndTeaResitory;
import ra.model.service.CoffeAndTeaService;

import java.sql.SQLException;
import java.util.List;
@Service
@Transactional(rollbackFor = SQLException.class)
public class CoffeAndTeaServiceImp implements CoffeAndTeaService {
    @Autowired
    private CoffeAndTeaResitory coffeAndTeaRepository;


    @Override
    public List<CoffeAndTea> findAll() {
        return coffeAndTeaRepository.finAllCoffe();
    }

    @Override
    public CoffeAndTea findById(int productID) {
        return coffeAndTeaRepository.findById(productID).get();
    }


    @Override
    public CoffeAndTea saveOrUpdate(CoffeAndTea coffeAndTea) {
        return coffeAndTeaRepository.save(coffeAndTea);
    }

    @Override
    public void delete(int coffeId) {
        coffeAndTeaRepository.deleteById(coffeId);

    }

    @Override
    public List<CoffeAndTea> searchByNameOrId(String coffeName, int coffeId) {
        return coffeAndTeaRepository.searchByCoffeNameOrCoffeId(coffeName,coffeId);
    }

    @Override
    public List<CoffeAndTea> sortBookByNameAndPrice(String directionName, String directionPrice) {
        List<CoffeAndTea> listCoffe;
        if (directionName.equals("asc")) {
            if (directionPrice.equals("asc")) {
                return coffeAndTeaRepository.findAll(Sort.by("coffeName").and(Sort.by("price")));
            } else {
                return coffeAndTeaRepository.findAll(Sort.by("coffeName").and(Sort.by("price").descending()));

            }
        } else {
            if (directionPrice.equals("asc")) {
                return coffeAndTeaRepository.findAll(Sort.by("coffeName").descending().and(Sort.by("price")));
            } else {
                return coffeAndTeaRepository.findAll(Sort.by("coffeName").descending().and(Sort.by("price").descending()));

            }
        }
    }

    @Override
    public Page<CoffeAndTea> getPagging(Pageable pageable) {
        return coffeAndTeaRepository.findAll(pageable);
    }


}
