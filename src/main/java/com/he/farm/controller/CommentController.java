package com.he.farm.controller;

import com.he.farm.common.Result;
import com.he.farm.common.ResultGenerator;
import com.he.farm.domain.TbComment;
import com.he.farm.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/4 16:46
 * @Description:有关评论的相关接口
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    @RequestMapping("/save")
    public Result savaComment(TbComment comment) {
        commentService.addComment(comment);
       return ResultGenerator.apiSuccess("添加评论成功");
    }

    @RequestMapping("/search")
    public Result searchComment() {
        return ResultGenerator.apiSuccess(commentService.getAllComment());
    }
}
