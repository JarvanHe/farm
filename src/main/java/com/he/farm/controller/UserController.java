package com.he.farm.controller;

import com.he.farm.common.Result;
import com.he.farm.common.ResultGenerator;
import com.he.farm.domain.ReceiveInfo;
import com.he.farm.domain.TbComment;
import com.he.farm.domain.TbFarmInfo;
import com.he.farm.domain.User;
import com.he.farm.domain.vo.Comment;
import com.he.farm.mapper.TbCommentMapper;
import com.he.farm.mapper.UserMapper;
import com.he.farm.service.CommentService;
import com.he.farm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/10/31 18:00
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;


    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        List<User> list = userService.login(user);
        BigDecimal consumeCount = userService.getConsumeByUsername(username);
        if (list.size() == 1) {
            list.get(0).setTotalConsume(consumeCount);
            return ResultGenerator.apiSuccess(list.get(0));
        } else {
            return ResultGenerator.apiError("用户名或密码错误");
        }
    }

    /**
     * 注册
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/reg")
    public Result reg(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      @RequestParam("tel") String tel,
                      @RequestParam("birthday") Date birthday,
                      @RequestParam("receiveAddress") String receiveAddress) {
        boolean isDuplicate = userService.checkDuplicate(username);
        if (isDuplicate) {
            return ResultGenerator.apiError("该用户已存在");
        } else {
            User user = new User();
            user.setUserName(username);
            user.setPassword(password);
            user.setBirthday(birthday);
            user.setTel(tel);
            user.setReceiveAddress(receiveAddress);
            user.setCreatetime(new Date());
            userService.saveUser(user);
            return ResultGenerator.apiSuccess("注册成功");
        }
    }

    /**
     * 修改密码
     *
     * @param userId
     * @param oldUsername
     * @param newPassword
     * @return
     */
    @RequestMapping("/changePass")
    public Result changePassword(@RequestParam("userId") Integer userId,
                                 @RequestParam("oldPassword") String oldUsername,
                                 @RequestParam("newPassword") String newPassword) {

        if (!userService.isUserExist(userId)) {
            return ResultGenerator.apiError("不存在该userId对应的用户");
        }
        if (!userService.isUserExist(userId, oldUsername)) {
            return ResultGenerator.apiError("原密码不正确");
        }
        return null;
    }

    /**
     * 根据userId查询用户对应的收货列表
     *
     * @param userId
     * @return
     */
    @RequestMapping("/getReceiveInfo")
    public Result getReceiveInfoByUserId(@RequestParam("userId") String userId) {
        List<ReceiveInfo> receiveInfos = userService.getReceiveInfoByUserId(userId);
        return ResultGenerator.apiSuccess(receiveInfos);
    }

    /**
     * 保存收货信息
     *
     * @param name
     * @param tel
     * @param address
     * @param userId
     * @param postalCode
     * @return
     */
    @RequestMapping("/saveReceiveInfo")
    public Result savaAddress(@RequestParam("name") String name,
                              @RequestParam("tel") String tel,
                              @RequestParam("address") String address,
                              @RequestParam("userId") Integer userId,
                              @RequestParam("postalCode") String postalCode) {

        ReceiveInfo receiveInfo = new ReceiveInfo();
        receiveInfo.setAddress(address);
        receiveInfo.setPostalCode(postalCode);
        receiveInfo.setUserId(userId);
        receiveInfo.setReceivePhone(tel);
        receiveInfo.setReceiveName(name);
        userService.saveReceiveInfo(receiveInfo);
        return ResultGenerator.apiSuccess("添加成功");
    }

    /**
     * 删除收货信息
     *
     * @param receiceId
     * @return
     */
    @RequestMapping("/deleteReceive")
    public Result deleteAdress(@RequestParam("receiceId") Integer receiceId) {
        userService.deleteReceiveInfo(receiceId);
        return ResultGenerator.apiSuccess("删除成功");
    }

    /**
     * 获取评论列表
     *
     * @return
     */
    @RequestMapping("/commentList")
    public Result getCommentList() {
        List<Comment> allComment = commentService.getAllComment();
        return ResultGenerator.apiSuccess(allComment);
    }

    /**
     * 留言
     *
     * @return
     */
    @RequestMapping("/leaveMessage")
    public Result leaveMessage(@Param("userId") Integer userId,
                               @Param("comment") String comment) {
        TbComment tbcomment = new TbComment();
        tbcomment.setComment(comment);
        tbcomment.setUserId(userId);
        tbcomment.setCommentDate(new Date());
        tbcomment.setCommentType(0);
        commentService.addComment(tbcomment);
        return ResultGenerator.apiSuccess("留言成功");
    }


    @RequestMapping("/deleteComment")
    public Result deleteComment(@Param("id") Integer id) {
        userService.deleteCommentById(id);
        return ResultGenerator.apiSuccess("删除成功");
    }

    /**
     * 获取农场信息
     *
     * @return
     */
    @RequestMapping("/getFarminfo")
    public Result getFarminfo() {
        TbFarmInfo farminfo = userService.getFarminfo();
        return ResultGenerator.apiSuccess(farminfo);
    }

    @RequestMapping("/userList")
    public Result getUserList(){
        List<User> userList = userService.getUserList();
        return ResultGenerator.apiSuccess(userList);
    }
}
