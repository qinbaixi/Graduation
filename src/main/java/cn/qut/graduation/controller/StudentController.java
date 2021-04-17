package cn.qut.graduation.controller;

import cn.qut.graduation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;


}
