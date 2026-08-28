DROP DATABASE IF EXISTS testing_system_assignment_5;
CREATE DATABASE testing_system_assignment_5;
USE Testing_System_Assignment_5;

DROP TABLE IF EXISTS department;
CREATE TABLE department (
    departmentID    INT AUTO_INCREMENT PRIMARY KEY,
    departmentName  VARCHAR(50) NOT NULL 
);

DROP TABLE IF EXISTS position;
CREATE TABLE position (
    positionID    INT AUTO_INCREMENT PRIMARY KEY,
    positionName  VARCHAR(50) NOT NULL 
);

DROP TABLE IF EXISTS account;
CREATE TABLE account (
    AccountID     INT AUTO_INCREMENT PRIMARY KEY,
    Email         VARCHAR(50) NOT NULL,
    Username      VARCHAR(50) NOT NULL,
    FullName      VARCHAR(50) NOT NULL,
    DepartmentID  INT NOT NULL,
    PositionID    INT NOT NULL,
    CreateDate    DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_Acc_Dep FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
    CONSTRAINT FK_Acc_Pos   FOREIGN KEY (PositionID)   REFERENCES `Position` (PositionID)
);

DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
    GroupID       INT AUTO_INCREMENT PRIMARY KEY,
    Groupname     VARCHAR(50) NOT NULL,
	CreatorID     INT NOT NULL,
    CreateDate    DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_Group_Acc FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount (
    GroupID       INT AUTO_INCREMENT ,
    AccountID     INT NOT NULL,
    JoinDate      DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (GroupID, AccountID),
    CONSTRAINT FK_GroupAccount_Group   FOREIGN KEY (GroupID)   REFERENCES `Group`(GroupID),
    CONSTRAINT FK_GroupAccount_Account FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion (
    TypeID          INT AUTO_INCREMENT PRIMARY KEY,
    TypeName        VARCHAR(50) NOT NULL 
);

DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion (
    CategoryID      INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName    VARCHAR(50) NOT NULL 
);

DROP TABLE IF EXISTS Question;
CREATE TABLE Question (
    QuestionID      INT AUTO_INCREMENT PRIMARY KEY,
    Content         VARCHAR(500) NOT NULL,
    CategoryID      INT NOT NULL,
    TypeID          INT NOT NULL,
    CreatorID       INT NOT NULL,
    CreateDate      DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_Question_Category FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
    CONSTRAINT FK_Question_Type     FOREIGN KEY (TypeID)     REFERENCES TypeQuestion(TypeID),
    CONSTRAINT FK_Question_Account  FOREIGN KEY (CreatorID)  REFERENCES `Account`(AccountID)
    );

DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer (
    AnswerID        INT AUTO_INCREMENT PRIMARY KEY,
    Content         VARCHAR(500) NOT NULL,
    QuestionID      INT NOT NULL,
    isCorrect       BIT NOT NULL DEFAULT 0,
    CONSTRAINT FK_Answer_Question FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
    ExamID          INT AUTO_INCREMENT PRIMARY KEY,
    Code            VARCHAR(50) NOT NULL UNIQUE,
    Title           VARCHAR(50) NOT NULL,
    CategoryID      INT NOT NULL,
    Duration        INT NOT NULL,
    CreatorID       INT NOT NULL,
    CreateDate      DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_Exam_Category FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
    CONSTRAINT FK_Exam_Account  FOREIGN KEY (CreatorID)  REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion (
    ExamID          INT NOT NULL,
    QuestionID      INT NOT NULL,
    PRIMARY KEY (ExamID, QuestionID),
    CONSTRAINT FK_ExamQuestion_Exam     FOREIGN KEY (ExamID)     REFERENCES Exam(ExamID),
    CONSTRAINT FK_ExamQuestion_Question FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

INSERT INTO Department (DepartmentID, DepartmentName)
VALUES  (1,  'Marketing'    ),
        (2,  'Sale'         ),
        (3,  'Bảo vệ'       ),
        (4,  'Nhân sự'      ),
        (5,  'Kỹ thuật'     ),
        (6,  'Tài chính'    ),
        (7,  'Phó giám đốc' ),
        (8,  'Giám đốc'     ),
        (9,  'Thư kí'       ),
        (10, 'Bán hàng'     );

-- Add data Position
INSERT INTO Position (PositionID, PositionName)
VALUES  (1, 'Dev'          ),
        (2, 'Test'         ),
        (3, 'Scrum Master' ),
        (4, 'PM'           ),
        (5, 'BA'           ),
		(6,  'QA Lead'     ),
        (7,  'Tech Lead'   ),
        (8,  'DevOps'      ),
        (9,  'Designer'    ),
        (10, 'Intern'      );

-- Add data Account
INSERT INTO Account (AccountID, Email, Username, FullName, DepartmentID, PositionID, CreateDate)
VALUES  (1,  'dangnh@vti.com',  'dangblack',    'Nguyễn Hải Đăng',        5, 1, '2019-03-05'),
        (2,  'anhtq@vti.com',   'quanganh',     'Tống Quang Anh',         1, 2, '2019-03-05'),
        (3,  'chiennv@vti.com', 'vanchien',     'Nguyễn Văn Chiến',       3, 3, '2019-03-07'),
        (4,  'duongdo@vti.com', 'cocoduongqua', 'Dương Văn Thảo',         3, 4, '2019-03-08'),
        (5,  'thangnc@vti.com', 'doccocaubai',  'Nguyễn Chiến Thắng Vũ',  3, 4, '2019-03-10'),
        (6,  'khanb@vti.com',   'khabanh',      'Ngô Bá Khá',             5, 3, '2020-04-05'),
        (7,  'huanbx@vti.com',  'huanhoahong',  'Bùi Xuân Huấn',          6, 2, '2020-04-05'),
        (8,  'tamnv@vti.com',   'tamtit',       'Nguyễn Văn Tâm',         2, 1, '2020-04-07'),
        (9,  'chiendv@vti.com', 'chienthan',    'Đỗ Văn Chiến',           2, 2, '2020-04-08'),
        (10, 'toannv@vti.com',  'vantoan',      'Nguyễn Văn Toàn Thắng',  2, 1, '2020-04-09');

-- Add data Group
INSERT INTO `Group` (GroupID, GroupName, CreatorID, CreateDate)
VALUES  (1,  'Testing System',   5,  '2019-03-05'),
        (2,  'Development',      1,  '2019-03-07'),
        (3,  'VTI Sale 01',      2,  '2019-03-09'),
        (4,  'VTI Sale 02',      3,  '2019-03-10'),
        (5,  'VTI Sale 03',      4,  '2019-11-28'),
        (6,  'VTI Creator',      6,  '2020-04-06'),
        (7,  'VTI Marketing 01', 7,  '2020-04-07'),
        (8,  'Management',       8,  '2020-04-08'),
        (9,  'Chat with love',   9,  '2020-04-09'),
        (10, 'Vi Ti Ai',         10, '2020-04-10');

-- Add data GroupAccount
INSERT INTO GroupAccount (GroupID, AccountID, JoinDate)
VALUES  (1,  1,  '2019-03-05'),
        (1,  2,  '2019-03-07'),
        (2,  3,  '2019-05-09'),
        (3,  4,  '2019-08-10'),
        (3,  5,  '2019-11-28'),
        (5,  6,  '2019-12-01'),
        (6,  7,  '2020-04-07'),
        (7,  8,  '2020-04-08'),
        (8,  9,  '2020-04-09'),
        (9,  10, '2020-04-10');

-- Add data TypeQuestion
INSERT INTO TypeQuestion (TypeID, TypeName)
VALUES  (1, 'Essay'             ),
        (2, 'Multiple-Choice'   ),
        (3,  'True/False'       ),
        (4,  'Fill in the blank'),
        (5,  'Matching'         ),
        (6,  'Short Answer'     ),
        (7,  'Coding'           ),
        (8,  'Ordering'         ),
        (9,  'Case Study'       ),
        (10, 'Oral'             );

-- Add data CategoryQuestion
INSERT INTO CategoryQuestion (CategoryID, CategoryName)
VALUES  (1,  'Java'    ),
        (2,  'ASP.NET' ),
        (3,  'ADO.NET' ),
        (4,  'SQL'     ),
        (5,  'Postman' ),
        (6,  'Ruby'    ),
        (7,  'Python'  ),
        (8,  'C++'     ),
        (9,  'C Sharp' ),
        (10, 'PHP'     );

-- Add data Question
INSERT INTO Question (QuestionID, Content, CategoryID, TypeID, CreatorID, CreateDate)
VALUES  (1,  'Câu hỏi về Java',      1,  1, 1,  '2019-04-05'),
        (2,  'Câu hỏi về PHP',       10, 2, 2,  '2019-04-05'),
        (3,  'Câu hỏi về C Sharp',   9,  2, 3,  '2019-04-06'),
        (4,  'Hỏi về Ruby',          6,  1, 4,  '2019-04-06'),
        (5,  'Hỏi về Postman',       5,  1, 5,  '2019-04-06'),
        (6,  'Hỏi về ADO.NET',       3,  2, 6,  '2020-04-06'),
        (7,  'Hỏi về ASP.NET',       2,  1, 7,  '2020-04-06'),
        (8,  'Hỏi về C++',           8,  1, 8,  '2020-04-07'),
        (9,  'Hỏi về SQL',           4,  2, 9,  '2020-04-07'),
        (10, 'Hỏi về Python',        7,  1, 10, '2020-04-07');

-- Add data Answer
INSERT INTO Answer (AnswerID, Content, QuestionID, isCorrect)
VALUES  (1,  'Trả lời 01', 1, 1),
        (2,  'Trả lời 02', 1, 0),
        (3,  'Trả lời 03', 1, 0),
        (4,  'Trả lời 04', 1, 0),
        (5,  'Trả lời 05', 2, 1),
        (6,  'Trả lời 06', 2, 0),
        (7,  'Trả lời 07', 2, 0),
        (8,  'Trả lời 08', 2, 0),
        (9,  'Trả lời 09', 3, 1),
        (10, 'Trả lời 10', 4, 1);

-- Add data Exam
INSERT INTO Exam (ExamID, `Code`, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES  (1,  'VTIQ001', 'Đề thi C#',      9,  60,  5,  '2019-04-05'),
        (2,  'VTIQ002', 'Đề thi PHP',     10, 60,  2,  '2019-04-05'),
        (3,  'VTIQ003', 'Đề thi C++',     8,  120, 2,  '2019-04-07'),
        (4,  'VTIQ004', 'Đề thi Java',    1,  60,  3,  '2019-08-08'),
        (5,  'VTIQ005', 'Đề thi Ruby',    6,  45,  4,  '2019-10-10'),
        (6,  'VTIQ006', 'Đề thi Postman', 5,  60,  6,  '2020-04-05'),
        (7,  'VTIQ007', 'Đề thi SQL',     4,  60,  7,  '2020-04-05'),
        (8,  'VTIQ008', 'Đề thi Python',  7,  60,  8,  '2020-04-07'),
        (9,  'VTIQ009', 'Đề thi ADO.NET', 3,  90,  9,  '2020-04-07'),
        (10, 'VTIQ010', 'Đề thi ASP.NET', 2,  90,  10, '2020-04-08');

-- Add data ExamQuestion
INSERT INTO ExamQuestion (ExamID, QuestionID)
VALUES  (1,  5),
        (2,  10),
        (3,  4),
        (4,  3),
        (5,  7),
        (6,  1),
        (7,  2),
        (8,  6),
        (9,  9),
        (10, 8);
        
INSERT INTO department (departmentName)
SELECT 'Chờ việc'
WHERE NOT EXISTS (SELECT 1 FROM department WHERE departmentName = 'Chờ việc');
        
Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó 
DROP PROCEDURE IF EXISTS sp_get_account_by_department;
DELIMITER $$
CREATE PROCEDURE sp_get_account_by_department(IN p_department_name VARCHAR(50))
BEGIN
    SELECT  t1.AccountID,
            t1.FullName,
            t1.Email,
            t1.Username,
            t2.departmentName
    FROM account t1
    INNER JOIN department t2 ON t1.DepartmentID = t2.departmentID
    WHERE t2.departmentName = p_department_name;
END$$
DELIMITER ;
CALL sp_get_account_by_department('Sale');

Question 2: Tạo store để in ra số lượng account trong mỗi group  
DROP PROCEDURE IF EXISTS sp_count_account_in_group;
DELIMITER $$
CREATE PROCEDURE sp_count_account_in_group()
BEGIN
    SELECT  t1.GroupID,
            t1.Groupname,
            COUNT(t2.AccountID) AS SoAccount
    FROM `group` t1
    LEFT JOIN groupaccount t2 ON t1.GroupID = t2.GroupID
    GROUP BY t1.GroupID, t1.Groupname;
END$$
DELIMITER ;
CALL sp_count_account_in_group();

Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại 
DROP PROCEDURE IF EXISTS sp_count_question_by_type_this_month;
DELIMITER $$
CREATE PROCEDURE sp_count_question_by_type_this_month()
BEGIN
    SELECT  t1.TypeID,
            t1.TypeName,
            COUNT(t2.QuestionID) AS SoCauHoi
    FROM typequestion t1
    LEFT JOIN question t2
           ON t1.TypeID = t2.TypeID
          AND MONTH(t2.CreateDate) = MONTH(CURDATE())
          AND YEAR(t2.CreateDate)  = YEAR(CURDATE())
    GROUP BY t1.TypeID, t1.TypeName;
END$$
DELIMITER ;
CALL sp_count_question_by_type_this_month();

Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất 
DROP PROCEDURE IF EXISTS sp_get_type_most_question;
DELIMITER $$
CREATE PROCEDURE sp_get_type_most_question(OUT p_type_id INT)
BEGIN
    SELECT TypeID INTO p_type_id
    FROM question
    GROUP BY TypeID
    ORDER BY COUNT(QuestionID) DESC
    LIMIT 1;
END$$
DELIMITER ;
CALL sp_get_type_most_question(@type_id);
SELECT @type_id AS TypeIDNhieuNhat;

Question 5: Sử dụng store ở question 4 để tìm ra tên của type question 
DROP PROCEDURE IF EXISTS sp_get_type_name_most_question;
DELIMITER $$
CREATE PROCEDURE sp_get_type_name_most_question()
BEGIN
    DECLARE v_type_id INT;
 
    CALL sp_get_type_most_question(v_type_id);
 
    SELECT TypeID, TypeName
    FROM typequestion
    WHERE TypeID = v_type_id;
END$$
DELIMITER ;
CALL sp_get_type_name_most_question();

Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào 
DROP PROCEDURE IF EXISTS sp_search_group_or_account;
DELIMITER $$
CREATE PROCEDURE sp_search_group_or_account(IN p_keyword VARCHAR(50))
BEGIN
    -- Tìm trong bảng group
    SELECT  GroupID   AS ID,
            Groupname AS Ten,
            'Group'   AS Loai
    FROM `group`
    WHERE Groupname LIKE CONCAT('%', p_keyword, '%')
 
    UNION ALL
 
    -- Tìm trong bảng account
    SELECT  AccountID AS ID,
            Username  AS Ten,
            'Account' AS Loai
    FROM account
    WHERE Username LIKE CONCAT('%', p_keyword, '%');
END$$
DELIMITER ;
 
CALL sp_search_group_or_account('VTI');
Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:  
username sẽ giống email nhưng bỏ phần @..mail đi  	
positionID: sẽ có default là developer 
departmentID: sẽ được cho vào 1 phòng chờ 
Sau đó in ra kết quả tạo thành công 
DROP PROCEDURE IF EXISTS sp_create_account;
DELIMITER $$
CREATE PROCEDURE sp_create_account(IN p_full_name VARCHAR(50), IN p_email VARCHAR(50))
BEGIN
    DECLARE v_username      VARCHAR(50);
    DECLARE v_position_id   INT;
    DECLARE v_department_id INT;
 
    -- Cắt phần @...mail khỏi email để làm username
    SET v_username = SUBSTRING_INDEX(p_email, '@', 1);
 
    -- Lấy positionID của Dev
    SELECT positionID INTO v_position_id
    FROM position
    WHERE positionName = 'Dev'
    LIMIT 1;
 
    -- Lấy departmentID của phòng chờ việc
    SELECT departmentID INTO v_department_id
    FROM department
    WHERE departmentName = 'Chờ việc'
    LIMIT 1;
 
    INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate)
    VALUES (p_email, v_username, p_full_name, v_department_id, v_position_id, NOW());
 
    -- In ra kết quả vừa tạo
    SELECT  'Tạo account thành công' AS KetQua,
            LAST_INSERT_ID()         AS AccountID,
            p_full_name              AS FullName,
            p_email                  AS Email,
            v_username               AS Username,
            v_department_id          AS DepartmentID,
            v_position_id            AS PositionID;
END$$
DELIMITER ;
 
CALL sp_create_account('Lê Trung Tín', 'tinlt@vti.com.vn');
Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất 
DROP PROCEDURE IF EXISTS sp_longest_question_by_type;
DELIMITER $$
CREATE PROCEDURE sp_longest_question_by_type(IN p_type_name VARCHAR(50))
BEGIN
    SELECT  t1.QuestionID,
            t1.Content,
            t2.TypeName,
            LENGTH(t1.Content) AS DoDai
    FROM question t1
    INNER JOIN typequestion t2 ON t1.TypeID = t2.TypeID
    WHERE t2.TypeName = p_type_name
      AND LENGTH(t1.Content) = (
            SELECT MAX(LENGTH(q.Content))
            FROM question q
            INNER JOIN typequestion t ON q.TypeID = t.TypeID
            WHERE t.TypeName = p_type_name
      );
END$$
DELIMITER ;
CALL sp_longest_question_by_type('Essay');
CALL sp_longest_question_by_type('Multiple-Choice');

Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID 
DROP PROCEDURE IF EXISTS sp_delete_exam;
DELIMITER $$
CREATE PROCEDURE sp_delete_exam(
    IN  p_exam_id            INT,
    OUT p_examquestion_count INT,
    OUT p_exam_count         INT
)
BEGIN
    -- Xóa bảng con trước để không vi phạm khóa ngoại
    DELETE FROM examquestion WHERE ExamID = p_exam_id;
    SET p_examquestion_count = ROW_COUNT();
 
    -- Rồi xóa bảng cha
    DELETE FROM exam WHERE ExamID = p_exam_id;
    SET p_exam_count = ROW_COUNT();
END$$
DELIMITER ;

Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa) 
Sau đó in số lượng record đã remove từ các table liên quan trong khi removing 
DROP PROCEDURE IF EXISTS sp_delete_old_exams;
DELIMITER $$
CREATE PROCEDURE sp_delete_old_exams()
BEGIN
    DECLARE v_done          INT DEFAULT 0;
    DECLARE v_exam_id       INT;
    DECLARE v_eq_count      INT DEFAULT 0;
    DECLARE v_e_count       INT DEFAULT 0;
    DECLARE v_total_eq      INT DEFAULT 0;
    DECLARE v_total_exam    INT DEFAULT 0;
 
    -- Con trỏ duyệt qua các exam cũ hơn 3 năm
    DECLARE cur CURSOR FOR
        SELECT ExamID
        FROM exam
        WHERE CreateDate < DATE_SUB(CURDATE(), INTERVAL 3 YEAR);
 
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_done = 1;
 
    OPEN cur;
    vong_lap: LOOP
        FETCH cur INTO v_exam_id;
        IF v_done = 1 THEN
            LEAVE vong_lap;
        END IF;
 
        CALL sp_delete_exam(v_exam_id, v_eq_count, v_e_count);
 
        SET v_total_eq   = v_total_eq   + v_eq_count;
        SET v_total_exam = v_total_exam + v_e_count;
    END LOOP;
    CLOSE cur;
 
    SELECT  v_total_exam AS SoExamDaXoa,
            v_total_eq   AS SoExamQuestionDaXoa;
END$$
DELIMITER ;
CALL sp_delete_old_exams();
Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc 
DROP PROCEDURE IF EXISTS sp_delete_department;
DELIMITER $$
CREATE PROCEDURE sp_delete_department(IN p_department_name VARCHAR(50))
BEGIN
    DECLARE v_department_id INT;
    DECLARE v_waiting_id    INT;
    DECLARE v_moved         INT DEFAULT 0;
 
    -- Lấy ID phòng ban cần xóa
    SELECT departmentID INTO v_department_id
    FROM department
    WHERE departmentName = p_department_name
    LIMIT 1;
 
    -- Lấy ID phòng chờ việc
    SELECT departmentID INTO v_waiting_id
    FROM department
    WHERE departmentName = 'Chờ việc'
    LIMIT 1;
 
    IF v_department_id IS NULL THEN
        SELECT 'Không tìm thấy phòng ban này' AS KetQua;
 
    ELSEIF v_department_id = v_waiting_id THEN
        SELECT 'Không thể xóa phòng ban chờ việc' AS KetQua;
 
    ELSE
        -- Chuyển nhân viên sang phòng chờ việc
        UPDATE account
        SET DepartmentID = v_waiting_id
        WHERE DepartmentID = v_department_id;
 
        SET v_moved = ROW_COUNT();
 
        -- Xóa phòng ban
        DELETE FROM department WHERE departmentID = v_department_id;
 
        SELECT  'Xóa phòng ban thành công' AS KetQua,
                p_department_name          AS PhongBanDaXoa,
                v_moved                    AS SoNhanVienDaChuyen;
    END IF;
END$$
DELIMITER ;
Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay 
DROP PROCEDURE IF EXISTS sp_question_by_month_this_year;
DELIMITER $$
CREATE PROCEDURE sp_question_by_month_this_year()
BEGIN
    SELECT  MONTH(CreateDate)   AS Thang,
            YEAR(CreateDate)    AS Nam,
            COUNT(QuestionID)   AS SoCauHoi
    FROM question
    WHERE YEAR(CreateDate) = YEAR(CURDATE())
    GROUP BY YEAR(CreateDate), MONTH(CreateDate)
    ORDER BY Thang;
END$$
DELIMITER ;
CALL sp_question_by_month_this_year();
Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong  tháng") 
DROP PROCEDURE IF EXISTS sp_question_last_6_months;
DELIMITER $$
CREATE PROCEDURE sp_question_last_6_months()
BEGIN
    SELECT  t1.Thang,
            IF( COUNT(t2.QuestionID) = 0,
                'Không có câu hỏi nào trong tháng',
                CAST(COUNT(t2.QuestionID) AS CHAR)
            ) AS SoCauHoi
    FROM (
            SELECT DATE_FORMAT(CURDATE(), '%Y-%m') AS Thang
            UNION ALL SELECT DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH), '%Y-%m')
            UNION ALL SELECT DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 2 MONTH), '%Y-%m')
            UNION ALL SELECT DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 3 MONTH), '%Y-%m')
            UNION ALL SELECT DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 4 MONTH), '%Y-%m')
            UNION ALL SELECT DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 5 MONTH), '%Y-%m')
         ) AS t1
    LEFT JOIN question t2
           ON DATE_FORMAT(t2.CreateDate, '%Y-%m') = t1.Thang
    GROUP BY t1.Thang
    ORDER BY t1.Thang;
END$$
DELIMITER ; 
CALL sp_question_last_6_months();