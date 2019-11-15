package com.he.farm.service.impl;

import com.he.farm.domain.OrderMaster;
import com.he.farm.domain.ProductCategory;
import com.he.farm.domain.ProductInfo;
import com.he.farm.domain.vo.ProductInfoVO;
import com.he.farm.mapper.OrderMasterMapper;
import com.he.farm.mapper.ProductCategoryMapper;
import com.he.farm.mapper.ProductInfoMapper;
import com.he.farm.service.CommentService;
import com.he.farm.service.OrderService;
import com.he.farm.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/4 17:23
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMasterMapper orderMasterMapper;

    @Autowired
    CommentService commentService;

    @Autowired
    ProductCategoryMapper categoryMapper;

    @Autowired
    ProductInfoMapper productMapper;

    @Override
    public int getTodayOrderCount() {
        Example example = new Example(OrderMaster.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andBetween("createTime", TimeUtil.getTodayZero(), TimeUtil.getCurrentTime());
        return orderMasterMapper.selectCountByExample(example);
    }

    @Override
    public int getTodayIncome() {
        return orderMasterMapper.getTodayIncome(TimeUtil.getTodayZero(), TimeUtil.getCurrentTime());
    }

    @Override
    public List<ProductCategory> getCategoryList() {
        return categoryMapper.selectAll();
    }

    @Override
    public void saveCategory(ProductCategory category) {
        categoryMapper.insert(category);
    }

    @Override
    public void deleteCategory(ProductCategory category) {
        categoryMapper.delete(category);
    }

    @Override
    public void updateCategory(ProductCategory category) {
        categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public List<ProductInfoVO> getProductList() {
        return productMapper.getProductInfoVOList();
    }

    @Override
    public void saveProduct(ProductInfo productInfo) {
        productMapper.insert(productInfo);
    }

    @Override
    public void deleteProduct(ProductInfo productInfo) {
        productMapper.deleteByPrimaryKey(productInfo.getProductId());
    }

    @Override
    public void updateProduct(ProductInfo productInfo) {
        productMapper.updateByPrimaryKey(productInfo);
    }

    @Override
    public void saveOrder(OrderMaster order) {
        orderMasterMapper.insert(order);
    }

    @Override
    public List<OrderMaster> getOrderList() {
        return orderMasterMapper.selectAll();
    }

}
