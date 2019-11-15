package com.he.farm.controller;

import com.he.farm.common.Result;
import com.he.farm.common.ResultGenerator;
import com.he.farm.service.CommentService;
import com.he.farm.service.OrderService;
import com.he.farm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/4 17:10
 * @Description:
 */
@RequestMapping("/home")
@RestController
public class HomeInfoController {

    @Autowired
    CommentService commentService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;


    @RequestMapping("/getHomeInfo")
    public Result getResultInfo() {
        Map<String,Object> resultMap=new HashMap();
        int todayOrder = orderService.getTodayOrderCount();
        int todayIncome;
        if(todayOrder==0){
            todayIncome=0;
        }else{
            todayIncome = orderService.getTodayIncome();
        }

        int todayUserCount = userService.getTodayUserCount();
        int todayCommentCount = commentService.getTodayCommentCount();

        resultMap.put("todayOrder",todayOrder);
        resultMap.put("todayIncome",todayIncome);
        resultMap.put("todayUserCount",todayUserCount);
        resultMap.put("todayCommentCount",todayCommentCount);
        return ResultGenerator.apiSuccess(resultMap);
    }
}
