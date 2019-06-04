package com.likzn.lisblog.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @auther: Li jx
 * @date: 2019/6/3 16:34
 * @description:
 */
@Getter
@Setter
public class BaseEntity {
    private Date createTime;
    private Date updateTime;
}
