package com.ai.learning.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 积分记录实体类
 */
@Data
@Entity
@Table(name = "point_record")
@EntityListeners(AuditingEntityListener.class)
public class PointRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer points;

    @Column(nullable = false, length = 50)
    private String sourceType;

    @Column
    private Long sourceId;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Integer balanceAfter;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;
}
