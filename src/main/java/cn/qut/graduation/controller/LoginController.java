package cn.qut.graduation.controller;

import cn.qut.graduation.pojo.SuVo;
import cn.qut.graduation.pojo.TeVo;
import cn.qut.graduation.service.StudentService;
import cn.qut.graduation.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("login")
    public String login() {
        return "login";
    }


    @PostMapping("suVerify")
    public String verify(SuVo suVo, HttpServletRequest httpServletRequest) {
        Integer sid = suVo.getSid();
        Integer pwd = suVo.getPwd();
        boolean flag = this.studentService.check(sid, pwd);
        if (flag) {
            HttpSession session = httpServletRequest.getSession();
            SuVo suvo = new SuVo();
            suvo.setSid(sid);
            suvo.setPwd(pwd);
            session.setAttribute("suLogin", suvo);
            return "redirect:index";
        }

        return "error";
    }

    @PostMapping("teVerify")
    public String verify(TeVo teVo, Model model, HttpServletRequest httpServletRequest) {
        boolean flag = this.teacherService.check(teVo);
        if (flag) {
            httpServletRequest.getSession().setAttribute("teLogin", teVo);
            return "redirect:Tindex";
        }
        return "error";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().removeAttribute("suLogin");
        return "redirect:login";
    }

    @GetMapping("tlogout")
    public String tlogout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().removeAttribute("teLogin");
        return "redirect:tlogin";
    }
}
