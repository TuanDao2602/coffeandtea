package ra.model.service;

import ra.model.entity.Size;
import ra.model.entity.Users;

import java.util.List;

public interface UserService {
    Users findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
    Users saveOrUpdate(Users user);
    Users findUserById(int userId);
    List<Users> findAllUsers();
}
