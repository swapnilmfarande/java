package com.app.Service;

import com.app.Dao.StudentDao;
import com.app.Model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    StudentDao studentDao;

    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    public Student getStudentById(int StudentId){
       return studentDao.getStudentById(StudentId);
    }

    public List<Student> getAllStudentByAllField(Student student){
        return studentDao.getAllStudentByAllfield(student);
    }

    public void addStudent(Student student){
        studentDao.addStudent(student);
    }

}