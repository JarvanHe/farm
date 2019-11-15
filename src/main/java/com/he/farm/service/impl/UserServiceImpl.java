package com.he.farm.service.impl;

import com.he.farm.domain.ReceiveInfo;
import com.he.farm.domain.TbFarmInfo;
import com.he.farm.domain.User;
import com.he.farm.mapper.ReceiveInfoMapper;
import com.he.farm.mapper.TbCommentMapper;
import com.he.farm.mapper.TbFarmInfoMapper;
import com.he.farm.mapper.UserMapper;
import com.he.farm.service.UserService;
import com.he.farm.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.jws.soap.SOAPBinding;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/10/31 17:49
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    ReceiveInfoMapper receiveInfoMapper;

    @Autowired
    TbFarmInfoMapper farmInfoMapper;

    @Autowired
    TbCommentMapper commentMapper;

    @Override
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void changePassword(User user) {

        userMapper.updateByExample(user, null);
    }

    @Override
    public List login(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userName", user.getUserName());
        criteria.andEqualTo("password", user.getPassword());
        List list = userMapper.selectByExample(example);
        return list;
    }

    /**
     * 查看是否有相同用户名的记录，true有，false没有
     *
     * @param username
     * @return
     */
    @Override
    public boolean checkDuplicate(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userName", username);
        List<User> list = userMapper.selectByExample(example);
        if (list.size() == 0) {
            return false;
        }
        return true;
    }

    /**
     * 根据Id判断该用户书否存在
     *
     * @param userId
     * @return
     */
    @Override
    public boolean isUserExist(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user != null) {
            return true;
        }
        return false;
    }

    /**
     * 根据userId和密码校验是否存在该用户
     *
     * @param userId
     * @param oldPassword
     * @return
     */
    @Override
    public boolean isUserExist(Integer userId, String oldPassword) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        criteria.andEqualTo("password", oldPassword);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() == 1) {
            return true;
        }
        return false;
    }

    @Override
    public int getTodayUserCount() {
        return userMapper.getTodayUserCount(TimeUtil.getTodayZero(), TimeUtil.getCurrentTime());
    }

    @Override
    public BigDecimal getConsumeByUsername(String username) {
        BigDecimal totalConsume = userMapper.getConsumeByUsername(username);
        return totalConsume;
    }

    @Override
    public List<ReceiveInfo> getReceiveInfoByUserId(String userId) {
        Example example = new Example(ReceiveInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        List<ReceiveInfo> receiveInfos = receiveInfoMapper.selectByExample(example);
        return receiveInfos;
    }

    @Override
    public void saveReceiveInfo(ReceiveInfo receiveInfo) {
        receiveInfoMapper.insert(receiveInfo);
    }

    @Override
    public void deleteReceiveInfo(Integer receiveId) {
        receiveInfoMapper.deleteByPrimaryKey(receiveId);
    }

    @Override
    public TbFarmInfo getFarminfo() {
        return farmInfoMapper.selectByPrimaryKey(Integer.valueOf(1));
    }

    @Override
    public void deleteCommentById(Integer id) {
        commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.selectAll();
    }

}
