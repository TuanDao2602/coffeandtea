package ra.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.model.entity.CoffeAndTea;
import ra.model.entity.Size;
import ra.model.entity.Topping;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetalsDTO {

    private int producDetailId;
    private int priceDetail;
    private String titleDetail;
    private String statusDetail;
    private String  sizeName;
    private String toppingName;
    private String coffeAndTeaName;
}
