package cn.com.zhang.album.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(ModelMap map) {
        map.addAttribute("HELLO","HI!");
        return "hello";
    }
}
