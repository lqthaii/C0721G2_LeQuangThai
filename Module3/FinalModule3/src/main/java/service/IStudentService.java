package repository;


import model.Student;

import java.util.List;

public interface IStudentRepository {
    public List<Student> getAllStudent();
    public Student getStudent(String id);
    public void addStudent(Student student);
    public void deleteStudent(int id);
    public void updateStudent(Student student);
    public List<Student> searchStudent(String name);
}
