package com.he.farm.mapper;

import com.he.farm.domain.ReceiveInfo;
import com.he.farm.domain.ReceiveInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface ReceiveInfoMapper  extends Mapper<ReceiveInfo> {

}