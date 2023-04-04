package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Size;
import ra.model.repository.SizeResitory;
import ra.model.service.SizeService;

import java.util.List;
@Service
public class SizeServiceImp implements SizeService {
    @Autowired
    private SizeResitory sizeResitory;
    @Override
    public List<Size> findAll() {
        return sizeResitory.findAll();
    }

    @Override
    public Size findById(int sizeID) {
        return sizeResitory.findById(sizeID).get();
    }

    @Override
    public Size saveAndUpdate(Size size) {
        return sizeResitory.save(size);
    }

    @Override
    public void delete(int sizeID) {
        sizeResitory.deleteById(sizeID);

    }

    @Override
    public List<Size> searchByName(String sizeName) {
        return sizeResitory.searchSizeBySizeNameContaining(sizeName);
    }
}
