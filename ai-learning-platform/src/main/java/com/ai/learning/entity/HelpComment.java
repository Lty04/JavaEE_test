package com.ai.learning.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 求助评论实体类
 */
@Data
@Entity
@Table(name = "help_comment")
@EntityListeners(AuditingEntityListener.class)
public class HelpComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "help_request_id", nullable = false)
    private HelpRequest helpRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column
    private Long parentId;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;
}
