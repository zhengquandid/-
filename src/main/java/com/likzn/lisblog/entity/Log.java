package com.likzn.lisblog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @auther: Li jx
 * @date: 2019/6/3 19:11
 * @description:
 */
@Entity
@Table(name = "blog_log")
@Setter
@Getter
public class Log extends BaseEntity {
    @Id
    private Long id;

    private String ip;

    private String operateBy;


}
