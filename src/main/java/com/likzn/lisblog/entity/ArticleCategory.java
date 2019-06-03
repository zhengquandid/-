package com.likzn.lisblog.entity;

import javax.persistence.*;

/**
 * @auther: Li jx
 * @date: 2019/6/3 16:26
 * @description:
 */
@Entity
@Table(name="blog_article_category")
public class ArticleCategory extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String categoryName;
    private int number;
}
