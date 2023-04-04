package ra.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowCart {
    private int quantity;
    private String productName;
    private String userName;
    private int price;
    private int totalAmount;
}
