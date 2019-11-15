package com.he.farm.service.impl;

import com.he.farm.domain.TbFarmInfo;
import com.he.farm.mapper.TbFarmInfoMapper;
import com.he.farm.service.FarmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/2 15:47
 * @Description:
 */
@Service
public class FramInfoServiceImpl implements FarmInfoService {

    @Autowired
    TbFarmInfoMapper mapper;

    /**
     * 更新弄成信息
     *
     * @param farmInfo
     */
    @Override
    public void updateFramInfo(TbFarmInfo farmInfo) {
        if (mapper.selectAll().size() == 0) {
            mapper.insert(farmInfo);
        } else {
            Example example = new Example(TbFarmInfo.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("farmId", 1);
            mapper.updateByExample(farmInfo, example);
        }
    }
}
