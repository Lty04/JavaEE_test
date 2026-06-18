package com.ai.learning.entity;

/**
 * 求助状态枚举
 */
public enum HelpStatus {
    PENDING("待解决"),
    CLAIMED("已认领"),
    WAITING_CONFIRM("待确认"),
    COMPLETED("已完成"),
    CLOSED("已关闭");
    
    private final String description;
    
    HelpStatus(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
