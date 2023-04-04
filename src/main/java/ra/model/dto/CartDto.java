package ra.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.model.entity.ProducDetail;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private int quantity;
    private int producDetailId;
    private String note;
}
