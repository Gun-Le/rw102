DROP DATABASE IF EXISTS testing_system_assignment_2;
CREATE DATABASE testing_system_assignment_2;
USE Testing_System_Assignment_2;

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
        
-- Question 2: Lấy ra tất cả các phòng ban
SELECT * 
FROM Department;

-- Question 3: Lấy ra id của phòng ban "Sale"
SELECT DepartmentID
FROM Department
WHERE DepartmentName = 'Sale';

-- Question 4: Lấy ra thông tin account có full name dài nhất
SELECT *
FROM Account
ORDER BY LENGTH(FullName) DESC
LIMIT 1;

-- Question 5: Full name dài nhất và thuộc phòng ban id = 3
SELECT *
FROM Account
WHERE DepartmentID = 3
ORDER BY LENGTH(FullName) DESC
LIMIT 1;

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT DISTINCT t1.GroupName
FROM `Group` t1
LEFT JOIN GroupAccount t2 ON t1.GroupID = t2.GroupID
WHERE t2.JoinDate < '2019-12-20';

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT QuestionID
FROM Answer
GROUP BY QuestionID
HAVING COUNT(AnswerID) >= 4;

-- Question 8: Mã đề thi có thời gian thi >= 60 phút và được tạo trước 20/12/2019
SELECT `Code`
FROM Exam
WHERE Duration >= 60
  AND CreateDate < '2019-12-20';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT *
FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(AccountID) AS SoNhanVien
FROM Account
WHERE DepartmentID = 2;

-- Question 11: Nhân viên có tên bắt đầu bằng "D" và kết thúc bằng "o"
SELECT *
FROM Account
WHERE FullName LIKE 'D%o';

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019

DELETE t2
FROM ExamQuestion t2
LEFT JOIN Exam t1 ON t1.ExamID = t2.ExamID
WHERE t1.CreateDate < '2019-12-20';

DELETE FROM Exam
WHERE CreateDate < '2019-12-20';

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE t2
FROM Answer t2
LEFT JOIN Question t1 ON t1.QuestionID = t2.QuestionID
WHERE t1.Content LIKE 'câu hỏi%';

DELETE t3
FROM ExamQuestion t3
LEFT JOIN Question t1 ON t1.QuestionID = t3.QuestionID
WHERE t1.Content LIKE 'câu hỏi%';

DELETE FROM Question
WHERE Content LIKE 'câu hỏi%';

-- Question 14: Update account id = 5
UPDATE Account
SET FullName = 'Nguyễn Bá Lộc',
    Email    = 'loc.nguyenba@vti.com.vn'
WHERE AccountID = 5;

-- Question 15: Update account id = 5 thuộc group id = 4
UPDATE GroupAccount
SET GroupID = 4
WHERE AccountID = 5;
