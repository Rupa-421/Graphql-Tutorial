package com.example.Graphql.Controller;
import com.example.Graphql.Entity.User;
import java.util.List;
public record UserPage (
    List<User> content,
    int page,
    int size,
    long totalElements,
    int totalPages,
    boolean last
){
}
