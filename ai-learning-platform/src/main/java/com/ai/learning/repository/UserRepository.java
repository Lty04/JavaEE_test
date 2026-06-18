package com.ai.learning.repository;

import com.ai.learning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

/**
 * 用户数据访问接口
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);
    
    Optional<User> findByEmail(String email);
    
    boolean existsByUsername(String username);
    
    boolean existsByEmail(String email);
    
    @Query("SELECT u FROM User u WHERE u.role = :role")
    List<User> findByRole(@Param("role") com.ai.learning.entity.Role role);
    
    @Query("SELECT u FROM User u WHERE u.username LIKE %:keyword% OR u.email LIKE %:keyword% OR u.realName LIKE %:keyword%")
    List<User> searchUsers(@Param("keyword") String keyword);
    
    @Query("SELECT u FROM User u ORDER BY u.points DESC")
    List<User> findTopByPoints();
}
