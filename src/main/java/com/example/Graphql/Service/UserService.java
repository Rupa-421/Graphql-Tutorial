package com.example.Graphql.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.example.Graphql.Entity.User;
import com.example.Graphql.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final int MAX_PAGE_SIZE = 50;
    private final UserRepository userRepository;

    public Page<User> findUsers(int page,int size) {
        int safeSize = Math.min(size,MAX_PAGE_SIZE);
        int safePage = Math.min(page,0);
        return userRepository.findAll(PageRequest.of(safePage,safeSize));
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