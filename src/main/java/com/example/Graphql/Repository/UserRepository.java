package com.example.Graphql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Graphql.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
}