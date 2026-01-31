package com.example.Graphql.Service;

import com.example.Graphql.Entity.User;
import com.example.Graphql.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
    public User delete(Long id){
        User user = findById(id);
        userRepository.delete(user);
        return user;
    }
}