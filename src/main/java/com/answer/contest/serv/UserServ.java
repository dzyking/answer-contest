package com.answer.contest.serv;

import com.answer.contest.dto.UserDTO;
import com.answer.contest.entity.Result;

public interface UserServ {

    Result login (UserDTO userDTO);

    void addUser ();

    void addRecord ();
}
