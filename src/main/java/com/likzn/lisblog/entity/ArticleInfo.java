package com.likzn.lisblog.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @auther: Li jx
 * @date: 2019/6/3 16:31
 * @description:
 */
@Entity
@Table(name = "BLOG_ARTICLE_INFO")
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
public class ArticleInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String summary;
    private String title;
    private Integer traffic;
    private String content;
    private Boolean isTop;
    private Long categoryId;

}
