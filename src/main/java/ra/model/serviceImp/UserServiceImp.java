package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Users;
import ra.model.repository.UserRepository;
import ra.model.service.UserService;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Users findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Users saveOrUpdate(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users findUserById(int userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public List<Users> findAllUsers() {
        return userRepository.findAllUser();
    }
}
