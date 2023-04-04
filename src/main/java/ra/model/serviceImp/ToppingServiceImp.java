package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.model.entity.Topping;
import ra.model.repository.ToppingResitory;
import ra.model.service.ToppingService;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional(rollbackFor = SQLException.class)
public class ToppingServiceImp implements ToppingService {
    @Autowired
    private ToppingResitory toppingResitory;

    @Override
    public List<Topping> findAll() {
        return toppingResitory.findAll();
    }

    @Override
    public Topping finById(int toppingId) {
        return toppingResitory.findById(toppingId).get();
    }

    @Override
    public Topping saveAndUpdate(Topping topping) {
        return toppingResitory.save(topping);
    }

    @Override
    public void delete(int toppingId) {
        toppingResitory.deleteById(toppingId);

    }

    @Override
    public List<Topping> searchByName(String toppingName) {
        return toppingResitory.findByToppingNameContaining(toppingName);
    }


}