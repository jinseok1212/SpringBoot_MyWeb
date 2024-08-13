package com.coding404.myweb.topic;

import com.coding404.myweb.command.TopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("topicService")
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public int topicInsert(TopicVO vo) {
        return topicMapper.topicInsert(vo);
    }
}
