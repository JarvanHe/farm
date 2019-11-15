package com.he.farm.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/11 16:17
 * @Description:
 */
@Data
public class Food implements Serializable {
    String description;
    String icon;
    String image;
    String name;
    BigDecimal price;
}
