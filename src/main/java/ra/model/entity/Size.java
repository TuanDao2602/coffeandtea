package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Size")
@Entity
@Data
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SizeId")
    private int sizeID;
    @Column(name = "SizeName")
    private String sizeName;
    @Column(name = "Status")
    private boolean status=true;
    @OneToMany(mappedBy = "size",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProducDetail> listProductDetail =new ArrayList<>();
//
//



}
