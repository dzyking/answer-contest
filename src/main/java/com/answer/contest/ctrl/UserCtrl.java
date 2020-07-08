package com.answer.contest.ctrl;

import com.answer.contest.dto.UserDTO;
import com.answer.contest.entity.Result;
import com.answer.contest.serv.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserCtrl {

    @Autowired
    private UserServ userServ;

    @PostMapping("login")
    public Result login(@RequestBody UserDTO userDTO){
        return userServ.login(userDTO);
    }

    @GetMapping("addUser")
    public void addUser(){
        userServ.addUser();
    }

    @GetMapping("addRecord")
    public void addRecord(){
        userServ.addRecord();
    }
}
