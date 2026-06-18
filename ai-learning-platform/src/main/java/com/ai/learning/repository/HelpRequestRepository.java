package com.ai.learning.repository;

import com.ai.learning.entity.HelpRequest;
import com.ai.learning.entity.HelpStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 求助数据访问接口
 */
@Repository
public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {

    Page<HelpRequest> findByStatus(HelpStatus status, Pageable pageable);

    Page<HelpRequest> findByStudentId(Long studentId, Pageable pageable);

    List<HelpRequest> findBySolverId(Long solverId);

    Page<HelpRequest> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
