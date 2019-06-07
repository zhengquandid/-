package com.likzn.lisblog.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @auther: Li jx
 * @date: 2019/6/6 15:51
 * @description:
 */
@Getter
@Setter
public class ArticleDTO {
    private String title;
    private String summary;
    private Boolean isTop;
    private Long categoryId;
    private String content;
    private Long id;

}
