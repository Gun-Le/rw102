DROP DATABASE IF EXISTS testing_system_assignment_6;
CREATE DATABASE testing_system_assignment_6;
USE Testing_System_Assignment_6;

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
        (10, 'Vi Ti Ai',         10, '2020-04-10')

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

-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước 
DROP TRIGGER IF EXISTS trg_group_check_createdate;
DELIMITER $$
CREATE TRIGGER trg_group_check_createdate
BEFORE INSERT ON `group`
FOR EACH ROW
BEGIN
    IF NEW.CreateDate < DATE_SUB(CURDATE(), INTERVAL 1 YEAR) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Khong the tao group co ngay tao truoc 1 nam';
    END IF;
END$$
DELIMITER ;

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user" 
DROP TRIGGER IF EXISTS trg_account_block_sale;
DELIMITER $$
CREATE TRIGGER trg_account_block_sale
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
    DECLARE v_dept_name VARCHAR(50);
 
    SELECT departmentName INTO v_dept_name
    FROM department
    WHERE departmentID = NEW.DepartmentID;
 
    IF v_dept_name = 'Sale' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
    END IF;
END$$
DELIMITER ;

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user 
DROP TRIGGER IF EXISTS trg_groupaccount_max_5;
DELIMITER $$
CREATE TRIGGER trg_groupaccount_max_5
BEFORE INSERT ON groupaccount
FOR EACH ROW
BEGIN
    DECLARE v_count INT;
 
    SELECT COUNT(*) INTO v_count
    FROM groupaccount
    WHERE GroupID = NEW.GroupID;
 
    IF v_count >= 5 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Moi group chi duoc toi da 5 user';
    END IF;
END$$
DELIMITER ;
-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question 
DROP TRIGGER IF EXISTS trg_examquestion_max_10;
DELIMITER $$
CREATE TRIGGER trg_examquestion_max_10
BEFORE INSERT ON examquestion
FOR EACH ROW
BEGIN
    DECLARE v_count INT;
 
    SELECT COUNT(*) INTO v_count
    FROM examquestion
    WHERE ExamID = NEW.ExamID;
 
    IF v_count >= 10 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Moi bai thi chi duoc toi da 10 question';
    END IF;
END$$
DELIMITER ;
-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com (đây là tài khoản admin, không cho phép user xóa), còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó 
DROP TRIGGER IF EXISTS trg_account_before_delete;
DELIMITER $$
CREATE TRIGGER trg_account_before_delete
BEFORE DELETE ON account
FOR EACH ROW
BEGIN
    IF OLD.Email = 'admin@gmail.com' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Khong the xoa tai khoan admin';
    ELSE
        -- Xóa answer của các question do user này tạo
        DELETE FROM answer
        WHERE QuestionID IN (SELECT QuestionID FROM question WHERE CreatorID = OLD.AccountID);
 
        -- Xóa examquestion liên quan tới question và exam của user này
        DELETE FROM examquestion
        WHERE QuestionID IN (SELECT QuestionID FROM question WHERE CreatorID = OLD.AccountID);
 
        DELETE FROM examquestion
        WHERE ExamID IN (SELECT ExamID FROM exam WHERE CreatorID = OLD.AccountID);
 
        -- Xóa question và exam do user này tạo
        DELETE FROM question WHERE CreatorID = OLD.AccountID;
        DELETE FROM exam     WHERE CreatorID = OLD.AccountID;
 
        -- Xóa thành viên của các group do user này tạo, rồi xóa group
        DELETE FROM groupaccount
        WHERE GroupID IN (SELECT GroupID FROM `group` WHERE CreatorID = OLD.AccountID);
 
        DELETE FROM `group` WHERE CreatorID = OLD.AccountID;
 
        -- Xóa các group mà user này tham gia
        DELETE FROM groupaccount WHERE AccountID = OLD.AccountID;
    END IF;
END$$
DELIMITER ;
-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, hãy tạo trigger cho phép người dùng khi tạo account không điền vào departmentID thì sẽ được phân vào phòng ban "waiting Department"   
INSERT INTO department (departmentName)
SELECT 'waiting Department'
WHERE NOT EXISTS (SELECT 1 FROM department WHERE departmentName = 'waiting Department');

