package com.ai.learning.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 学习求助实体类
 */
@Data
@Entity
@Table(name = "help_request")
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HelpRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(length = 2000)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HelpStatus status = HelpStatus.PENDING;

    @Column(nullable = false)
    private Integer rewardPoints = 0;

    @Column
    private LocalDateTime deadline;

    @Column(length = 500)
    private String tags;

    @Column(length = 100)
    private String knowledgePoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solver_id")
    private User solver;

    @Column(length = 2000)
    private String solutionContent;

    @Column
    private LocalDateTime solvedTime;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;

    @Column(nullable = false)
    private LocalDateTime updateTime;
}
