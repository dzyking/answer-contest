package com.answer.contest.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dzy
 * @date 2020/6/29
 * @desc
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String test(){
        return "index";
    }
}
