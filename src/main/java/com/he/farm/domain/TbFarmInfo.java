package com.he.farm.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_farm_info")
public class TbFarmInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer farmId;

    private String framName;

    private String deliveryInfo;

    private String discountInfo;

    private String privideInfo;

    private String noticeInfo;

    public Integer getFarmId() {
        return farmId;
    }

    public void setFarmId(Integer farmId) {
        this.farmId = farmId;
    }

    public String getFramName() {
        return framName;
    }

    public void setFramName(String framName) {
        this.framName = framName == null ? null : framName.trim();
    }

    public String getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(String deliveryInfo) {
        this.deliveryInfo = deliveryInfo == null ? null : deliveryInfo.trim();
    }

    public String getDiscountInfo() {
        return discountInfo;
    }

    public void setDiscountInfo(String discountInfo) {
        this.discountInfo = discountInfo == null ? null : discountInfo.trim();
    }

    public String getPrivideInfo() {
        return privideInfo;
    }

    public void setPrivideInfo(String privideInfo) {
        this.privideInfo = privideInfo == null ? null : privideInfo.trim();
    }

    public String getNoticeInfo() {
        return noticeInfo;
    }

    public void setNoticeInfo(String noticeInfo) {
        this.noticeInfo = noticeInfo == null ? null : noticeInfo.trim();
    }
}