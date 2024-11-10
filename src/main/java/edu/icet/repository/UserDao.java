package edu.icet.repository;

import edu.icet.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);

    @Query(value = "SELECT * FROM User u WHERE u.email = :email AND u.password = :password AND u.is_disable = false", nativeQuery = true)
    Optional<UserEntity> getValidUser(@Param("email") String email, @Param("password") String password);
}
