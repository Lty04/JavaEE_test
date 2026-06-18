package com.ai.learning.entity;

/**
 * 求助状态枚举
 */
public enum HelpStatus {
    /**
     * 待解决
     */
    PENDING,
    
    /**
     * 已认领
     */
    CLAIMED,
    
    /**
     * 待确认
     */
    WAITING_CONFIRM,
    
    /**
     * 已完成
     */
    COMPLETED,
    
    /**
     * 已关闭
     */
    CLOSED
}
