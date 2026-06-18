package com.ai.learning.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 学习求助实体类
 */
@Entity
@Table(name = "help_requests")
public class HelpRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 200)
    private String title;
    
    @Column(nullable = false, length = 2000)
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private User student;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
    
    @Column(length = 200)
    private String tags; // 知识点标签，逗号分隔
    
    @Column(nullable = false)
    private Integer rewardPoints = 0; // 悬赏积分
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HelpStatus status = HelpStatus.PENDING;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resolver_id")
    private User resolver; // 认领者/解决者
    
    @Column(length = 2000)
    private String solution; // 解答内容
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;
    
    @Column(nullable = false)
    private LocalDateTime deadline; // 期望截止时间
    
    @Column
    private LocalDateTime resolveTime; // 解决时间
    
    @Column
    private LocalDateTime confirmTime; // 确认完成时间
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime updateTime;
    
    @PrePersist
    protected void onCreate() {
        createTime = LocalDateTime.now();
        updateTime = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updateTime = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public User getStudent() { return student; }
    public void setStudent(User student) { this.student = student; }
    
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
    
    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }
    
    public Integer getRewardPoints() { return rewardPoints; }
    public void setRewardPoints(Integer rewardPoints) { this.rewardPoints = rewardPoints; }
    
    public HelpStatus getStatus() { return status; }
    public void setStatus(HelpStatus status) { this.status = status; }
    
    public User getResolver() { return resolver; }
    public void setResolver(User resolver) { this.resolver = resolver; }
    
    public String getSolution() { return solution; }
    public void setSolution(String solution) { this.solution = solution; }
    
    public LocalDateTime getCreateTime() { return createTime; }
    public LocalDateTime getDeadline() { return deadline; }
    public void setDeadline(LocalDateTime deadline) { this.deadline = deadline; }
    
    public LocalDateTime getResolveTime() { return resolveTime; }
    public void setResolveTime(LocalDateTime resolveTime) { this.resolveTime = resolveTime; }
    
    public LocalDateTime getConfirmTime() { return confirmTime; }
    public void setConfirmTime(LocalDateTime confirmTime) { this.confirmTime = confirmTime; }
    
    public LocalDateTime getUpdateTime() { return updateTime; }
}
