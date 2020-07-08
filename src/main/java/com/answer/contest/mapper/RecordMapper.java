package com.answer.contest.mapper;


import com.answer.contest.entity.Record;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RecordMapper extends Mapper<Record> {

    List<Record> getRecordList ();
}