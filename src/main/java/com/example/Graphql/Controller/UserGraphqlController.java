package com.example.Graphql.Controller;

import com.example.Graphql.Service.UserService;
import com.example.Graphql.Entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.*;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserGraphqlController {
    private final UserService userService;
    
    @QueryMapping
    public UserPage users(@Argument int page, @Argument int size){
        var pageResult = userService.findUsers(page,size);
        return new UserPage(pageResult.getContent(),
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages(),
                pageResult.isLast());
    }

    @QueryMapping
    public User user(@Argument Long id){
        return userService.findById(id);
    }

    @MutationMapping
    public User createUser(@Argument CreateUserInput input){
        User user = User.builder()
        .name(input.name())
        .email(input.email())
        .build();
        return userService.createUser(user);
    }

    @MutationMapping
    public User deleteUser(@Argument Long id){
        return userService.delete(id);
    }
}