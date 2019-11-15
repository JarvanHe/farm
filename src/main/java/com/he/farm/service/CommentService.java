package com.he.farm.service;

import com.he.farm.domain.TbComment;
import com.he.farm.domain.vo.Comment;

import java.util.List;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/4 15:44
 * @Description:
 */
public interface CommentService {
    int getAllCommentCount();
    int getTodayCommentCount();
    List<Comment> getAllComment();
    List<Comment>getTodayComment();
    void addComment(TbComment comment);
}
