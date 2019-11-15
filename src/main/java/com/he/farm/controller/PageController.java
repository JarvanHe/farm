package com.he.farm.controller;

import com.he.farm.common.Result;
import com.he.farm.common.ResultGenerator;
import com.he.farm.domain.TbFarmInfo;
import com.he.farm.service.FarmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/2 16:06
 * @Description:
 */
@Controller
public class PageController {
    @Autowired
    FarmInfoService farmInfoService;

    /**
     * 主界面
     * @return
     */
    @RequestMapping("/main")
    public String gotomain() {
        return "all-admin-index";
    }

    /**
     * 订单页
     * @return
     */
    @RequestMapping("/allOrder")
    public String allOrder() {
        return "all-order-manage-list";
    }

    /**
     * 编辑农场信息
     * @return
     */
    @RequestMapping("/editFarm")
    public String editFarmInfo() {
        return "all-admin-dataform";
    }

    /**
     * 留言列表页
     * @return
     */
    @RequestMapping("/leavemessage")
    public String goComment() {
        return "leave-message";
    }

    /**
     * 编辑农场信息
     * @param framName
     * @param deliveryInfo
     * @param discountInfo
     * @param privideInfo
     * @param noticeInfo
     * @return
     */
    @RequestMapping("/editFarminfo")
    @ResponseBody
    public Result updateFarminfo(@RequestParam("framName") String framName,
                                 @RequestParam("deliveryInfo") String deliveryInfo,
                                 @RequestParam("discountInfo") String discountInfo,
                                 @RequestParam("privideInfo") String privideInfo,
                                 @RequestParam("noticeInfo") String noticeInfo) {

        TbFarmInfo farmInfo = new TbFarmInfo();
        farmInfo.setFramName(framName);
        farmInfo.setDeliveryInfo(deliveryInfo);
        farmInfo.setDiscountInfo(discountInfo);
        farmInfo.setPrivideInfo(privideInfo);
        farmInfo.setNoticeInfo(noticeInfo);
        farmInfoService.updateFramInfo(farmInfo);
        return ResultGenerator.apiSuccess("更新成功");
    }

    /**
     * 会员列表
     * @return
     */
    @RequestMapping("/member")
    public String goMemberPage(){
        return "member-list";
    }

    /**
     * 品类列表
     * @return
     */
    @RequestMapping("/category")
    public String goCategory(){
        return "category-list";
    }

    /**
     * 产品列表
     * @return
     */
    @RequestMapping("/product")
    public String goProduct(){
        return "product-list";
    }

    /**
     * 订单列表
     * @return
     */
    @RequestMapping("/orderList")
    public String getOrder(){
        return "order-list";
    }
    /**
     * 订单列表
     * @return
     */
    @RequestMapping("/userManager")
    public String userManager(){
        return "usermanager";
    }
}
