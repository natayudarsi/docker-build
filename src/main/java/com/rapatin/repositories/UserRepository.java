package com.rapatin.repositories;

import com.rapatin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByid(Integer id);
    User findByName(String name);
}
