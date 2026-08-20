DROP DATABASE IF EXISTS Testing_System_Assignment_1;
CREATE DATABASE Testing_System_Assignment_1;
USE Testing_System_Assignment_1;

---Table 1:Department ---
----DepartmentID:  định danh của phòng ban (auto increment) ----
----DepartmentName: tên đầy đủ của phòng ban (VD: sale, marketing, …) ----
DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
    DepartmentID    INT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName  VARCHAR(50) NOT NULL 
);
SELECT * 
FROM Department;

-----Table 2: Position -----
-----PositionID:  định danh của chức vụ (auto increment)----- 
-----PositionName: tên chức vụ (Dev, Test, Scrum Master, PM)-----
DROP TABLE IF EXISTS Position;
CREATE TABLE Position (
    PositionID    INT AUTO_INCREMENT PRIMARY KEY,
    PositionName  VARCHAR(50) NOT NULL 
);
SELECT * 
FROM Position ;

----Table 3: Account-------
----AccountID:  định danh của User (auto increment) ----
----Email:  Địa chỉ email----
----Username:  tên đăng nhập----
----FullName:  tên đầy đủ----
----DepartmentID: phòng ban của user trong hệ thống---- 
----PositionID: chức vụ của User---- 
----CreateDate: ngày tạo tài khoản---- 
DROP TABLE IF EXISTS Account;
CREATE TABLE Account (
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
SELECT * 
FROM Account ;

----Table 4: Group  ----
----GroupID:  định danh của nhóm (auto increment)---- 
----GroupName:  tên nhóm ----
----CreatorID: id của người tạo group---- 
----CreateDate: ngày tạo group---- 

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group` (
    GroupID       INT AUTO_INCREMENT PRIMARY KEY,
    Groupname     VARCHAR(50) NOT NULL,
	CreatorID     INT NOT NULL,
    CreateDate    DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_Group_Acc FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);
SELECT * 
FROM `Group`; 

----Table 5: GroupAccount ---- 
----GroupID:  định danh của nhóm ----
----AccountID:  định danh của User ----
----JoinDate: Ngày user tham gia vào nhóm ----
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount (
    GroupID       INT AUTO_INCREMENT ,
    AccountID     INT NOT NULL,
    JoinDate      DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (GroupID, AccountID),
    CONSTRAINT FK_GroupAccount_Group   FOREIGN KEY (GroupID)   REFERENCES `Group`(GroupID),
    CONSTRAINT FK_GroupAccount_Account FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID)
);
SELECT  *
FROM GroupAccount;

----Table 6: TypeQuestion ----
----TypeID:  định danh của loại câu hỏi (auto increment) ----
----TypeName:  tên của loại câu hỏi (Essay, Multiple-Choice) ----
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion (
    TypeID          INT AUTO_INCREMENT PRIMARY KEY,
    TypeName        VARCHAR(50) NOT NULL 
);
SELECT *
FROM TypeQuestion;

----Table 7: CategoryQuestion ----
----CategoryID:  định danh của chủ đề câu hỏi (auto increment)---- 
----CategoryName:  tên của chủ đề câu hỏi (Java, .NET, SQL, Postman, Ruby, …) ----
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion (
    CategoryID      INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName    VARCHAR(50) NOT NULL 
);
SELECT *
FROM CategoryQuestion; 

----Table 8: Question ---- 
----QuestionID:  định danh của câu hỏi (auto increment) ----
----Content:  nội dung của câu hỏi ----
----CategoryID:  định danh của chủ đề câu hỏi ----
----TypeID:  định danh của loại câu hỏi ----
----CreatorID: id của người tạo câu hỏi ----
----CreateDate: ngày tạo câu hỏi---- 

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
SELECT *
FROM Question;

----Table 9: Answer ----
----AnswerID:  định danh của câu trả lời (auto increment) ----
----Content:  nội dung của câu trả lời ----
----QuestionID:  định danh của câu hỏi ---- 
----isCorrect: câu trả lời này đúng hay sai ----
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer (
    AnswerID        INT AUTO_INCREMENT PRIMARY KEY,
    Content         VARCHAR(500) NOT NULL,
    QuestionID      INT NOT NULL,
    isCorrect       BIT NOT NULL DEFAULT 0,
    CONSTRAINT FK_Answer_Question FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);
SELECT *
FROM Answer;

----Table 10: Exam ---- 
----ExamID:  định danh của đề thi (auto increment)---- 
----Code: mã đề thi ----
----Title: tiêu đề của đề thi ----
----CategoryID:  định danh của chủ đề thi ----
----Duration: thời gian thi ----
----CreatorID: id của người tạo đề thi---- 
----CreateDate: ngày tạo đề thi---- 
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
SELECT * 
FROM Exam;

----Table 11: ExamQuestion----  
----ExamID:  định danh của đề thi ----
----QuestionID:  định danh của câu hỏi ----
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion (
    ExamID          INT NOT NULL,
    QuestionID      INT NOT NULL,
    PRIMARY KEY (ExamID, QuestionID),
    CONSTRAINT FK_ExamQuestion_Exam     FOREIGN KEY (ExamID)     REFERENCES Exam(ExamID),
    CONSTRAINT FK_ExamQuestion_Question FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

SELECT *
FROM Department
EX2: 
Table 1: 
INSERT INTO Department (DepartmentID, DepartmentName)
VALUES
    (1,  'Marketing'    ),
    (2,  'Sale'         ),
    (3,  'Bảo vệ'       ),
    (4,  'Nhân sự'      ),
    (5,  'Kỹ thuật'     ),
    (6,  'Tài chính'    ),
    (7,  'Phó giám đốc' ),
    (8,  'Giám đốc'     ),
    (9,  'Thư kí'       ),
    (10, 'Bán hàng'     );

 Table 2: 
INSERT INTO `Position` (PositionID, PositionName)
VALUES
    (1, 'Dev'          ),
    (2, 'Test'         ),
    (3, 'Scrum Master' ),
    (4, 'PM'           ),
    (5, 'BA'           );
SELECT * 
FROM Position; 

Table 3: 
INSERT INTO `Account` (AccountID, Email, Username, FullName, DepartmentID, PositionID, CreateDate)
VALUES
    (1, 'nguyenvana@gmail.com',   'ngvana',   N'Nguyễn Văn A',  5, 1, '2024-01-05'),
    (2, 'levanb@gmail.com',  'levanb',  N'Lê Văn B', 5, 2, '2024-02-10'),
    (3, 'tranvanc@gmail.com', 'tranvc', N'Trần Văn C',   1, 4, '2024-03-15'),
    (4, 'dothid@gmail.com',  'dothid',  N'Đỗ Thị D',   4, 3, '2024-04-20'),
    (5, 'caobae@gmail.com','caoba', N'Cao Bá E',     6, 5, '2024-05-25');
SELECT *
FROM Account;

Table 4: 
INSERT INTO `Group` (GroupID, GroupName, CreatorID, CreateDate)
VALUES
    (1, N'Java Fresher',       1, '2024-07-01'),
    (2, N'Front End',          2, '2024-07-05'),
    (3, N'Mock Project',       3, '2024-07-10'),
    (4, N'Ôn tập Python',      4, '2024-07-15'),
    (5, N'SQL Nâng cao',       5, '2024-07-20');
SELECT *
FROM `Group`;

Table 5: 
INSERT INTO GroupAccount (GroupID, AccountID, JoinDate)
VALUES
    (1, 1, '2024-07-02'),
    (1, 2, '2024-07-03'),
    (2, 2, '2024-07-06'),
    (3, 3, '2024-07-11'),
    (4, 4, '2024-07-16'),
    (5, 5, '2024-07-21');
SELECT * 
FROM GroupAccount; 

Table 6: 
INSERT INTO TypeQuestion (TypeID, TypeName)
VALUES
    (1, N'Essay'             ),
    (2, N'Multiple-Choice'   ),
    (3, N'True-False'        ),
    (4, N'Fill in the blank' ),
    (5, N'Matching'          );
SELECT *
FROM TypeQuestion; 

Table 7: 
INSERT INTO CategoryQuestion (CategoryID, CategoryName)
VALUES
    (1, 'Java'),
    (2, 'Python'),
    (3, 'SQL'),
    (4, 'Rust'),
    (5, 'Ruby');
SELECT * 
FROM CategoryQuestion

Table 8: 
INSERT INTO Question (QuestionID, Content, CategoryID, TypeID, CreatorID, CreateDate)
VALUES
    (1, 'Java là ngôn ngữ lập trình gì?',                    1, 2, 1, '2024-08-01'),
    (2, 'Python vì sao phổ biến',                            2, 1, 2, '2024-08-02'),
    (3, 'Lệnh nào dùng để lấy dữ liệu từ bảng trong SQL?',   3, 2, 3, '2024-08-03'),
    (4, 'Rust là ngôn ngữ lập trình như nào?',               4, 2, 4, '2024-08-04'),
    (5, 'Ruby on Rails là gì?',                              5, 1, 5, '2024-08-05');
SELECT * 
FROM Question;

Table 9:
INSERT INTO Answer (AnswerID, Content, QuestionID, isCorrect)
VALUES
    (1, 'Ngôn ngữ lập trình hướng đối tượng', 1, 1),
    (2, 'Ngôn ngữ chỉ chạy trên Windows',     1, 0),
    (3, 'Một loại cà phê',                    1, 0),
    (4, 'SELECT',                             3, 1),
    (5, 'API',                                4, 1);
SELECT * 
FROM Answer;

Table 10: 

INSERT INTO Exam (ExamID, Code, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES
    (1, 'DE01', N'Đề thi Java cơ bản',                1, 60, 1, '2024-09-01'),
    (2, 'DE02', N'Đề thi Python đầu vào',             2, 60, 2, '2024-09-02'),
    (3, 'DE03', N'Đề thi SQL cơ bản',                 3, 45, 3, '2024-09-03'),
    (4, 'DE04', N'Kiểm tra thường xuyên Rust',        4, 30, 4, '2024-09-04'),
    (5, 'DE05', N'Đề thi Ruby nâng cao',              5, 90, 5, '2024-09-05');
SELECT * 
FROM Exam; 

Table 11: 
INSERT INTO ExamQuestion (ExamID, QuestionID)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (1, 3);
SELECT * 
FROM ExamQuestion; 
