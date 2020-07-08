package com.answer.contest.ctrl;

import com.answer.contest.dto.VoteDTO;
import com.answer.contest.entity.Result;
import com.answer.contest.serv.VoteServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author dzy
 * @date 2020/7/1
 * @desc
 */
@RestController
@RequestMapping("vote")
public class VoteCtrl {

    @Autowired
    private VoteServ voteServ;

    @GetMapping("getGroupList")
    public Result getGroupList(@RequestParam(name = "userId") Integer userId){
        return new Result().genSuccessResult(voteServ.getGroupList(userId));
    }

    @PostMapping("add")
    public Result add(@RequestBody VoteDTO voteDTO){
        return voteServ.add(voteDTO);
    }

    @GetMapping("getVoteAchievement")
    public Result getVoteAchievement(){
        return new Result().genSuccessResult(voteServ.getVoteAchievement());
    }

}
