-- ============================================
-- AI 赋能校园学习互助平台 - 数据库初始化脚本
-- ============================================

-- 创建默认管理员账号 (密码：admin123)
-- BCrypt 加密后的密码：$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi
INSERT INTO users (username, password, email, real_name, role, enabled, points, create_time, update_time)
VALUES ('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'admin@school.edu.cn', '系统管理员', 'ADMIN', true, 1000, NOW(), NOW())
ON DUPLICATE KEY UPDATE username=username;

-- 创建测试学生账号 (密码：student123)
INSERT INTO users (username, password, email, real_name, role, enabled, points, create_time, update_time)
VALUES ('student', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'student@school.edu.cn', '测试学生', 'STUDENT', true, 100, NOW(), NOW())
ON DUPLICATE KEY UPDATE username=username;

-- 创建测试课程数据
INSERT INTO courses (name, code, description, credit, teacher_name, create_time, update_time)
VALUES 
('计算机基础', 'CS101', '计算机科学入门课程', 3.0, '张教授', NOW(), NOW()),
('数据结构', 'CS201', '学习基本数据结构与算法', 4.0, '李副教授', NOW(), NOW()),
('高等数学', 'MATH101', '微积分与线性代数基础', 5.0, '王教授', NOW(), NOW())
ON DUPLICATE KEY UPDATE name=name;

-- 创建测试标签
INSERT INTO tags (name, description, create_time)
VALUES 
('Java', 'Java 编程语言相关', NOW()),
('Python', 'Python 编程语言相关', NOW()),
('数学', '数学问题讨论', NOW()),
('算法', '算法设计与分析', NOW()),
('数据库', '数据库相关知识', NOW())
ON DUPLICATE KEY UPDATE name=name;

-- 创建测试求助问题
INSERT INTO help_requests (title, content, subject, status, student_id, reward_points, create_time, update_time)
VALUES 
('如何理解递归算法？', '在学习递归时总是想不明白调用过程，有没有好的学习方法？', '计算机科学', 'PENDING', 2, 20, NOW(), NOW()),
('求推荐 Java 学习路线', '刚开始学 Java，不知道应该按什么顺序学习，求大佬指点！', '编程', 'PENDING', 2, 15, NOW(), NOW())
ON DUPLICATE KEY UPDATE title=title;

-- 说明：
-- 1. 执行此脚本前，请确保数据库 ai_learning_platform 已创建
-- 2. 密码使用 BCrypt 加密，明文密码为 admin123 和 student123
-- 3. ON DUPLICATE KEY UPDATE 用于避免重复插入导致的错误
-- 4. 生产环境请删除此文件或修改默认密码
