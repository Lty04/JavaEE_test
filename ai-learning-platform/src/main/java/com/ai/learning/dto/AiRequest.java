package com.ai.learning.dto;

/**
 * AI请求DTO
 */
public class AiRequest {
    
    private String functionType; // 功能类型：summary, recommendation, qa, moderation, studyPlan
    private String content; // 内容
    private String context; // 上下文信息
    private Long userId; // 用户ID
    private Long resourceId; // 资源ID（可选）
    
    public AiRequest() {}
    
    public AiRequest(String functionType, String content) {
        this.functionType = functionType;
        this.content = content;
    }
    
    // Getters and Setters
    public String getFunctionType() { return functionType; }
    public void setFunctionType(String functionType) { this.functionType = functionType; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public String getContext() { return context; }
    public void setContext(String context) { this.context = context; }
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public Long getResourceId() { return resourceId; }
    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }
}
