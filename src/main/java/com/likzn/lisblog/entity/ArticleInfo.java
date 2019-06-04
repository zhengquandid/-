package com.likzn.lisblog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @auther: Li jx
 * @date: 2019/6/3 16:31
 * @description:
 */
@Entity
@Table(name = "BLOG_ARTICLE_INFO")
@Getter
@Setter
public class ArticleInfo extends BaseEntity{
    @Id
    private Long id;
    private String summary;
    private String title;
    private int traffic;
    private String content;
    private int isTop;
    private int categoryId;

}
