package com.ai.learning.repository;

import com.ai.learning.entity.HelpRequest;
import com.ai.learning.entity.HelpStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 求助请求数据访问接口
 */
@Repository
public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {
    
    Page<HelpRequest> findByStatus(HelpStatus status, Pageable pageable);
    
    Page<HelpRequest> findByStudentId(Long studentId, Pageable pageable);
    
    Page<HelpRequest> findByResolverId(Long resolverId, Pageable pageable);
    
    @Query("SELECT h FROM HelpRequest h WHERE h.status = :status AND (:title IS NULL OR h.title LIKE %:title%)")
    Page<HelpRequest> searchHelpRequests(@Param("status") HelpStatus status, 
                                         @Param("title") String title, 
                                         Pageable pageable);
    
    @Query("SELECT h FROM HelpRequest h WHERE h.course.id = :courseId AND h.status = :status")
    List<HelpRequest> findByCourseId(@Param("courseId") Long courseId, @Param("status") HelpStatus status);
    
    @Query("SELECT h FROM HelpRequest h WHERE h.status IN :statuses ORDER BY h.createTime DESC")
    Page<HelpRequest> findByStatuses(@Param("statuses") List<HelpStatus> statuses, Pageable pageable);
}
