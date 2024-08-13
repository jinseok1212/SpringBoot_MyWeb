package com.coding404.myweb.topic;

import com.coding404.myweb.command.TopicVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicMapper {
    public int topicInsert(TopicVO vo);

}
