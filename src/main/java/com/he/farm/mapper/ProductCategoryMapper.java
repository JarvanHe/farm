package com.he.farm.mapper;

import com.he.farm.domain.ProductCategory;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ProductCategoryMapper extends Mapper<ProductCategory> {

}