package cn.qut.graduation.controller;

import cn.qut.graduation.pojo.HCommit;
import cn.qut.graduation.pojo.Homework;
import cn.qut.graduation.pojo.Student;
import cn.qut.graduation.service.HCommitService;
import cn.qut.graduation.service.HomeworkService;
import cn.qut.graduation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TJump {
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private HCommitService hCommitService;


    @GetMapping("Tindex")
    public String jumpIndex() {
        return "Tindex";
    }


    @GetMapping("ThomeworkList")
    public String jumpToHomeworkList(Model model) {
        List<Homework> hwList = homeworkService.getHwList();
        model.addAttribute("hwList", hwList);
        return "ThomeworkList";
    }

    @GetMapping("TstudentList")
    public String jumpToTstudentList(Model model) {

        List<Student> allStudents = this.studentService.getAllStudentsandPwd();
        model.addAttribute("suList", allStudents);
        return "TstudentList";
    }

    @GetMapping("ThcommitList")
    public String jumpToHCommit(Model model) {
        List<HCommit> hCommitList = this.hCommitService.getAll();
        model.addAttribute("hcList", hCommitList);
        return "ThcommitList";
    }

}
