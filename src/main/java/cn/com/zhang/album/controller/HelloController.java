package cn.com.zhang.album.controller;

import cn.com.zhang.album.dao.impl.UserRepository;
import cn.com.zhang.album.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class HelloController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    public String hello(ModelMap map) {
//        User user = new User();
//        user.setName("zz");
//        user.setPassword("123");
//        userRepository.save(user);
        Optional<User> newU = userRepository.findById(6L);
        System.out.println(newU);
        map.addAttribute("HELLO","ABCD");
        map.addAttribute("USER",newU.get());

        List<String> listA = new ArrayList<>();
        listA.add("1");
        listA.add("2");
        List<String> listB = new ArrayList<>();
        listB.add("3");
        listB.add("4");
        map.addAttribute("LIST_A",listA);
        map.addAttribute("LIST_B",listB);
        return "hello";
    }
}
