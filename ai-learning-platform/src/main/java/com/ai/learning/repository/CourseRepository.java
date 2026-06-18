package com.ai.learning.repository;

import com.ai.learning.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 课程数据访问接口
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByCode(String code);

    List<Course> findByEnabledTrue();

    List<Course> findByNameContainingIgnoreCase(String name);
}
