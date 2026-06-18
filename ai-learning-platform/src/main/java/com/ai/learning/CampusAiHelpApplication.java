package com.ai.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * AI赋能校园学习互助平台 - 主启动类
 * 
 * 这是整个项目的入口，就像汽车的点火开关一样。
 * 运行这个类，整个系统就会启动起来！
 * 
 * @author Campus AI Team
 * @version 1.0.0
 */
@SpringBootApplication
@EnableWebSecurity
public class CampusAiHelpApplication {

    /**
     * 主方法 - 程序的起点
     * 
     * 使用方法：
     * 1. 右键点击这个文件
     * 2. 选择 "Run 'CampusAiHelpApplication'"
     * 3. 或者在命令行运行：mvn spring-boot:run
     * 
     * @param args 命令行参数（一般不需要传）
     */
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   AI赋能校园学习互助平台 正在启动...");
        System.out.println("========================================");
        
        SpringApplication.run(CampusAiHelpApplication.class, args);
        
        System.out.println("========================================");
        System.out.println("   ✓ 系统启动成功！");
        System.out.println("   🌐 访问地址：http://localhost:8080");
        System.out.println("========================================");
    }
}
