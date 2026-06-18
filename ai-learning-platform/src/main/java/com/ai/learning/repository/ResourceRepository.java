package com.ai.learning.repository;

import com.ai.learning.entity.Resource;
import com.ai.learning.entity.AuditStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 资源数据访问接口
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    Page<Resource> findByAuditStatus(AuditStatus status, Pageable pageable);

    Page<Resource> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    List<Resource> findByUploaderId(Long uploaderId);

    @Query("SELECT r FROM Resource r WHERE r.auditStatus = :status ORDER BY r.viewCount DESC")
    Page<Resource> findTopResources(AuditStatus status, Pageable pageable);

    List<Resource> findByCourseId(Long courseId);
}
