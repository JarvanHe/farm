package com.he.farm.service.impl;

import com.he.farm.domain.TbComment;
import com.he.farm.domain.vo.Comment;
import com.he.farm.mapper.TbCommentMapper;
import com.he.farm.service.CommentService;
import com.he.farm.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/4 15:50
 * @Description:
 */
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    TbCommentMapper mapper;

    @Override
    public int getAllCommentCount() {
        return mapper.getAllCommentCount();
    }

    @Override
    public int getTodayCommentCount() {
        return mapper.getTodayCommentCount(TimeUtil.getTodayZero(), TimeUtil.getCurrentTime());
    }

    @Override
    public List<Comment> getAllComment() {
        return mapper.getAllComment();
    }

    @Override
    public List<Comment> getTodayComment() {
        return mapper.getTodayComment(TimeUtil.getTodayZero(), TimeUtil.getCurrentTime());
    }

    @Override
    public void addComment(TbComment comment) {
        mapper.insert(comment);
    }
}
