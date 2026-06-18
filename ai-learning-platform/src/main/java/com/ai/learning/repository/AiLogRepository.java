package com.ai.learning.repository;

import com.ai.learning.entity.AiLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * AI调用日志数据访问接口
 */
@Repository
public interface AiLogRepository extends JpaRepository<AiLog, Long> {
    
    Page<AiLog> findByUserId(Long userId, Pageable pageable);
    
    @Query("SELECT a FROM AiLog a WHERE a.user.id = :userId ORDER BY a.createTime DESC")
    Page<AiLog> findUserAiLogs(@Param("userId") Long userId, Pageable pageable);
    
    Page<AiLog> findByFunctionType(String functionType, Pageable pageable);
    
    Page<AiLog> findBySuccess(Boolean success, Pageable pageable);
}
