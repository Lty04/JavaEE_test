package com.ai.learning.repository;

import com.ai.learning.entity.ResourceFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 资源收藏数据访问接口
 */
@Repository
public interface ResourceFavoriteRepository extends JpaRepository<ResourceFavorite, Long> {
    
    Optional<ResourceFavorite> findByUserIdAndResourceId(Long userId, Long resourceId);
    
    List<ResourceFavorite> findByUserId(Long userId);
    
    List<ResourceFavorite> findByResourceId(Long resourceId);
    
    @Query("SELECT COUNT(f) FROM ResourceFavorite f WHERE f.resource.id = :resourceId")
    Long countByResourceId(@Param("resourceId") Long resourceId);
    
    boolean existsByUserIdAndResourceId(Long userId, Long resourceId);
}
