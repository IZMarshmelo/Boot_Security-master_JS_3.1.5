package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("from User u join fetch u.roles where u.email = :email")
    Optional<User> findByEmail(String email);

    @Query("from User u join fetch u.roles where u.id = :id")
    Optional<User> findById(Long id);
}
