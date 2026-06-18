package com.ai.learning.dto;

import java.util.List;
import java.util.Map;

/**
 * AI响应DTO
 */
public class AiResponse {
    
    private Boolean success;
    private String message;
    private String result; // 主要结果文本
    private List<String> keywords; // 关键词列表
    private List<Map<String, Object>> recommendations; // 推荐结果
    private Map<String, Object> data; // 其他结构化数据
    private Long duration; // 耗时（毫秒）
    
    public AiResponse() {
        this.success = true;
    }
    
    public AiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    
    // Getters and Setters
    public Boolean getSuccess() { return success; }
    public void setSuccess(Boolean success) { this.success = success; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
    
    public List<String> getKeywords() { return keywords; }
    public void setKeywords(List<String> keywords) { this.keywords = keywords; }
    
    public List<Map<String, Object>> getRecommendations() { return recommendations; }
    public void setRecommendations(List<Map<String, Object>> recommendations) { this.recommendations = recommendations; }
    
    public Map<String, Object> getData() { return data; }
    public void setData(Map<String, Object> data) { this.data = data; }
    
    public Long getDuration() { return duration; }
    public void setDuration(Long duration) { this.duration = duration; }
    
    public static AiResponse success(String message, String result) {
        AiResponse response = new AiResponse(true, message);
        response.setResult(result);
        return response;
    }
    
    public static AiResponse error(String message) {
        return new AiResponse(false, message);
    }
}
