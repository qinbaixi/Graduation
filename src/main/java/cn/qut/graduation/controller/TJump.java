package cn.qut.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TJump {


    @GetMapping("Tindex")
    public String jumpIndex() {
        return "Tindex";
    }
}
