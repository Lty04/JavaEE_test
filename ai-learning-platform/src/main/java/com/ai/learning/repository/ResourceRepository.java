package com.ai.learning.repository;

import com.ai.learning.entity.Resource;
import com.ai.learning.entity.AuditStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 资源数据访问接口
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    
    Page<Resource> findByStatus(AuditStatus status, Pageable pageable);
    
    Page<Resource> findByStatusAndTitleContaining(AuditStatus status, String title, Pageable pageable);
    
    @Query("SELECT r FROM Resource r WHERE r.status = :status AND (:title IS NULL OR r.title LIKE %:title%) AND (:type IS NULL OR r.type = :type) AND (:tags IS NULL OR r.tags LIKE %:tags%)")
    Page<Resource> searchResources(@Param("status") AuditStatus status, 
                                   @Param("title") String title, 
                                   @Param("type") String type, 
                                   @Param("tags") String tags,
                                   Pageable pageable);
    
    List<Resource> findByUploaderId(Long uploaderId);
    
    @Query("SELECT r FROM Resource r WHERE r.status = :status ORDER BY r.viewCount DESC")
    Page<Resource> findTopByViewCount(@Param("status") AuditStatus status, Pageable pageable);
    
    @Query("SELECT r FROM Resource r WHERE r.status = :status ORDER BY r.favoriteCount DESC")
    Page<Resource> findTopByFavoriteCount(@Param("status") AuditStatus status, Pageable pageable);
    
    @Query("SELECT r FROM Resource r WHERE r.status = :status ORDER BY r.rating DESC")
    Page<Resource> findTopByRating(@Param("status") AuditStatus status, Pageable pageable);
    
    @Query("SELECT r FROM Resource r WHERE r.course.id = :courseId AND r.status = :status")
    List<Resource> findByCourseId(@Param("courseId") Long courseId, @Param("status") AuditStatus status);
}
