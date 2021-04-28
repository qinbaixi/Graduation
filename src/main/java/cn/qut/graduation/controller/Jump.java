package cn.qut.graduation.controller;

import cn.qut.graduation.pojo.HCommit;
import cn.qut.graduation.pojo.Homework;
import cn.qut.graduation.pojo.Student;
import cn.qut.graduation.pojo.SuVo;
import cn.qut.graduation.service.HCommitService;
import cn.qut.graduation.service.HomeworkService;
import cn.qut.graduation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class Jump {

    @Autowired
    private StudentService studentService;
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private HCommitService hCommitService;

    /**
     * 跳转首页
     * @param model
     * @param httpServletRequest
     * @return
     */
    @GetMapping("index")
    public String testIndex(Model model, HttpServletRequest httpServletRequest) {
        SuVo suLogin = (SuVo) httpServletRequest.getSession().getAttribute("suLogin");
        String name = this.studentService.getNameBySid(suLogin.getSid());
        model.addAttribute("suName", name);
        return "index";
    }


    @GetMapping("studentInfo")
    public String jumpStuInfo(HttpServletRequest httpServletRequest, Model model) {
        SuVo suLogin = (SuVo) httpServletRequest.getSession().getAttribute("suLogin");
        System.out.println(suLogin.toString());
       Student student= this.studentService.getStuBySid(suLogin.getSid());
        model.addAttribute("su", student);
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
     * 跳转已交作业列表
     *
     * @return
     */
    @GetMapping("hcommit")
    public String jumpToHcommit( HttpServletRequest httpServletRequest,Model model) {
        SuVo suLogin = (SuVo) httpServletRequest.getSession().getAttribute("suLogin");
        System.out.println(suLogin.toString());
        Integer id = studentService.getIdBySid(suLogin.getSid());
        //获取提交列表
        List<HCommit> allBySid = this.hCommitService.getAllBySid(id);
        //加载页面name
        String name = this.studentService.getNameBySid(suLogin.getSid());
        model.addAttribute("suName", name);

        model.addAttribute("hcList", allBySid);

        return "hcommitList";
    }
}
