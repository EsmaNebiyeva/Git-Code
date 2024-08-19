package org.example.project.repository;

import jakarta.transaction.Transactional;
import org.example.project.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    @Query("select u from User u where u.email=:email")
    Optional<User> findByEmail(String email);
}
