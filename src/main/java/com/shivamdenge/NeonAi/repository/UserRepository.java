package com.shivamdenge.NeonAi.repository;

import com.shivamdenge.NeonAi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
