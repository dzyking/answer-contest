package com.answer.contest.ctrl;

import com.answer.contest.dto.QuestionDTO;
import com.answer.contest.entity.Result;
import com.answer.contest.serv.QuestionServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author dzy
 * @date 2020/6/28
 * @desc
 */
@RestController
@RequestMapping("question")
public class QuestionCtrl {

    @Autowired
    private QuestionServ questionServ;

    @GetMapping("getQuestionById")
    public Result getQuestionById(@RequestParam(name = "questionId") Integer questionId){
        return new Result().genSuccessResult(questionServ.getQuestionById(questionId));
    }

    @PostMapping("answer")
    public Result answer(@RequestBody QuestionDTO questionDTO){
        return new Result().genSuccessResult(questionServ.answer(questionDTO));
    }

    @GetMapping("getAchievement")
    public Result getAchievement(){
        return new Result().genSuccessResult(questionServ.getAchievement());
    }

    @GetMapping("add")
    public void add(QuestionDTO question){
        questionServ.add(question);
    }

}
