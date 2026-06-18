package com.ai.learning.repository;

import com.ai.learning.entity.ResourceRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 资源评价数据访问接口
 */
@Repository
public interface ResourceRatingRepository extends JpaRepository<ResourceRating, Long> {

    Optional<ResourceRating> findByUserIdAndResourceId(Long userId, Long resourceId);

    List<ResourceRating> findByResourceId(Long resourceId);

    List<ResourceRating> findByUserId(Long userId);

    @Query("SELECT AVG(r.rating) FROM ResourceRating r WHERE r.resource.id = :resourceId")
    Double averageRatingByResourceId(@Param("resourceId") Long resourceId);
}
