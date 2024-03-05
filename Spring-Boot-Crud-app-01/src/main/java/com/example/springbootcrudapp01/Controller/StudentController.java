package com.example.springbootcrudapp01.Controller;

import com.example.springbootcrudapp01.Model.Student;
import com.example.springbootcrudapp01.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    StudentService studentService;

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @DeleteMapping
    public void deleteStudent(@RequestBody Student student){
        studentService.deleteStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable("id") int id){
        studentService.deleteStudentById(id);
    }

    @PostMapping("/bulk")
    public void addAllStudent(@RequestBody List<Student> students){
        studentService.addAllStudent(students);
    }

    @GetMapping("/{studentId}")
    public Optional<Student> getStudentById(@PathVariable ("studentId") int studentId){
        return studentService.getStudentById(studentId);
    }



}
