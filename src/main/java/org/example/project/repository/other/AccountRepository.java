package org.example.project.repository.other;

import jakarta.transaction.Transactional;
import org.example.project.entity.other.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT p FROM Account  p where upper(p.name)=upper(:name)")
    Optional<Account> findByName(String name);
}
