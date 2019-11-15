package com.he.farm.mapper;

import com.he.farm.domain.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;

@Repository
public interface UserMapper extends Mapper<User> {
  int  getTodayUserCount(@Param("startTime") String startTime,@Param("endTime")String endTime);
  BigDecimal getConsumeByUsername(@Param("username") String username);
}