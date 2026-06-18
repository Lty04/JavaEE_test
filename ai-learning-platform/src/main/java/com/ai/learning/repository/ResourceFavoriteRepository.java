package com.ai.learning.repository;

import com.ai.learning.entity.ResourceFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
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

    boolean existsByUserIdAndResourceId(Long userId, Long resourceId);

    void deleteByUserIdAndResourceId(Long userId, Long resourceId);
}
