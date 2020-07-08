package com.answer.contest.serv;

import com.answer.contest.dto.VoteDTO;
import com.answer.contest.entity.Result;
import com.answer.contest.entity.GGroup;

import java.util.List;

/**
 * @author dzy
 * @date 2020/7/1
 * @desc
 */
public interface VoteServ {

    List<GGroup> getGroupList ( Integer userId);

    Result add(VoteDTO voteDTO);

    List<GGroup> getVoteAchievement();
}
