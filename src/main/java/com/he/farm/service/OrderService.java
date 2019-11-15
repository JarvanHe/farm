package com.he.farm.service;

import com.he.farm.domain.OrderMaster;
import com.he.farm.domain.ProductCategory;
import com.he.farm.domain.ProductInfo;
import com.he.farm.domain.vo.ProductInfoVO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/4 17:15
 * @Description:
 */
public interface OrderService {
  int  getTodayOrderCount();
  int   getTodayIncome();
  List<ProductCategory> getCategoryList();
  void saveCategory(ProductCategory category);
  void deleteCategory(ProductCategory category);
  void updateCategory(ProductCategory category);
  List<ProductInfoVO>getProductList();
  void saveProduct(ProductInfo productInfo);
  void deleteProduct(ProductInfo productInfo);
  void updateProduct(ProductInfo productInfo);
  void saveOrder(OrderMaster order);
  List<OrderMaster>getOrderList();
}
