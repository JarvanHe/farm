package com.he.farm.mapper;

import com.he.farm.domain.OrderMaster;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface OrderMasterMapper extends Mapper<OrderMaster> {

    int getTodayIncome(@Param("startTime")String startTime, @Param("endTime")String endTime);
}