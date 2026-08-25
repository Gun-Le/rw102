DROP DATABASE IF EXISTS testing_system_assignment_4;
CREATE DATABASE testing_system_assignment_4;
USE Testing_System_Assignment_4;

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
        
-- Question 1: View chứa danh sách nhân viên thuộc phòng ban Sale

DROP VIEW IF EXISTS v_sale_department;
CREATE VIEW v_sale_department AS
SELECT  t1.AccountID,
        t1.FullName,
        t1.Email,
        t1.Username,
        t2.departmentName
FROM account t1
INNER JOIN department t2 ON t1.DepartmentID = t2.departmentID
WHERE t2.departmentName = 'Sale';

SELECT * 
FROM v_sale_department;

-- Question 2: View chứa thông tin các account tham gia vào nhiều group nhất
DROP VIEW IF EXISTS v_account_most_group;
CREATE VIEW v_account_most_group AS
SELECT  t1.AccountID,
        t1.FullName,
        t1.Email,
        COUNT(t2.GroupID) AS SoGroup
FROM account t1
INNER JOIN groupaccount t2 ON t1.AccountID = t2.AccountID
GROUP BY t1.AccountID, t1.FullName, t1.Email
HAVING COUNT(t2.GroupID) = (
    SELECT MAX(SoLan)
    FROM (  SELECT COUNT(GroupID) AS SoLan
            FROM groupaccount
            GROUP BY AccountID) AS tmp
);
 
SELECT * 
FROM v_account_most_group;

-- Question 3: View chứa câu hỏi có content quá dài (> 300) rồi xóa nó đi
DROP VIEW IF EXISTS v_question_too_long;
CREATE VIEW v_question_too_long AS
SELECT  QuestionID,
        Content,
        CategoryID,
        TypeID,
        CreatorID,
        CreateDate
FROM question
WHERE LENGTH(Content) > 300;

SELECT * 
FROM v_question_too_long;

DELETE FROM answer
WHERE QuestionID IN (SELECT QuestionID FROM (SELECT QuestionID FROM v_question_too_long) AS tmp);
 
DELETE FROM examquestion
WHERE QuestionID IN (SELECT QuestionID FROM (SELECT QuestionID FROM v_question_too_long) AS tmp);

DELETE FROM v_question_too_long;

SELECT * 
FROM v_question_too_long;

-- Question 4: View chứa danh sách các phòng ban có nhiều nhân viên nhất
DROP VIEW IF EXISTS v_department_most_account;
CREATE VIEW v_department_most_account AS
SELECT  t1.departmentID,
        t1.departmentName,
        COUNT(t2.AccountID) AS SoNhanVien
FROM department t1
INNER JOIN account t2 ON t1.departmentID = t2.DepartmentID
GROUP BY t1.departmentID, t1.departmentName
HAVING COUNT(t2.AccountID) = (
    SELECT MAX(SoLan)
    FROM (  SELECT COUNT(AccountID) AS SoLan
            FROM account
            GROUP BY DepartmentID) AS tmp
);
 
SELECT * 
FROM v_department_most_account;

-- Question 5: View chứa tất cả các câu hỏi do user họ Nguyễn tạo
DROP VIEW IF EXISTS v_question_by_nguyen;
CREATE VIEW v_question_by_nguyen AS
SELECT  t1.QuestionID,
        t1.Content,
        t1.CategoryID,
        t1.TypeID,
        t1.CreateDate,
        t2.FullName AS NguoiTao
FROM question t1
INNER JOIN account t2 ON t1.CreatorID = t2.AccountID
WHERE t2.FullName LIKE 'Nguyễn%';
 
SELECT * 
FROM v_question_by_nguyen;