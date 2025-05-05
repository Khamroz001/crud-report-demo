package uz.khamroz.crudreportdemo.service;

import org.springframework.stereotype.Service;
import uz.khamroz.crudreportdemo.model.User;
import uz.khamroz.crudreportdemo.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
    public User updateUser(Long id, User userDetails){
        return userRepository.findById(id).map(user -> {
            Optional.ofNullable(userDetails.getUsername()).ifPresent(user::setUsername);
            Optional.ofNullable(userDetails.getPassword()).ifPresent(user::setPassword);
            Optional.ofNullable(userDetails.getRole()).ifPresent(user::setRole);
            user.setLastLogin(String.valueOf(LocalDateTime.now()));
            return userRepository.save(user);
        }).orElseThrow(()->new RuntimeException("User not found"));
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
