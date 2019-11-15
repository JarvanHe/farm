package com.he.farm.controller;

import com.he.farm.common.Result;
import com.he.farm.common.ResultGenerator;
import com.he.farm.domain.OrderMaster;
import com.he.farm.domain.ProductCategory;
import com.he.farm.domain.ProductInfo;
import com.he.farm.domain.User;
import com.he.farm.domain.vo.Food;
import com.he.farm.domain.vo.ProductInfoVO;
import com.he.farm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/11 01:56
 * @Description:
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    /**
     * 获取商品种类
     *
     * @return
     */
    @RequestMapping("/getCategoryList")
    public Result getCategoryList() {
        List<ProductCategory> categoryList = orderService.getCategoryList();
        return ResultGenerator.apiSuccess(categoryList);
    }

    /**
     * 添加商品种类
     *
     * @param category
     * @return
     */
    @RequestMapping("/addCategory")
    public Result saveCategoty(@RequestBody ProductCategory category) {
        orderService.saveCategory(category);
        return ResultGenerator.apiSuccess("添加成功");
    }

    /**
     * 删除种类
     *
     * @param category
     * @return
     */
    @RequestMapping("/deleteCategory")
    public Result deleteCategory(@RequestBody ProductCategory category) {
        orderService.deleteCategory(category);
        return ResultGenerator.apiSuccess("删除成功");
    }

    /**
     * 更新种类
     *
     * @param category
     * @return
     */
    @RequestMapping("/updateCategory")
    public Result updateCategory(@RequestBody ProductCategory category) {
        orderService.updateCategory(category);
        return ResultGenerator.apiSuccess("更新成功");
    }

    /**
     * 获取产品列表
     *
     * @return
     */
    @RequestMapping("/productList")
    public Result getProductList() {
        List<ProductInfoVO> productList = orderService.getProductList();
        return ResultGenerator.apiSuccess(productList);
    }

    /**
     * 添加产品
     *
     * @return
     */
    @RequestMapping("/saveProduct")
    public Result saveProduct(@RequestBody ProductInfo productInfo) {
        orderService.saveProduct(productInfo);
        return ResultGenerator.apiSuccess(productInfo);
    }

    /**
     * 删除产品
     *
     * @param productInfo
     * @return
     */
    @RequestMapping("/deleteProduct")
    public Result deleteProduct(@RequestBody ProductInfo productInfo) {
        orderService.deleteProduct(productInfo);
        return ResultGenerator.apiSuccess("删除成功");
    }

    /**
     * 更新产品
     *
     * @param productInfo
     * @return
     */
    @RequestMapping("/updateProduct")
    public Result updateProduct(@RequestBody ProductInfo productInfo) {
        orderService.updateProduct(productInfo);
        return ResultGenerator.apiSuccess("更新成功");
    }

    /**
     * 获取产品列表
     *
     * @return
     */
    @RequestMapping("/getGoods")
    public Result getGoods() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<ProductCategory> categoryList = orderService.getCategoryList();
        List<ProductInfoVO> productList = orderService.getProductList();
        List<Map<String, Object>> goodsList = new ArrayList<Map<String, Object>>();

        for (ProductCategory category : categoryList) {
            Map<String, Object> foodsMap = new HashMap<String, Object>();
            foodsMap.put("name", category.getCategoryName());
            foodsMap.put("type", "-1");

            List<Food> foods = new ArrayList<Food>();
            for (ProductInfoVO product : productList) {
                if (category.getCategoryName().equals(product.getCategoryType())) {
                    Food food = new Food();
                    food.setDescription(product.getProductDescription());
                    food.setIcon(product.getProductIcon());
                    food.setImage(product.getProductIcon());
                    food.setName(product.getProductName());
                    food.setPrice(product.getProductPrice());
                    foods.add(food);
                }
            }
            foodsMap.put("foods", foods);
            goodsList.add(foodsMap);
        }
        resultMap.put("goods", goodsList);
        return ResultGenerator.apiSuccess(resultMap);
    }

    @RequestMapping("/generateOrder")
    public Result generateOrder(@RequestParam("buyerName") String buyerName,
                                @RequestParam("buyerPhone") String buyerPhone,
                                @RequestParam("buyerAddress") String buyerAddress,
                                @RequestParam("orderAmount") BigDecimal orderAmount) {
        OrderMaster order = new OrderMaster();
        order.setBuyerAddress(buyerAddress);
        order.setBuyerName(buyerName);
        order.setBuyerPhone(buyerPhone);
        order.setOrderAmount(orderAmount);
        order.setOrderStatus((byte) 0);
        order.setPayStatus((byte) 0);
        orderService.saveOrder(order);
        return ResultGenerator.apiSuccess("提交订单成功");
    }

    @RequestMapping("/orderList")
    public Result getOrderList(){
        List<OrderMaster> orderList = orderService.getOrderList();
        return ResultGenerator.apiSuccess(orderList);
    }
}
