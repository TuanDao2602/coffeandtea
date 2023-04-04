package ra.model.service;

import ra.model.entity.Size;
import ra.model.entity.Topping;

import java.util.List;

public interface SizeService{
    List<Size> findAll();
    Size findById(int sizeID);
    Size saveAndUpdate(Size size);
    void delete(int sizeID);
    List<Size> searchByName(String sizeName);
}
