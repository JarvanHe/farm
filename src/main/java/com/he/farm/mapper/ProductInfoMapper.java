package com.he.farm.mapper;

import com.he.farm.domain.ProductInfo;

import java.util.List;

import com.he.farm.domain.vo.ProductInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ProductInfoMapper extends Mapper<ProductInfo> {
List<ProductInfoVO> getProductInfoVOList();
}