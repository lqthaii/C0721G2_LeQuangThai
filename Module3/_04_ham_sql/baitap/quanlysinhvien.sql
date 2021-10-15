drop database if exists QuanLySinhVien;

CREATE DATABASE QuanLySinhVien;

USE QuanLySinhVien;

CREATE TABLE Class
(
    ClassID   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ClassName VARCHAR(60) NOT NULL,
    StartDate DATETIME    NOT NULL,
    Status    BIT
);

CREATE TABLE Student
(
    StudentId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    StudentName VARCHAR(30) NOT NULL,
    Address     VARCHAR(50),
    Phone       VARCHAR(20),
    Status      BIT,
    ClassId     INT         NOT NULL,
    FOREIGN KEY (ClassId) REFERENCES Class (ClassID)
);

CREATE TABLE Subject
(
    SubId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubName VARCHAR(30) NOT NULL,
    Credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    Status  BIT                  DEFAULT 1
);

CREATE TABLE Mark
(
    MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);

INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);

INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (5, 'HDJ', 6, 1),
       (4, 'RDBMS', 10, 1);
       
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
       
SELECT * FROM student
WHERE StudentName LIKE "h%";       

SELECT * FROM class
WHERE month(StartDate) =12;

SELECT * FROM `subject`
WHERE Credit <=5 AND Credit >=3;

UPDATE student 
SET student.ClassId=2
WHERE student.StudentName = "Hung";

SELECT student.StudentName , `subject`.SubName, mark.Mark
FROM student join mark
on student.StudentId = mark.StudentId
join `subject` 
on mark.SubId = `subject`.SubId
ORDER BY mark.Mark DESC, student.StudentName ASC;


/*Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.*/
SELECT * FROM `subject`
where `subject`.credit = (select max(`subject`.credit) from `subject`);

/*Hiển thị các thông tin môn học có điểm thi lớn nhất*/
SELECT `subject`.SubId, SubName, Credit, `Status` FROM `subject` 
join mark  on `subject`.SubId = mark.SubId
where mark.Mark = (select max(mark.Mark) from mark);

/*Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần*/
SELECT student.studentid, student.StudentName, avg(mark.mark) "Diem TB"
FROM student
join mark on student.StudentId = mark.StudentId
group by mark.studentid
order by avg(mark.mark) desc;





