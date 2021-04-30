package cn.qut.graduation.controller;

import cn.qut.graduation.annotation.LoginRequired;
import cn.qut.graduation.pojo.*;
import cn.qut.graduation.service.HCommitService;
import cn.qut.graduation.service.HomeworkService;
import cn.qut.graduation.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    @LoginRequired
    public String testIndex(Model model, HttpServletRequest httpServletRequest) {
        SuVo suLogin = (SuVo) httpServletRequest.getSession().getAttribute("suLogin");
        String name = this.studentService.getNameBySid(suLogin.getSid());
        model.addAttribute("suName", name);
        return "index";
    }

    /**
     * 学生详情
     * @param httpServletRequest
     * @param model
     * @return
     */
    @LoginRequired
    @GetMapping("studentInfo")
    public String jumpStuInfo(HttpServletRequest httpServletRequest, Model model) {
        SuVo suLogin = (SuVo) httpServletRequest.getSession().getAttribute("suLogin");
//        System.out.println(suLogin.toString());
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
    @LoginRequired
    public String jumpToHomework(Model model,HttpServletRequest httpServletRequest) {
        SuVo suLogin = (SuVo) httpServletRequest.getSession().getAttribute("suLogin");
        Integer sid = suLogin.getSid();
        String name = this.studentService.getNameBySid(sid);
        model.addAttribute("suName", name);

        List<HomeworkVo> hwVoList = homeworkService.getHwVoList(sid);
        model.addAttribute("hwList", hwVoList);


        return "homeworkList";
    }

    /**
     * 跳转已交作业列表
     *
     * @return
     */
    @GetMapping("hcommit")
    @LoginRequired
    public String jumpToHcommit( HttpServletRequest httpServletRequest,Model model) {
        SuVo suLogin = (SuVo) httpServletRequest.getSession().getAttribute("suLogin");
//        System.out.println(suLogin.toString());
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
