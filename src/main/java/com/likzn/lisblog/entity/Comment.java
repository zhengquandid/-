package com.likzn.lisblog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @auther: Li jx
 * @date: 2019/6/3 17:39
 * @description:
 */
@Getter
@Setter
@Entity
@Table(name = "blog_comment")
public class Comment extends BaseEntity {
    @Id
    private Long id;

    private String email;

    private String content;

    private String name;

}
