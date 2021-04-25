package cn.qut.graduation.controller;

import cn.qut.graduation.pojo.Teacher;
import cn.qut.graduation.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    @GetMapping("getAll")
    public ResponseEntity<List<Teacher>> getAll() {
        List<Teacher> teacherList = teacherService.getAll();
        if (teacherList.size() < 1) {
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teacherList);
    }
}
