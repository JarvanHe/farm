package com.he.farm.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/10/29 22:34
 * @Description:
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
    String username;
    String password;
}
