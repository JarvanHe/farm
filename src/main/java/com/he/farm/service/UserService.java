package com.he.farm.service;

import com.he.farm.common.Result;
import com.he.farm.domain.ReceiveInfo;
import com.he.farm.domain.TbFarmInfo;
import com.he.farm.domain.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/10/31 17:44
 * @Description:
 */
public interface UserService {
    /**
     * 注册
     * @param user
     */
    void saveUser(User user);

    /**
     * 修改密码
     * @param user
     */
    void changePassword(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    List login(User user);

    /**
     * 看数据库是否有相同用户名的记录
     * @param username
     * @return
     */
    boolean checkDuplicate(String username);

    /**
     * 是否存在该userId的用户
     * @param userId
     * @return
     */
    boolean isUserExist(Integer userId);

    /**
     * 是否存在该userId且旧密码为该密码的用户
     * @param userId
     * @param oldPassword
     * @return
     */
    boolean isUserExist(Integer userId,String oldPassword);

    /**
     * 获取当日新增用户数
     * @return
     */
    int  getTodayUserCount();

    /**
     * 获取用户消费总额
     * @param username
     * @return
     */
    BigDecimal getConsumeByUsername(String username);

    /**
     * 根据userId获取收货信息列表
     * @param userId
     * @return
     */
    List<ReceiveInfo> getReceiveInfoByUserId(String userId);

    /**
     * 添加收货信息
     * @param receiveInfo
     */
    void saveReceiveInfo(ReceiveInfo receiveInfo);

    /**
     * 根据收货信息Id删除收货信息
     * @param receiveId
     */
    void deleteReceiveInfo(Integer receiveId);

    /**
     * 获取农场信息
     * @return
     */
    TbFarmInfo getFarminfo();
    /*
     *删除留言
     */
    void deleteCommentById(Integer id);

    List<User>getUserList();
}
