package cn.qut.graduation.controller;

import cn.qut.graduation.dao.HomeworkDao;
import cn.qut.graduation.pojo.Homework;
import cn.qut.graduation.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("homework")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    @GetMapping
    public ResponseEntity<List<Homework>> getHwList() {
       List<Homework> homeworkList =  homeworkService.getHwList();
        return ResponseEntity.ok(homeworkList);

    }
}
