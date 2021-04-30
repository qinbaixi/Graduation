package cn.qut.graduation.controller;

import cn.qut.graduation.annotation.LoginRequired;
import cn.qut.graduation.pojo.*;
import cn.qut.graduation.service.HCommitService;
import cn.qut.graduation.service.HomeworkService;
import cn.qut.graduation.service.StudentService;
import cn.qut.graduation.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TJump {
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private HCommitService hCommitService;
    @Autowired
    private TeacherService teacherService;


    @GetMapping("tlogin")
    public String jumpToTLogin() {
        return "Tlogin";
    }


    @GetMapping("Tindex")
    @LoginRequired
    public String jumpIndex(Model model, HttpServletRequest httpServletRequest) {
        TeVo teVo = (TeVo) httpServletRequest.getSession().getAttribute("teLogin");
        String name = this.teacherService.getNameByTid(teVo.getTid());
        model.addAttribute("teName", name);
        return "Tindex";
    }

    @LoginRequired
    @GetMapping("ThomeworkList")
    public String jumpToHomeworkList(Model model,HttpServletRequest httpServletRequest) {
        List<Homework> hwList = homeworkService.getHwList();
        model.addAttribute("hwList", hwList);

        TeVo teVo = (TeVo) httpServletRequest.getSession().getAttribute("teLogin");
        String name = this.teacherService.getNameByTid(teVo.getTid());
        model.addAttribute("teName", name);
        return "ThomeworkList";
    }

    @LoginRequired
    @GetMapping("TstudentList")
    public String jumpToTstudentList(Model model, HttpServletRequest httpServletRequest) {

        TeVo teVo = (TeVo) httpServletRequest.getSession().getAttribute("teLogin");
        String name = this.teacherService.getNameByTid(teVo.getTid());
        model.addAttribute("teName", name);

        List<Student> allStudents = this.studentService.getAllStudentsandPwd();
        model.addAttribute("suList", allStudents);
        return "TstudentList";
    }

    @LoginRequired
    @GetMapping("ThcommitList")
    public String jumpToHCommit(Model model, HttpServletRequest httpServletRequest) {
        TeVo teVo = (TeVo) httpServletRequest.getSession().getAttribute("teLogin");
        String name = this.teacherService.getNameByTid(teVo.getTid());
        model.addAttribute("teName", name);

        List<HCommit> hCommitList = this.hCommitService.getAll();
        model.addAttribute("hcList", hCommitList);
        return "ThcommitList";
    }

    /**
     * 教师评分操作
     * @param score
     * @param idExtension
     * @return
     */
    @PostMapping("updateScore")
    public String updateScore(@RequestParam(name = "score") Integer score, IdExtension idExtension) {
        HCommit hCommit = new HCommit();
        hCommit.setScore(score);
        hCommit.setId( idExtension);
        this.hCommitService.save(hCommit);
        return "redirect:ThcommitList";
    }

}
