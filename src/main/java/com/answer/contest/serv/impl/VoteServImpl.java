package com.answer.contest.serv.impl;

import com.answer.contest.dto.VoteDTO;
import com.answer.contest.entity.*;
import com.answer.contest.mapper.GroupMapper;
import com.answer.contest.mapper.UserMapper;
import com.answer.contest.mapper.VoteDetailMapper;
import com.answer.contest.serv.VoteServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dzy
 * @date 2020/7/1
 * @desc
 */
@Service
public class VoteServImpl implements VoteServ {

    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private VoteDetailMapper detailMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<GGroup> getGroupList(Integer userId) {

        User user = userMapper.selectByPrimaryKey(userId);

        List<GGroup> groupList = groupMapper.selectAll();
        int i = -1;
        for (GGroup group : groupList) {
            String name = group.getName();
            String userName = user.getUserName();
            String substring = userName.substring(0, 4);
            if (name.substring(0, 4).equals(substring)) {
                i = groupList.indexOf(group);
            }
        }
        if (i >= 0) {
            groupList.remove(i);
        }

        return groupList;
    }

    @Override
    public Result add(VoteDTO voteDTO) {
        Integer groupId = voteDTO.getGroupId();
        Integer userId = voteDTO.getUserId();

        VoteDetail query = new VoteDetail();
        query.setUserId(userId);
        int i = detailMapper.selectCount(query);
        if (i > 0) {
            return new Result().genFailResult(ResultCode.UPPER_LIMIT, "您已经投过票了");
        }
        GGroup group = groupMapper.selectByPrimaryKey(groupId);
        group.setTicketNum(group.getTicketNum() + 1);
        groupMapper.updateByPrimaryKeySelective(group);

        User user = userMapper.selectByPrimaryKey(userId);

        VoteDetail voteDetail = new VoteDetail();
        voteDetail.setUserId(userId);
        voteDetail.setUserName(user.getUserName());
        voteDetail.setGroupId(groupId);
        voteDetail.setGroupName(group.getName());
        detailMapper.insertSelective(voteDetail);
        return new Result().genSuccessResult("投票成功");
    }

    @Override
    public List<GGroup> getVoteAchievement() {
        List<GGroup> groupList = groupMapper.selectAll();
        groupList = groupList.stream().sorted(Comparator.comparing(GGroup::getTicketNum).reversed()).collect(Collectors.toList());
        return groupList;
    }
}
