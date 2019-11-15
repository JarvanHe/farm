package com.he.farm.controller;

import com.he.farm.common.Result;
import com.he.farm.common.ResultGenerator;
import com.he.farm.domain.TbSysUser;
import com.he.farm.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/14 11:38
 * @Description:
 */
@RestController
@RequestMapping("/sys")
public class SysController {
    @Autowired
    SysService sysService;

    @RequestMapping("/sysUserList")
    public Result getSysUser() {
        List<TbSysUser> sysUserList = sysService.getSysUserList();
        return ResultGenerator.apiSuccess(sysUserList);
    }
}
