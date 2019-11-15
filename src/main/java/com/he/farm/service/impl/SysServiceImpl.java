package com.he.farm.service.impl;

import com.he.farm.domain.TbSysUser;
import com.he.farm.mapper.TbSysUserMapper;
import com.he.farm.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/14 11:49
 * @Description:
 */
@Service
public class SysServiceImpl implements SysService {
    @Autowired
    TbSysUserMapper sysUserMapper;

    @Override
    public List<TbSysUser> getSysUserList() {
        return sysUserMapper.selectAll();
    }
}
