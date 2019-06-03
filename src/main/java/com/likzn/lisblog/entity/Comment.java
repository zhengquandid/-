package com.likzn.lisblog.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @auther: Li jx
 * @date: 2019/6/3 17:39
 * @description:
 */
@Entity
@Table(name = "blog_comment")
public class Comment extends BaseEntity {
    @Id
    private int id;
}
