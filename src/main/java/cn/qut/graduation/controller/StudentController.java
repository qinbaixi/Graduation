package cn.qut.graduation.controller;

import cn.qut.graduation.pojo.Student;
import cn.qut.graduation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("stuInfo/{id}")
    public ResponseEntity<Student> getStuById(@PathVariable(name = "id",required = true) Integer id) {
        Student stuByIdAndPwd = this.studentService.getStuByIdAndPwd(id);
        return ResponseEntity.ok(stuByIdAndPwd);
    }
 /*     @GetMapping("stuInfo/{id}")
    public String getStuById(@PathVariable(name = "id",required = true) Integer id,Model model) {
        Student stuByIdAndPwd = this.studentService.getStuByIdAndPwd(id);
          model.addAttribute("stu", stuByIdAndPwd);
          return "redirect:studentInfo";*/



}