ALTER TABLE account MODIFY DepartmentID INT NULL;

DROP TRIGGER IF EXISTS trg_account_default_department;
DELIMITER $$
CREATE TRIGGER trg_account_default_department
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
    DECLARE v_dept_id INT;

    IF NEW.DepartmentID IS NULL THEN
        SELECT departmentID INTO v_dept_id
        FROM department
        WHERE departmentName = 'waiting Department'
        LIMIT 1;

        SET NEW.DepartmentID = v_dept_id;
    END IF;
END$$
DELIMITER ;
-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng. 
DROP TRIGGER IF EXISTS trg_answer_limit;
DELIMITER $$
CREATE TRIGGER trg_answer_limit
BEFORE INSERT ON answer
FOR EACH ROW
BEGIN
    DECLARE v_total   INT;
    DECLARE v_correct INT;

    SELECT COUNT(*) INTO v_total
    FROM answer
    WHERE QuestionID = NEW.QuestionID;

    IF v_total >= 4 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Moi question chi duoc toi da 4 answer';
    END IF;

    SELECT COUNT(*) INTO v_correct
    FROM answer
    WHERE QuestionID = NEW.QuestionID AND isCorrect = 1;

    IF NEW.isCorrect = 1 AND v_correct >= 2 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Moi question chi duoc toi da 2 dap an dung';
    END IF;
END$$
DELIMITER ;
-- Question 8: Viết trigger sửa lại dữ liệu cho đúng: Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database 
ALTER TABLE account ADD COLUMN gender VARCHAR(20) NULL;

DROP TRIGGER IF EXISTS trg_account_fix_gender_insert;
DELIMITER $$
CREATE TRIGGER trg_account_fix_gender_insert
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
    IF LOWER(NEW.gender) = 'nam' THEN
        SET NEW.gender = 'M';
    ELSEIF LOWER(NEW.gender) IN ('nữ', 'nu') THEN
        SET NEW.gender = 'F';
    ELSEIF LOWER(NEW.gender) IN ('chưa xác định', 'chua xac dinh') THEN
        SET NEW.gender = 'U';
    END IF;
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS trg_account_fix_gender_update;
DELIMITER $$
CREATE TRIGGER trg_account_fix_gender_update
BEFORE UPDATE ON account
FOR EACH ROW
BEGIN
    IF LOWER(NEW.gender) = 'nam' THEN
        SET NEW.gender = 'M';
    ELSEIF LOWER(NEW.gender) IN ('nữ', 'nu') THEN
        SET NEW.gender = 'F';
    ELSEIF LOWER(NEW.gender) IN ('chưa xác định', 'chua xac dinh') THEN
        SET NEW.gender = 'U';
    END IF;
END$$
DELIMITER ;
-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày 
DROP TRIGGER IF EXISTS trg_exam_before_delete;
DELIMITER $$
CREATE TRIGGER trg_exam_before_delete
BEFORE DELETE ON exam
FOR EACH ROW
BEGIN
    IF OLD.CreateDate > DATE_SUB(NOW(), INTERVAL 2 DAY) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Khong the xoa bai thi moi tao duoc 2 ngay';
    END IF;
END$$
DELIMITER ;
-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào 
-- Trigger cho update
DROP TRIGGER IF EXISTS trg_question_before_update;
DELIMITER $$
CREATE TRIGGER trg_question_before_update
BEFORE UPDATE ON question
FOR EACH ROW
BEGIN
    DECLARE v_count INT;

    SELECT COUNT(*) INTO v_count
    FROM examquestion
    WHERE QuestionID = OLD.QuestionID;

    IF v_count > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Khong the sua question da nam trong exam';
    END IF;
END$$
DELIMITER ;

-- Trigger cho delete
DROP TRIGGER IF EXISTS trg_question_before_delete;
DELIMITER $$
CREATE TRIGGER trg_question_before_delete
BEFORE DELETE ON question
FOR EACH ROW
BEGIN
    DECLARE v_count INT;

    SELECT COUNT(*) INTO v_count
    FROM examquestion
    WHERE QuestionID = OLD.QuestionID;

    IF v_count > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Khong the xoa question da nam trong exam';
    END IF;
END$$
DELIMITER ;
