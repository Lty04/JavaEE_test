package com.ai.learning.repository;

import com.ai.learning.entity.OperationLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 操作日志数据访问接口
 */
@Repository
public interface OperationLogRepository extends JpaRepository<OperationLog, Long> {
    
    Page<OperationLog> findByUserId(Long userId, Pageable pageable);
    
    @Query("SELECT o FROM OperationLog o WHERE o.user.id = :userId ORDER BY o.createTime DESC")
    Page<OperationLog> findUserOperationLogs(@Param("userId") Long userId, Pageable pageable);
    
    Page<OperationLog> findByOperationType(String operationType, Pageable pageable);
}
