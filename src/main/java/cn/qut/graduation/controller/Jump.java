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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Jump {

    @Autowired
    private StudentService studentService;
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private HCommitService hCommitService;

    @GetMapping("index")
    public ModelAndView testIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("testStuInfo")
    public String testStuInfo() {
        return "studentInfo";
    }

    /**
     * 学生信息跳转
     *
     * @return
     */
    @GetMapping("studentInfo2/{id}")
    public String jumpStuInfo(Model model, @PathVariable(name = "id") String strId) {

        Integer id = Integer.parseInt(strId);
        Student stuByIdAndPwd = studentService.getStuByIdAndPwd(id);
        model.addAttribute("stu", stuByIdAndPwd);
        return "studentInfo2";
    }

    @GetMapping("studentInfo")
    public String jumpStuInfo() {
        return "studentInfo";
    }

    /**
     * 作业页面跳转
     *
     * @param model
     * @return
     */
    @GetMapping("homeworkList")
    public String jumpToHomework(Model model) {
        List<Homework> hwList = homeworkService.getHwList();
        model.addAttribute("hwList", hwList);
        return "homeworkList";
    }

    /**
     * 跳转已作业列表
     *
     * @return
     */
    @GetMapping("hcommit/{sid}")
    public String jumpToHcommit(@PathVariable(name = "sid", required = false) Integer sid, Model model) {
        if (sid != null && !sid.equals("")) {
            List<HCommit> hCommitList = hCommitService.getAllById(sid);
            model.addAttribute("hcList", hCommitList);
        }

        return "hcommitList";
    }
}
