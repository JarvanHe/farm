package com.he.farm.service;

import com.he.farm.domain.TbSysUser;
import com.he.farm.mapper.TbSysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/14 11:45
 * @Description:
 */
public interface SysService {
 List<TbSysUser> getSysUserList();
}
