package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "Users")
@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int userId;
    @Column(name = "UserName",unique = true,nullable = false)
    private String userName;
    @Column(name = "PassWord",nullable = false)
    @JsonIgnore
    private String passWord;
    @Column(name = "Created")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime created;
    @Column(name = "Email",unique = true,nullable = false)
    private String email;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "UserStatus")
    private boolean userStatus;
    @Column(name = "Adress")
    private String adress;
    @Column(name = "FullName")
    private String fullName;

//    @OneToMany(mappedBy = "users")
//    private List<OrDer> orDerList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name ="User_Role",joinColumns =@JoinColumn(name = "UserId"),inverseJoinColumns =@JoinColumn(name = "RoleId") )
    private Set<Roles> listRoles =new HashSet<>();

    @OneToMany(mappedBy = "users")
    private List<Orders> orders = new ArrayList<>();
}
