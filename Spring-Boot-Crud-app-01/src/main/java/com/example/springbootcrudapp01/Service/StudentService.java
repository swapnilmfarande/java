package com.example.springbootcrudapp01.Service;

import com.example.springbootcrudapp01.Dao.StudentRepository;
import com.example.springbootcrudapp01.Model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    StudentRepository studentRepository;
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();

    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    public void addAllStudent(List<Student> students) {
        studentRepository.saveAll(students);
    }

    public Optional<Student> getStudentById(int studentId) {
        return studentRepository.findById(studentId);
    }
}
