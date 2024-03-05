package com.app.Controller;

import com.app.Model.Student;
import com.app.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    StudentService service;

 @GetMapping

    public ModelAndView getAllStudent(){
        List<Student> studentList = service.getAllStudent();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student");
        modelAndView.addObject("students",studentList);
        studentList.forEach(System.out::println);
        return modelAndView;
    }

 @GetMapping("/{studentId}")

    public ModelAndView getStudentById(@PathVariable("studentId") int studentId){
     ModelAndView modelAndView = new ModelAndView();
     modelAndView.setViewName("studentById");
     modelAndView.addObject("studentById",service.getStudentById(studentId));
     return modelAndView;
 }

 @GetMapping("/filter1")

    public ModelAndView filterStudent(
     @RequestParam(value = "id",required = false) int StudentId,
     @RequestParam(value = "name",required = false) String StudentName,
     @RequestParam(value = "city",required = false) String StudentCity,
     @RequestParam(value = "phone",required = false) int StudentPhone){

     Student student = Student.builder()
             .StudentId(StudentId)
             .StudentName(StudentName)
             .StudentCity(StudentCity)
             .StudentPhone(StudentPhone)
             .build();
     List<Student> studentList = service.getAllStudentByAllField(student);
     ModelAndView modelAndView = new ModelAndView();
     modelAndView.setViewName("list");
     modelAndView.addObject("studentList",studentList);
     return modelAndView;
 }


 @GetMapping("/create")
    public ModelAndView StudentForm(){
     ModelAndView modelAndView = new ModelAndView();
     modelAndView.setViewName("studentForm");
     return modelAndView;
 }

 @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student){
     service.addStudent(student);
     return "redirect:/student";
 }


}
