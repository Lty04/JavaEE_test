package com.ai.learning.repository;

import com.ai.learning.entity.PointRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 积分记录数据访问接口
 */
@Repository
public interface PointRecordRepository extends JpaRepository<PointRecord, Long> {

    Page<PointRecord> findByUserId(Long userId, Pageable pageable);

    List<PointRecord> findByUserIdOrderByCreateTimeDesc(Long userId);
}
