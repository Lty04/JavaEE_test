package com.ai.learning.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * AI调用日志实体类
 */
@Entity
@Table(name = "ai_logs")
public class AiLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(nullable = false, length = 100)
    private String functionType; // 调用功能：资源摘要、智能推荐、学习问答、内容审核等
    
    @Column(length = 2000)
    private String requestSummary; // 请求摘要
    
    @Column(length = 2000)
    private String responseSummary; // 响应摘要
    
    @Column(nullable = false)
    private Long duration; // 耗时（毫秒）
    
    @Column(nullable = false)
    private Boolean success; // 是否成功
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;
    
    @PrePersist
    protected void onCreate() {
        createTime = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    public String getFunctionType() { return functionType; }
    public void setFunctionType(String functionType) { this.functionType = functionType; }
    
    public String getRequestSummary() { return requestSummary; }
    public void setRequestSummary(String requestSummary) { this.requestSummary = requestSummary; }
    
    public String getResponseSummary() { return responseSummary; }
    public void setResponseSummary(String responseSummary) { this.responseSummary = responseSummary; }
    
    public Long getDuration() { return duration; }
    public void setDuration(Long duration) { this.duration = duration; }
    
    public Boolean getSuccess() { return success; }
    public void setSuccess(Boolean success) { this.success = success; }
    
    public LocalDateTime getCreateTime() { return createTime; }
}
