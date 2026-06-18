package com.ai.learning.repository;

import com.ai.learning.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 课程数据访问接口
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
    List<Course> findByActiveTrue();
    
    @Query("SELECT c FROM Course c WHERE c.teacher.id = :teacherId")
    List<Course> findByTeacherId(@Param("teacherId") Long teacherId);
    
    @Query("SELECT c FROM Course c WHERE c.name LIKE %:keyword% OR c.code LIKE %:keyword%")
    List<Course> searchCourses(@Param("keyword") String keyword);
}
